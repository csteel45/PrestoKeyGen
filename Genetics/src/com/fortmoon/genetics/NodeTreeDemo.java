package com.fortmoon.genetics;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 *
 * @since Jan 29, 2011 8:58:43 AM
 */
public class NodeTreeDemo implements NodeTree {
	Random random = new Random(System.currentTimeMillis());
	ArrayList<Operand> operandList = new ArrayList<Operand>();
	private int treeDepth = 0;
	private int treeDepthLimit = 4;
	
	public Node buildTree() {
		Node rootNode = getNode();
		operandList.add(new IfOperand());
		return rootNode;
	}
	
	public Node getNode() {
		Node node = null;
		treeDepth++;
		if(random.nextBoolean() && treeDepth < treeDepthLimit) {
			//node is a FunctionNode
			Operand operand = operandList.get(random.nextInt(operandList.size()));		
		}
		else {
			//node is a ConstantNode
		}
		treeDepth--;
		return node;
	}
	
	public static void main(String[] args) {
		NodeTree demo = new NodeTreeDemo();
		
		Node rootNode = demo.buildTree();
		
		System.out.println("Node =: " + rootNode);
		System.out.println("Node evaluates to: " + rootNode.evaluate());
	}
}
