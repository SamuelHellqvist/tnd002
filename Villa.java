package lab5;

public class Villa extends Building implements CityProperty{
	
	//VARIABLES
	
	private double electricity;
	private double heating;
	private int bedrooms;
	
	//CONSTRUCTORS
	
	public Villa(String arg1, double arg2, int arg3, double arg4, double arg5, int arg6) {
		super(arg1, arg2, arg3);
		electricity = arg4;
		heating = arg5;
		bedrooms = arg6;
	}
	
	//METHODS
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public double maintenance() {
		return electricity+heating;
	}
	
	public double computePropertyTax(){
		return 20*squareMeters + 100*bedrooms;
	}

}
