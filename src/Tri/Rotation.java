package Tri;

import Modele.Modele;
public class Rotation {

	public Rotation() {
	}

	public void rotationX(Modele m, int radian) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(radian));
			double sin = Math.sin(Math.toRadians(radian));

			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setY((y*cos)-(z*sin));
			m.getPointAtIndex(i).setZ((y*sin)+(z*cos));
		}
	}

	public void rotationY(Modele m, int radian) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(radian));
			double sin = Math.sin(Math.toRadians(radian));

			double x = m.getPointAtIndex(i).getX();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*cos+z*sin);
			m.getPointAtIndex(i).setZ((-sin)*x+z*cos);
		}
	}
	public void rotationZ(Modele m, int radian) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {
			double cos = Math.cos(Math.toRadians(radian));
			double sin = Math.sin(Math.toRadians(radian));

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();

			m.getPointAtIndex(i).setX(x*cos-sin*y);
			m.getPointAtIndex(i).setY(sin*x+cos*y);
		}
	}
	
	public void zoom(Modele m, double coef) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*(1+coef));
			m.getPointAtIndex(i).setY(y*(1+coef));
			m.getPointAtIndex(i).setZ(z*(1+coef));
		}
	}
	public void dezoom(Modele m, double coef) {
		for(int i = 0 ; i < m.getAllPoints().length;i++) {

			double x = m.getPointAtIndex(i).getX();
			double y = m.getPointAtIndex(i).getY();
			double z = m.getPointAtIndex(i).getZ();

			m.getPointAtIndex(i).setX(x*(1-coef));
			m.getPointAtIndex(i).setY(y*(1-coef));
			m.getPointAtIndex(i).setZ(z*(1-coef));
		}
	}
}
