// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.operator.imp;

import java.util.List;

import org.apache.log4j.Logger;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;
import au.adelaide.uni.ec.operator.IMutation;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class InsertMutation implements IMutation{

	private Logger log = Logger.getLogger(this.getClass()); 
	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.IMutation#executeMutation(au.adelaide.uni.ec.bo.Population)
	 */
	@Override
	public List<Individual> executeMutation(Population p) {
		for(int i=0;i<p.getInds().size();i++){
			int length = p.getInds().get(i).getTour().length;
			int randomId1 = (int) (Math.random() * length);//is it length or length+1? need to test
			int randomId2 = (int) (Math.random() * length);
			while(randomId1==randomId2){
				randomId2 = (int) (Math.random() * length);
			}//keep it not same
			
			int[] newTour  = p.getInds().get(i).getTour().clone();
			if(Math.abs(randomId1-randomId2)!=1){
				int temp = newTour[Math.min(randomId1, randomId2)+1];
				newTour[Math.min(randomId1, randomId2)+1] =  p.getInds().get(i).getTour()[Math.max(randomId1, randomId2)];
				newTour[Math.max(randomId1, randomId2)] = -1;
				for(int j=Math.min(randomId1, randomId2)+2;j<p.getInds().get(i).getTour().length;j++){
					if(newTour[j]!=-1){
						int temp2=  newTour[j];
						newTour[j]=temp;
						temp = temp2;
					}
					else{
						newTour[j]=temp;
						break;
					}
				}
				p.getInds().get(i).setTour(newTour);
			}

		}
		
		for(int i=0;i<p.getInds().size();i++){
			log.debug(p.getInds().get(i).printTour());
		}
		return p.getInds();
	}

}
