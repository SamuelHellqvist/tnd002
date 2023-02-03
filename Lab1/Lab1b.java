package Lab1;

public class Lab1b {

	public static void main(String[] args) {
		System.out.println("vdef = " + Vector.vdef);
		//print out the values of vdef
		
		Vector v1 = new Vector();
		//Creates a new instance of Vector
		System.out.println("v1 = " + v1);
		
		Vector newDef = new Vector(1.0, 2.0, 3.0);
		Vector.setDefault(newDef);
		//setDefault changes the default vector, gives it the default tag
		
		v1.setToDefault();
		//Gives v1 the values of our new default vector
		
		System.out.println("v1 = " + v1);
		Vector v2 = new Vector(1.0, 1.0, 2.0);
		//Creating a new vector w values
		
		System.out.println("v2 = " + v2);
		
		System.out.println("Lenght: " + v1.lenght());
		
		double[][] m1 = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0,1.0}};
		
		System.out.println("v1*m1 = " + v1.matrixMult(m1));
		//Calling the method matrixMult and printing out the result of v1 * m1
		
		double[][]m2 = {{1.0, 0.0}, {0.0, 1.0}};
		
		System.out.println("v1*m2 = " + v1.matrixMult(m2));
		//Will write out v1 bc m2 is not a 3x3 matrix
		
		double[][]m3 = {{0.0, 1.0, 0.}, {1.0, 0.0, 0.0}, {0.0, 0.0,1.0}};
		
		System.out.println("v1*m3 = " + v1.matrixMult(m3));
		
		System.out.println("v1+v2 = " + Vector.plus(v1, v2));
		//Write to the console, addition between v1 & v2 w our method in class Vector (class method, static)
		
		System.out.println("v1-v2 = " + v1.minus(v2));
		//Write out the subtraction between v1 and v2 w the method minus (defined in a different way)
		
		System.out.println("dotpruduct v1*v2 = " + v1.mult(v2));
		//Writes out the dot product between two vectors, understands which method mult bc of my input arg
		
		System.out.println(v1.mult(2));
		
		System.out.println(v1.compareTo(v2));
		//Compares the vectors v1 & v2 lenghts, writes out an int
		
		v1.norm();
		v2.norm();
		//Normalizing the vectors v1 & v2
		
		System.out.println(v1.mult(v2));
		//Dot product of normalized vectors
		
		System.out.println(v2.mult(v2));
		//Dot product between normalized v2 vector and itself
		
		
		
		
		
		

	}

}
