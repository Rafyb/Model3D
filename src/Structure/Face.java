package Structure;

public class Face {	
	Point[] tabp;
	/**
	 * 
	 * @param s Premier point ( x ) 
	 * @param s1 Deuxieme point ( y )
	 * @param s2 Troisieme point ( z ) 
	 */
	public Face(Point s, Point s1, Point s2) { 
		tabp = new Point[] {s, s1, s2};
		
	}

	public Point[] getTabp() {
		return tabp;
	}

	public void setTabp(Point[] tabp) {
		this.tabp = tabp;
	}
	
}
		
		
	
	
	
	
	


