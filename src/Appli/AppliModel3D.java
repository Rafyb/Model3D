package Appli;

import Controlleur.GestionAffichage;
import Modele.Modele;
import Modele.ReadModele;
import Vue.Affichage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Class a executer pour lancer l'application. 
 * @author bauvinr
 */
public class AppliModel3D extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Modele mod = new Modele(new ReadModele("data/corner.ply"));
		Affichage aff = new Affichage(mod);
		GestionAffichage ga = new GestionAffichage(mod);
		aff.start(primaryStage);
		ga.start(new Stage());

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
