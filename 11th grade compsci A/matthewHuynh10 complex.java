/*
	Matthew Huynh			Homeroom 130
	Term #2, Assignment #10
	November 18, 2005
	I certify that this assignment is entirely my own work. 
*/

public class ComplexProg { 

public static void main(String args[]) {
	
	/*
	Complex first = new Complex();
	System.out.println(first);
	Complex second = new Complex(0);
	System.out.println(second);
	Complex third = new Complex(1.2, 1.2);
	System.out.println(third);
	int a = 5, b = -2;
	Complex fourth = new Complex(a, b);
	System.out.println(fourth);
	Complex fifth = new Complex(3, 4);
	System.out.println(fifth);
	Complex sixth = new Complex(3.0, 4);
	System.out.println(sixth);
	*/
	
	Complex z = new Complex(1,1);
	Complex w = new Complex(1,1);
	
	System.out.println("Absolute value of w: " + w.abs());
	
	System.out.println("Complex z + Complex w: " + z.add(w));
	System.out.println("Complex z - Complex w: " + z.subtract(w));
	System.out.println("Complex z * Complex w: " + z.multiply(w));
	System.out.println("Complex z / Complex w: " + z.divide(w));
	
}// end main program code

}// end public class ComplexProg

public class Complex {  

	private double real;
	private double imag;

	public Complex() {
	
		real = 0;
		imag = 0;
		System.out.println("Hello from the first constructor!");
	}
	
	public Complex(double a) {
	
		real = a;
		imag = a;
		System.out.println("Hello from the second constructor!");
	}
	
	public Complex(double a, double b) {
	
		real = a;
		imag = b;
		System.out.println("Hello from the third constructor!");
	}

	public Complex(int a, int b) {
	
		real = a;
		imag = b;
		System.out.println("Hello from the fourth constructor!");
	}
	
	public double getReal() {
		return real;
	}
	
	public double getImag() {
		return imag;
	}
	
	public void setReal(double r) {
		real = r;
	}

	public void setImag(double i) {
		imag = i;
	}

	public String toString() {
		return real + " + " + imag + "i";
	}
	
	public double abs() {
		return Math.sqrt((real*real) + (imag*imag));
	}
	
	public Complex add(Complex c) {
		return new Complex(real + c.real,imag + c.imag);
	}
	
	public Complex subtract(Complex c) {
		return new Complex(real - c.real,imag - c.imag);
	}
	
	public Complex multiply(Complex c) {
		return new Complex((real * c.real) - (imag * c.imag),(imag * c.real) + (real * c.imag));
	}
	
	public Complex divide(Complex c) {
		double d = (c.real * c.real) + (c.imag * c.imag);
		return new Complex ( ((real * c.real) + (imag * c.imag)) / d,((c.real * c.real) - (real * imag)) / d );
	}
	
}// end public class Complex