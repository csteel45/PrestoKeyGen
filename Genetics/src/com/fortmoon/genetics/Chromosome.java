package com.fortmoon.genetics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

public class Chromosome implements Comparable {
	private ArrayList<Gene> genes;
	private int fitness;
	private UUID uuid;
	private ArrayList<ParamNode> inputs;
	private Random random = new Random(System.currentTimeMillis()+20000);

	private Chromosome() {
		uuid = UUID.randomUUID();
	}

	public Chromosome(int numGenes, int inputSize) {
		this();

		genes = new ArrayList<Gene>(numGenes);
		for (int i = 0; i < numGenes; i++) {
			genes.add(createGene());
		}
	}
	
	public Gene createGene() {
		return new Gene();
	}

	public void mutate() {
		Gene gene = createGene();
		genes.set(random.nextInt(genes.size()), gene);
	}

	public int getNumGenes() {
		return genes.size();
	}

	public void setGenes(ArrayList<Gene> genes) {
		this.genes = genes;
	}

	public ArrayList<Gene> getGenes() {
		return genes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		if (o instanceof Chromosome) {
			Chromosome c = (Chromosome) o;
			return (this.fitness < c.fitness ? -1 : (this.fitness == c.fitness ? 0 : 1));
		}
		return 0;
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	public int evaluate(int i, int j) {
		ArrayList<Node> inputs = new ArrayList<Node>();
		inputs.add(new ConstNode(i));
		inputs.add(new ConstNode(j));
		int result = 0;
		//System.out.println("--------------------------------");
		for(Gene gene : genes) {
			result += gene.node.evaluate(inputs).intValue();
			//System.out.println("Gene " + gene + " Result for " + i + " " + j + " = " + result);
		}
		return result;
	}

	/**
	 * @return
	 */
	private int getFitness() {
		// TODO Auto-generated method stub
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("\n\tUUID: " + uuid);
		buf.append("\n\tFintess: " + fitness);
		for (Gene gene : genes) {
			buf.append("\n\tGene: " + gene);
		}
		return buf.toString();
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<Chromosome> list = new ArrayList<Chromosome>();
		for (int i = 0; i < 48; i++) {
			Chromosome c = new Chromosome(4, 0);
			c.setFitness(5000);
			list.add(c);
		}
		// System.out.println("Unsorted list: " + list);
		Collections.sort(list);
		System.out.println("Sorted list: " + list);

	}

}
