package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 30, 2011 11:01:34 AM
 */
public class FunctionNodeBase extends FunctionNode {

	/**
	 * @param operand
	 * @param paramList
	 */
	public <T extends Node> FunctionNodeBase(Operand operand, ArrayList<T> paramList) {
		super(operand, paramList);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.fortmoon.genetics.Node#evaluate(java.util.ArrayList)
	 */
	@Override
	public <T extends Node> Number evaluate(ArrayList<T> args) {
/*		System.out.println("FNB evaluate args = " + args);
		System.out.println("FNB evaluate paramList.get(0) = " + paramList.get(0));
		System.out.println("FNB evaluate paramList.get(1) = " + paramList.get(1));
		System.out.println("FNB evaluate paramList.get(0).evaluate = " + paramList.get(0).evaluate(args));
		System.out.println("FNB evaluate paramList.get(1).evaluate = " + paramList.get(1).evaluate(args));
*/
		return operand.evaluate(paramList.get(0).evaluate(args), paramList.get(1).evaluate(args));
	}

}
