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
	
	@SuppressWarnings("unchecked")
	public <T extends Node> FunctionNode(Operand operand, ArrayList<T> paramList2) {
		this.operand = operand;
		this.paramList = (ArrayList<Node>) paramList2;
	}
	
	public Number evaluate() {
		return operand.evaluate(paramList);
	}
	
	public String toString() {
		return operand.toString() + "(" + paramList.toString() + ")";
	}

	/**
	 * @param args
	 * @return
	 */
	public  <T extends Node> Number evaluate(ArrayList<T> args) {
		return operand.evaluate(paramList);
	}
	
}
