package lab5;


public abstract class Building implements Comparable<Building>{
	
	//VARIABLES
	private String address;
	private double price;
	protected int squareMeters;				//protected makes it reachable in sub/super- classes but not else
	protected static int selection = 1;		//static means we create a space in the heap
	
	
	//CONSTRUCTOR
	
	public Building(String arg1, double arg2, int arg3) {
		address = arg1;
		price = arg2;
		squareMeters = arg3;
	}
	
	//METHODS
	
	public abstract double maintenance();
		//no body bc abstract
	
	

	public int compareTo(Building arg) {
		int x;
		if(selection == 1) {
			if(price == arg.price){ 						//if the price is the same as Buildings price
				x = 0; 										//they are equals
				}
			else if (price < arg.price) { 					//If the price is lower than Buildings price
				x = -1; 									//The price is below
			}
			else {
				x = 1; 										//Else the price will be above
			}
		}
		else {												//If the selection is not equal to 1 we compare squaremeters
			if(squareMeters == arg.squareMeters) {			//If the square meters are the same as Buildings square meters
				x = 0;										//x becomes 0 to show they are equal
			}
			else if(squareMeters < arg.squareMeters) {		//If squaremeters is smaller than the buildings squaremeters
				x = -1;										//x becomes negative to show it is smaller
			}
			else {											//otherwise the squaremeters will be above the Buildings squaremeters
				x = 1; 										//we show that by giving x a positiv variable
			}
		}
	return x;
	}
	
	public String toString() {
		String output = String.format("Address: %16s,  Living area: %4d,  Price: %10.2f,  Maintenance(per month): %7.2f",
				address, squareMeters, price, maintenance());
		
		if(this instanceof CityProperty) {
			CityProperty temp = (CityProperty)this; //**pin**explain
			output = output + "Property tax: " + temp.computePropertyTax();
		}
		return output;
	}
	
	
}
