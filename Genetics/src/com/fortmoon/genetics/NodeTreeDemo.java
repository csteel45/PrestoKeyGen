package com.fortmoon.genetics;

import java.util.ArrayList;
import java.util.Random;

import com.fortmoon.genetics.MathOperand.Operation;

/**
 * @author Christopher Steel - FortMoon Consulting, Inc.
 * 
 * @since Jan 29, 2011 8:58:43 AM
 */
public class NodeTreeDemo implements NodeTree {
	static Random random = new Random(System.currentTimeMillis());
	static ArrayList<Operand> operandList = new ArrayList<Operand>();
	private static int treeDepth = 0;
	private static int treeDepthLimit = 5;

	static {
		// operandList.add(new IfOperand());
		operandList.add(new MathOperand(Operation.PLUS));
		operandList.add(new MathOperand(Operation.TIMES));
		// operandList.add(new MathOperand(Operation.POWER));
	}

	public NodeTreeDemo() {
	}

	public Node buildTree(int arg1, int arg2) {
		Node rootNode = getNode(arg1, arg2);
		return rootNode;
	}

	/**
	 * @return
	 */
	public Node getNode() {
		Node node = null;
		// node is a FunctionNode
		Operand operand = operandList.get(random.nextInt(operandList.size()));
		ArrayList<Node> params = new ArrayList<Node>(2);
		// I think we need to add something to the list before we can call set. Not sure why.
		//System.out.println("Params size = " + params.size());
		int rand = 5;
		for (int i = 0; i < 2; i++) {
			rand = random.nextInt(3);
			// if(rand == 3 && lastRand == 0)
			// System.out.println("Rand = 0 both times");
			// lastRand = rand;
			if (rand == 0)
				params.add(new ParamNode(0));
			if (rand == 1)
				params.add(new ParamNode(1));
			if (rand > 1)
				params.add(new ConstNode(random.nextInt(20)));
		}
		node = new FunctionNodeBase(operand, params);

		return node;
	}

	public Node getNode(int arg1, int arg2) {
		Node node = null;
		treeDepth++;
		if (random.nextBoolean() && treeDepth < treeDepthLimit) {
			// node is a FunctionNode
			Operand operand = operandList.get(random.nextInt(operandList.size()));
			ArrayList<Node> params = new ArrayList<Node>();
			int rand = 5;
			int lastRand = 5;
			for (int i = 0; i < 2; i++) {
				rand = random.nextInt(4);
				// if(rand == 3 && lastRand == 0)
				// System.out.println("Rand = 0 both times");
				// lastRand = rand;
				if (rand == 0)
					params.add(new ConstNode(arg1));
				if (rand == 1)
					params.add(new ConstNode(arg2));
				if (rand == 2)
					params.add(new ConstNode(random.nextInt(5)));
				if (rand > 2)
					params.add(getNode(arg1, arg2));
			}
			node = new FunctionNodeBase(operand, params);
		} else {
			// node is a ConstantNode
			node = new ConstNode(random.nextInt(10));
		}
		treeDepth--;
		return node;
	}

	public static void main(String[] argumentss) {
		Node rootNode = null;
		NodeTree demo = new NodeTreeDemo();
		long fitness = Integer.MAX_VALUE;
		ArrayList<Node> args = new ArrayList<Node>();
		args.add(new ConstNode(8));
		args.add(new ConstNode(24));

		while (0 < fitness && fitness > 500) {
			rootNode = demo.buildTree(26, 35);
			fitness = Math.abs(829 - (Integer) rootNode.evaluate(args));
			fitness += Math.abs(141 - (Integer) rootNode.evaluate(args));
		}
		System.out.println("Node =: " + rootNode);
		System.out.println("Node evaluates to: " + rootNode.evaluate(args));
		System.out.println("Node evaluates2 to: " + rootNode.evaluate(args));
	}

}
