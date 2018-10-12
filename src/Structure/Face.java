package Structure;

public class Face implements Comparable<Face>{	
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
	public void updateCdG() {
		Point s = tabp[0];
		Point s1 = tabp[1];
		Point s2 = tabp[2];
		double xG = (s.getX()+s1.getX()+s2.getX())/3;
		double yG = (s.getY()+s1.getY()+s2.getY())/3;
		double zG = (s.getZ()+s1.getZ()+s2.getZ())/3;
		centreGravite = new Point(xG,yG,zG);
	}
	public void setTabp(Point[] tabp) {
		this.tabp = tabp;
	}
	
	public String toString() {
		//return "["+tabp[0]+"-"+tabp[1]+"-"+tabp[2]+"]";
		return centreGravite.getZ()+"";
	}

	@Override
	public int compareTo(Face o) {
		// TODO Auto-generated method stub
		if (this.getCentreG().getZ() == o.getCentreG().getZ()) return 0;
		if (this.getCentreG().getZ() - o.getCentreG().getZ() < 0) return -1;
		return 1;
	}
}
		
		
	
	
	
	
	


