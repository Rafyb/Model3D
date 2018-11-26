package Matrices;

import Modele.Modele;
import Modele.Point;

public class Translation implements Transformation{

	/**
	 * Methode permettant de faire les transitions de la figure.
	 * @param p le point utilisé pour la translation
	 * @param m Modele utilisé
	 */
	public void appliquer(Modele m, Object o) {
		Point p = (Point)o;
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x+p.getX());
			m.getPointAtIndex(i).setY(y+p.getY());
			m.getPointAtIndex(i).setZ(z+p.getZ());
		}
		
	}

}
