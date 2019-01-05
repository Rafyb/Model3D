package Matrices;

import Modele.Modele;
import Modele.Point;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer les calculs des operations de mouvement sur le modele : rotation, zoom et translation.
 * @author canonnet
 */
public class Translation implements StrategieTransformation{
	Modele m;
	
	public Translation(Modele m) {
		this.m = m;
	}

	/**
	 * Methode permettant de faire les transitions de la figure.
	 * @param p le point utilise pour la translation
	 */
	public void appliquer(Object o) {
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
	
	/**
	 * Methode permettant de realiser une translation du Modele vers le centre.
	 */
	public Point translationCentre() {
		m.updateCentre();
		Point translation = new Point(-m.getCentreModele().getX(),-m.getCentreModele().getY(),-m.getCentreModele().getZ());
		this.appliquer(translation);
		Point translationRetour = new Point(-translation.getX(),-translation.getY(),-translation.getZ());
		return translationRetour;
	}

}
