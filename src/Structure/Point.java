package Structure;

public class Point {
	double x,y,z;
	
	
	public Point(double c, double d, double e) {
		x = c;
		y = d;
		z = e;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
	
	public String toString() {
		return "("+x+","+y+","+z+")";
	}

}
