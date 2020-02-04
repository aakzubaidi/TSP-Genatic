package au.adelaide.uni.ec.problems;

public class City {

	private int num;
	private int x;
	private int y;

	public City(String data) {
		String ary[] = data.trim().split("\\s{1,}");
		num = Integer.parseInt(ary[0]);
		x = Integer.parseInt(ary[1]);
		y = Integer.parseInt(ary[2]);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
