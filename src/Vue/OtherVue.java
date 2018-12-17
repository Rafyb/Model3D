package Vue;

import java.util.ArrayList;
import java.util.Arrays;

import Modele.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OtherVue {
	private GraphicsContext gc;
	private Canvas canvas;
	private Modele mod;
	
	public OtherVue(Modele mod) {
		this.mod = mod;
	}

	public void rotAuto(){
		canvas = new Canvas (800, 800);
		gc = canvas.getGraphicsContext2D();
		
		
		VBox root = new VBox();
		root.getChildren().add(canvas);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setMinWidth(800);
		stage.setMinHeight(800);
		stage.setTitle("Vue rotation");
		stage.setResizable(true);
		stage.show();
		
		try {
			System.out.println("Affichage Rotation Auto");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		stage.close();
	}
	

	
	public void vueRotatif() {
		
	}
	

}
