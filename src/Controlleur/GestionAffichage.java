package Controlleur;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import ExceptionTest.WrongNumberFace;
import ExceptionTest.WrongNumberOfPoint;
import Modele.Modele;
import Modele.Point;
import Modele.ReadModele;
import Vue.OtherVue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Un controleur attache au modele qui est la fenetre de controle de l'affichage.
 * Permet d'effectuer les differentes operations de translation/rotation/zoom.
 * La sensibilite des mouvements est modifiable via les sliders.
 * @author bauvinr
 */
public class GestionAffichage implements Observer{
	private Modele mod;
	private ArrayList<String> listeModele;
	private ComboBox<String> comboBox;
	private VBox root;

		
	/**
	 * Constructeur prenant en parametre le modele qu'il va controler.
	 * @param modele le modele qui va etre controle.	 * 
	 */
	  public GestionAffichage(Modele modele) {
		mod = modele;
		mod.addObserver(this);
		
		listeModele = new ArrayList<String>();
		File f = new File("./data");
		String[] liste = f.list();
		for(String s: liste) {
			if (s.contains(".ply")) listeModele.add(s);		
		}
		listeModele.sort(null);
		//System.out.println(listeModele);
	}
	  /**
	   * Afficher tout les controleurs du modele.
	   * @param stage stage
	   */
	
