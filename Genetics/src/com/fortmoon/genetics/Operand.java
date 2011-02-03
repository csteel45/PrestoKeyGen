package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 7:53:25 AM
 */
public interface Operand extends Node {
	public Float evaluate(ArrayList<Node> params);
	
}
