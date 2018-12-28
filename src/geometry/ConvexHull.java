package geometry;

import java.util.ArrayList;

public class ConvexHull {
	
	public static Point[] jarvis(Point[] points) {
		if(points.length < 3) return points;
		ArrayList<Point> hull = new ArrayList<>();
		
		int leftMost = 0;
		
		for(int i=0;i<points.length;i++) {
			if(points[i].x < points[leftMost].x) {
				leftMost = i;
			}
		}
		
		int i = leftMost;
		int j;
		
		do {
			hull.add(points[i]);
			j = (i+1)%points.length;
			double maxAngle = -10000; // -INF
			Vector v1 = new Vector(points[j],points[i]);
			for(int p=0;p<points.length;p++) {
				Vector v2 = new Vector(points[j],points[p]);
				double angle = Math.acos(v1.dotProduct(v2)/ (v1.length()*v2.length()));
				if(angle > maxAngle) {
					maxAngle = angle;
					j = p;
				}
			}
			i=j;
		}while(i!=leftMost);
		
		return Point.toArray(hull);
	}
	
	public static void main(String[] args) {
		Point[] points = null;
		{
			ArrayList<Point> p = new ArrayList<>();
			p.add(new Point(1, 1));
			p.add(new Point(2, 3));
			p.add(new Point(2, 4));
			p.add(new Point(2.3, 1.6));
			p.add(new Point(6, 2));
			p.add(new Point(3, 4));
			p.add(new Point(1, 5));
			points = Point.toArray(p);
		}
		
		System.out.println(Point.ArrayToString(jarvis(points)));
		
	}
	
}
