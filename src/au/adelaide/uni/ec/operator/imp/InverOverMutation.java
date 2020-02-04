package au.adelaide.uni.ec.operator.imp;


import java.util.ArrayList;
import java.util.List;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;
import au.adelaide.uni.ec.operator.IMutation;
import au.adelaide.uni.ec.problems.Problem;


/**
 * implementing the the inver over operation as explained in the paper 
 */
public class InverOverMutation implements IMutation {

	private double p = 0.02d; // possibility to create new connections

	@Override
	public List<Individual> executeMutation(Population population) {
		int city, nextCity, indexOfCity, indexOfNextCity, indexNCity, indexPCity;
		int[] tour, tour2;
		Individual parent, child;
		List<Individual> output = new ArrayList<Individual>();
		boolean exitloop;
		// for each individual of the population
		for (Individual individual : population.getInds()) {
			parent = individual;
			tour = parent.getTour();
			// select randomly a city from "tour"
			indexOfCity = (int) (Math.random() * (tour.length - 1));
			city = tour[indexOfCity];
			exitloop = false;
			do {
				if (Math.random() <= p) {
					// select the nextcity from the remaining cities in "tour"
					indexOfNextCity = (int) (Math.random() * (tour.length - 2)); // 0..n-2
					if (indexOfCity == indexOfNextCity)
						indexOfNextCity = tour.length - 1;
					nextCity = tour[indexOfNextCity];
				}
				else {
					// select randomly an individual from Population
					int randomIndividual = (int) (Math.random() * (population.getInds().size()));
					tour2 = population.getInds().get(randomIndividual).getTour();
					// assign to "nextCity" the next city to the "city" in the
					// selected individual
					nextCity = tour2[(findIndex(tour2, city) + 1) % tour2.length];
					// is unknown
					indexOfNextCity = -1;
				}
				// if the next or previous city of "city" in "tour" is
				// "nextCity"
				indexNCity = (indexOfCity + 1) % tour.length;
				indexPCity = (indexOfCity == 0) ? tour.length - 1 : indexOfCity - 1;
				if (tour[indexNCity] == nextCity || tour[indexPCity] == nextCity) {
					exitloop = true;
				}
				else {
					tour = inverse(tour, indexNCity, (indexOfNextCity == -1) ? findIndex(tour, nextCity)
							: indexOfNextCity);
				}
			} while (!exitloop);
			// child = new Individual(schedule, new PermutationGenotype(tour),
			// new Individual[] { parent });
			child = new Individual(Problem.getProblem(), tour);// , new Individual[] { parent
													// });
			output.add(child);
		}
		return output;
	}
	
	
	/**
	 * Inverse a substring from position start to end
	 * 
	 * @return the array with the inverted section
	 */
	private int[] inverse(int[] tour, int start, int end) {
		int[] result = (int[]) tour.clone();
		for (int i = 0; (start + i - 1) % tour.length != end; i++) {
			result[(start + i) % tour.length] = tour[(end - i < 0) ? end - i + tour.length : end - i];
		}
		return result;
	}


	private int findIndex(int[] tour, int city) {
		int i;
		for (i = 0; tour[i] != city; i++) {
		}
		return i;
	}
}
