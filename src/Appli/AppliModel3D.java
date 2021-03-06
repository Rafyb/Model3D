package Appli;

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

	public void start(Stage primaryStage) throws Exception {
		Modele mod = Modele.getModele(new ReadModele("data/beethoven.ply"));
		Affichage aff = new Affichage(mod);
		aff.start(primaryStage);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
