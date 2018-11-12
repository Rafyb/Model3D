package Modele;

import java.util.Arrays;
import java.util.Observable;

public class Modele extends Observable{
	/**
	 * @attributes points = tableau de point du modèle.
	 * face = tableau de face du modèle.
	 * r = Rotation du modèle. 
	 */
	private Point[] points ;
	private Face[] face;
	private Rotation r = new Rotation();	
	private boolean affTrait = true;
	private boolean affFace = true;
	

	/**
	 * 
	 * Constructeur
	 * @param r pour donner un modèle dans un fichier.
	 */
	public Modele(ReadModele r) {
		points = r.getPoint();		
		face =  r.getFace();
		this.centrer();
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
		r.translation(this, translation);
		
		
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
		while(xMax*(1+zoom) < 500 && yMax*(1+zoom) < 380) {
			zoom += 0.01;
		}

		System.out.println(zoom);
		r.zoom(this,zoom);

		//System.out.println(" xMin = "+ xMin +" xMax = "+ xMax + " yMin = "+ yMin + " yMax = "+ yMax);
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
		r.zoom(this,coef);
		this.setChanged();
		notifyObservers();
	}
	/**
	 * 
	 * Methode pour dezoomer le modèle et notifie les observers.
	 * @param coef coefficient pour zoomer
	 */
	public void dezoom(double coef) {
		r.dezoom(this,coef);
		this.setChanged();
		notifyObservers();
	}
	/**
	 * 
	 * Methode pour translater le modèle et notifie les observers.
	 * @param p point afin de faire la translation
	 */

	public void translation(Point p) {
		r.translation(this, p);
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


	public boolean getCheckF() {
		return affFace;
	}


	public boolean getCheckT() {
		return affTrait;
	}





}
