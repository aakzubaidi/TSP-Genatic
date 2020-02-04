// $Id$
/**
* Copyright (C) 2013 UOA
* University of Adelaide
* 
*
*/
package au.adelaide.uni.ec.operator.imp;

import java.util.Collections;
import java.util.List;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;
import au.adelaide.uni.ec.operator.ISelection;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class ReplaceWorstSelection implements ISelection{

	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.ISelection#executeSelect(au.adelaide.uni.ec.bo.Population)
	 */
	@Override
	public List<Individual> executeSelect(Population p) {
		Collections.reverse(p.getInds());
		int needToRemove = p.getInds().size() - p.getInitialSize();
		for(int i=1;i<=needToRemove;i++){
			p.getInds().remove(p.getInds().size()-i);
		}
		Collections.shuffle(p.getInds());
		return p.getInds();
	}

}
