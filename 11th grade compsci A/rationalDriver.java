/*
	Trivial application that displays a string
*/

public class TrivialApplication {

	public static void main(String args[]) {
		
		Rational a = new Rational(1, 3);
		Rational b = new Rational(1, 4);
		Rational add, sub, mul, div;
		
		System.out.println("(" + a + ") + (" + b + ") = " + a.add(b));
		System.out.println("(" + a + ") - (" + b + ") = " + a.subtract(b));
		System.out.println("(" + a + ") * (" + b + ") = " + a.multiply(b));
		System.out.println("(" + a + ") / (" + b + ") = " + a.divide(b));
		System.out.println(b + " = " + b.toDecimal());
	}
}