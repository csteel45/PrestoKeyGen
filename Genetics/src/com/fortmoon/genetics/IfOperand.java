package com.fortmoon.genetics;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 7:54:05 AM
 */
public class IfOperand implements Operand{

		public <T extends Node> Number evaluate(ArrayList<T> args) {
				if(args.get(0).evaluate().doubleValue() > 0) {
					return args.get(1).evaluate();
				}
				else {
					return args.get(2).evaluate();
				}
		}
		
		public String toString() {
			return "if";
		}

		/* (non-Javadoc)
		 * @see com.fortmoon.genetics.Node#evaluate()
		 */
		@Override
		public Number evaluate() {
			// TODO Auto-generated method stub
			return new Integer(0);
		}

}
