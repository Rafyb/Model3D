package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Modele.Modele;
import Structure.Point;
import Structure.ReadModele;

class ModeleReader {
	Modele m;
	
	@Before
	void initialiser() {
		m = new Modele(new ReadModele("data/dolphin.ply") );
	}
	
	@Test
	void ajoutDesStructures() {
		assertNotNull(m.getAllPoints());
		assertNotNull(m.getAllFace());
	}

}
