package Tri;

import Modele.Modele;
import Structure.Face;
import Structure.ReadModele;

public class TriRapide {
	public  void triRapide(Face[] tableau)
	{
		int longueur=tableau.length;
		triRapide(tableau,0,longueur-1);
	}

	private  int partition(Face[] tableau,int deb,int fin)
	{
		int compt=deb;
		Face pivot=tableau[deb];

		for(int i=deb+1;i<=fin;i++)
		{
			if (tableau[i].getCentreG().getZ()<pivot.getCentreG().getZ())
			{
				compt++;
				echanger(tableau,compt,i);
			}
		}
		echanger(tableau,deb,compt);
		return(compt);
	}

	private void triRapide(Face[] tableau,int deb,int fin)
	{
		if(deb<fin)
		{
			int positionPivot=partition(tableau,deb,fin);
			triRapide(tableau,deb,positionPivot-1);
			triRapide(tableau,positionPivot+1,fin);
		}
	}
	private static void echanger(Face[] face, int m, int n) {
		Face temp = face[m];

		face[m] = face[n];
		face[n] = temp;
	}
	
	public static void main(String []args) {
		Modele test1 = new Modele(new ReadModele("ressources/test1.ply"));
		Modele test2 = new Modele(new ReadModele("ressources/test2.ply"));
		Face[] points ;
		Face[] points2 ;
		
		test2.triZ();
		points = test1.getAllFace();
		points2 = test2.getAllFace();
		
		for(int i = 0; i < points.length; i++) {
			System.out.println(points[i]);
			System.out.println(points2[i]);
			
		}
		
			
		
	}
}
