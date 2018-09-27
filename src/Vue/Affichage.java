package Vue;

import java.util.ArrayList;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

public class Affichage extends Application {
	ArrayList<TriangleMesh> triangles= new ArrayList<TriangleMesh>();
	GraphicsContext gc;

	  public void start(Stage stage) { 
		  
		//////////////////////////// SCENES ////////////////////////////
		VBox root = new VBox();
	    GestionAffichage direction = new GestionAffichage();
	    Canvas canvas = new Canvas (300, 300);
	    gc = canvas.getGraphicsContext2D();
	    gc.setFill(Color.GREY);
	    root.getChildren().add(canvas);
	    Scene scene = new Scene(root);
	    scene.setCamera(new PerspectiveCamera());
	    
	    triangle(new double[] {30.0,100.0,10.0},new double[] {30.0,10.0,200.0},3);
	    
	    stage.setScene(scene);
	    stage.setTitle("Model 3D Afficheur");
	    stage.setResizable(false);
	    stage.show();
	    direction.start(new Stage());

	  }

	  public static void main(String[] args) {
	    Application.launch(args);
	  }
	  
	  public void triangle(double[] pointX, double[] pointY, int nPoint) {
		  gc.fillPolygon(pointX,pointY,nPoint);
	  }

}

