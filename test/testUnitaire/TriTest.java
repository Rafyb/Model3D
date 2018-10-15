package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Modele.Modele;
import Structure.Face;
import Structure.ReadModele;


public class TriTest {
	Modele test1 ;
	Modele test2 ;
	
	@Test
	public void TrieRapideTest() {
		test1 = new Modele(new ReadModele("data/corner.ply"));
		test2 = new Modele(new ReadModele("data/test1.ply"));
		test1.triZ();
		
		
	
		
		assertFalse(test1.getAllFace().equals(test2.getAllFace()));	
			
			
			
		}
	


}
