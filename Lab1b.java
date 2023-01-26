package lab1;

public class Lab1b {

	public static void main(String[] args) {
		
		//Write out the content of vdef
		System.out.println(Vector.vdef);
		
		//creates a new vector v1 that is set to vdef
		Vector v1 = new Vector();
		
		//Write out the content of v1
		System.out.println(v1);
		
		//creates a new vector newDef and change vdef to that vector
		Vector newDef = new Vector(1.0, 2.0, 3.0);
		Vector.setDefaulft(newDef);
		
		//sets v1 to the new vdef
		v1.setToDeafault();
		
		//Write out the content of v1
		System.out.println(v1);
		
		//creates a new vector v2
		Vector v2 = new Vector(1.0, 1.0, 2.0);
		
		//write out the length of v1
		System.out.println("lenght: " + v1.length());
		
		//Write the result of subtracting v2 from v1 to the console.
		System.out.println(Vector.plus(v1, v2));
		
		//Write the result of 2*v1 to the console.
		System.out.println(v1.mult(2));
		
		//Write the result of the dot product between v1 and v2 to the console.
		System.out.println(v1.mult(v2));
		
		//Write the result of the length comparison of v1 and v2 to the console.
		System.out.println(v1.compareTo(v2));
		
		//Normalize v1 and v2
		v1.norm();
		v2.norm();
		
		System.out.println(v1);
		
		//write out the scalar product of v1 and v2
		System.out.println(v1.mult(v2));
		
		//write out the scalar product of v2 and itself
		System.out.println(v2.mult(v2));
	}

}
