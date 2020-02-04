package au.adelaide.uni.ec.bo;

import java.util.ArrayList;
import java.util.List;

import au.adelaide.uni.ec.problems.Problem;

public class Population {

	private List<Individual> inds;
	private double avearageFitness;
	private int initialSize;

	public int getInitialSize() {
		return initialSize;
	}

	private double bestFitness;

	public double getBestFitness(){
		return bestFitness;
	}

	public double getAvearageFitness() {
		return avearageFitness;
	}
	
	public List<Individual> getInds() {
		return inds;
	}

	public Population (Problem p, int size,boolean initial){
		inds = new ArrayList<Individual>(size);
		if(initial){
			for(int i=0;i<size;i++){
				inds.add(new Individual(p)) ;
			}
		}
	}
	
    public Individual getFittest() {
        Individual fittest = inds.get(0);
        for (int i = 0; i < inds.size(); i++) {
            if (fittest.getFitness() <= this.inds.get(0).getFitness()) {
                fittest = this.inds.get(i);
            }
        }
        return fittest;
    }
    
    public void calculateFitness(){
    	double sum =0.0;
    	double best =0.0;
    	for(int i=0;i<inds.size();i++){
    		sum += inds.get(i).getFitness();
    		if(best<inds.get(i).getFitness()){
    			best = inds.get(i).getFitness();
    		}
    	}
    	avearageFitness =  sum/inds.size();
    	bestFitness = best;
    }

}
