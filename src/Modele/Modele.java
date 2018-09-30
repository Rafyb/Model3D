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
		
		public ArrayList<Point> getAllPoints(){
			return points;
		}
		
		public ArrayList<Face> getAllFace(){
			return face;
		}
		
		public Point getPointAtIndex(int index){
			return points.get(index);
		}
		
		public Face getFaceAtIndex(int index){
			return face.get(index);
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
		
		
		
		
		
}
