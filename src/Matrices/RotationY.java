package Matrices;

import Modele.Modele;
import Modele.Point;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer une rotation sur l'axe des Y.
 * @author canonnet
 */
public class RotationY implements StrategieTransformation{
	Modele m;
	Translation t;
	
	public RotationY(Modele m) {
		this.m = m;
		t = new Translation(m);
	}
	
	/**
	 * Permet de faire la rotation autour de l'axe Y avec un angle en radian.
	 * @param radian l'angle en radian utilisé
	 * @param m Modele utilisé
	 */

	public void appliquer(Object radian) {
		Point vecteurT = t.translationCentre();
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians((int)radian));
			double sin = Math.sin(Math.toRadians((int)radian));

			double x = m.getPointAtIndex(i).getX();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*cos+z*sin);
			m.getPointAtIndex(i).setZ((-sin)*x+z*cos);
		}
		t.appliquer(vecteurT);
	}

}
