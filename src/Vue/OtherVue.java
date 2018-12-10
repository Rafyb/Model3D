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

	public void vueEnCoupe(){
		canvas = new Canvas (800, 800);
		gc = canvas.getGraphicsContext2D();
		
		
		VBox root = new VBox();
		root.getChildren().add(canvas);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setMinWidth(800);
		stage.setMinHeight(800);
		stage.setTitle("Vue en coupe");
		stage.setResizable(true);
		stage.show();
		
		try {
			System.out.println("Affichage Coupe Start");
			affCoupe();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		stage.close();
	}
	
	private double[] getDoubleTab(ArrayList<Double> list) {
		double[] re = new double[list.size()];
		int idx = 0;
		for(Double d : list) {
			re[idx] = d.doubleValue();
			idx++;
		}
		return re;
	}
	
	private void affCoupe() throws InterruptedException {
		Point[] points = mod.getAllPoints();
		Arrays.sort(points);
		
		Point tmp = points[0];
		
		ArrayList<Double> tabx = new ArrayList<>();
		ArrayList<Double> tabz = new ArrayList<>();
		
		System.out.println("Tri effectué");
		
		for(Point p : points) {
			if(p.getY()==tmp.getY()) {
				tabx.add(p.getX());
				tabz.add(p.getZ());
				System.out.println("add "+p.getY());
			} else {
				gc.clearRect(0, 0, 800, 800);
				gc.fillPolygon(getDoubleTab(tabx), getDoubleTab(tabz), tabx.size());

				Thread.sleep(5000);
				System.out.println("On est en "+p.getY());
				
				tmp = p;
				tabx.clear();
				tabz.clear();
				tabx.add(p.getX());
				tabz.add(p.getZ());
			}
		}	
	}
	
	public void vueRotatif() {
		
	}
	

}
