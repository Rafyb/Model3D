package Structure;
/**
 * Objet Face qui est forme de 3 points, contient les methodes de gestions du centre de gravite.
 * @author danglotc
 */
public class Face implements Comparable<Face>{	
	private Point[] tabp;
	private Point centreGravite;
	/**
	 * Constructeur : 
	 * @param s Premier point ( x ) 
	 * @param s1 Deuxieme point ( y )
	 * @param s2 Troisieme point ( z )
	 * 
	 */
	public Face(Point s, Point s1, Point s2) { 
		tabp = new Point[] {s, s1, s2};
		double xG = (s.getX()+s1.getX()+s2.getX())/3;
		double yG = (s.getY()+s1.getY()+s2.getY())/3;
		double zG = (s.getZ()+s1.getZ()+s2.getZ())/3;
		centreGravite = new Point(xG,yG,zG);
		
	}
	/**
	 * Recupérer les points d'une face dans un tableau.
	 */
	public Point[] getTabp() {
		return tabp;
	}
	/**
	 * Récupérer le centre de gravité d'une face.
	 */
	public Point getCentreG() {
		return centreGravite;
	}
	/**
	 * Permet de mettre à jour le centre de gravité.
	 */
	public void updateCdG() {
		Point s = tabp[0];
		Point s1 = tabp[1];
		Point s2 = tabp[2];
		double xG = (s.getX()+s1.getX()+s2.getX())/3;
		double yG = (s.getY()+s1.getY()+s2.getY())/3;
		double zG = (s.getZ()+s1.getZ()+s2.getZ())/3;
		centreGravite = new Point(xG,yG,zG);
	}
	/**
	 * Mettre à jour le tableau de points.
	 */
	public void setTabp(Point[] tabp) {
		this.tabp = tabp;
	}
	/**
	 * Methode toString pour la face.
	 */
	public String toString() {
		return "["+tabp[0]+"-"+tabp[1]+"-"+tabp[2]+"]";
		
	}

	/**
	 * Une fonction de tri pour l'affichage du modèle.
	 */
	public int compareTo(Face o) {
		if (this.getCentreG().getZ() == o.getCentreG().getZ()) return 0;
		if (this.getCentreG().getZ() - o.getCentreG().getZ() < 0) return -1;
		return 1;
	}
}
		
		
	
	
	
	
	


