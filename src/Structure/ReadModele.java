package Structure;

import java.io.File;
import java.util.ArrayList;

public class ReadModele {
	private File f;
	
	ArrayList<Point> point = new ArrayList<Point>();
	ArrayList<Face> face = new ArrayList<Face>();
	
	public ReadModele(String fichier) {
		f = new File(fichier);
	}
	
	public ArrayList<Point> getPoint(){	
		return point;
	}
	
	public ArrayList<Face> getFace(){	
		return face;
	}
}