	public void start(Stage stage) {
	    GridPane boutonsRot = new GridPane();
	    GridPane boutonsTr = new GridPane();

	    root = new VBox();
	    HBox ligne1 = new HBox();
	    HBox ligne2 = new HBox();
	    HBox ligne3 = new HBox();
	    
	    HBox ligne4 = new HBox();
	    HBox ligne5 = new HBox();
	    HBox ligne6 = new HBox();
	    
	    comboBox = new ComboBox<String>();

	    Text choixT = new Text("Choix du modele :");
	    Text slideRot = new Text("10");
	    Text slideTr = new Text("10");
		
	    Slider sliderrot = new Slider();
	    sliderrot.setValue(10);
	    sliderrot.setMin(1.0);
	    sliderrot.setMax(180.0);
	    
	    Slider slidertr = new Slider();
	    slidertr.setValue(10);
	    slidertr.setMin(1.0);
	    slidertr.setMax(100.0);
	    
	    Button rotdroite = new Button("⤷");
	    Button rotgauche = new Button("⤶");
	    
	    Button droite = new Button(">");
	    Button gauche = new Button("<");
	    Button haut = new Button("^");
	    Button bas = new Button("v");
	    
	    Button tdroite = new Button(">");
	    Button tgauche = new Button("<");
	    Button thaut = new Button("^");
	    Button tbas = new Button("v");
	    
	    Button zoom = new Button("+");
	    Button dezoom = new Button("-");
	    
	    CheckBox trait = new CheckBox();
	    trait.setSelected(true);
	    CheckBox face = new CheckBox();
	    CheckBox ombre = new CheckBox();
	    ombre.setSelected(true);
	    
	    Button rotAuto = new Button("Rotation Automatique");
	    Button centre = new Button("Centrer");
	    
	    ligne2.getChildren().addAll(zoom,dezoom);
	    
	    zoom.setMinSize(75, 35);
	    dezoom.setMinSize(75, 35);
	    
	    ligne1.getChildren().addAll(new Label("Slider rotation : "),slideRot);
	    ligne3.getChildren().addAll(new Label("Slider translation : "),slideTr);
	    ligne4.getChildren().addAll(trait,new Label("Masquer traits"));
	    ligne5.getChildren().addAll(face,new Label("Masquer faces"));
	    ligne6.getChildren().addAll(ombre,new Label("Visualisation Ombre"));
	    
	    // ---------------------------- CONTROLEURS ------------------------------//
	    
	    
	    haut.setOnAction(e ->mod.rotationX((int)sliderrot.getValue()));
	    bas.setOnAction(e ->mod.rotationX((int)sliderrot.getValue()*-1)); 
	    gauche.setOnAction(e ->mod.rotationY((int)sliderrot.getValue()*-1));
	    droite.setOnAction(e ->mod.rotationY((int)sliderrot.getValue()));
	    
	    rotgauche.setOnAction(e ->mod.rotationZ((int)sliderrot.getValue()*-1));
	    rotdroite.setOnAction(e ->mod.rotationZ((int)sliderrot.getValue()));
	    
	    zoom.setOnAction(e ->mod.zoom(0.25));
	    dezoom.setOnAction(e ->mod.dezoom(0.25));
	    
	    thaut.setOnAction(e ->mod.translation(new Point(0,slidertr.getValue()*-1, 0)));
	    tbas.setOnAction(e ->mod.translation(new Point(0,slidertr.getValue(), 0)));    
	    tgauche.setOnAction(e ->mod.translation(new Point(slidertr.getValue()*-1, 0, 0)));
	    tdroite.setOnAction(e ->mod.translation(new Point(slidertr.getValue(), 0, 0)));
 
	    sliderrot.valueProperty().addListener(e->slideRot.setText(Integer.toString((int)sliderrot.getValue())));
	    slidertr.valueProperty().addListener(e->slideTr.setText(Integer.toString((int)slidertr.getValue())));
	    
	    trait.setOnAction(e-> mod.checkT());
	    face.setOnAction(e-> mod.checkF());
	    ombre.setOnAction(e -> mod.checkO());
	    
	    centre.setOnAction(e->{
	    mod.centrer();
	    });

	    rotAuto.setOnAction(e->{
		    Stage st2 = new Stage();
		    OtherVue o = new OtherVue(mod);
	    	Thread t = new Thread( (Runnable) o);

	    	o.start(st2);
	    	t.start();
	    });
	    
	    try {
	    comboBox.setValue("beethoven.ply");
	    comboBox.getSelectionModel().selectedItemProperty().addListener(observable -> {
			try {
				mod.changerModele(new ReadModele("./data/"+comboBox.getSelectionModel().getSelectedItem()));
			} catch (WrongNumberOfPoint e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (WrongNumberFace e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	   
	    
	    
	    
	    
	    // --------------------------- TAILLE BOUTONS --------------------------//
	    
	    droite.setMinSize(50, 50);
	    gauche.setMinSize(50, 50);
	    haut.setMinSize(50, 50);
	    bas.setMinSize(50, 50);
	    
	    rotdroite.setMinSize(50, 50);
	    rotgauche.setMinSize(50, 50);

	    boutonsRot.add(rotgauche, 0, 0);
	    boutonsRot.add(rotdroite, 2, 0);
	    boutonsRot.add(haut, 1, 0);
	    boutonsRot.add(gauche, 0, 1);
	    boutonsRot.add(bas, 1, 1);
	    boutonsRot.add(droite, 2, 1);
	    
	    tdroite.setMinSize(50, 50);
	    tgauche.setMinSize(50, 50);
	    thaut.setMinSize(50, 50);
	    tbas.setMinSize(50, 50);
	    
	    boutonsTr.add(tgauche, 0, 1);
	    boutonsTr.add(tbas, 1, 1);
	    boutonsTr.add(tdroite, 2, 1);
	    boutonsTr.add(thaut, 1, 0);
	    
	    comboBox.setMinWidth(150); 
	    
	    root.setStyle("-fx-background-color: #8FAAC8;");
	    
	    comboBox.getItems().setAll(listeModele);
	    root.getChildren().addAll(choixT,comboBox,ligne1,sliderrot,boutonsRot,ligne2,ligne3,slidertr,boutonsTr,ligne4,ligne5,ligne6,rotAuto,centre);
	    root.setPadding(new Insets(10,15,20,20));
	    root.setSpacing(10);
	    
	  }



	/**
	 * Methode pour mettre a jour la liste.
	 */
	public void update(Observable o, Object arg) {
		comboBox.setValue(comboBox.getSelectionModel().getSelectedItem());
	}
	
	public VBox getPage() {
		return root;
	}
}

