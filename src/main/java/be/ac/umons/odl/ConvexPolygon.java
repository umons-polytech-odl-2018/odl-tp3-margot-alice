package be.ac.umons.odl;

import java.awt.*;

public class ConvexPolygon implements Drawable {
	private final Point[] vertices;

	public ConvexPolygon(Point[] vertices) {
		this.vertices = vertices;
	}

	public Point[] getVertices() {
		return vertices;
	}

	private double areatriangle(Point A, Point B, Point C){
		return (Math.abs((A.getX()-C.getX())*(B.getY()-C.getY())-(A.getY()-C.getY())*(B.getX()-C.getX()))/2);
	}
	public double area() {
		double area = 0;
		Point centre = new Point(0, 0);
		for (Point i : vertices) {
			centre.setX(centre.getX() + i.getX());
			centre.setY(centre.getY() + i.getY());
		}
		centre.setX(centre.getX() / vertices.length);
		centre.setY(centre.getY() / vertices.length);
		for (int i = 0; i < vertices.length; i++) {
			if (i + 1 != vertices.length) area += areatriangle(vertices[i], vertices[i + 1], centre);
			else area += areatriangle(vertices[i], vertices[0], centre);
		}
		return area;
	}
	public double perimeter(){
		double per = 0;
		for(int i = 0; i<vertices.length; i++) {
			if(i+1==vertices.length) per += vertices[i].distanceTo(vertices[0]);
			else per += vertices[i].distanceTo(vertices[i+1]);
		}
		return per;
	}
	@Override
	public void draw(Graphics g) {
		int[] xPoints = new int[vertices.length];
		int[] yPoints = new int[vertices.length];
		for (int i = 0; i < vertices.length; i++) {
			Point vertex = vertices[i];
			xPoints[i] = vertex.getX();
			yPoints[i] = vertex.getY();
		}
		g.drawPolygon(xPoints, yPoints, vertices.length);
	}
}
