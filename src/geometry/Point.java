package geometry;

import java.util.ArrayList;

public class Point {

	public double x;
	public double y;
	
	public Point(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public static String ArrayToString(Point[] array) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<array.length;i++) {
			sb.append("( " + array[i].x + " " + array[i].y + ")\n");
		}
		return sb.toString();
	}
	
	public static Point[] toArray(ArrayList<Point> p) {
		Point points[] = new Point[p.size()];
		int i=0;
		for(Point point : p) {
			points[i++] = point;
		}
		return points;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point p = (Point)obj;
			return p.x == this.x && p.y == this.y;
		}
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "("+x+" "+y+")";
	}
}
