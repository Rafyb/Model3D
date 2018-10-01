package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.sun.swing.internal.plaf.metal.resources.metal;

import Modele.Modele;
import Structure.ReadModele;
import Tri.TriRapide;

public class TriTest {
	TriRapide t = new TriRapide();
	Modele m ;
	@Before
	void initialiser() {
		m = new Modele(new ReadModele("ressources/3carre.ply"));
	}

}
