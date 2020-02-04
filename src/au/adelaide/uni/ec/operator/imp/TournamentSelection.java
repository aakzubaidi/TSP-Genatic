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

import org.apache.log4j.Logger;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;
import au.adelaide.uni.ec.operator.ISelection;
import au.adelaide.uni.ec.problems.Problem;

/**
 * @author Dell
 * @date Aug 24, 2013
 *
 */
public class TournamentSelection implements ISelection{

	private Logger log = Logger.getLogger(this.getClass()); 
	
	/* (non-Javadoc)
	 * @see au.adelaide.uni.ec.operator.ISelection#executeSelect(au.adelaide.uni.ec.bo.Population)
	 */
	@Override
	public List<Individual> executeSelect(Population p) {
		Population tournamentSelection = new Population(Problem.getProblem(),5,false);
		for (int i = 0; i < 2; i++) {
            int randomId = (int) (Math.random() * (p.getInds().size()));
            tournamentSelection.getInds().add(p.getInds().get(randomId));
        }
        Individual fittest1 = tournamentSelection.getFittest();
		Population tournamentSelection2 = new Population(Problem.getProblem(),5,false);
		for (int i = 0; i < 2; i++) {
            int randomId = (int) (Math.random() * (p.getInds().size()));
            tournamentSelection2.getInds().add(p.getInds().get(randomId));
        }
        Individual fittest2 = tournamentSelection2.getFittest();
        //low chance to get the same individual
        
        List<Individual> selectedParents = new ArrayList<Individual>(2);
        selectedParents.add(fittest1);
        selectedParents.add(fittest2);
        log.debug(fittest1.printTour());
        log.debug(fittest2.printTour());
        return selectedParents;
	}

}
