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
/**
 * La vue du modele,fonctionne sous la forme de Observer/Observable.
 * Fenetre affichant le modele en 3D à l'aide d'une methode de dessin de triangle.
 * Gere aussi les rotations a la souris 
 * > x et y
 * > x seulement avec ctrl enfonce
 * > y seulement avec shift enfonce
 * @author bauvinr canonnet
 */
public class Affichage implements Observer {
	private Polygon[] triangles;
	private GraphicsContext gc;
	private Canvas canvas;
	private Modele mod;
	private double x,y;

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
		//scene.setCamera(new PerspectiveCamera());
		
		
		/////////////////////// MOUVEMENTS SOURIS ///////////////////////
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

		////////////////////////// EXECUTION ///////////////////////////
		mod.triZ();
		triangle();

		stage.setScene(scene);
		stage.setTitle("Model 3D Afficheur");
		stage.setResizable(false);
		stage.show();


	}

	// --------------------------- Dessine les triangles --------------------------//
	private void triangle() {
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

