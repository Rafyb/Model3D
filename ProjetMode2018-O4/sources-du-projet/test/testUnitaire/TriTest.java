package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ExceptionTest.WrongNumberFace;
import ExceptionTest.WrongNumberOfPoint;
import Matrices.*;
import Modele.Face;
import Modele.Modele;
import Modele.Point;
import Modele.ReadModele;


public class TriTest {
	
	Modele test1 ;
	FileWriter fWriter1;
	//Modele test2 ;
	ReadModele exist;
	Matrice t;
	

	@Before
	public void setup() throws WrongNumberOfPoint, WrongNumberFace, IOException {
		fWriter1 = new FileWriter("data/cornertest.ply");
		fWriter1.write("ply\n" + 
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
		fWriter1.close();
				
		t = new Matrice();
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

	/**
	 * Dezoom.
	 */
	@Test
	public void Dezoom() {
        double dezoom = 0.25;
		test1.dezoom(dezoom);
		
		
		
		//On ajoute 299.009 car les points sont centrés			
		
		assertEquals(299.009-19.75, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(-2 , test1.getPointAtIndex(3).getX());
		assertEquals(299.009-17.75, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		}

	/**
	 * Rotation X haut.
	 */
	@Test
	public void RotationXHaut() {
		int rotation = 1;

		t.transformation(new RotationX(test1),rotation);



		//On ajoute 299.009 car les points sont centrés
		
				assertEquals(380.010 + 93.761 , test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(1, test1.getPointAtIndex(0).getY(),1);
				assertEquals(0.0, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-1.0, test1.getPointAtIndex(3).getX());
				assertEquals(380.952, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(6.650, test1.getPointAtIndex(3).getZ(),0.001);
				}
	
	
	/**
	 * Rotation X bas.
	 */
	@Test
	public void RotationXBas() {
		int rotation = -1;

		t.transformation(new RotationX(test1),rotation);



		//On ajoute 299.009 car les points sont centrés		
				assertEquals(380.001+ 92.761, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(0 +1.0, test1.getPointAtIndex(0).getY(),1);
				assertEquals(0.0, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-1 - 1.25, test1.getPointAtIndex(3).getX());
				assertEquals(380.001+ 95.261, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(0, test1.getPointAtIndex(3).getZ(),1);
				}



	

	/**
	 * Rotation Y droite.
	 */
	@Test
	public void RotationYDroite() {
		
		int rotation = 1;
		t.transformation(new RotationY(test1),rotation);
		
		//On ajoute 299.009 car les points sont centrés		
		assertEquals(380.001+ 93.689, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(0 + 1.25, test1.getPointAtIndex(0).getY());
		assertEquals(0 - 8.29, test1.getPointAtIndex(0).getZ(),0.001);
		
		
		assertEquals(-1 - 0.25, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(380.001 + 96.261 , test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ(),0.001);
		}
	
	
	/**
	 * Rotation Y gauche.
	 */
	@Test
	public void RotationYGauche() {
		int rotation = -1;
		t.transformation(new RotationY(test1),rotation);
		
		
		
		//On ajoute 299.009 car les points sont centrés		
				assertEquals(380.001+ 93.761, test1.getPointAtIndex(0).getX(),0.001);
				assertEquals(0 + 1.25, test1.getPointAtIndex(0).getY());
				assertEquals(0, test1.getPointAtIndex(0).getZ(),0.001);
				
				
				assertEquals(-1.0 - 0.25, test1.getPointAtIndex(3).getX());
				assertEquals(380.001 + 96.261, test1.getPointAtIndex(3).getY(),0.001);
				assertEquals(0.0, test1.getPointAtIndex(3).getZ(),0.001);
				}
		
	

	/**
	 * Rotation Z droite.
	 */
	@Test
	public void RotationZDroite() {
		
		int rotation = 1;
		t.transformation(new RotationZ(test1),rotation);
		
		
		//On ajoute 299.009 car les points sont centrés		
		assertEquals(378.860 + 379.0099999998003 , test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(15.228, test1.getPointAtIndex(0).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ(),1);
		
		
		assertEquals(-15.296, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(379.01 + 379.0099999998003, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		}
	
	
	/**
	 * Rotation Z gauche.
	 */
	@Test
	public void RotationZGauche() {
		int rotation = -1;
		t.transformation(new RotationZ(test1),rotation);
		
		//On ajoute 299.009 car les points sont centrés		
		assertEquals(0.952+ 379.001, test1.getPointAtIndex(0).getX(),0.01);
		assertEquals(-6.632, test1.getPointAtIndex(0).getY(),0.01);
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(6.632, test1.getPointAtIndex(3).getX(),0.001);
		assertEquals(379.001 +.952, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
		}
	


	/**
	 * Zoom.
	 */
	@Test
	public void Zoom() {
		double zoom = 0.25;
		test1.zoom(zoom);
		test1.triZ();

		///On ajoute 299.009 car les points sont centrés		
	
		assertEquals(299.009 + 75.003, test1.getPointAtIndex(0).getX(), 0.01);
		assertEquals(1.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());


		assertEquals(-1.00, test1.getPointAtIndex(3).getX());
		assertEquals(77.01 + 299.009, test1.getPointAtIndex(3).getY(), 0.01); 
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
	}

	/**
	 * Translation haut.
	 */
	@Test
	public void TranslationHaut() {
		
		Point p = new Point(0, -1, 0);
		test1.translation(p);
		
		
		//On ajoute 299.009 car les points sont centrés	
		
		
		assertEquals(75.003 + 299.009, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(-1.0, test1.getPointAtIndex(3).getX());
		assertEquals(76.003 + 299.009, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
		}
	
		
	
	
	
	/**
	 * Translation bas.
	 */
	@Test
	public void TranslationBas() {
		
		Point p = new Point(0, 1, 0);
		test1.translation(p);
		
		//On ajoute 299.009 car les points sont centrés	

		
		
		assertEquals(1.0 + 299.009, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(1.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(0.0, test1.getPointAtIndex(3).getX());
		assertEquals(2.0 + 299.009, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
	
		
	}
	
	
	/**
	 * Translation droit.
	 */
	@Test
	public void TranslationDroit() {
		
		Point p = new Point(-1, 0, 0);
		test1.translation(p);
		
		//On ajoute 299.009 car les points sont centrés	
		
		
		assertEquals(74.003 + 299.009, test1.getPointAtIndex(0).getX(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(0).getY());
		assertEquals(0.0, test1.getPointAtIndex(0).getZ());
		
		
		assertEquals(-2.0, test1.getPointAtIndex(3).getX());
		assertEquals(76.003 + 299.009, test1.getPointAtIndex(3).getY(),0.001);
		assertEquals(0.0, test1.getPointAtIndex(3).getZ());
		
		
	}
	
	
	


	
	
	
	/**
	 * Translation gauche.
	 */
	@Test
	public void TranslationGauche() {
		Point p = new Point(-1, 0, 0);
		test1.translation(p);
		
		
		//On ajoute 299.009 car les points sont centrés	

			assertEquals(0 + 299.009 , test1.getPointAtIndex(0).getX(),0.001);
			assertEquals(1.0, test1.getPointAtIndex(0).getY());
			assertEquals(0.0, test1.getPointAtIndex(0).getZ());
			
			
			assertEquals(-1.0, test1.getPointAtIndex(3).getX());
			assertEquals(2+ 299.009, test1.getPointAtIndex(3).getY(),0.001);
			assertEquals(0.0, test1.getPointAtIndex(3).getZ());

	
		
	}
	
	/**
	 * Recup face.
	 */
	@Test
	public void RecupFace() {
		
		
		assertEquals(8, exist.getNbFaces());
		assertNotEquals(10,  exist.getNbFaces());
		
		
	}
	
	/**
	 * Recup points.
	 */
	@Test
	public void RecupPoints() {
    assertEquals(6,exist.getNbPoints());
	assertNotEquals(10,  exist.getNbPoints());
		
		
	}
 
	/**
	 * File exist.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void FileExist() {
	assertTrue(exist.fileExist("data/corner.ply"));		
		
	}

	
	/**
	 * Recup not exist.
	 */
	@SuppressWarnings("static-access")
	@Test
	public void RecupNotExist() {
	assertFalse(exist.fileExist("ppppp"));		
		
	}

    /**
     * Point to sting.
     */
    @Test
    public void pointToSting(){
    	Point point = new Point(1.0, 1.0, 1.0);
    	assertEquals("(1.0,1.0,1.0)", point.toString());
    	
    }
    
    /**
     * Face to sting.
     */
    @Test
    public void faceToSting(){
    	Point point1 = new Point(1.0, 1.0, 1.0);
    	Point point2 = new Point(2.0, 2.0, 2.0);
    	Point point3 = new Point(3.0, 3.0, 3.0);
    	
    	Face face = new Face(point1, point2, point3);
    	
    	
    	assertEquals("[(1.0,1.0,1.0)-(2.0,2.0,2.0)-(3.0,3.0,3.0)]", face.toString());    	
    }
    
    /**
     * Face compare.
     */
    @Test
    public void faceCompare(){
    	Point point1 = new Point(1.0, 1.0, 1.0);
    	Point point2 = new Point(2.0, 2.0, 2.0);
    	Point point3 = new Point(3.0, 3.0, 3.0);    
    	
    	Face face1 = new Face(point2, point2, point2);
    	Face face2 = new Face(point1, point1, point1);
    	Face face3 = new Face(point3, point3, point3);
    	
    	
    	assertEquals(0 ,face1.compareTo(face1));
    	assertEquals(-1 ,face1.compareTo(face3));
    	assertEquals(1 ,face1.compareTo(face2));    

    	
    }
    





}
