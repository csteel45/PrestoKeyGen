package com.fortmoon.genetics;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 * 
 * @since Jan 29, 2011 7:54:05 AM
 */
public class MathOperand implements Operand {
	private Operation operation;

	public enum Operation {
		PLUS {
			<T extends Number> T eval(T x, T y) {
				return (T) new BigDecimal(x.toString()).add(new BigDecimal(y.toString()));
			}
		},

		MINUS {
			<T extends Number> T eval(T x, T y) {
				return (T) new BigDecimal(x.toString()).subtract(new BigDecimal(y.toString()));
			}
		},
		TIMES {
			<T extends Number> T eval(T x, T y) {
				return (T) new BigDecimal(x.toString()).multiply(new BigDecimal(y.toString()));
			}
		},

		DIVIDE {
			<T extends Number> T eval(T x, T y) {
				if(x instanceof Integer || x instanceof Long)
					return (T) new BigDecimal(x.toString()).divide(new BigDecimal(y.toString()), BigDecimal.ROUND_DOWN);
				else
					return (T) new BigDecimal(x.toString()).divide(new BigDecimal(y.toString()), 10, BigDecimal.ROUND_DOWN);
			}
		},

		POWER {
			<T extends Number> T eval(T x, T y) {
				return (T) new BigDecimal(x.toString()).pow(new BigDecimal(y.toString()).intValue());
			}
		};

		// Do arithmetic op represented by this constant
		abstract <T extends Number> Number eval(T number, T number2);
	}

	@SuppressWarnings("unused")
	private MathOperand() {
	}

	public MathOperand(Operation op) {
		this.operation = op;
	}

	@Override
	public <T extends Node> Number evaluate(ArrayList<T> args) {
		return this.operation.eval(args.get(0).evaluate(args), args.get(1).evaluate(args));
	}

	public <T extends Node> Number evaluate(Number num1, Number num2) {
		return this.operation.eval(num1, num2);
	}

	public String toString() {
		return this.operation.toString();
	}

	public static void main(String[] args) {
		ArrayList<Node> params = new ArrayList<Node>();
		params.add(new ConstNode(2));
		params.add(new ConstNode(3));

		for (Operation op : Operation.values()) {
			MathOperand math = new MathOperand(op);
			System.out.println("Integer Eval of 2 " + op.toString() + " 3 = " + op.eval(new Integer(2), new Integer(3)));
		}

		for (Operation op : Operation.values()) {
			MathOperand math = new MathOperand(op);
			System.out.println("Float Eval of 2 " + op.toString() + " 3.1 = " + op.eval(new Float(2), new Float(3.1)));
		}

		for (Operation op : Operation.values()) {
			MathOperand math = new MathOperand(op);
			System.out.println("Eval of 2 " + op.toString() + " 3 = " + math.evaluate(params));
		}

	}

}
