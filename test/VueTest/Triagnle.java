package VueTest;

import Vue.Affichage;
import javafx.stage.Stage;

public class Triagnle {
	
	public static void main(String[] args) {
		Affichage paint = new Affichage();
		paint.start(new Stage());
		paint.triangle(new double[] {30.0,100.0,10.0},new double[] {30.0,10.0,200.0},3);

	}
}
