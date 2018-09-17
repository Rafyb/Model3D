package Vue;

import Controlleur.GestionAffichage;
import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Affichage extends Application {

	  public void start(Stage stage) { 
		VBox root = new VBox();
	    GestionAffichage direction = new GestionAffichage();
	    Canvas canvas = new Canvas (300, 300);
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    root.getChildren().add(canvas);
        root.setStyle("-fx-background-color: lightgrey;"); 
        
	    
	    

	    Scene scene = new Scene(root);
	    scene.setCamera(new PerspectiveCamera());
	    
	    

	    
	    
	    
	    
	    stage.setScene(scene);
	    stage.setTitle("Model 3D Afficheur");
	    stage.setResizable(false);
	    stage.show();
	    direction.start(new Stage());

	  }

	  public static void main(String[] args) {
	    Application.launch(args);
	  }

}

