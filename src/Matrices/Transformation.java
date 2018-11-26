package Matrices;

import Modele.Modele;

/**
 * Permet d'effectuer les calculs des operations de mouvement sur le modele : rotation, zoom et translation.
 * @author danglotc
 */
public interface Transformation {
	
	public void appliquer(Modele m, Object o);

}
