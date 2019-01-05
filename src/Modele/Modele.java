package Modele;

import java.util.Arrays;
import java.util.Observable;
import Matrices.*;
/**
 * Class principal, elle represente le Modele 3D et fait partie de la configuration MVC.
 * Le MVC est construit autour de Observer/Observable, le modele est l'observable.
 * Elle est sous forme d'un "singleton" et ne comporte aucun lien direct avec la vue ou le controleur.
 * Elle comprend toute les mÈthodes de manipulations du modele.
 * @author danglotc bauvinr brevierl canonnet
 */
public final class Modele extends Observable{
	/**
	 * points = tableau de point du modele.
	 * face = tableau de face du modele.
	 * t = Matrice de transformation
	 * 		> Translation
	 * 		> Redimensionnement
	 * 		> Rotation sur l'axe X
	 *      > Rotation sur l'axe Y
	 *      > Rotation sur l'axe Z
	 * affTrait = savoir si on affiche les traits ou pas.
	 * affFace = savoir si on affiche les faces ou pas.
	 * affOmbre = savoir si on affiche l'ombre ou pas.
	 * rotAuto = savoir si la rotation est active.
	 * centreModele = le centre du Modele.
	 */
	private Point[] points ;
	private Face[] face;
	private Matrice t;
	private boolean affTrait = true;
	private boolean affFace = true;
	private boolean affOmbre = false;
	private boolean rotAuto = false;
	private Point centreModele;
	
	private static Modele instance = null;
	
	/**
	 * Constructeur
	 * @param r le reader du fichier du modele.
	 */
	private Modele(ReadModele r) {
		this.points = r.getPoint();		
		this.face =  r.getFace();
		t = new Matrice();
		this.centrer();
	}
	
	/**
	 * Recuperer l'instance du modele.
	 * @param r le reader du fichier du modele
	 * @return l'instance unique du modele
	 */
	public static Modele getModele(ReadModele r) {
		if(instance == null) instance = new Modele(r);
		return instance;
	}

