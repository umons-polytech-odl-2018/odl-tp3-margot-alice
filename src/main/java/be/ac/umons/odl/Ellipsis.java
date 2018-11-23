package be.ac.umons.odl;
import java.awt.*;
public class Ellipsis implements Drawable {
	private Point a;
	private int xAxisLength;
	private int yAxisLength;
	public Ellipsis(Point a, int xAxisLength, int yAxisLength) {
		this.a = a;
		this.xAxisLength = xAxisLength;
		this.yAxisLength = yAxisLength;
	}
	public double perimeter(){
		return 2*Math.PI*Math.sqrt((Math.pow(xAxisLength,2)+Math.pow(yAxisLength,2))/2);
	}
	public double area(){
		return Math.PI*xAxisLength*yAxisLength;
	}
	@Override
	public void draw(Graphics g) {
		int x = a.getX();
		int y = a.getY();
		g.drawOval(x,y,xAxisLength,yAxisLength);
	}
}
