package Modele;

import java.util.ArrayList;
import Structure.*;


public class Modele {

		public ArrayList<Point> points = new ArrayList<>() ;
		//public ArrayList<Segment> segments = new ArrayList<>() ;
		public ArrayList<Face> face = new ArrayList<>();
		
		
		public Modele(ReadModele r) {
			points = r.getPoint();
			//segments = r.getSegment();
			face =  r.getFace();
		}
		
		
		public void ajoutPoint(Point p) {
			points.add(p);
		}
		
		/*public void ajoutSegment(Segment s) {
			points.add(s);
		}*/
		
		public void ajoutFace(Face f) {
			face.add(f);
		}
		
		
		
		
		
}