	/**
	 * Methode pour changer le modele que l'on veut afficher.
	 * @param r le nouveau reader du fichier du modele
	 */
	public void changerModele(ReadModele r) {
		points = r.getPoint();
		face = r.getFace();

		this.update();
		this.centrer();
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Methode pour trier le modele sur les Z.
	 */
	public void triZ() {
		Arrays.sort(face);
	}
		
	/**
	 * Methode pour centrer le modele par rapport a†la vue.
	 */
	public void centrer() {
		double xMin = points[0].getX(), xMax = points[0].getX(),yMin = points[0].getY(),yMax = points[0].getY();
		for (Point p : points) {
			if (p.getX()<xMin)
				xMin = p.getX();
			if (p.getX()>xMax)
				xMax = p.getX();
			if (p.getY()<yMin)
				yMin = p.getY();
			if (p.getY()>yMax)
				yMax = p.getY();
		}
		
		double xT = -((xMax+xMin)/2);
		double yT = -((yMax+yMin)/2);
		Point translation = new Point(xT,yT,0);
		t.transformation(new Translation(this) , translation);
		
		
		xMin = points[0].getX(); xMax = points[0].getX();yMin = points[0].getY();yMax = points[0].getY();
		for (Point p : points) {
			if (p.getX()<xMin)
				xMin = p.getX();
			if (p.getX()>xMax)
				xMax = p.getX();
			if (p.getY()<yMin)
				yMin = p.getY();
			if (p.getY()>yMax)
				yMax = p.getY();
		}

		double zoom = 0;
		while(xMax*(1+zoom) < 360 && yMax*(1+zoom) < 300) {
			zoom += 0.01;
		}
		
		t.transformation(new Redimensionnement(this),zoom);

		//System.out.println(" xMin = "+ xMin +" xMax = "+ xMax + " yMin = "+ yMin + " yMax = "+ yMax);
	}
	
	/**
	 * Methode pour mettre ‡ jour le centre du modele.
	 */
	public void updateCentre() {
		double xMin = points[0].getX(), xMax = points[0].getX(),yMin = points[0].getY(),yMax = points[0].getY(),zMin = points[0].getZ(),zMax = points[0].getZ();
		for (Point p : points) {
			if (p.getX()<xMin)
				xMin = p.getX();
			if (p.getX()>xMax)
				xMax = p.getX();
			if (p.getY()<yMin)
				yMin = p.getY();
			if (p.getY()>yMax)
				yMax = p.getY();
			if (p.getZ()<zMin)
				zMin = p.getZ();
			if (p.getZ()>zMax)
				zMax = p.getZ();
		}
		centreModele = new Point((xMin+xMax)/2,(yMin+yMax)/2,(zMin+zMax)/2);
	}
	
	/**
	 * @return le point au centre du Modele.
	 */
	public Point getCentreModele() {
		return centreModele;
	}
	
	/**
	 * @param le point que l'on dÈfinit comme le centre du modele.
	 */
	public void setCentreModele(Point centreModele) {
		this.centreModele = centreModele;
	}
	
	/**
	 * Switch l'Ètat d'afficher Trait.
	 */
	public void checkT() {
		if(affTrait) affTrait =false;
		else {
			affTrait = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Switch l'Ètat d'afficher Face.
	 */
	public void checkF() {
		if(affFace) affFace =false;
		else {
			affFace = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Switch l'Ètat d'afficher le flux lumineux.
	 */
	public void checkO() {
		if(affOmbre) affOmbre =false;
		else {
			affOmbre = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Switch l'Ètat de la rotationAuto.
	 */
	public void checkR() {
		if(rotAuto) rotAuto =false;
		else {
			rotAuto = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode pour la rotation dans l'axe X et notifie les observers.
	 * @param radian l'angle en radian.
	 */
	public void rotationX(int radian) {
		t.transformation(new RotationX(instance),radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * Methode pour la rotation dans l'axe Y sur le mod√®le et notifie les observers.
	 * @param radian l'angle en radian.
	 */
	public void rotationY(int radian) {
		t.transformation(new RotationY(instance),radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * Methode pour la rotation dans l'axe Z sur le mod√®le et notifie les observers.
	 * @param radian l'angle en radian.
	 */
	public void rotationZ(int radian) {
		t.transformation(new RotationZ(instance),radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode pour zoomer le modele et notifie les observers.
	 * @param coef coefficient pour zoomer
	 */
	public void zoom(double coef) {
		t.transformation(new Redimensionnement(instance),coef);
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode pour dezoomer le modele et notifie les observers.
	 * @param coef coefficient pour zoomer
	 */
	public void dezoom(double coef) {
		t.transformation(new Redimensionnement(instance),-1*coef);
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode pour translater le modele et notifie les observers.
	 * @param p point afin de faire la translation
	 */
	public void translation(Point p) {
		t.transformation(new Translation(instance),p);
		this.setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode pour translater le modele vers le centre et notifie les observers.
	 */
	public void translationCentre() {
		Translation tr = new Translation(instance);
		tr.translationCentre();
		this.setChanged();
		notifyObservers();
	}

	/**
	 * Methode mettant a jour le centre de gravite.
	 */ 
	private void update() {
		for (Face f : face) {
			f.updateCdG();
		}
	}
	
	/**
	 * Recuperer tout les points.
	 * @return les points du modele dans un tableau
	 */
	public Point[] getAllPoints(){
		return points;
	}
	
	/**
	 * Recuperer toutes les faces.
	 * @return les faces du modele dans un tableau
	 */
	public Face[] getAllFace(){
		return face;
	}
	
	/**
	 * Recuperer le points selon un index en parametre.
	 * @param index indice pour chercher les points dans le tableau.
	 * @return les points selon l'indice
	 */
	public Point getPointAtIndex(int index){
		return points[index];
	}
	
	
	/**
	 * Recuperer une face selon un index en parametre.
	 * @param index l'indice permettant de trouver la face
	 * @return Une face selon l'indice donne.
	 */
	public Face getFaceAtIndex(int index){
		return face[index];
	}
	
	
	/**
	 * Methode d'affichage sortie standard.
	 * @return toString.
	 */
	public String toString() {
		String res = "Points : [";
		for (Point p : points) {
			res += p + ",";
		}
		res = res.substring(0,res.length()-1);
		res+= "] - Face [";
		for (Face f : face) {
			res += f + ",";
		}
		res = res.substring(0,res.length()-1);
		res+= "]";
		return res;
	}

	/**
	 * Permet de savoir si on affiche les faces ou non.
	 * @return true or false.
	 */
	public boolean getCheckF() {
		return affFace;
	}

	/**
	 * Permet de savoir si on affiche les points ou non.
	 * @return true or false.
	 */
	public boolean getCheckT() {
		return affTrait;
	}

	/**
	 * Permet de savoir si on affiche les ombres ou non.
	 * @return true or false.
	 */
	public boolean getCheckO() {
		return affOmbre;
	}

	/**
	 * Permet de savoir si la rotationAuto est en marche ou non.
	 * @return true or false.
	 */
	public boolean getCheckR() {
		return rotAuto;
	}


}
