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
			@SuppressWarnings("unchecked")
			<T extends Number> T eval(T x, T y) {
				//System.out.println("MathOperand.add x y " + new BigDecimal(x.toString()) + " " + new BigDecimal(y.toString()));
				//System.out.println("MathOperand.add = " + new BigDecimal(x.toString()).add(new BigDecimal(y.toString())));
				return (T) new BigDecimal(x.toString()).add(new BigDecimal(y.toString()));
			}
		},

		MINUS {
			@SuppressWarnings("unchecked")
			<T extends Number> T eval(T x, T y) {
				return (T) new BigDecimal(x.toString()).subtract(new BigDecimal(y.toString()));
			}
		},
		TIMES {
			@SuppressWarnings("unchecked")
			<T extends Number> T eval(T x, T y) {
				return (T) new BigDecimal(x.toString()).multiply(new BigDecimal(y.toString()));
			}
		},

		DIVIDE {
			@SuppressWarnings("unchecked")
			<T extends Number> T eval(T x, T y) {
				BigDecimal X = new BigDecimal(x.toString());
				BigDecimal Y = new BigDecimal(y.toString());
				
				if(y.equals(BigDecimal.valueOf(0)))
					return (T) Y;
				try {
				if(x instanceof Integer || x instanceof Long)
					return (T) X.divide(Y, BigDecimal.ROUND_DOWN);
				else
					return (T) X.divide(Y, 10, BigDecimal.ROUND_DOWN);
				}
				catch(Exception e) {
					return (T) BigDecimal.valueOf(0);
				}
			}
		},

		POWER {
			@SuppressWarnings("unchecked")
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
			//MathOperand math = new MathOperand(op);
			System.out.println("Integer Eval of 2 " + op.toString() + " 3 = " + op.eval(new Integer(2), new Integer(3)));
		}

		for (Operation op : Operation.values()) {
			//MathOperand math = new MathOperand(op);
			System.out.println("Float Eval of 2 " + op.toString() + " 3.1 = " + op.eval(new Float(2), new Float(3.1)));
		}

		for (Operation op : Operation.values()) {
			MathOperand math = new MathOperand(op);
			System.out.println("Eval of 2 " + op.toString() + " 3 = " + math.evaluate(params));
		}

	}

}
