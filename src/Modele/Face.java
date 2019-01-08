package Modele;

import com.sun.javafx.geom.Vec3f;

/**
 * Objet Face qui est forme de 3 points, contient les methodes de gestions du centre de gravite.
 * @author danglotc
 */
public class Face implements Comparable<Face>{	
	private Point[] tabp;
	private int[] couleur;
	private Point centreGravite;
	private double coefLuminosite;
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
		
		if(this.estColore())
			couleur = new int[] {200,200,200};
		else
			couleur = new int[]{(int)(s.getR()+s1.getR()+s2.getR())/3,(int)(s.getG()+s1.getG()+s2.getG())/3,(int)(s.getB()+s1.getB()+s2.getB())/3};

	}
	
	public boolean estColore() {
		return (tabp[0].getR() == -1 || tabp[1].getR() == -1 || tabp[2].getR() == -1);
	}
	
	/**
	 * Recupérer le coefficent de luminosité d'une face.
	 * @return  Un coefficient entre 0 et 1.
	 */
	public double getCoefLuminosite() {
		return coefLuminosite;
	}
	
	/**
	 * Modifier le coefficent de luminosité d'une face.
	 * @param  Un coefficient entre 0 et 1.
	 */
	public void setCoefLuminosite(double coefLuminosite) {
		this.coefLuminosite = coefLuminosite;
	}
	
	
	/**
	 * Calcul un vecteur normal au plan.
	 */
	public void calculNormal() {

		if (Modele.getModele(null).getCheckO()) {
		Vec3f vL = new Vec3f(-0,1,0);
		
		Vec3f v1 = new Vec3f((float)(tabp[1].getX()-tabp[0].getX()),(float)(tabp[1].getY()-tabp[0].getY()),(float)(tabp[1].getZ()-tabp[0].getZ()));
		Vec3f v2 = new Vec3f((float)(tabp[2].getX()-tabp[0].getX()),(float)(tabp[2].getY()-tabp[0].getY()),(float)(tabp[2].getZ()-tabp[0].getZ()));

		v1.cross(v1, v2);
		
		double dessus = vL.x *v1.x + vL.y * v1.y + vL.z * v1 .z;
		double dessous1 = Math.sqrt(vL.x*vL.x + vL.y * vL.y + vL.z * vL.z );
		double dessous2 = Math.sqrt(v1.x*v1.x + v1.y * v1.y + v1.z * v1.z );
		
		double cosa = dessus/(dessous1*dessous2);
		
		this.setCoefLuminosite(Math.acos(cosa)/3);
		} else {
			this.setCoefLuminosite(0.5);
		}
	}
	
	/**
	 * Recupérer les points d'une face dans un tableau.
	 * @return  Un tableau de points d'une face
	 */
	public Point[] getTabp() {
		return tabp;
	}
	/**
	 * Récupérer le centre de gravité d'une face.
	 * @return  le centre de gravité de la face.
	 */
	public Point getCentreG() {
		return centreGravite;
	}
	/**
	 * Récupérer le code couleur RGB d'une face.
	 * @return le code couleur d'une face.
	 */
	public int[] getCouleur() {
		if(couleur[0]==0 && couleur[1]==0 && couleur[2]==0) return null;
		return couleur;
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
	 * @param tabp tableau de points qui doit être mis à jour dans la fonction.
	 */
	public void setTabp(Point[] tabp) {
		this.tabp = tabp;
	}
	/**
	 * Methode toString pour la face.
	 * @return toString.
	 */
	public String toString() {
		return "["+tabp[0]+"-"+tabp[1]+"-"+tabp[2]+"]";
		
	}

	/**
	 * @param o
	 * Une fonction de tri pour l'affichage du modèle.
	 * @return 1, -1, 0
	 */
	public int compareTo(Face o) {
		if (this.getCentreG().getZ() == o.getCentreG().getZ()) return 0;
		if (this.getCentreG().getZ() - o.getCentreG().getZ() < 0) return -1;
		return 1;
	}
}
		
		
	
	
	
	
	


