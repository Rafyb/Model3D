package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import ExceptionTest.WrongNumberOfPoint;
import Matrices.*;
import Modele.Modele;
import Modele.Point;
import Modele.ReadModele;


public class TriTest {
	Modele test1 ;
	//Modele test2 ;
	ReadModele exist;	
	
	@Before
	public void setup() throws WrongNumberOfPoint {
		test1  = Modele.getModele(new ReadModele("data/corner.ply"));
		exist =  new ReadModele("data/corner.ply");	
		//test2  = new Modele(new ReadModele("data/cornertrie.ply"));

	}
		
	/*
	@Test
	public void trieRapideTest() {
	test1.triZ();
	for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}
	*/

	@Test
	public void Dezoom() {
        double dezoom = 0.25;
        Redimensionnement r = new Redimensionnement();
		r.appliquer(test1,-1);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(0.0, test1.getPointAtIndex(0).getX());
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(-0.0, test1.getPointAtIndex(3).getX());
		assertEquals(0.0, test1.getPointAtIndex(3).getY());
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		}

	@Test
	public void RotationXHaut() {
		int rotation = 1;

		Rotation r = new Rotation();
		r.rotationX(test1, rotation);


		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(379.01 + 379.0099999998003, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(2.0, test1.getPointAtIndex(0).getY(),1);
				assertEquals(0.035, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-2.0, test1.getPointAtIndex(3).getX());
				assertEquals(382.894 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(13.299, test1.getPointAtIndex(3).getZ(),0.001);
				}
	
	
	@Test
	public void RotationXBas() {
		int rotation = -1;

		Rotation r = new Rotation();
		r.rotationX(test1, rotation);



		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(378.01 + 379.0099999998003, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(1.0, test1.getPointAtIndex(0).getY(),1);
				assertEquals(0.0174, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-3.0, test1.getPointAtIndex(3).getX());
				assertEquals(382.011 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(0, test1.getPointAtIndex(3).getZ(),1);
				}



	

	@Test
	public void RotationYDroite() {
		Rotation r = new Rotation();
		int rotation = 1;
		r.rotationY(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(378 + 379.904, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(2.0, test1.getPointAtIndex(0).getY());
		assertEquals(-13.229, test1.getPointAtIndex(0).getZ(),0.001);
		
		
		assertEquals(-1.999, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(383.01 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0359, test1.getPointAtIndex(3).getZ(),0.001);
		}
	
	
	@Test
	public void RotationYGauche() {
		Rotation r = new Rotation();
		int rotation = -1;
		r.rotationY(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(379.01 + 379.0099999998003, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(2.0, test1.getPointAtIndex(0).getY());
				assertEquals(0, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-2.0, test1.getPointAtIndex(3).getX());
				assertEquals(383.01 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(0.0, test1.getPointAtIndex(3).getZ(),0.001);
				}
		
	

	@Test
	public void RotationZDroite() {
		Rotation r = new Rotation();
		int rotation = 1;
		r.rotationZ(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
		assertEquals(378.860 + 379.0099999998003 , test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(15.228, test1.getPointAtIndex(0).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ(),1);
		
		
		assertEquals(-15.296, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(379.01 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
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
		Redimensionnement r = new Redimensionnement();
		r.appliquer(test1,1);
		test1.triZ();

		//On ajoute 379.0099999998003 car les points sont centrés	
	
		assertEquals(380.01 + 378.01   , test1.getPointAtIndex(0).getX(), 0.001);
		assertEquals(2.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());


		assertEquals(-2.0, test1.getPointAtIndex(3).getX());
		assertEquals(382.01 + 380.01, test1.getPointAtIndex(3).getY(), 0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
	}

	@Test
	public void TranslationHaut() {
		Translation r= new Translation();
		Point p = new Point(0, -1, 0);
		r.appliquer(test1, p);
		
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		assertEquals(379.01 + 379.0099999998003, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(1.0, test1.getPointAtIndex(0).getY(),1);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ(),1);
		
		
		assertEquals(-2.0, test1.getPointAtIndex(3).getX());
		assertEquals(381.894 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(13.299, test1.getPointAtIndex(3).getZ(),0.001);
		
		}
	
		
	
	
	
	@Test
	public void TranslationBas() {
		Translation r= new Translation();
		Point p = new Point(0, 1, 0);
		r.appliquer(test1, p);
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
		Translation r= new Translation();
		Point p = new Point(-1, 0, 0);
		r.appliquer(test1, p);
		
       //On ajoute 379.0099999998003 car les points sont centrés	
	
		assertEquals(378.01 + 379.0099999998003, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(1.0, test1.getPointAtIndex(0).getY(),1);
		assertEquals(0.035, test1.getPointAtIndex(0).getZ(),0.001);
		
		
		assertEquals(-3.0, test1.getPointAtIndex(3).getX());
		assertEquals(381.894 +379.0099999998003 , test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(13.299, test1.getPointAtIndex(3).getZ(),0.001);
		
		
	}
	
	
	
	@Test
	public void TranslationGauche() {
		Translation r= new Translation();
		Point p = new Point(-1, 0, 0);
		r.appliquer(test1, p);
		//On ajoute 379.0099999998003 car les points sont centrés	
		
			assertEquals(0 + 379.0099999998003, test1.getPointAtIndex(0).getX());
			assertEquals(1.0, test1.getPointAtIndex(0).getY());
			assertEquals(0.0, test1.getPointAtIndex(0).getZ());
			
			
			assertEquals(-1.0, test1.getPointAtIndex(3).getX());
			assertEquals(2+ 379.0099999998003, test1.getPointAtIndex(3).getY());
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
