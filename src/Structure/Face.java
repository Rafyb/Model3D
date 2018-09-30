package Structure;

public class Face {	
	Point[] tabp;
	Point centreGravite;
	/**
	 * 
	 * @param s Premier point ( x ) 
	 * @param s1 Deuxieme point ( y )
	 * @param s2 Troisieme point ( z ) 
	 */
	public Face(Point s, Point s1, Point s2) { 
		tabp = new Point[] {s, s1, s2};
		double xG = (s.getX()+s1.getX()+s2.getX())/3;
		double yG = (s.getY()+s1.getY()+s2.getY())/3;
		double zG = (s.getZ()+s1.getZ()+s2.getZ())/3;
		centreGravite = new Point(xG,yG,zG);
		
	}

	public Point[] getTabp() {
		return tabp;
	}
	public Point getCentreG() {
		return centreGravite;
	}
	public void setTabp(Point[] tabp) {
		this.tabp = tabp;
	}
	
	public String toString() {
		//return "["+tabp[0]+"-"+tabp[1]+"-"+tabp[2]+"]";
		return centreGravite.getZ()+"";
	}
}
		
		
	
	
	
	
	


