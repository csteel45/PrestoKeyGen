package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 * 
 * @since Jan 29, 2011 2:22:40 AM
 */
public class ConstNode extends ParamNode {
	protected Number constant;

	/**
	 * @param number
	 */
	public ConstNode(Number number) {
		this.constant = number;
	}

	public Object getConstant() {
		return constant;
	}

	public void setConstant(Number constant) {
		this.constant = constant;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.fortmoon.genetics.Node#evaluate(java.util.ArrayList)
	 */
	@Override
	public <T extends Node> Number evaluate(ArrayList<T> args) {
		// TODO Auto-generated method stub
		return constant;
	}

	public String toString() {
		if (constant instanceof Integer)
			return ((Integer) constant).toString();
		if (constant instanceof Long)
			return ((Long) constant).toString();
		if (constant instanceof Float)
			return ((Float) constant).toString();
		if (constant instanceof Double)
			return ((Double) constant).toString();

		return new String("Unknown number type: " + constant);
	}
}
