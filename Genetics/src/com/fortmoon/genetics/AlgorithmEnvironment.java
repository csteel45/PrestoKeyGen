/**
 * 
 */
package com.fortmoon.genetics;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * @author csteel
 *
 */
public class AlgorithmEnvironment extends Thread implements Environment {

	protected Population population;
	protected float threshold = 1.5f;
	private BigDecimal ZERO = new BigDecimal(0);

	/**
	 * @param args
	 */
	public AlgorithmEnvironment(int population) {
		super("Main");
		this.population = new Population(population);
	}
	
	
	public void init() {
		Random random = new Random(System.currentTimeMillis());
		Collection<ArrayList<BigDecimal>> testData = new ArrayList<ArrayList<BigDecimal>>(8);
		for (int i = 0; i < 8; i++) {
			ArrayList<BigDecimal> set = new ArrayList<BigDecimal>(3);

			int x = random.nextInt(50);
			int y = random.nextInt(50);
			int result = (x * y + 2 + (x * 9) + 12*y);
			
			set.add(BigDecimal.valueOf(x));
			set.add(BigDecimal.valueOf(y));
			set.add(BigDecimal.valueOf(result));

			testData.add(set);
		}
		//System.out.println("Test data = " + testData);
		population.setTestData(testData);
	}

	public BigDecimal calculateFitness() {
		// Feed the population the test data and let it sort out the fittest.
		return population.calculateFitness();
	}
	
	public void run() {
		long generation = 0;
		while(calculateFitness().compareTo(ZERO) > 0 && generation < Integer.MAX_VALUE) {
			population.doCrossovers();
			population.sort();
			population.doMutations();
			if(generation % 1000 == 1) {
				System.out.println("Fittest = " + population.getFittest().toString());
			}
			generation++;
		}

		if(calculateFitness().equals(ZERO)) {
			System.out.println("Environment equilibrium complete. Found solution in " + generation + " generations.");
		}
		else {
			System.out.println("Environment equilibrium complete. Did not find solution after " + generation + " generations.");
		}

		System.out.println("Fittest chromosome = " + population.getFittest().toString());
	}
	
	public static void main(String args[]) {
		AlgorithmEnvironment env = new AlgorithmEnvironment(48);
		env.init();
		env.start();
		System.out.println("Environment started.");
	}
}
