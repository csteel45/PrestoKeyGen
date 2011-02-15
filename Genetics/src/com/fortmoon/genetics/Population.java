package com.fortmoon.genetics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * @author csteel
 *
 */
public class Population {
	private ArrayList<Chromosome> chromosomes;
	private Random random = new Random(System.currentTimeMillis());
	protected Collection<ArrayList<BigDecimal>> testData;
	protected Double mutationRate = 0.2;  

	private Population() {
		chromosomes = new ArrayList<Chromosome>();
	}

	public Population(int i) {
		this();
		this.setNumChromosomes(i);
	}
	
	/**
	 * @throws InterruptedException 
	 * 
	 */
	public BigDecimal calculateFitness() {
		BigDecimal populationFitness = BigDecimal.valueOf(Long.MAX_VALUE);
		for(Chromosome c : chromosomes) {
			BigDecimal fitness = BigDecimal.valueOf(0);
			for(ArrayList<BigDecimal> data : testData) {
				BigDecimal x = data.get(0);
				BigDecimal y = data.get(1);
				BigDecimal expResult = data.get(2);
				BigDecimal actualResult = c.evaluate(x,y); 
				//System.out.println("Test data = " + x + " " + y + " " + expResult);
				//System.out.println("Actual result = " + actualResult);
				fitness = fitness.add((actualResult.subtract(expResult)).abs());
				//if(fitness.longValue() == 0 )
					//System.out.println("########################################fitness = " + fitness);
			}
			c.setFitness(fitness);

			if(fitness.compareTo(populationFitness) < 0)
				populationFitness = fitness;
		}
		
		return populationFitness;
	}	

	public void doCrossovers() {
		Chromosome c = chromosomes.get(0);
		for(int i = 1; i < chromosomes.size() - 1; i++) {
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
		// Let's mutate a vaible percentage of the population
		int numMutations = (int)(chromosomes.size() * mutationRate);
		//System.out.println("Num mutations = " + numMutations);
		for(int i = 0; i < numMutations; i++) {
			Chromosome c = chromosomes.get(random.nextInt(chromosomes.size()));
			if(random.nextInt(100000) > 99998) {
				System.out.println("Adding a gene.");
				c.getGenes().add(new Gene());
			}
/*			if(random.nextInt(100000) > 99998) {
				c = chromosomes.get(0);
				if(c.getGenes().size() > 1)
					c.getGenes().remove(c.getGenes().size() - 1);
			}
*/			c.mutate();
		}
	}

	public Chromosome getFittest() {
		// TODO Auto-generated method stub
		sort();
		return chromosomes.get(0);
	}

	public void sort() {
		Collections.sort(chromosomes);		
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
				c.setFitness(BigDecimal.valueOf(Integer.MAX_VALUE));
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

	public Collection<ArrayList<BigDecimal>> getTestData() {
		return testData;
	}

	public void setTestData(Collection<ArrayList<BigDecimal>> testData) {
		this.testData = testData;
	}
	
	public Double getMutationRate() {
		return mutationRate;
	}

	public void setMutationRate(Double mutationRate) {
		this.mutationRate = mutationRate;
	}

}
