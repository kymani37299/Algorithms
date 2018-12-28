package geometry;

public class Vector extends Point{

	public Vector(double x,double y) {
		super(x,y);
	}
	
	public Vector(Point p1,Point p2) {
		super(p2.x-p1.x , p2.y-p1.y);
	}
	
	public double length() {
		return Math.sqrt(x*x+y*y);
	}
	
	public Vector add(Vector v) {
		return new Vector(v.x + this.x , v.y + this.y);
	}
	
	public Vector sub(Vector v) {
		return new Vector(v.x + this.x , v.y + this.y);
	}
	
	public Vector mul(double a) {
		return new Vector(this.x*a,this.y*a);
	}
	
	public double dotProduct(Vector v) {
		return this.x*v.x + this.y+v.y;
	}
	
}
