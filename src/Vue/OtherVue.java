package Vue;

import Modele.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Fenetre s'ouvrant apr�s l'utilisation du bouton Rotation Automatique de l'application.
 * Tant que la fenetre est en premier plan, l'objet effectue une rotation continue au tour de lui meme. 
 * @author bauvinr
 */
public class OtherVue extends Application implements Runnable{
	
	private GraphicsContext gc;
	private Canvas canvas;
	private Modele mod;
	private Stage stage;
	

	public OtherVue(Modele mod) {
		this.mod = mod;
	}

	/**
	 * Methode qui dessine les triangles du modele sur la fenetre.
	 */
	private void printTriangle() {
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
	 * Methode issu de l'implementation de Runnable qui lance l'execution d'un second thread pour
	 * gerer la rotation du modele sur la nouvelle fenetre.
	 */
	public void run() {
    	mod.checkR();
    	mod.centrer();
		while(stage.isShowing()) {
			try {
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				mod.triZ();
				printTriangle();
				
				Thread.sleep(100);
				mod.rotationY(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    	mod.checkR();
	}

	/**
	 * Ouvre une seconde fenetre sur laquel s'effectue la rotation.
	 */
	public void start(Stage s){
		stage = s;
		stage = new Stage();
		canvas = new Canvas (800, 800);
		gc = canvas.getGraphicsContext2D();
		printTriangle();
		
		VBox root = new VBox();
		root.getChildren().add(canvas);
		
		stage.setScene(new Scene(root));
		stage.setMinWidth(800);
		stage.setMinHeight(800);
		stage.setTitle("Vue rotation");
		stage.setResizable(true);
		stage.show();

	}
	

}
