package be.ac.umons.odl;
public class Circle extends Ellipsis {
	private int radius;
	public Circle(Point a, int radius) {
		super(a, radius, radius);
		this.radius = radius;
	}
	public double perimeter(){
		return 2*Math.PI*radius;
	}
	public double area(){
		return Math.PI*Math.pow(radius,2);
	}
}


