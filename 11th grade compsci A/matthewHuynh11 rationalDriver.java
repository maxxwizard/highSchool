/*
	Matthew Huynh			Homeroom 130
	Term #2, Assignment #11
	November 28, 2005
	I certify that this assignment is entirely my own work. 
*/

public class RationalProgram { 

public static void main(String args[]) {
	
	Rational a = new Rational();
	Rational b = new Rational(2,4);
	
	System.out.println("Rational a: " + a);
	System.out.println("Rational b: " + b);
	System.out.println("Rational a numerator: " + a.getNumerator());
	System.out.println("Rational a denominator: " + a.getDenominator());
	System.out.println("Rational b numerator: " + b.getNumerator());
	System.out.println("Rational b denominator: " + b.getDenominator());
	
	a.setNumerator(1);
	a.setDenominator(2);
	b.setNumerator(3);
	b.setDenominator(4);
	System.out.println("Rational a: " + a);
	System.out.println("Rational b: " + b);
	System.out.println("Rational a + b: " + a.add(b));
	System.out.println("Rational a - b: " + a.subtract(b));
	System.out.println("Rational a * b: " + a.multiply(b));
	System.out.println("Rational a / b: " + a.divide(b));
	System.out.println("Rational a in decimal form: " + a.toDecimal());
	System.out.println("Rational b in decimal form: " + b.toDecimal());
	
}// end main program code

}// end public class RationalProgram