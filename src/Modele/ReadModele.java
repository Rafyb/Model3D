package Modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		if(ReadModele.fileExist(fichier)) {
			f = new File(fichier);

			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}

			nbPoint = this.getNbPoints();
			nbFace = this.getNbFaces();
			this.endHeader();
			this.insertPoints(nbPoint);
			this.insertFaces(nbFace);
		}


	}

	public static boolean fileExist(String path) {
		return new File(path).exists();
	}
	public int getNbPoints() {
		String st ="";
		int res;
		do {
			try {
				st = br.readLine();
			} catch (IOException e) {
				System.out.println("element vertex bug");
			}
		} while (!st.contains("element vertex"));
		res = Integer.parseInt(st.substring(15));
		return res;

	}
	public int getNbFaces() {
		String st = "";
		int res;
		do {
			try {
				st = br.readLine();
			} catch (IOException e) {
				System.out.println("element face bug");
			}
		} while (!st.contains("element face"));
		res = Integer.parseInt(st.substring(13));
		return res;
	}

	public String endHeader() {
		String st = "";
		do {
			try {
				st = br.readLine();
			} catch (IOException e) {
				System.out.println("end header bug");
			}
		} while (!st.contains("end_header"));
		return st;
	}

	public Point[] insertPoints(int nbPoint) {
		points = new Point[nbPoint];
		int cpt = 0;
		String st = "";  
		while (cpt < nbPoint) {
			try {
				st = br.readLine();
				String[] p = st.split(" ");
				if (p.length == 3)
					points[cpt] = new Point(Double.parseDouble(p[0]), Double.parseDouble(p[1]), Double.parseDouble(p[2]));
				else 
					points[cpt] = new Point(Double.parseDouble(p[0]), Double.parseDouble(p[1]), Double.parseDouble(p[2]),Double.parseDouble(p[3]), Double.parseDouble(p[4]), Double.parseDouble(p[5]));
				cpt ++;
			} catch (IOException e) {
				System.out.println("point bug bug");
			}
		}
		return points;
	}

	public Face[] insertFaces(int nbFace) {
		faces = new Face[nbFace];
		int cpt = 0;
		String st = "";
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
		return faces;
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
