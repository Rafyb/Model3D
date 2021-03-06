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
import javafx.stage.Stage;

/**
 * La vue du modele,fonctionne sous la forme de Observer/Observable.
 * Fenetre affichant le modele en 3D à l'aide d'une methode de dessin de triangle.
 * Gere aussi les rotations et translations a la souris :
 *  x et y
 *  x seulement avec ctrl enfonce
 *  y seulement avec shift enfonce
 * @author bauvinr canonnet
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
	 * Methode principale.
	 */
	public void start(Stage stage) { 

		//////////////////////////// SCENES ////////////////////////////
		HBox root = new HBox();
		GestionAffichage boutons = new GestionAffichage(mod);
		boutons.start(stage);
		canvas = new Canvas (1150, 800);
		gc = canvas.getGraphicsContext2D();
		
		root.getChildren().addAll(canvas,boutons.getPage());
		Scene scene = new Scene(root);

		/////////////////////// MOUVEMENTS SOURIS ///////////////////////
		canvas.setOnMouseDragged(e->{
			if (e.isPrimaryButtonDown()) {
				int rotaX = (int) ((Math.abs(this.x-e.getX()) > 20 ) ? -Math.copySign(20, this.x-e.getX()) : -(this.x-e.getX()));
				int rotaY = (int) ((Math.abs(this.y-e.getY()) > 20 ) ? Math.copySign(20, this.y-e.getY()) : (this.y-e.getY()));

				if(rotaX<0 && !e.isShiftDown()) {
					mod.rotationY(rotaX);
				} else if (rotaX>0  && !e.isShiftDown()) {
					mod.rotationY(rotaX);
				}

				if(rotaY<0 && !e.isControlDown()) {

					mod.rotationX(rotaY);
				} else if (rotaY>0 && !e.isControlDown()) {

					mod.rotationX(rotaY);
				}
				this.x = e.getX();
				this.y = e.getY();
			} else if (e.isSecondaryButtonDown()) {
				Point p = new Point(-(this.x-e.getX()),-(this.y-e.getY()),0 );
				mod.translation(p);
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
		
		scene.widthProperty().addListener(e ->{
			canvas.setWidth(scene.getWidth()-boutons.getPage().getWidth());
			this.update(mod,new Object());
			
		});
		scene.heightProperty().addListener(e ->{
			canvas.setHeight(scene.getHeight());
			this.update(mod,new Object());
		});
		
		////////////////////////// EXECUTION ///////////////////////////
		mod.triZ();
		triangle();

		
		stage.setScene(scene);
		stage.setMinWidth(800);
		stage.setMinHeight(700);
		stage.setTitle("Model 3D Afficheur");
		stage.setResizable(true);
		stage.show();
	}

	/**
	 * Methode pour dessiner les triangles.
	 */
	private void triangle() {
		for(int i = 0; i < mod.getAllFace().length; i++) {
			gc.setFill(Color.GREY);
			Face face = mod.getFaceAtIndex(i);
			Point[] points = face.getTabp();
			
			int[] colors = face.getCouleur();
			gc.setFill(Color.rgb((int)(colors[0]*face.getCoefLuminosite()), (int)(colors[1]*face.getCoefLuminosite()), (int)(colors[2]*face.getCoefLuminosite())));

			if(mod.getCheckF())gc.fillPolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
			if(mod.getCheckT())gc.strokePolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
		}
	}

	/**
	 * Methode pour mettre a jour l'affichage en effacant l'ecran et en triant le modele.
	 *
	 */
	public void update(Observable o, Object arg) {
		try {
			if(!mod.getCheckR()) {
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			mod.triZ();
			triangle();
			}
		} catch(Exception e) {

		}

	}

}

