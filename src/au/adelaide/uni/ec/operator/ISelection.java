// $Id$
/**
 * Copyright (C) 2013 UOA
 * University of Adelaide
 * 
 *
 */
package au.adelaide.uni.ec.operator;

import java.util.List;

import au.adelaide.uni.ec.bo.Individual;
import au.adelaide.uni.ec.bo.Population;

/**
 * @author Dell
 * @date Aug 24, 2013
 * 
 */
public interface ISelection {

	public List<Individual> executeSelect(Population p);
}
