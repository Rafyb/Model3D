package Tri;

import Structure.Face;

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

	private  void triRapide(Face[] tableau,int deb,int fin)
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
}
