package Modele;

/**
 * Objet Point avec les coordonnees x, y et z.
 * @author danglotc
 */
public class Point{
	private double x,y,z;
	private double r,g,b;
	
	/**
	 * Constructeur pour les coordonnées
	 * @param c = coordonnée X
	 * @param d = coordonnée Y
	 * @param e = coordonnée Z
	 */
	public Point(double c, double d, double e) {
		r = g = b = -1;
		x = c;
		y = d;
		z = e;
	}
	/**
	 * Constructeur pour les coordonnées avec les couleurs.
	 * @param c = coordonnée X
	 * @param d = coordonnée Y
	 * @param e = coordonnée Z
	 * @param r code couleur R
	 * @param g code couleur G
	 * @param b code couleur B
	 */
	
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
	 * @return coordonnée X
	 */
	public double getX() {
		return x;
	}
	/**
	 * Mettre à jour la coordonnée X
	 * @param x nouvelle coordonnée X	 * 
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Récupérer la coordonnée Y
	 * @return coordonnée Y
	 */
	public double getY() {
		return y;
	}
	/**
	 * Mettre à jour la coordonnée Y
	 * @param y nouvelle coordonnée y
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * Récupérer la coordonnée Z
	 * @return coordonnée Z
	 */
	public double getZ() {
		return z;
	}
	/**
	 * Mettre à jour la coordonnée Z
	 * @param z nouvelle coordonnée z
	 */
	public void setZ(double z) {
		this.z = z;
	}
	/**
	 * Retourne le code couleur R
	 * @return code couleur R
	 */
	public double getR() {
		return r;
	}
	/**
	 * Retourne le code couleur G
	 * @return code couleur G
	 */
	public double getG() {
		return g;
	}
	/**
	 * Retourne le code couleur B
	 * @return code couleur B
	 */
	public double getB() {
		return b;
	}
	
	
	/**
	 * Méthode d'affichage.
	 * @return toString.
	 */
	public String toString() {
		return "("+x+","+y+","+z+")";
	}

	
}
