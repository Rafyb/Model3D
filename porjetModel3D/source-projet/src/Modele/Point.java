package Modele;

/**
 * Objet Point avec les coordonnees x, y et z.
 * @author danglotc
 */
public class Point {
	private double x,y,z;
	private double r,g,b;
	
	/**
	 * Constructeur pour les coordonnées
	 * @param c = coordonnée X
	 * @param d = coordonnée Y
	 * @param e = coordonnée Z
	 */
	public Point(double c, double d, double e) {
		x = c;
		y = d;
		z = e;
	}
	
	public Point(double c, double d, double e, double r, double g, double b) {
		x = c;
		y = d;
		z = e;
		this.r = r;
		this.g = g;
		this.b = b; 
	}
	/**
	 * Récupérer la coordonnée X
	 */
	public double getX() {
		return x;
	}
	/**
	 * Mettre à jour la coordonnée X
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Récupérer la coordonnée Y
	 */
	public double getY() {
		return y;
	}
	/**
	 * Mettre à jour la coordonnée Y
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Récupérer la coordonnée Z
	 */
	public double getZ() {
		return z;
	}
	/**
	 * Mettre à jour la coordonnée Z
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	public double getR() {
		return r;
	}
	public double getG() {
		return g;
	}
	public double getB() {
		return b;
	}
	
	
	
	
	
	/**
	 * Méthode d'affichage.
	 */
	public String toString() {
		return "("+x+","+y+","+z+")";
	}

}
