package Vue;

import java.util.Observable;
import java.util.Observer;

import Controlleur.GestionAffichage;
import Modele.Face;
import Modele.Modele;
import Modele.Point;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
/**
 * La vue du modele,fonctionne sous la forme de Observer/Observable.
 * Fenetre affichant le modele en 3D à l'aide d'une methode de dessin de triangle.
 * Gere aussi les rotations a la souris 
 * > x et y
 * > x seulement avec ctrl enfonce
 * > y seulement avec shift enfonce
 * @author bauvinr canonnet danglotc
 */
public class Affichage implements Observer {
	private GraphicsContext gc;
	private Canvas canvas;
	private Modele mod;
	private double x,y;
	/**
	 * Constructeur de la classe Affichage.
	 *  @param modele = attribut mod.
	 */
	public Affichage(Modele modele) {
		mod = modele;
		mod.addObserver(this);
		x=y=0;
	}
	/**
	 * Methode principale pour l'affichage qui crée les fenêtres.
	 * 
	 */
	public void start(Stage stage) { 
	
		//////////////////////////// SCENES ////////////////////////////
		HBox root = new HBox();
		GestionAffichage boutons = new GestionAffichage(mod);
		boutons.start(stage);
		canvas = new Canvas (1150, 800);
		gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.GREY);
		root.getChildren().addAll(canvas,boutons.getPage());
		Scene scene = new Scene(root);
		
		
		
		/////////////////////// MOUVEMENTS SOURIS ///////////////////////
		canvas.setOnMouseDragged(e->{
			
			if (e.isPrimaryButtonDown()) {
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
			} else if (e.isSecondaryButtonDown()) {
				Point p = new Point(-(this.x-e.getX()),-(this.y-e.getY()),0 );
				mod.translation(p);
				System.out.println(this.x + "   "+ e.getX() + " " + this.y  + "  " + e.getY());
				this.x = e.getX();
				this.y = e.getY();
			}
		});
		
		canvas.setOnMousePressed(e ->{this.x = e.getX();this.y = e.getY();});
		
		canvas.setOnScroll(e -> {
			if(e.getDeltaY() > 0) {
				mod.zoom(0.1);
			} else if (e.getDeltaY() < 0){
				mod.dezoom(0.1);
			}
		});
		
		canvas.setOnKeyPressed(e -> {
			System.out.println(e.getCode());
			if (e.getCode().equals(KeyCode.LEFT)) {
				mod.rotationY(-10);
			} else if (e.getCode().equals(KeyCode.UP)) {
				mod.rotationX(10);
			} else if (e.getCode().equals(KeyCode.RIGHT)) {
				mod.rotationY(10);
			} else if (e.getCode().equals(KeyCode.DOWN)) {
				mod.rotationX(10);
			}
		});

		////////////////////////// EXECUTION ///////////////////////////
		mod.triZ();
		triangle();

		stage.setScene(scene);
		stage.setTitle("Model 3D Afficheur");
		stage.setResizable(false);
		stage.show();

		
			
		
	}

	/**
	 * Methode pour dessiner les triangles.
	 */
	private void triangle() {
		for(int i = 0; i < mod.getAllFace().length; i++) {
			Face face = mod.getFaceAtIndex(i);
			Point[] points = face.getTabp();
			if(face.getCouleur()!= null) {
				int[] colors = face.getCouleur();
				gc.setFill(Color.rgb(colors[0], colors[1], colors[2]));
			}
			gc.fillPolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
			gc.strokePolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
		}
	}

	/**
	 * Methode pour mettre à jour l'affichage en effaçant l'écran et en triant le modèle.
	 */
	public void update(Observable o, Object arg) {
		try {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		mod.triZ();
		triangle();
		} catch(Exception e) {
			
		}

	}

}

