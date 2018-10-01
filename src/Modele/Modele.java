package Modele;

import java.util.Observable;

import Controlleur.GestionAffichage;
import Structure.Face;
import Structure.Point;
import Structure.ReadModele;
import Tri.TriRapide;
import Vue.Affichage;
import javafx.stage.Stage;


public class Modele extends Observable{

	public Point[] points ;
	//public ArrayList<Segment> segments = new ArrayList<>() ;
	public Face[] face;
	public TriRapide t = new TriRapide();
	
	Affichage aff = new Affichage(this);
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
		t.triRapide(face);
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
		boutons.start(new Stage());
		
	}





}
