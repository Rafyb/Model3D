package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ExceptionTest.WrongNumberFace;
import ExceptionTest.WrongNumberOfPoint;
import Matrices.*;
import Modele.Modele;
import Modele.Point;
import Modele.ReadModele;


public class TriTest {
	Modele test1 ;
	FileWriter fWriter;
	//Modele test2 ;
	ReadModele exist;	
	
	@Before
	public void setup() throws WrongNumberOfPoint, WrongNumberFace, IOException {
		fWriter = new FileWriter("data/cornertest.ply");
		fWriter.write("ply\n" + 
				"format ascii 1.0\n" + 
				"element vertex 6\n" + 
				"property float x\n" + 
				"property float y\n" + 
				"property float z\n" + 
				"element face 8\n" + 
				"property list uchar int vertex_indices\n" + 
				"end_header\n" + 
				"1 0 0\n" + 
				"0 -1 0\n" + 
				"-1 0 0\n" + 
				"0 1 0\n" + 
				"0 0 1\n" + 
				"0 0 -1\n" + 
				"3 4 0 1 \n" + 
				"3 4 1 2 \n" + 
				"3 4 2 3 \n" + 
				"3 4 3 0 \n" + 
				"3 5 1 0 \n" + 
				"3 5 2 1 \n" + 
				"3 5 3 2 \n" + 
				"3 5 0 3 \n" );
		fWriter.close();
		test1  = Modele.getModele(new ReadModele("data/cornertest.ply"));
		exist =  new ReadModele("data/cornertest.ply");	
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
		
				assertEquals(379.010, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(1, test1.getPointAtIndex(0).getY(),1);
				assertEquals(0.0, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-1.0, test1.getPointAtIndex(3).getX());
				assertEquals(380.952, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(6.650, test1.getPointAtIndex(3).getZ(),0.001);
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
		
		assertEquals(378.952, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(1.0, test1.getPointAtIndex(0).getY());
		assertEquals(-6.632, test1.getPointAtIndex(0).getZ(),0.001);
		
		
		assertEquals(-1, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(381.009, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ(),0.001);
		}
	
	
	@Test
	public void RotationYGauche() {
		Rotation r = new Rotation();
		int rotation = -1;
		r.rotationY(test1, rotation);
		
		//On ajoute 379.0099999998003 car les points sont centrés	
		
				assertEquals(379.009, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(1.0, test1.getPointAtIndex(0).getY());
				assertEquals(0, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-1.0, test1.getPointAtIndex(3).getX());
				assertEquals(381.010, test1.getPointAtIndex(3).getY(),0.001);
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
		assertEquals( 379.009, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(-1, test1.getPointAtIndex(0).getY(),1);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ(),1);
		
		
		assertEquals(-1.0, test1.getPointAtIndex(3).getX());
		assertEquals(379.952, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(6.632, test1.getPointAtIndex(3).getZ(),0.001);
		
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
	
		assertEquals(378.01 , test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(1.0, test1.getPointAtIndex(0).getY(),1);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ(),0.001);
		
		
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
		
			assertEquals(379.0099999998003 , test1.getPointAtIndex(0).getX());
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
		assertNotEquals(10,  exist.getNbFaces());
		
		
	}
	
	@Test
	public void RecupPoints() {
    assertEquals(6,exist.getNbPoints());
	assertNotEquals(10,  exist.getNbPoints());
		
		
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
