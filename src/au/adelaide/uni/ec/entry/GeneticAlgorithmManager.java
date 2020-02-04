package au.adelaide.uni.ec.entry;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import au.adelaide.uni.ec.bo.Envolution;
import au.adelaide.uni.ec.operator.imp.*;

public class GeneticAlgorithmManager {

	public static void main(String[] args) {
		 BasicConfigurator.configure();
	     PropertyConfigurator.configure("log4j.properties");  
		
		Envolution e = new Envolution(new TournamentSelection(), new ReplaceWorstSelection(), new InsertMutation(),new PMXCrossover());
		e.envolve(4, 500, "", "eil51.tsp", "eil51.opt.tour");

	}
}
