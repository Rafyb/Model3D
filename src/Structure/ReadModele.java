package Structure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Modele.Modele;

/**
 * Lit un fichier de format .ply et genere la liste de point et de face du modele.
 * @author danglotc
 */
public class ReadModele {
	private File f;
	private BufferedReader br;

	private int nbPoint;
	private int nbFace;

	private Point[] points;
	private Face[] faces;
	
	
	/**
	 * Constructeur prenant en @param l'adresse d'un fichier, génère un objet ReadModele contenant les faces et les points lues sur le fichier.
	 *  
	 */
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
		points = new Point[nbPoint];
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
		faces = new Face[nbFace];
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
				points[cpt] = new Point(Double.parseDouble(p[0]), Double.parseDouble(p[1]), Double.parseDouble(p[2]));
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
				faces[cpt] = new Face(points[Integer.parseInt(p[1])], points[Integer.parseInt(p[2])], points[Integer.parseInt(p[3])]);
				cpt ++;
			} catch (IOException e) {
				System.out.println("point bug bug");
			}
		}

	}
	/**
	 * Récupérer les points.
	 */
	public Point[] getPoint(){	
		return points;
	}
	/**
	 * Récupérer les faces.
	 */
	public Face[] getFace(){	
		return faces;
	}	
}
