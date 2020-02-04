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

/**
 * @author Dell
 * @date Aug 24, 2013
 * 
 */
public interface ICrossover {

	/*
	 * 
	 */
	public List<Individual> excuteCrossover(Individual i1, Individual i2);
}
