package au.adelaide.uni.ec.problems;

import java.util.List;

public class Problem {

	private String name;
	private String comment;
	private String type;
	private String dimension;
	private String edgeWeightType;
	private List<City> cities;
	private List<Integer> solution;
	private int[][] distance;

	private static Problem p = null;

	private Problem() {
	}

	public static Problem getProblem() {
		if (p == null) {
			return p = new Problem();
		}
		return p;
	}

	public int[][] getDistance() {
		if (distance == null) {
			int cityNum = this.getCities().size();
			this.distance = new int[cityNum][cityNum];
			for (int i = 0; i < cityNum - 1; i++) {
				distance[i][i] = 0;
				for (int j = i + 1; j < cityNum; j++) {
					double rij = Math
							.sqrt((this.getCities().get(i).getX() - this
									.getCities().get(j).getX())
									* (this.getCities().get(i).getX() - this
											.getCities().get(j).getX())
									+ (this.getCities().get(i).getY() - this
											.getCities().get(j).getY())
									* (this.getCities().get(i).getY() - this
											.getCities().get(j).getY()));
					int tij = (int) Math.round(rij);
					distance[i][j] = tij;
					distance[j][i] = distance[i][j];

				}
			}
			distance[cityNum - 1][cityNum - 1] = 0;
		}
		return distance;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getEdgeWeightType() {
		return edgeWeightType;
	}

	public void setEdgeWeightType(String edgeWeightType) {
		this.edgeWeightType = edgeWeightType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Integer> getSolution() {
		return solution;
	}

	public void setSolution(List<Integer> solution) {
		this.solution = solution;
	}

}
