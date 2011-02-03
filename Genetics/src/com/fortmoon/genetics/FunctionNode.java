package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 2:44:49 AM
 */
public abstract class FunctionNode implements Node {
	protected Operand operand;
	protected ArrayList<Node> paramList;
	
	public FunctionNode(Operand operand, ArrayList<Node> paramList) {
		this.operand = operand;
		this.paramList = paramList;
	}
	
	public Float evaluate() {
		return operand.evaluate(paramList);
	}
	
	public String toString() {
		return operand.toString() + "(" + paramList.toString() + ")";
	}
	
}
