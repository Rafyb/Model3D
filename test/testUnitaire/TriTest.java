package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.ws.policy.PolicyIntersector;

import Modele.Face;
import Modele.Modele;
import Modele.Point;
import Modele.ReadModele;
import Modele.Rotation;


public class TriTest {
	Modele test1   = new Modele(new ReadModele("data/corner.ply"));
	Modele test2  = new Modele(new ReadModele("data/cornertrie.ply"));
	ReadModele exist = new ReadModele("data/corner.ply");	
	
	@Before
	public void setup() {
		test1  = new Modele(new ReadModele("data/corner.ply"));
		exist =  new ReadModele("data/corner.ply");	
		test2  = new Modele(new ReadModele("data/cornertrie.ply"));

}
		

	@Test
	public void trieRapideTest() {
	test1.triZ();
	for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}

	@Test
	public void Dezoom() {
        double dezoom = 0.25;
		Rotation r = new Rotation();
		r.dezoom(test1,1);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(0.0, test1.getPointAtIndex(0).getX());
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(0.0, test1.getPointAtIndex(3).getX());
		assertEquals(0.0, test1.getPointAtIndex(3).getY());
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		}

	@Test
	public void RotationXHaut() {
		int rotation = 1;

		Rotation r = new Rotation();
		r.rotationX(test1, rotation);


		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(1 + 379.0099999998003, test1.getPointAtIndex(0).getX());
				assertEquals(0.0, test1.getPointAtIndex(0).getY());
				assertEquals(0.0, test1.getPointAtIndex(0).getZ());
				
				
				assertEquals(0.0, test1.getPointAtIndex(3).getX());
				assertEquals(0.951 + 379.001, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(6.632, test1.getPointAtIndex(3).getZ(),0.001);
				}
	
	
	@Test
	public void RotationXBas() {
		int rotation = -1;

		Rotation r = new Rotation();
		r.rotationX(test1, rotation);



		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(1 + 379.009, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(0.0, test1.getPointAtIndex(0).getY());
				assertEquals(0.0, test1.getPointAtIndex(0).getZ());
				
				
				assertEquals(0.0, test1.getPointAtIndex(3).getX());
				assertEquals(0.952 + 379.001, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(-6.632, test1.getPointAtIndex(3).getZ(),0.001);
				}



	

	@Test
	public void RotationYDroite() {
		Rotation r = new Rotation();
		int rotation = 1;
		r.rotationY(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(0.942 + 379.01, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(-6.632, test1.getPointAtIndex(0).getZ(),0.001);
		
		
		assertEquals(0.0, test1.getPointAtIndex(3).getX());
		assertEquals(1 + 379.0099999998003, test1.getPointAtIndex(3).getY());
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		}
	
	
	@Test
	public void RotationYGauche() {
		Rotation r = new Rotation();
		int rotation = -1;
		r.rotationY(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(0.942 + 379.01, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(0.0, test1.getPointAtIndex(0).getY());
				assertEquals(6.632, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(0.0, test1.getPointAtIndex(3).getX());
				assertEquals(1 + 379.0099999998003, test1.getPointAtIndex(3).getY());
				assertEquals(0.0, test1.getPointAtIndex(3).getZ());
				}
		
	

	@Test
	public void RotationZDroite() {
		Rotation r = new Rotation();
		int rotation = 1;
		r.rotationZ(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(0.952 + 379.001 , test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(6.632, test1.getPointAtIndex(0).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(-6.632, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(379.01 + 0.942, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		}
	
	
	@Test
	public void RotationZGauche() {
		Rotation r = new Rotation();
		int rotation = -1;
		r.rotationZ(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(0.952+ 379.001, test1.getPointAtIndex(0).getX(),0.01);
		assertEquals(-6.632, test1.getPointAtIndex(0).getY(),0.01);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(6.632, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(379.001 +.952, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
		}
	


	@Test
	public void Zoom() {
		double zoom = 0.25;
		Rotation r = new Rotation();
		r.zoom(test1,1);
		test1.triZ();

		//On ajoute 379.0099999998003 car les points sont centrés	
	
		assertEquals(381.01 + 379.01   , test1.getPointAtIndex(0).getX(), 0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());


		assertEquals(0.0, test1.getPointAtIndex(3).getX());
		assertEquals(381.01 + 379.01, test1.getPointAtIndex(3).getY(), 0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
	}

	@Test
	public void TranslationHaut() {
		Rotation r= new Rotation();
		Point p = new Point(0, -1, 0);
		r.translation(test1, p);
		
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		assertEquals(1 + 379.0099999998003, test1.getPointAtIndex(0).getX());
		assertEquals(-1.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(0.0, test1.getPointAtIndex(3).getX());
		assertEquals(0 + 379.0099999998003, test1.getPointAtIndex(3).getY());
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
		}
	
		
	
	
	
	@Test
	public void TranslationBas() {
		Rotation r= new Rotation();
		Point p = new Point(0, 1, 0);
		r.translation(test1, p);
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(1.0 + 379.0099999998003, test1.getPointAtIndex(0).getX());
		assertEquals(1.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(0.0, test1.getPointAtIndex(3).getX());
		assertEquals(2.0 + 379.0099999998003, test1.getPointAtIndex(3).getY());
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
	
		
	}
	
	
	@Test
	public void TranslationDroit() {
		Rotation r= new Rotation();
		Point p = new Point(-1, 0, 0);
		r.translation(test1, p);
		
       //On ajoute 379.0099999998003 car les points sont centrés	
	
		assertEquals(0 + 379.0099999998003, test1.getPointAtIndex(0).getX());
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(-1.0, test1.getPointAtIndex(3).getX());
		assertEquals(1 +379.0099999998003 , test1.getPointAtIndex(3).getY());
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
		
	}
	
	
	
	@Test
	public void TranslationGauche() {
		Rotation r= new Rotation();
		Point p = new Point(-1, 0, 0);
		r.translation(test1, p);
		//On ajoute 379.0099999998003 car les points sont centrés	
		
			assertEquals(0 + 379.0099999998003, test1.getPointAtIndex(0).getX());
			assertEquals(0.0, test1.getPointAtIndex(0).getY());
			assertEquals(0.0, test1.getPointAtIndex(0).getZ());
			
			
			assertEquals(-1.0, test1.getPointAtIndex(3).getX());
			assertEquals(1+ 379.0099999998003, test1.getPointAtIndex(3).getY());
			assertEquals(0.0, test1.getPointAtIndex(3).getZ());

	//	}
		
	}
	
	@Test
	public void RecupFace() {
		
		
		assertEquals(8, exist.getNbFaces());
		
		
	}
	
	@Test
	public void RecupPoints() {
    assertEquals(6,exist.getNbPoints());
		
		
	}
	
	@Test
	public void FileExist() {
	assertTrue(exist.fileExist("data/corner.ply"));		
		
	}

	
	@Test
	public void RecupNotExist() {
	assertFalse(exist.fileExist("ppppp"));		
		
	}







}
