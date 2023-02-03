package Lab1;

import java.lang.Math;

public class Vector {
	private double x;
	private double y;
	private double z;
	
	public static Vector vdef = new Vector(0.0, 0.0, 0.0);
	
	public Vector(){
		setToDefault();
	}
	
	public Vector(double arg1, double arg2, double arg3) {
		x = arg1;
		y = arg2;
		z = arg3;
	}
	
	public static void setDefault(Vector arg) {
		vdef.x = arg.x;
		vdef.y = arg.y;
		vdef.z = arg.z;
	}
	public void setToDefault() {
		x = vdef.x;
		y = vdef.y;
		z = vdef.z;
	}
	
	public static Vector plus (Vector arg1, Vector arg2) {
		Vector d3 = new Vector();
		d3.x = (arg1.x) + (arg2.x);
		d3.y = (arg1.y) + (arg2.y);
		d3.z = (arg1.z) + (arg2.z);
		return(d3);
		}
	
	public Vector minus(Vector arg) {
		Vector d3 = new Vector();
		d3.x = this.x - arg.x;
		d3.y = this.y - arg.y;
		d3.z = this.z - arg.z;
		return d3;
	}
	
	public Vector mult(double arg) {
		Vector d3 = new Vector();
		d3.x = this.x * arg;
		d3.y = this.y * arg;
		d3.z = this.z * arg;
		return d3;
	}

	public double mult(Vector arg) {
		Vector d3 = new Vector();
		d3.x = this.x * arg.x;
		d3.y = this.y * arg.y;
		d3.z = this.z * arg.z;
		
		double dot = d3.x + d3.y + d3.z;
		return dot;
	}
	
	public double lenght() {
		double L = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
		return L;
	}
	
	public Vector matrixMult(double[][] arg) {
		Vector sum = new Vector();
		
		if(arg.length == 3 && arg[0].length ==3) {
			sum.x = arg[0][0]*x + arg[0][1]*y + arg[0][1]*z;
			sum.y = arg[1][0]*x + arg[1][1]*y + arg[1][2]*z;
			sum.z = arg[2][0]*x + arg[2][1]*y + arg[2][2]*z;
		return sum;
		}
		return this; //Java gets that we use the x,y,z from 'this'
	}
	
	public void norm() {
		double l = this.lenght();
		double quotient = 1/l;
		Vector d3 = this.mult(quotient);//Calling the mult method for doubles
		//d3 is created to change this not to be returned
		this.x = d3.x;
		this.y = d3.y;
		this.z = d3.z;
		}
	
	public int compareTo(Vector arg) {
		int ans = 0;
		double l1 = this.lenght();
		double l2 = arg.lenght();
		if(l1 == l2) {
			ans = 0;
		}
		else if(l1 > l2) {
			ans = 1;
		}
		else{
			ans = -1;
		}
		return ans;
	}
	
	public String toString() {
		String sstart = "Vector = (";
		String sx = String.format("%04.01f ", this.x);
		String sy = String.format("%04.01f ", this.y);
		String sz = String.format("%04.01f", this.z);
		String send = ")";
		String sfinish = sstart + sx + sy + sz + send;
		return sfinish;
	}
}
