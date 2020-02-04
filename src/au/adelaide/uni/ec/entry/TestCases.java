// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.entry;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;
import au.adelaide.uni.ec.operator.imp.CycleCrossover;
import au.adelaide.uni.ec.operator.imp.InsertMutation;
import au.adelaide.uni.ec.operator.imp.PMXCrossover;
import au.adelaide.uni.ec.problems.Problem;
import au.adelaide.uni.ec.problems.ProblemManager;

/**
 * @author Dell
 * @date Aug 28, 2013
 *
 */
public class TestCases {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProblemManager pf = new ProblemManager();
		pf.readProblem("eil51.tsp");
		
//		int tour1[] = {0,1,7,4,5,6,2,3,8,9,11,12,10};
//		int tour2[] = {12,2,3,5,1,4,7,0,9,8,6,10,11};
		int tour1[] = {23,22,13,45,50,44,9,29,41,7,10,26,35,2,11,3,43,12,39,1,16,36,27,37,31,42,17,8,14,38,0,49,28,33,20,47,18,19,25,4,46,6,40,5,15,32,21,34,48,30,24};
		int tour2[] = {13,7,50,33,6,46,18,3,27,28,37,11,8,4,31,12,43,21,20,32,14,30,24,0,16,17,45,1,19,5,47,48,25,49,44,38,42,23,29,40,39,10,34,26,15,9,35,36,41,2,22};
		Individual i1 = new Individual(Problem.getProblem(),tour1);
		Individual i2 = new Individual(Problem.getProblem(),tour2);
		
		//test cycle crossover
//		CycleCrossover cc = new CycleCrossover();
//		cc.excuteCrossover(i1, i2);
//		
		//test PMX
		PMXCrossover pc = new PMXCrossover();
		pc.excuteCrossover(i1, i2);
		
		//test Insert mutation
//		Population pop = new Population(Problem.getProblem(),3,false);
//		InsertMutation im = new InsertMutation();
//		pop.getInds().add(i1);
//		pop.getInds().add(i2);
//		im.executeMutation(pop);

	}

}
