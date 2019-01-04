package Modele;

import java.util.Arrays;
import java.util.Observable;

import Matrices.*;
public final class Modele extends Observable{
	/**
	 * points = tableau de point du modèle.
	 * face = tableau de face du modèle.
	 * r = Rotation du modèle.
	 * affTrait = savoir si on affiche les traits ou pas.
	 * affFace = savoir si on affiche les faces ou pas.
	 * 
	 * 
	 * 
	 */
	private Point[] points ;
	private Face[] face;
	private Transformation[] t;
	private Rotation r;
	private boolean affTrait = true;
	private boolean affFace = true;
	private boolean affOmbre = false;
	private Point centreModele;
	
	private static Modele instance = null;
	/**
	 * 
	 * Constructeur
	 * @param r pour donner un modèle dans un fichier.
	 */
	private Modele(ReadModele r) {
		this.points = r.getPoint();		
		this.face =  r.getFace();
		this.t = new Transformation[3];
		t[0] = new Translation();
		t[1] = new Redimensionnement();
		t[2] = new Rotation();
		this.r = new Rotation();
		this.centrer();
	}
	/**
	 * Récupérer le modèle.
	 * @param r lire le modele
	 * @return une instance du modèle
	 */
	public static Modele getModele(ReadModele r) {
		if(instance == null) instance = new Modele(r);
		return instance;
	}
	
	
	
	
	/**
	 * Methode pour changer le modèle que l'on veut afficher.
	 * @param r Modèle different de l'ancien.
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
	 * Methode pour trier le modèle.
	 */
	public void triZ() {
		Arrays.sort(face);
	}
		
	/**
	 * Methode pour afficher le modèle centrer par rapport à la vue.
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
		t[0].appliquer(this, translation);
		
		
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
		
		t[1].appliquer(this,zoom);

		//System.out.println(" xMin = "+ xMin +" xMax = "+ xMax + " yMin = "+ yMin + " yMax = "+ yMax);
	}
	
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
	
	public Point getCentreModele() {
		return centreModele;
	}
	
	
	public void setCentreModele(Point centreModele) {
		this.centreModele = centreModele;
	}
	
	
	public void checkT() {
		if(affTrait) affTrait =false;
		else {
			affTrait = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	
	
	public void checkF() {
		if(affFace) affFace =false;
		else {
			affFace = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	
	public void checkO() {
		if(affOmbre) affOmbre =false;
		else {
			affOmbre = true;
		}
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * Methode pour la rotation dans l'axe X et notifie les observers.
	 * @param radian l'angle en radian.
	 */
	public void rotationX(int radian) {
		r.rotationX(this,radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	
	
	/**
	 * Methode pour la rotation dans l'axe Y sur le modèle et notifie les observers.
	 * @param radian l'angle en radian.
	 */
	public void rotationY(int radian) {
		r.rotationY(this,radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * Methode pour la rotation dans l'axe Z sur le modèle et notifie les observers.
	 * @param radian l'angle en radian.
	 */
	public void rotationZ(int radian) {
		r.rotationZ(this,radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * 
	 * Methode pour zoomer le modèle et notifie les observers.
	 * @param coef coefficient pour zoomer
	 */
	public void zoom(double coef) {
		t[1].appliquer(this,coef);
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * 
	 * Methode pour dezoomer le modèle et notifie les observers.
	 * @param coef coefficient pour zoomer
	 */
	public void dezoom(double coef) {
		t[1].appliquer(this,-1*coef);
		this.setChanged();
		notifyObservers();
	}
	
	
	/**
	 * 
	 * Methode pour translater le modèle et notifie les observers.
	 * @param p point afin de faire la translation
	 */

	public void translation(Point p) {
		t[0].appliquer(this, p);
		this.setChanged();
		notifyObservers();
	}
	
	
	public void translationCentre() {
		((Translation) t[0]).translationCentre(this);
		this.setChanged();
		notifyObservers();
	}

	/**
	 * Methode mettant à jour le centre de gravité.
	 */ 
	private void update() {
		for (Face f : face) {

			f.updateCdG();
		}
	}
	
	
	/**
	 * Récupérer tout les points.
	 * @return tout les points
	 * 
	 */
	public Point[] getAllPoints(){
		return points;
	}
	
	
	/**
	 * Récupérer toutes les faces.
	 * @return toutes les faces
	 */
	public Face[] getAllFace(){
		return face;
	}
	
	
	/**
	 * Récupérer les points selon un index en paramètre.
	 * @param index indice pour chercher les points dans le tableau.
	 * @return les points selon l'indice
	 */
	public Point getPointAtIndex(int index){
		return points[index];
	}
	
	
	/**
	 * Récupérer une face selon un index en paramètre.
	 * @param index l'indice permettant de trouver la face
	 * @return Une face selon l'indice donné.
	 */
	public Face getFaceAtIndex(int index){
		return face[index];
	}
	
	
	/**
	 * Methode d'affichage.
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


	public boolean getCheckO() {
		return affOmbre;
	}



}
