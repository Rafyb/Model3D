package Vue;

import Modele.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class OtherVue extends Application implements Runnable{
	private GraphicsContext gc;
	private Canvas canvas;
	private Modele mod;
	private Stage stage;
	
	public OtherVue(Modele mod) {
		this.mod = mod;
	}

	
	private void printTriangle() {
		for(int i = 0; i < mod.getAllFace().length; i++) {
			gc.setFill(Color.GREY);
			Face face = mod.getFaceAtIndex(i);
			Point[] points = face.getTabp();
			if(face.getCouleur()!= null) {
				int[] colors = face.getCouleur();
				gc.setFill(Color.rgb(colors[0], colors[1], colors[2]));
			}
			if(mod.getCheckF())gc.fillPolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
			if(mod.getCheckT())gc.strokePolygon(new double[]{points[0].getX()+(canvas.getWidth()/2),points[1].getX()+(canvas.getWidth()/2),points[2].getX()+(canvas.getWidth()/2)},
					new double[]{points[0].getY()+(canvas.getHeight()/2),points[1].getY()+(canvas.getHeight()/2),points[2].getY()+(canvas.getHeight()/2)},3);
		}
	}
	

	@Override
	public void run() {
    	mod.checkR();
		while(stage.isFocused()) {
			try {
				gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				mod.triZ();
				printTriangle();
				
				Thread.sleep(50);
				mod.rotationY(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	mod.checkR();
		
	}

	@Override
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
