package Matrices;

import Modele.Modele;

public class Redimensionnement implements Transformation{
	
	/**
	 * Zoomer la figure selon un paramètre de zoom donné.
	 * @param coef le coef utilisé pour le zoom
	 * @param m Modele utilisé
	 */
	public void appliquer(Modele m, double coef) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*(1+coef));
			m.getPointAtIndex(i).setY(y*(1+coef));
			m.getPointAtIndex(i).setZ(z*(1+coef));
		}
	}

}
