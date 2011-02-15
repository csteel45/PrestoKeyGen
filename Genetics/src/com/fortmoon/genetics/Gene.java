/**
 * 
 */
package com.fortmoon.genetics;

/**
 * @author csteel
 *
 */
public class Gene {
	protected Node node;
	private static NodeTreeDemo nodeTreeDemo = new NodeTreeDemo();
	
	public Gene() {
		node = nodeTreeDemo.getNode();
	}
	
	public String toString() {
		return node.toString();
	}
}
