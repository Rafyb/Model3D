package Vue;

import java.util.Observable;
import java.util.Observer;

import Modele.Modele;
import Structure.Face;
import Structure.Point;
import javafx.application.Application;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Affichage implements Observer {
	Polygon[] triangles;
	GraphicsContext gc;
	Canvas canvas;
	Modele mod;
	double x,y;

	public Affichage(Modele modele) {
		mod = modele;
		mod.addObserver(this);
		x=y=0;
	}

	public void start(Stage stage) { 

		//////////////////////////// SCENES ////////////////////////////
		VBox root = new VBox();
		canvas = new Canvas (1000, 800);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.GREY);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root);
		scene.setCamera(new PerspectiveCamera());
		canvas.setOnMouseDragged(e->{
			
			if(this.x-e.getX()<0 && !e.isShiftDown()) {
				mod.rotationY(2);
			} else if (this.x-e.getX()>0  && !e.isShiftDown()) {
				mod.rotationY(-2);
			}
			
			if(this.y-e.getY()<0 && !e.isControlDown()) {
				
				mod.rotationX(-2);
			} else if (this.y-e.getY()>0 && !e.isControlDown()) {
				
				mod.rotationX(2);
			}
			this.x = e.getX();
			this.y = e.getY();
		});

		mod.triZ();
		triangle();

		stage.setScene(scene);
		stage.setTitle("Model 3D Afficheur");
		stage.setResizable(false);
		stage.show();


	}


	public void triangle() {
		for(int i = 0; i < mod.getAllFace().length; i++) {
			Face face = mod.getFaceAtIndex(i);
			Point[] points = face.getTabp();
			gc.fillPolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
			gc.strokePolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		mod.triZ();
		triangle();

	}

}

