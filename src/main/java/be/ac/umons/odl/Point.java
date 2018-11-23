package be.ac.umons.odl;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	double distanceTo(Point other) {
		return Math.sqrt(Math.pow((double) (other.x - this.x), 2.0) + Math.pow((double) (other.y - this.y), 2.0));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int a){
		this.x = a;
	}

	public void setY(int a){
		this.y = a;
	}

}
