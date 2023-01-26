package lab1;

public class Lab1a {
	
	public static void main(String[] args) {
		double[] da1 = {1.0, 2.0, 3.0};
		double[] da2 = {0.0, -0.5, -2.0};
		System.out.println(da1);//The result of the print function is where the vector d1 is stored
		
		addition(da1, da2);
		subtraction(da1, da2);
		printVector(da1);
		
	}
	
	public static double[] addition(double[] arg1, double[] arg2) {
		
		double[] d3 = new double[3];
		d3[0] = (arg1[0]) + (arg2[0]);
		d3[1] = (arg1[1]) + (arg2[1]);
		d3[2] = (arg1[2]) + (arg2[2]);
		System.out.println(d3);
		System.out.println(d3[0]);
		return(d3);
		
		
	}
	
	public static double[] subtraction(double[] arg1, double[] arg2) {
		
		double[] d3 = new double[3];
		d3[0] = arg1[0] - (arg2[0]);
		d3[1] = arg1[1] - (arg2[1]);
		d3[2] = arg1[2] - (arg2[2]);
		System.out.println(d3);
		System.out.println(d3[0]);
		return(d3);
		
		
	}
	
	public static void printVector(double[] arg) {
		int s = arg.length;
		if (s == 3) {
			System.out.printf("vector is (%04.01f %04.01f %04.01f)", arg[0], arg[1], arg[2]);
		}
	}

}
