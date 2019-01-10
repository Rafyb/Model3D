package ExceptionTest;

public class WrongNumberFace  extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public String toString() {
		return "Nombre de points dans la face incorrect";
	}

}
