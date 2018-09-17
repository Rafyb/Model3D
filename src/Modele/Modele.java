package Modele;

import java.util.ArrayList;
import Structure.*;


public class Modele {

		public ArrayList<Point> points = new ArrayList<>();
		public ArrayList<Segment> segement = new ArrayList<>();
		
		
		
		public void ajoutPoint(Point p) {
			points.add(p);
		}
		
		
		public void ajoutSegment(Segment s) {
			segement.add(s);
		}
		
		
		
}
