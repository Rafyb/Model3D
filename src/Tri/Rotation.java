package Tri;

import Modele.Modele;
import Structure.Face;
import Structure.Point;
/**
 * Permet d'effectuer les calculs des operations de mouvement sur le modele : rotation, zoom et translation.
 * @author danglotc
 */
public class Rotation {	
	/**
	 * Permet de faire la rotation autour de l'axe X avec un nagle en radian.
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
	/**
	 * Zoomer la figure selon un paramètre de zoom donné.
	 */
	public void zoom(Modele m, double coef) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*(1+coef));
			m.getPointAtIndex(i).setY(y*(1+coef));
			m.getPointAtIndex(i).setZ(z*(1+coef));
		}
	}
	/**
	 * Dezoomer la figure selon un paramètre de dezoom donné. 
	 */
	public void dezoom(Modele m, double coef) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*(1-coef));
			m.getPointAtIndex(i).setY(y*(1-coef));
			m.getPointAtIndex(i).setZ(z*(1-coef));
		}
	}
	/**
	 * Methode permettant de faire les transitions de la figure.
	 */
	public void translation(Modele m, Point p) {
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
