package Matrices;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer les calculs des operations de mouvement sur le modele : rotation, zoom et translation.
 * @author bauvinr
 */
public interface StrategieTransformation {
	
	/**
	 * Methode commune a toutes les transformations, applique la transformation.
	 *
	 * @param o > argument de transformation
	 */
	public void appliquer(Object o);

}
