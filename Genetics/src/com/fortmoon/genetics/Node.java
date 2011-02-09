package com.fortmoon.genetics;

import java.util.ArrayList;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 2:19:14 AM
 */
public interface Node {
	public <T extends Node> Number evaluate(ArrayList<T> args);
}
