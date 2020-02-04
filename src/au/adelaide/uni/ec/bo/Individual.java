package au.adelaide.uni.ec.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import org.apache.log4j.Logger;

import au.adelaide.uni.ec.problems.Problem;

public class Individual implements Comparable<Individual>{

	private Logger log = Logger.getLogger(this.getClass());  
	private int[] tour;
	private Problem p;
	
	public int[] getTour() {
		return tour;
	}
	
	public double getFitness() {
	     double fitness = 0.0;
	     int cityNum = p.getCities().size();
	     int [][] distance =p.getDistance() ;
	     int len = 0;
	     for (int i = 0; i < cityNum - 1; i++) {
	    	 len += distance[this.tour[i]][this.tour[i+1]]; 
	     	}
	      len += distance[0][tour[cityNum-1]];
	      fitness = 1.0/len;
	      return fitness;
	}
	
	public int getTotalLength(){
	     int cityNum = p.getCities().size();
	     int [][] distance =p.getDistance() ;
	     int len = 0;
	     for (int i = 0; i < cityNum - 1; i++) {
	    	 len += distance[this.tour[i]][this.tour[i+1]]; 
	     	}
	      len += distance[0][tour[cityNum-1]];
	      return len;
	}



	public Individual(Problem p){
		tour =  new int [p.getCities().size()];
		this.p = p;
		Vector<Integer> allowedCities = new Vector<Integer>();
		 for (int i = 0; i < p.getCities().size(); i++) {
			 allowedCities.add(Integer.valueOf(i));
		 }
		 
		 Random r = new Random(System.currentTimeMillis());
		 for (int i = 0; i < p.getCities().size(); i++) {
			 int index = r.nextInt(allowedCities.size());
			 int selectedCity = allowedCities.get(index).intValue();
			 tour[i] = selectedCity;
			 allowedCities.remove(index);
		 }
		
//		List<Integer> tourList = new ArrayList<Integer>();
//		 for (int i = 0; i < p.getCities().size(); i++) {
//			 tourList.add( p.getCities().get(i).getNum()-1);
//		 }
//		 Collections.shuffle(tourList);
//		 for (int i = 0; i < p.getCities().size(); i++) {
//			 tour[i] = tourList.get(i);
//		 }
	}

	public Individual(Problem p, int[] tour){
		this.tour =  new int [p.getCities().size()];
		this.p = p;
		this.tour = tour;
	}
	
	public void setTour(int[] tour){
		this.tour =  tour;
	}

	@Override
	public int compareTo(Individual arg0) {
		return (int) (arg0.getFitness()-this.getFitness());
	}
	
	public StringBuffer printTour(){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<tour.length;i++){
			sb.append(tour[i]+" ");
		}
		return sb;
		
	}
	
}
