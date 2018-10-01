package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import com.sun.swing.internal.plaf.metal.resources.metal;

import Modele.Modele;
import Structure.Face;
import Structure.ReadModele;
import Tri.TriRapide;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class TriTest {
	TriRapide t = new TriRapide();
	Modele test1 ;
	Modele test2 ;
	
	@Test
	public void TrieRapideTest() {
		test1 = new Modele(new ReadModele("ressources/test1.ply"));
		test2 = new Modele(new ReadModele("ressources/test2.ply"));
		Face [] f1;
		Face [] f2;
		f1 = test1.getAllFace();
		test2.triZ();
		f2 = test2.getAllFace();
		
		assertFalse(!(f1.equals(f2)));
			
			
			
			
		
		
	
		
	}

}
