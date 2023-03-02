package lab5;

public class Cottage extends Building{
	
	//VARIABLES
	private double electricity;
	
	//CONSTRUCTOR
	public Cottage(String arg1, double arg2, int arg3, double arg4) {
		super(arg1, arg2, arg3);
		electricity = arg4;
	}
	
	//METHODS
	
	public double maintenance() {
		return electricity;
	}
	
	
}
