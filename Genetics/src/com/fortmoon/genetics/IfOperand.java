package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 7:54:05 AM
 */
public class IfOperand implements Operand{

		public Float evaluate(ArrayList<Node> args) {
				if(args.get(0).evaluate() > 0) {
					return args.get(1).evaluate();
				}
				else {
					return args.get(2).evaluate();
				}
		}

		/* (non-Javadoc)
		 * @see com.fortmoon.genetics.Node#evaluate()
		 */
		@Override
		public Float evaluate() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public String toString() {
			return "if";
		}

}
