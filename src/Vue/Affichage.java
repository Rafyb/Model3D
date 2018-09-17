package Vue;

import Controlleur.GestionAffichage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Affichage extends Application {

	  public void start(Stage stage) {
	    VBox root = new VBox();
	    
	    GestionAffichage direction = new GestionAffichage();
	    

	    Scene scene = new Scene(root, 500, 500);
	    stage.setScene(scene);
	    //stage.setFullScreen(true);
	    stage.setTitle("Model 3D Afficheur");
	    stage.setResizable(false);
	    stage.show();
	    direction.start(new Stage());

	  }

	  public static void main(String[] args) {
	    Application.launch(args);
	  }

}

