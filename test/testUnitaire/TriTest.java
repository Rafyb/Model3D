package testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.sun.xml.internal.ws.policy.PolicyIntersector;

import Modele.Face;
import Modele.Modele;
import Modele.Point;
import Modele.ReadModele;
import Modele.Rotation;


public class TriTest {
	Modele test1  = new Modele(new ReadModele("data/corner.ply"));;
	Modele test2 = new Modele(new ReadModele("data/cornertrie.ply"));;


	@Test
	public void TrieRapideTest() {
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
		r.dezoom(test2,0.25);
		test1.triZ();
		for(int i = 0 ; i < test1.getAllPoints().length;i++) {

			double x = test1.getPointAtIndex(i).getX();
			double y = test1.getPointAtIndex(i).getY();
			double z = test1.getPointAtIndex(i).getZ();

			test1.getPointAtIndex(i).setX(x*(1-dezoom));
			test1.getPointAtIndex(i).setY(y*(1-dezoom));
			test1.getPointAtIndex(i).setZ(z*(1-dezoom));

		}
			for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}

		
	}


	@Test
	public void RotationXHaut() {
		int rotation = 10;

		Rotation r = new Rotation();
		r.rotationX(test1, rotation);



		for(int i = 0 ; i < test2.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(rotation));
			double sin = Math.sin(Math.toRadians(rotation));

			double y = test2.getPointAtIndex(i).getY();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setY((y*cos+z*(-sin)));
			test2.getPointAtIndex(i).setZ((y*sin)+(z*cos));
		}

		test1.triZ();
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}



	}
	
	
	@Test
	public void RotationXBas() {
		int rotation = -10;

		Rotation r = new Rotation();
		r.rotationX(test1, rotation);



		for(int i = 0 ; i < test2.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(rotation));
			double sin = Math.sin(Math.toRadians(rotation));

			double y = test2.getPointAtIndex(i).getY();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setY((y*cos+z*(-sin)));
			test2.getPointAtIndex(i).setZ((y*sin)+(z*cos));
		}

		test1.triZ();
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}



	}

	@Test
	public void RotationYDroite() {
		Rotation r = new Rotation();
		int rotation = 10;
		r.rotationY(test1, rotation);
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(rotation));
			double sin = Math.sin(Math.toRadians(rotation));

			double x = test2.getPointAtIndex(i).getX();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setX(x*cos+z*sin);
			test2.getPointAtIndex(i).setZ((-sin)*x+z*cos);
		}
		
		test1.triZ();
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}
	
	@Test
	public void RotationYGauche() {
		Rotation r = new Rotation();
		int rotation = -10;
		r.rotationY(test1, rotation);
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(rotation));
			double sin = Math.sin(Math.toRadians(rotation));

			double x = test2.getPointAtIndex(i).getX();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setX(x*cos+z*sin);
			test2.getPointAtIndex(i).setZ((-sin)*x+z*cos);
		}
		
		test1.triZ();
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}

	@Test
	public void RotationZDroite() {
		Rotation r = new Rotation();
		int rotation = 10;
		r.rotationZ(test1, rotation);
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(rotation));
			double sin = Math.sin(Math.toRadians(rotation));

			double x = test2.getPointAtIndex(i).getX();
			double y = test2.getPointAtIndex(i).getY();

			test2.getPointAtIndex(i).setX(x*cos-sin*y);
			test2.getPointAtIndex(i).setY(sin*x+cos*y);
		}
		
		test1.triZ();
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}
	
	@Test
	public void RotationZGauche() {
		Rotation r = new Rotation();
		int rotation = -10;
		r.rotationZ(test1, rotation);
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++)  {
			double cos = Math.cos(Math.toRadians(rotation));
			double sin = Math.sin(Math.toRadians(rotation));

			double x = test2.getPointAtIndex(i).getX();
			double y = test2.getPointAtIndex(i).getY();

			test2.getPointAtIndex(i).setX(x*cos-sin*y);
			test2.getPointAtIndex(i).setY(sin*x+cos*y);
		}
		
		test1.triZ();
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}
	

	@Test
	public void Zoom() {
		double zoom = 0.25;
		Rotation r = new Rotation();
		r.zoom(test2,0.25);
		test1.triZ();
		for(int i = 0 ; i < test1.getAllPoints().length;i++) {

			double x = test1.getPointAtIndex(i).getX();
			double y = test1.getPointAtIndex(i).getY();
			double z = test1.getPointAtIndex(i).getZ();

			test1.getPointAtIndex(i).setX(x*(1+zoom));
			test1.getPointAtIndex(i).setY(y*(1+zoom));
			test1.getPointAtIndex(i).setZ(z*(1+zoom));

		}
			for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}
	
	@Test
	public void TranslationHaut() {
		Rotation r= new Rotation();
		Point p = new Point(0, -1, 0);
		r.translation(test1, p);
		
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {

			double x = test2.getPointAtIndex(i).getX();
			double y = test2.getPointAtIndex(i).getY();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setX(x+p.getX());
			test2.getPointAtIndex(i).setY(y+p.getY());
			test2.getPointAtIndex(i).setZ(z+p.getZ());
		}
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
	}
		
	
	
	
	@Test
	public void TranslationBas() {
		Rotation r= new Rotation();
		Point p = new Point(0, 1, 0);
		r.translation(test1, p);
		
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {

			double x = test2.getPointAtIndex(i).getX();
			double y = test2.getPointAtIndex(i).getY();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setX(x+p.getX());
			test2.getPointAtIndex(i).setY(y+p.getY());
			test2.getPointAtIndex(i).setZ(z+p.getZ());
		}
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
		
	}
	
	
	@Test
	public void TranslationDroit() {
		Rotation r= new Rotation();
		Point p = new Point(-1, 0, 0);
		r.translation(test1, p);
		
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {

			double x = test2.getPointAtIndex(i).getX();
			double y = test2.getPointAtIndex(i).getY();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setX(x+p.getX());
			test2.getPointAtIndex(i).setY(y+p.getY());
			test2.getPointAtIndex(i).setZ(z+p.getZ());
		}
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
		
	}
	
	
	
	@Test
	public void TranslationGauche() {
		Rotation r= new Rotation();
		Point p = new Point(1, 0, 0);
		r.translation(test1, p);
		
		
		for(int i = 0 ; i < test2.getAllPoints().length;i++) {

			double x = test2.getPointAtIndex(i).getX();
			double y = test2.getPointAtIndex(i).getY();
			double z = test2.getPointAtIndex(i).getZ();

			test2.getPointAtIndex(i).setX(x+p.getX());
			test2.getPointAtIndex(i).setY(y+p.getY());
			test2.getPointAtIndex(i).setZ(z+p.getZ());
		}
		for(int i = 0; i < test2.getAllPoints().length; i++) {
			
			assertTrue(test1.getPointAtIndex(i).getX() == test2.getPointAtIndex(i).getX());
			assertTrue(test1.getPointAtIndex(i).getY() == (test2.getPointAtIndex(i).getY()));
			assertTrue(test1.getPointAtIndex(i).getZ() == (test2.getPointAtIndex(i).getZ()));
		}
		
	}




}
