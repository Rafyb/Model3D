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
	}

	/*public void ajoutSegment(Segment s) {
			points.add(s);
		}*/

	public void triZ() {
		Arrays.sort(face);
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
	public void zoom(double coef) {
		r.zoom(this,coef);
		update();
		this.setChanged();
		notifyObservers();
	}
	public void dezoom(double coef) {
		r.dezoom(this,coef);
		update();
		this.setChanged();
		notifyObservers();
	}
	
	public void translation(Point p) {
		r.translation(this, p);
		update();
		this.setChanged();
		notifyObservers();
	}


	private void update() {
		
		
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
