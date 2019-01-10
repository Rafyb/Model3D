package Matrices;

import Modele.Modele;
import Modele.Point;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer une rotation sur l'axe des Z.
 * @author canonnet
 */
public class RotationZ implements StrategieTransformation{

	Modele m;
	Translation t;

	public RotationZ(Modele m) {
		this.m = m;
		t = new Translation(m);
	}

	/**
	 * Permet de faire la rotation autour de l'axe Z avec un angle en radian.
	 * @param radian l'angle en radian utilise
	 */
	public void appliquer(Object radian) {
		Point vecteurT = t.translationCentre();
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians((int)radian));
			double sin = Math.sin(Math.toRadians((int)radian));

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();

			m.getPointAtIndex(i).setX(x*cos-sin*y);
			m.getPointAtIndex(i).setY(sin*x+cos*y);
		}
		t.appliquer(vecteurT);
	}
	

}
