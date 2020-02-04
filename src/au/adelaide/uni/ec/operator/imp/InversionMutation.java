// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.operator.imp;

import java.util.List;
import java.util.Random;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;
import au.adelaide.uni.ec.operator.IMutation;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class InversionMutation implements IMutation {

	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.IMutation#executeMutation(au.adelaide.uni.ec.bo.Population)
	 */
	@Override
	public List<Individual> executeMutation(Population p) {
		 Random r = new Random(System.currentTimeMillis());
		for(Individual ind:p.getInds()){
			int s1 = r.nextInt(ind.getTour().length);
			int s2 = r.nextInt(ind.getTour().length);
			
			int max = Math.max(s1, s2);
			int min = Math.min(s1, s2);
			for(int i=min;i<=(max+1)/2;i++){
				int temp = ind.getTour()[i];
				ind.getTour()[i] = ind.getTour()[max-i+1];
				ind.getTour()[max-i+1] = temp;
			}
		}
		return p.getInds();
	}

}
