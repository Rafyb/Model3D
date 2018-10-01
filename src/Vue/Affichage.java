package Vue;

import java.util.ArrayList;

import Controlleur.GestionAffichage;
import Modele.Modele;
import Structure.Face;
import Structure.Point;
import Structure.ReadModele;
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
	    Canvas canvas = new Canvas (800, 800);
	    gc = canvas.getGraphicsContext2D();
	    gc.setFill(Color.GREY);
	    root.getChildren().add(canvas);
	    Scene scene = new Scene(root);
	    scene.setCamera(new PerspectiveCamera());
	    
	    
	    Modele mod = new Modele(new ReadModele("ressources/dolphin.ply"));
	    affiche(mod);
	    
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
	  
	  public void affiche(Modele mod) {
		  for(int i = 0; i < mod.getAllFace().length; i++) {
			  Face face = mod.getFaceAtIndex(i);
			  Point[] points = face.getTabp();
			  triangle(new double[]{points[0].getX(),points[1].getX(),points[2].getX()},
					   new double[]{points[0].getY(),points[1].getY(),points[2].getY()},3);
		  }
	  }

}

