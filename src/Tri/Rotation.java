package Tri;

import Modele.Modele;
public class Rotation {
	
	public Rotation() {
	}
	
	public void rotationX(Modele m, int radian) {
	 for(int i = 0 ; i < m.getAllPoints().length;i++) {
		 double cos = Math.cos(Math.toRadians(radian));
		 double sin = Math.sin(Math.toRadians(radian));
		 double x = m.getPointAtIndex(i).getX();
		 double y = m.getPointAtIndex(i).getY();
		 double z = m.getPointAtIndex(i).getZ();
		 
		 m.getPointAtIndex(i).setY((y*cos)-(z*sin));
		 m.getPointAtIndex(i).setZ((y*sin)+(z*cos));
	 }
	}
}
