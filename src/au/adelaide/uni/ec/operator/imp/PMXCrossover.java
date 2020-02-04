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
import java.util.Random;

import org.apache.log4j.Logger;


import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.operator.ICrossover;
import au.adelaide.uni.ec.problems.Problem;

/**
 * @author Dell
 * @date Aug 24, 2013
 * 
 */
public class PMXCrossover implements ICrossover {

	private Logger log = Logger.getLogger(this.getClass());  
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * au.adelaide.uni.ec.operator.ICrossover#excuteCrossover(au.adelaide.uni
	 * .ec.bo.Individual, au.adelaide.uni.ec.bo.Individual)
	 */
	@Override
	public List<Individual> excuteCrossover(Individual i1, Individual i2) {
		Random r = new Random(System.currentTimeMillis());
		int s1 = r.nextInt(i1.getTour().length);
		int s2 = r.nextInt(i2.getTour().length);
		
		int min = Math.min(s1, s2);
		int max = Math.max(s1, s2);
		int child[] = new int[i1.getTour().length];
		
		for(int i=0;i<child.length;i++){
			child[i] = -1;
		}
		
		int part1[] = new int[max-min+1];
		int part2[] = new int [max-min+1];
		
		int j=0;
		StringBuffer sb = new StringBuffer("~~~~~~~\n");
		for(int i=min;i<max+1;i++){
			child[i] = i1.getTour()[i];
			part1[j] = i1.getTour()[i];
			part2[j] = i2.getTour()[i];
			sb.append(part1[j]+" ");
			j++;
		}
		sb.append("======");
		for(int i=0;i<part2.length;i++){
			sb.append(part2[i]+" ");
		}
		log.debug(sb.toString());
		/*
		 * Looking in the same segment positions in parent 2, 
		 * select each value that hasn't already been copied to the child.
		 * 
		 * */
		for(int i=0;i<part2.length;i++){
			boolean exist =  false;
			for(int k=0;k<part1.length;k++){
				if(part1[k]==part2[i]){
					exist = true;
					break;
				}
			}
			if(!exist){
				int toCheck = part1[i];
				int dest = this.checkinParent(part2[i],toCheck, part1, part2);
				//find the mapping value and set it to the child array
				for(int m=0;m<i2.getTour().length;m++){
					if(dest==i2.getTour()[m]){
						child[m] = part2[i];
					}
				}
				
			}
		}
		
		//Copy the left part from parent2 to child
		for(int i=0;i<i2.getTour().length;i++){
			if(child[i]==-1){
				child[i] = i2.getTour()[i];
			}
		}

		List<Individual> offSprings = new ArrayList<Individual>(1);
		Individual offSpring1 = new Individual(Problem.getProblem(),child);
		
        offSprings.add(offSpring1);
        
        log.debug(offSpring1.printTour());
        return offSprings;
	}
	
	private int checkinParent(int src, int toCheck, int[]  part1, int[] part2){

				boolean exist = false;
				int index = -1;
				for(int m=0;m<part2.length;m++){
					if(toCheck==part2[m]&&toCheck!=src){
						exist = true;
						index = m;
						break;
					}
				}
				if(exist){
					int continueCheck = part1[index];
					return this.checkinParent(src,continueCheck, part1, part2);
				}
				else{
					return toCheck;
				}
				
				
	}
	
}
