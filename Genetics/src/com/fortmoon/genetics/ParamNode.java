package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 2:23:35 AM
 */
public class ParamNode implements Node {
	protected int paramNumber;

	protected ParamNode() {
		
	}
	
	public ParamNode(int param) {
		this.paramNumber = param;
	}

	public Number getParam() {
		return paramNumber;
	}

	public void setParam(int param) {
		this.paramNumber = param;
	}

	/* (non-Javadoc)
	 * @see com.fortmoon.genetics.Node#evaluate(java.util.ArrayList)
	 */
	@Override
	public <T extends Node> Number evaluate(ArrayList<T> args) {
		return args.get(paramNumber).evaluate(args);
	}
	
	public String toString() {
		if(paramNumber == 0)
			return "x";
		if(paramNumber == 1)
			return "y";
		return "IN:" + paramNumber;
	}


}
