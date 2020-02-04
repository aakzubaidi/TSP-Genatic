package au.adelaide.uni.ec.problems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemManager {

	public void readProblem(String filename) {
		Problem problem = Problem.getProblem();
		try {
			BufferedReader data = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename)));
			String line = data.readLine();

			while (line != null) {
				if (line.contains("NAME")) {
					problem.setName(line.split(":")[1]);
				}
				if (line.contains("COMMENT")) {
					problem.setComment(line.split(":")[1]);
				}
				if (line.contains("TYPE")) {
					problem.setType(line.split(":")[1]);
				}
				if (line.contains("DIMENSION")) {
					problem.setDimension(line.split(":")[1]);
				}
				if (line.contains("EDGE_WEIGHT_TYPE")) {
					problem.setEdgeWeightType(line.split(":")[1]);
				}
				if (line.contains("NODE_COORD_SECTION")) {
					line = data.readLine();
					List<City> list = new ArrayList<>();
					problem.setCities(list);
					while (!line.equals("EOF")) {
						City c = new City(line);
						list.add(c);
						line = data.readLine();
					}
				}
				line = data.readLine();

			}
			data.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		problem.getDistance();
	}

	public void readSolution(String filename) {
		Problem problem = Problem.getProblem();
		try {
			BufferedReader data = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename)));
			String line = data.readLine();

			while (line != null) {
				if (line.contains("TOUR_SECTION")) {
					line = data.readLine();
					List<Integer> solution = new ArrayList<Integer>();
					problem.setSolution(solution);
					while (!line.equals("-1")) {
						solution.add(Integer.parseInt(line));
						line = data.readLine();
					}
				}
				line = data.readLine();

			}
			data.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		problem.getDistance();
	}
}
