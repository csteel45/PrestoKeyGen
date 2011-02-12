package com.fortmoon.genetics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author csteel
 *
 */
public class Population {
	private ArrayList<Chromosome> chromosomes;
	private Random random = new Random(System.currentTimeMillis());
	private int[][] testData;
	
	private Population() {
		chromosomes = new ArrayList<Chromosome>();
	}
	
	public Population(int numChromosomes) {
		this();
		setNumChromosomes(numChromosomes);
//		int[][] testData = new int[][] {{26,35,829}, {8,24,141}, {20,1,467}, {33,11,1215}, {37,16,157}};
		testData = new int[8][3];
		for(int i = 0; i < 8; i++) {
			int x = random.nextInt(50);
			int y = random.nextInt(50);
			int result = x*x + 2*y + 3*x + y*y;
			testData[i][0] = x;
			testData[i][1] = y;
			testData[i][2] = result;			
		}
	}

	public int getNumChromosomes() {
		return chromosomes.size();
	}

	public void setNumChromosomes(int numChromosomes) {
		if(numChromosomes == chromosomes.size())
			return;
		
		if(chromosomes.size() < numChromosomes) {
			int diff = numChromosomes - chromosomes.size();
			for(int i = 0; i < diff; i++) {
				
				//Start with 1 gene per Chromosome and grow
				Chromosome c = new Chromosome(1, 0);
				c.setFitness(Integer.MAX_VALUE);
				chromosomes.add(c);
			}
		}
		else {
			int diff = chromosomes.size() - numChromosomes;
			for(int i = 0; i < diff; i++) {
				chromosomes.remove(chromosomes.size() - 1);
			}
		}
		System.out.println("Population size now = " + chromosomes.size());
	}
	
	public void doCrossovers() {
		Chromosome c = chromosomes.get(0);
		for(int i = 1; i < chromosomes.size() - 1; i++) {
			int rand = random.nextInt(chromosomes.size()/3);
			// For a random number of genes
				// Grab some random genes
			int geneIndex = random.nextInt(c.getGenes().size());
			Gene gene = c.getGenes().get(geneIndex);
			Chromosome target = chromosomes.get(i+1);
			if(target.getGenes().size() < geneIndex+1)
				target.getGenes().add(gene);
			else
				target.getGenes().set(geneIndex, gene);
			c = chromosomes.get(i);
		}
	}
	
	public void doMutations() {
		for(int i = 0; i < 6; i++) {
			Chromosome c = chromosomes.get(3 + random.nextInt(chromosomes.size()-3));
			if(random.nextInt(10000) > 9998) {
				c.getGenes().add(new Gene());
			}
			c.mutate();
		}
	}

	/**
	 * @return
	 */
	public Chromosome getFittest() {
		// TODO Auto-generated method stub
		sort();
		return chromosomes.get(0);
	}

	/**
	 * 
	 */
	public void sort() {
		Collections.sort(chromosomes);		
	}

	/**
	 * @throws InterruptedException 
	 * 
	 */
	public int calculateFitness() {
		Random random = new Random(System.currentTimeMillis());
		int populationFitness = Integer.MAX_VALUE;
		for(Chromosome c : chromosomes) {
			int fitness = 0;
			for(int[] data : testData) {
//				System.out.println("Test data = " + data[0] + " " + data[1] + " " + data[2]);
				int expResult = data[2];
				fitness += Math.abs(c.evaluate(data[0], data[1]) - expResult);
			}
			c.setFitness(fitness);

			if(fitness < populationFitness)
				populationFitness = fitness;
		}
		
		return populationFitness;
	}

}
