package Modele;

import java.util.Arrays;
import java.util.Observable;

import Controlleur.GestionAffichage;
import Structure.Face;
import Structure.Point;
import Structure.ReadModele;
import Vue.Affichage;
import javafx.stage.Stage;
import Tri.Rotation;


public class Modele extends Observable{

	public Point[] points ;
	//public ArrayList<Segment> segments = new ArrayList<>() ;
	public Face[] face;
	public Rotation r = new Rotation();
	
	Affichage aff = new Affichage(this);
	//Affichage aff2 = new Affichage(this);
	//Affichage aff3 = new Affichage(this);
	GestionAffichage boutons = new GestionAffichage(this);


	public Modele(ReadModele r) {
		points = r.getPoint();
		//segments = r.getSegment();
		face =  r.getFace();
		this.centrer();
	}

	/*public void ajoutSegment(Segment s) {
			points.add(s);
		}*/

	public void triZ() {
		Arrays.sort(face);
	}
	
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
		
		double transla = -300/xMin;
		if (300/xMax < transla)  transla = 300/xMax;
		if (-400/yMin < transla)  transla = -400/yMin;
		if (400/yMax < transla)  transla = 400/yMax;
		System.out.println(transla);
		r.zoom(this,transla);
		
		System.out.println(" xMin = "+ xMin +" xMax = "+ xMax + " yMin = "+ yMin + " yMax = "+ yMax);
	}
	
	public void rotationX(int radian) {
		r.rotationX(this,radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	public void rotationY(int radian) {
		r.rotationY(this,radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	public void rotationZ(int radian) {
		r.rotationZ(this,radian);
		update();
		this.setChanged();
		notifyObservers();
	}
	public void zoom(double coef) {
		r.zoom(this,coef);
		this.setChanged();
		notifyObservers();
	}
	public void dezoom(double coef) {
		r.dezoom(this,coef);
		this.setChanged();
		notifyObservers();
	}
	
	public void translation(Point p) {
		r.translation(this, p);
		this.setChanged();
		notifyObservers();
	}


	private void update() {
		for (Face f : face) {
			
			f.updateCdG();
		}
		
	}

	public Point[] getAllPoints(){
		return points;
	}

	public Face[] getAllFace(){
		return face;
	}

	public Point getPointAtIndex(int index){
		return points[index];
	}

	public Face getFaceAtIndex(int index){
		return face[index];
	}

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

	public void start() {
		aff.start(new Stage());
		//aff2.start(new Stage());
		//aff3.start(new Stage());
		boutons.start(new Stage());
		
	}





}
