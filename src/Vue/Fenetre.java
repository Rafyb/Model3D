package Vue;

import Controlleur.GestionAffichage;
import Modele.Modele;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Fenetre{
	private Modele mod;
	private Stage stage;
	
	
	public Fenetre(Modele m) {
		mod = m;
	}
	
	public void start(Stage s) {
	stage = s;
	VBox root = new VBox();
	Affichage aff = new Affichage(mod);
	Node gaff = new GestionAffichage(mod);
	root.getChildren().add(gaff);
	gaff.start(stage);
	
	Scene scene = new Scene(root, 1150, 1200);
	
	
	stage.setScene(scene);
    stage.setTitle("Model 3D Move");
    stage.setResizable(false);
    stage.show();
	}

}
