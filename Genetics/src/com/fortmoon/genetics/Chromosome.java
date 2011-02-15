package com.fortmoon.genetics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

public class Chromosome implements Comparable<Object> {
	private ArrayList<Gene> genes;
	private BigDecimal fitness;
	private UUID uuid;
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

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	public BigDecimal evaluate(BigDecimal x, BigDecimal y) {
		ArrayList<Node> inputs = new ArrayList<Node>();
		inputs.add(new ConstNode(x));
		inputs.add(new ConstNode(y));
		BigDecimal result = BigDecimal.valueOf(0);
		//System.out.println("--------------------------------");
		for(Gene gene : genes) {
			BigDecimal eval = BigDecimal.valueOf(gene.node.evaluate(inputs).longValue());
			//System.out.println("Eval: " + eval);
			result = result.add(eval);
			//System.out.println("Gene " + gene + " Result for " + x + " " + y + " = " + result);
		}
		return result;
	}

	/**
	 * @return
	 */
	private BigDecimal getFitness() {
		// TODO Auto-generated method stub
		return fitness;
	}

	public void setFitness(BigDecimal fitness2) {
		this.fitness = fitness2;
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
			return (getFitness().compareTo(c.fitness));
		}
		return 0;
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

	public static void main(String[] args) {
		ArrayList<Chromosome> list = new ArrayList<Chromosome>();
		for (int i = 0; i < 48; i++) {
			Chromosome c = new Chromosome(4, 0);
			c.setFitness(BigDecimal.valueOf(5000));
			list.add(c);
		}
		// System.out.println("Unsorted list: " + list);
		Collections.sort(list);
		System.out.println("Sorted list: " + list);

	}

}
