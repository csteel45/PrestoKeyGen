package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 7:54:05 AM
 */
public class IfOperand implements Operand{

		public <T extends Node> Number evaluate(ArrayList<T> args) {
				if(args.get(0).evaluate(args).doubleValue() > 0) {
					return args.get(1).evaluate(args);
				}
				else {
					return args.get(2).evaluate(args);
				}
		}

		/* (non-Javadoc)
		 * @see com.fortmoon.genetics.Operand#evaluate(java.lang.Number, java.lang.Number)
		 */
		@Override
		public <T extends Node> Number evaluate(Number num1, Number num2) {
			ArrayList<Node> inputs = new ArrayList<Node>(2);
			inputs.add(new ConstNode(num1));
			inputs.add(new ConstNode(num2));
			return evaluate(inputs);
		}
		
		public String toString() {
			return "if";
		}

}
