package Matrices;

import Modele.Modele;

public class Redimensionnement implements StrategieTransformation{
	Modele m;
	
	/**
	 * Fait parti du desing pattern "Strategy"
	 * Permet d'agrandir et de retrecir le modele
	 * @author canonnet
	 */
	public Redimensionnement(Modele m) {
		this.m=m;
	}
	
	/**
	 * Zoomer la figure selon un parametre de zoom donne.
	 * @param coef le coef utilise pour le zoom
	 */
	public void appliquer(Object o) {
		double coef = (double)o;
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
