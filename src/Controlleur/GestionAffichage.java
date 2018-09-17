package Controlleur;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GestionAffichage extends Application {

	  public void start(Stage stage) {
	    GridPane root = new GridPane();
	    
	    Button droite = new Button(">");
	    Button gauche = new Button("<");
	    Button haut = new Button("^");
	    Button bas = new Button("v");
	    
	    droite.setMinSize(50, 50);
	    gauche.setMinSize(50, 50);
	    haut.setMinSize(50, 50);
	    bas.setMinSize(50, 50);
	    

	    root.add(gauche, 0, 1);
	    root.add(bas, 1, 1);
	    root.add(droite, 2, 1);
	    root.add(haut, 1, 0);
	    

	    Scene scene = new Scene(root, 150, 100);
	    stage.setScene(scene);
	    //stage.setFullScreen(true);
	    stage.setTitle("Model 3D Move");
	    stage.setResizable(false);
	    stage.show();

	  }

	  public static void main(String[] args) {
	    Application.launch(args);
	  }
}

