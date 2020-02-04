package au.adelaide.uni.ec.bo;

import java.util.List;

import org.apache.log4j.Logger;

import au.adelaide.uni.ec.operator.*;
import au.adelaide.uni.ec.problems.Problem;
import au.adelaide.uni.ec.problems.ProblemManager;

public class Envolution {
	
	private ISelection parentsSelection;
	private ISelection survivorSelection;
	private IMutation mutation;
	private ICrossover crossover;
	private Population envolvingGeneration;
	private Logger log = Logger.getLogger(this.getClass());
	
	public Envolution(ISelection parentsSelection,ISelection survivorSelection,IMutation mutation,ICrossover crossover){
		this.parentsSelection=parentsSelection;
		this.survivorSelection=survivorSelection;
		this.crossover=crossover;
		this.mutation=mutation;
	}
	
	public void envolve(int poplationSize,int generationSize,String outputFile,String problemFile,String optimumFile){
		this.readProblem(problemFile);
		this.initial(poplationSize);
		this.envolve(generationSize);
		this.outputOptimumResult(optimumFile);
		this.recordOutput(outputFile);
	}
	
	private void readProblem(String problemFile){
		ProblemManager pf = new ProblemManager();
		pf.readProblem(problemFile);
	}
	
	private Population initial(int poplationSize){
		Population fisrtGeneration = new Population(Problem.getProblem(),poplationSize,true);
		for(int i=0;i<fisrtGeneration.getInds().size();i++){
			log.debug(fisrtGeneration.getInds().get(i).printTour());
		}
		return this.envolvingGeneration=fisrtGeneration;
	}
	
	private void envolve(int generationSize){
		for(int i=0;i<generationSize;i++){
			List<Individual> selectedParents  = this.parentsSelection.executeSelect(envolvingGeneration);
			List<Individual> offSprings  = this.crossover.excuteCrossover(selectedParents.get(0), selectedParents.get(1));
			envolvingGeneration.getInds().addAll(offSprings);
			this.mutation.executeMutation(envolvingGeneration);
			this.survivorSelection.executeSelect(envolvingGeneration);
			outputActualResult(i);
		}
	}
	
	private void outputActualResult(int i){
		envolvingGeneration.calculateFitness();
//		System.out.println("Best fitness in "+ i+" generation "+envolvingGeneration.getBestFitness());
//		System.out.println("Average fitness in "+ i+" generation "+pop.getAvearageFitness());
		log.info("Best length of the tour in "+ i+" generation "+1/envolvingGeneration.getBestFitness());
	}
	
	private void outputOptimumResult(String optimumFile){
		ProblemManager pf = new ProblemManager();
		pf.readSolution(optimumFile);
		int[] tour = new int[Problem.getProblem().getSolution().size()];
		for(int i=0;i<Problem.getProblem().getSolution().size();i++){
			tour[i] =  Problem.getProblem().getSolution().get(i)-1;
		}
		
		Individual i = new Individual(Problem.getProblem(),tour);
		log.info("Optimum solution is "+i.getTotalLength());
	}
	
	private void recordOutput(String outputFile){
		
	}
	

}
