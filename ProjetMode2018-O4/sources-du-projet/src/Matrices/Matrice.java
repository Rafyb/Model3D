package Matrices;

/**
 * Fait parti du desing pattern "Strategy"
 * Permet d'effectuer les calculs des operations de mouvement sur le modele : rotation, redimensionnement et translation.
 * @author bauvinr
 */
public class Matrice {
	
	/**
	 * Transformation.
	 *
	 * @param st > la strategie employee pour la transformation
	 * @param o > l'argument de transformation
	 */
	public void transformation(StrategieTransformation st, Object o) {
		st.appliquer(o);
	}

}
