// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.operator.imp;

import java.util.ArrayList;
import java.util.List;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.operator.ICrossover;
import au.adelaide.uni.ec.problems.Problem;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class CycleCrossover implements ICrossover{

	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.ICrossover#excuteCrossover(au.adelaide.uni.ec.bo.Individual, au.adelaide.uni.ec.bo.Individual)
	 */
	@Override
	public List<Individual> excuteCrossover(Individual i1, Individual i2) {
		List<Integer> list = new ArrayList<Integer>();
		
		List<Individual> offSprings = new ArrayList<Individual>(2);
		
		int[] newTour1 = i1.getTour().clone();
		int[] newTour2 = i2.getTour().clone();
		
		int first =i1.getTour()[0];
		int matchInTour2 = i2.getTour()[0];
		
		
//		if(first!=matchInTour2){
//			offSprings.add(i1);
//			offSprings.add(i2);
//			return offSprings;
//		}
		list.add(0);
		
		cycleCrossover(list,first,matchInTour2,i1.getTour(),i2.getTour());
		
		int tempValue=0;
		for(int i=0;i<list.size();i++){
				tempValue= newTour1[list.get(i)];
				newTour1[list.get(i)] = newTour2[list.get(i)];
				newTour2[list.get(i)] = tempValue;
		}

		Individual offSpring1 = new Individual(Problem.getProblem(),newTour1);
		Individual offSpring2 = new Individual(Problem.getProblem(),newTour2);
		
        offSprings.add(offSpring1);
        offSprings.add(offSpring2);
        
        return offSprings;
	}
	
	private void cycleCrossover(List<Integer> list, int first, int target, int[] tour1, int[] tour2){
		for(int i=0;i<tour1.length;i++){
			if(target==tour1[i]){
				int matchInTour2=tour2[i];
				if(matchInTour2!=first){
					list.add(i);
					cycleCrossover(list, first, matchInTour2,tour1, tour2);
				}
				else{
					list.add(i);
					return ;
				}
			}
		}
	}

	
}
