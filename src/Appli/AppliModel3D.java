package Appli;

import Modele.Modele;
import Structure.ReadModele;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppliModel3D extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Modele mod = new Modele(new ReadModele("ressources/spider.ply"));
		mod.start();

	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
