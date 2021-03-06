package Matrices;

import Modele.Modele;
import Modele.Point;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer un Redimensionnement.
 * @author canonnet
 */
public class Redimensionnement implements StrategieTransformation{

	Modele m;
	Translation t;
	
	public Redimensionnement(Modele m) {
		this.m=m;
		t = new Translation(m);
	}
	
	/**
	 * Zoomer la figure selon un parametre de zoom donne.
	 */
	public void appliquer(Object o) {
		double coef = (double)o;
		Point vecteurT = t.translationCentre();
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*(1+coef));
			m.getPointAtIndex(i).setY(y*(1+coef));
			m.getPointAtIndex(i).setZ(z*(1+coef));
		}
		t.appliquer(vecteurT);
	}

}
