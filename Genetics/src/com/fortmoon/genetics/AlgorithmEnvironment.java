/**
 * 
 */
package com.fortmoon.genetics;

import java.util.Random;

/**
 * @author csteel
 *
 */
public class AlgorithmEnvironment extends Thread implements Environment {

	protected Population population;
	protected float threshold = 1.5f;

	/**
	 * @param args
	 */
	public AlgorithmEnvironment(int population) {
		super("Main");
		this.population = new Population(population);
	}
	
	
	public void init() {

	}

	public int calculateFitness() {
		// Feed the population the test data and let it sort out the fittest.
		return population.calculateFitness();
	}
	
	public void run() {
		long generation = 0;
		while(calculateFitness() > 1) {
			population.doCrossovers();
			population.doMutations();
			if(generation % 1000 == 1) {
				System.out.println("Fittest = " + population.getFittest().toString());
			}
			generation++;
		}

		System.out.println("Environment equilibrium complete. Found solution in " + generation + " generations.");
		System.out.println("Fittest chromosome = " + population.getFittest().toString());
	}
	
	public static void main(String args[]) {
		AlgorithmEnvironment env = new AlgorithmEnvironment(48);
		env.init();
		env.start();
		System.out.println("Environment started.");
	}
}
