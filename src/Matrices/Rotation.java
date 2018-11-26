package Matrices;

import Modele.Modele;

public class Rotation implements Transformation{	
	/**
	 * Permet de faire la rotation autour de l'axe X avec un angle en radian.
	 * @param radian l'angle en radian utilisé
	 * @param m Modele utilisé
	 * 
	 * 
	 */

	public void rotationX(Modele m, int radian) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(radian));
			double sin = Math.sin(Math.toRadians(radian));

			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setY((y*cos+z*(-sin)));
			m.getPointAtIndex(i).setZ((y*sin)+(z*cos));
		}
	}
	/**
	 * Permet de faire la rotation autour de l'axe Y avec un angle en radian.
	 * @param radian l'angle en radian utilisé
	 * @param m Modele utilisé
	 */

	public void rotationY(Modele m, int radian) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(radian));
			double sin = Math.sin(Math.toRadians(radian));

			double x = m.getPointAtIndex(i).getX();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*cos+z*sin);
			m.getPointAtIndex(i).setZ((-sin)*x+z*cos);
		}
	}
	/**
	 * Permet de faire la rotation autour de l'axe Z avec un angle en radian.
	 * @param radian l'angle en radian utilisé
	 * @param m Modele utilisé
	 */
	public void rotationZ(Modele m, int radian) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(radian));
			double sin = Math.sin(Math.toRadians(radian));

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();

			m.getPointAtIndex(i).setX(x*cos-sin*y);
			m.getPointAtIndex(i).setY(sin*x+cos*y);
		}
	}


}
