package Matrices;

import Modele.Modele;
import Modele.Point;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer une rotation sur l'axe des X.
 * @author canonnet
 */
public class RotationX implements StrategieTransformation{	

	Modele m;
	Translation t;
	
	public RotationX(Modele m) {
		this.m = m;
		t = new Translation(m);
	}

	/**
	 * Permet de faire la rotation autour de l'axe X avec un angle en radian.
	 * @param radian l'angle en radian utilise
	 */
	public void appliquer(Object radian) {
		Point vecteurT = t.translationCentre();
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians((int)radian));
			double sin = Math.sin(Math.toRadians((int)radian));

			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setY((y*cos+z*(-sin)));
			m.getPointAtIndex(i).setZ((y*sin)+(z*cos));
		}
		t.appliquer(vecteurT);
	}


}
