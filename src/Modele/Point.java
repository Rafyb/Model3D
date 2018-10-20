package Modele;

/**
 * Objet Point avec les coordonnees x, y et z.
 * @author danglotc
 */
public class Point {
	private double x,y,z;
	
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
	/**
	 * Méthode d'affichage.
	 */
	public String toString() {
		return "("+x+","+y+","+z+")";
	}

}
