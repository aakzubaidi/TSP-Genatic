// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.operator.imp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.operator.ICrossover;
import au.adelaide.uni.ec.problems.Problem;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class OrderCrossover implements ICrossover {

	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.ICrossover#excuteCrossover(au.adelaide.uni.ec.bo.Individual, au.adelaide.uni.ec.bo.Individual)
	 */
	@Override
	public List<Individual> excuteCrossover(Individual i1, Individual i2) {
		// TODO Auto-generated method stub
	//Get the size of tour	
		int size = i1.getTour().length;
	//	System.out.println(size);
	
		// Generate two random number in range of tour size
		Random r = new Random(System.currentTimeMillis());
		int r1=r.nextInt(size-1);
		int r2=r.nextInt(size);
		
		//create two integer list p1 and p2 to copy from individual i1 and i2
		
		List<Integer> p1 = new ArrayList<Integer>();
		List<Integer> p2 = new ArrayList<Integer>();
		
		// loop to put data in arraylist
		for (int i = 0; i < i1.getTour().length; i++)
	    {
	        p1.add(i1.getTour()[i]);
	        p2.add(i2.getTour()[i]);
	        
	    }
	
		//Store smaller random number in begin and bigger random number in end. 
		int begin=Math.min(r1, r2);
		int end=Math.max(r1, r2);
		//if you want to print the start and end position for crossover uncomment next comment
		/*		System.out.println(begin);
		System.out.println(end);
		*/	
		// Create two childs
		List<Integer> child1 = new ArrayList<Integer>();
		List<Integer> child2 = new ArrayList<Integer>();
		
		// copy cities from parent 1 and parent 2 to the correct positons i.e. accroding to begin and end 
		child1.addAll(p1.subList(begin, end));
		child2.addAll(p2.subList(begin, end));
	
	//If you want to print the parents remove the next comment.	
	/*	for(int i=0;i<p1.size();i++){
			System.out.print(p1.get(i));
		}
		System.out.print("\n");
		for(int i=0;i<p2.size();i++){
			System.out.print(p2.get(i));
		}
		System.out.print("\n");
	*/	
		// initialise current city position
		int citypos=0;
		//initialise city position in parent 1
		int cpos_i1=0;
		// initialise city position in parent 2
		int cpos_i2=0;
				
		
		
		for(int i=0;i<size;i++ )
		{
			//position of current city
			citypos=(end+i) % size ;
			// get the city at the current position in each of the two parents
			cpos_i1=p1.get(citypos);
			cpos_i2=p2.get(citypos);
			
			// if child 1 does not already contain the current city in parent 2, add it			
			if(!child1.contains(cpos_i2))
			{
				child1.add(cpos_i2);
			}
			
			 // if child 2 does not already contain the current city in parent 1, add it
			
			if(!child2.contains(cpos_i1))
			{
				child2.add(cpos_i1);
			}				
		}
		
		// rotate the lists so the original slice is in the same place as in the parents 
		Collections.rotate(child1, begin);
		Collections.rotate(child2, begin);
		//if you want to print children uncomment the next comment.	
	/*	for(int i=0;i<child1.size();i++){
			System.out.print(child1.get(i));
		}
		System.out.print("\n");
		for(int i=0;i<child2.size();i++){
			System.out.print(child2.get(i));
		}
	*/	
		// convert bact the array list to int array
		int ret1[]=new int[size];
		int ret2[]=new int[size];
		for(int i=0;i<child1.size();i++)
		{
			ret1[i]=child1.get(i);
			ret2[i]=child2.get(i);
		}
		
		
		
		List<Individual> offspring = new ArrayList<Individual>(2);
		
		Individual offspring1 = new Individual(Problem.getProblem(),ret1);
		Individual offspring2 = new Individual(Problem.getProblem(),ret2);
		
		offspring.add(offspring1);
		offspring.add(offspring2);
		
		//return the offspring
		
		return offspring;
	}


}
