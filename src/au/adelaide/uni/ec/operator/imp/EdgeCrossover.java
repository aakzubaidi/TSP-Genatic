// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.operator.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.operator.ICrossover;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class EdgeCrossover implements ICrossover {

	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.ICrossover#excuteCrossover(au.adelaide.uni.ec.bo.Individual, au.adelaide.uni.ec.bo.Individual)
	 */
	@Override
	public List<Individual> excuteCrossover(Individual i1, Individual i2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void generateNeigbourList(Individual i1, Individual i2){
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<i1.getTour().length;i++){
			
		}
	}

}
