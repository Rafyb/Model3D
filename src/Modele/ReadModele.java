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
	 * Constructeur prenant en param fichier l'adresse d'un fichier, génère un objet ReadModele contenant les faces et les points lues sur le fichier.
	 *  @param fichier adresse du fichier
	 */
	public ReadModele(String fichier) {
		if(ReadModele.fileExist(fichier)) {
			f = new File(fichier);

			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				System.out.println(e);
			}

			nbPoint = this.ajoutNbPoints();
			nbFace = this.ajoutNbFaces();
			this.endHeader();
			this.insertPoints(nbPoint);
			this.insertFaces(nbFace);
		}


	}
	/**
	 * Savoir si il y a un chemin vers le fichier, si oui return true.
	 * @param path chemin vers le fichier
	 * @return si le fichier existe ou pas
	 */
	public static boolean fileExist(String path) {
		return new File(path).exists();
	}
	/**
	 * 
	 * @return nombre de points mis à jour.
	 */
	public int ajoutNbPoints() {
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
	/**
	 * 
	 * @return nombre de faces mis à jour.
	 */
	public int ajoutNbFaces() {
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
	/**
	 * Recupérer le nombre de points.
	 * @return nombre de points
	 */
	public int getNbPoints() {
		return nbPoint;
	}
	/**
	 * Récupérer le nombre de faces.
	 * @return nombre de faces
	 */
	public int getNbFaces() {
		
		return nbFace;
	}
	/**
	 * Arriver a la fin du header.
	 * @return le premier point en String.
	 */
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
	/**
	 * Permet d'insérer le nombre de points dans le tableau.
	 * @param nbPoint nombres de points dans le tableau
	 *  @return tableau de points mis à jour
	 */
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
	/**
	 * Permet d'insérer le nombre de faces dans le tableau.
	 * @param nbFace nombres de faces dans le tableau
	 *  @return tableau de faces mis à jour
	 */

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
	 * @return points du modèle
	 */
	public Point[] getPoint(){	
		return points;
	}
	/**
	 * Récupérer les faces.
	 * @return faces du modèle
	 */
	public Face[] getFace(){	
		return faces;
	}	
}


