package Structure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Modele.Modele;

public class ReadModele {
	private File f;
	private BufferedReader br;

	private int nbPoint;
	private int nbFace;

	private ArrayList<Point> point = new ArrayList<Point>();
	private ArrayList<Face> face = new ArrayList<Face>();

	public ReadModele(String fichier) {
		f = new File(fichier);

		try {
			br = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		String st = ""; 

		// ------------------------- GET NB POINT ------------------------
		do {
			try {
				st = br.readLine();
			} catch (IOException e) {
				System.out.println("element vertex bug");
			}
		} while (!st.contains("element vertex"));
		nbPoint = Integer.parseInt(st.substring(15));
		System.out.println(nbPoint);


		// ------------------------- GET NB FACE ------------------------
		do {
			try {
				st = br.readLine();
			} catch (IOException e) {
				System.out.println("element face bug");
			}
		} while (!st.contains("element face"));
		nbFace = Integer.parseInt(st.substring(13));
		System.out.println(nbFace);




		// ------------------------- Arrive fin du header ------------------------
		do {
			try {
				st = br.readLine();
			} catch (IOException e) {
				System.out.println("end header bug");
			}
		} while (!st.contains("end_header"));


		// ------------------------- Ajout des point dans l'ArrayList ------------------------

		int cpt = 0;
		while (cpt < nbPoint) {
			try {
				st = br.readLine();
				String[] p = st.split(" ");
				point.add(new Point(Double.parseDouble(p[0]), Double.parseDouble(p[1]), Double.parseDouble(p[2])));
				cpt ++;
			} catch (IOException e) {
				System.out.println("point bug bug");
			}
		}

		// ------------------------- Ajout des faces dans l'ArrayList ------------------------

		cpt = 0;
		while (cpt < nbFace) {
			try {
				st = br.readLine();
				String[] p = st.split(" ");
				face.add(new Face(point.get(Integer.parseInt(p[0])), point.get(Integer.parseInt(p[1])), point.get(Integer.parseInt(p[2]))));
				cpt ++;
			} catch (IOException e) {
				System.out.println("point bug bug");
			}
		}

	}

	public ArrayList<Point> getPoint(){	
		return point;
	}

	public ArrayList<Face> getFace(){	
		return face;
	}

	public static void main(String[] args) {
		Modele m = new Modele(new ReadModele("ressources/3carre.ply"));
		System.out.println(m);
	}
}
