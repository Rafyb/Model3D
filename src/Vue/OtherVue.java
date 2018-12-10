package Vue;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OtherVue {
	private GraphicsContext gc;
	private Canvas canvas;
	
	public void vueEnCoupe() {
		canvas = new Canvas (500, 500);
		gc = canvas.getGraphicsContext2D();
		
		VBox root = new VBox();
		root.getChildren().add(canvas);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setMinWidth(800);
		stage.setMinHeight(700);
		stage.setTitle("Model 3D Afficheur");
		stage.setResizable(true);
		stage.show();
	}
	
	public void vueRotatif() {
		
	}

}
