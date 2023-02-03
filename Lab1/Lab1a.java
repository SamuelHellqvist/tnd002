package Lab1;

public class Lab1a {

	public static void main(String[] args) {
		
		//instantiating the array
		double[] da1 = new double[3]; //Creating a vector with 3 slots saved
		//filling it up element by element
		da1[0]=1.0; 
		da1[1]=2.0;
		da1[2]=3.0;
		
		//initializing the array when we declare the reference variable
		double[]da2 = {0.0, -0.5, -2.0};
		
		System.out.println(da1); //gives us the address in the heap memory that holds the array
		
		addition(da1, da2);
		subtraction(da1, da2);
		printVector(da1);
	}
	
	public static double[] addition (double[] arg1, double[] arg2){
		
			double[] d3 = new double [3];
			d3[0] = arg1[0] + arg2[0];//Each element in both arguments adds together to create the new d3
			d3[1] = arg1[1] + arg2[1];
			d3[2] = arg1[2] + arg2[2];
			System.out.println(d3);//Writes out the address
			System.out.println(d3[0]);//Writes out the value
			return(d3);
		}
	
	public static double[] subtraction(double[] arg1, double[] arg2){
		
		double[] d3 = new double [3];
		d3[0] = arg1[0] - arg2[0];
		d3[1] = arg1[1] - arg2[1];
		d3[2] = arg1[2] - arg2[2];
		System.out.println(d3);
		System.out.println(d3[0]);
		return(d3);
	}
	
	public static void printVector(double[] arg) {
		
		int s = arg.length;
		if (s==3) {
			System.out.printf("Vector is ( %04.1f %04.1f %04.1f)", arg[0], arg[1], arg[2]);
		}
	}

}
