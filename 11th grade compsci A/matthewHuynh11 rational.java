/*
	Matthew Huynh			Homeroom 130
	Term #2, Assignment #3
	December 2, 2005
	I certify that this assignment is entirely my own work. 
*/

public class Rational {  

	private int numerator;
	private int denominator;
	
	//returns a reduced fraction
	private Rational reduceFraction()
	    {
		int GCD = 0;
		boolean found = false;

		GCD = gcd(Math.abs(numerator),denominator);
		
		/*Check for GCD = 0*/
		if(GCD == 0)
		    {
			System.err.println("GCD = 0!");
			return new Rational(0,1);
		    }

	return new Rational(numerator /= GCD, denominator /= GCD);
	}

	//returns the greatest common divisor between two integers
	private int gcd(int num1, int num2)
	    {
		while (num1 != num2)
		    {
			if (num1 > num2)
			    {
				num1 = num1 - num2;
			    }
			else
			    {
				num2 = num2 - num1;
			    }
		    }
		return num1;
	}
	
	//returns mixed numbers
	private boolean isMixed() {
		return (numerator > denominator);
	}
	
	private int intPartMixed() {
		return (numerator / denominator);
	}
	
	private Rational fractPartMixed() {
		return (subtract(new Rational(intPartMixed(), 1))).reduceFraction();
	}
	
	public String toString() {
	
		String s;
		
		if (isMixed())
			s = intPartMixed() + " " + fractPartMixed().toString();
		else
			if (denominator == 1)
				s = numerator + "";
			else
				s = numerator + "/ " + denominator;
		return s;
	}
	
	//create a fraction of 0/1
	public Rational() {
	
		numerator = 0;
		denominator = 1;
	}

	//create a fraction of a/b
	public Rational(int a, int b) {
		
		numerator = a;
		if (b != 0)
			denominator = b;
	}
	
	//retrieves the numerator of a fraction
	public int getNumerator() {
		
		return numerator;
	}
	
	//retrieves the denominator of a fraction
	public int getDenominator() {
		
		return denominator;
	}
	
	//sets the numerator of a fraction
	public void setNumerator(int a) {
		
		numerator = a;
	}
	
	//sets the denominator of a fraction
	public void setDenominator(int a) {
	
		if (a != 0)
			denominator = a;
		else
			System.out.println("You cannot have 0 as the denominator.");
	}
	
	
	
	//add a fraction
	public Rational add(Rational a) {
		
		Rational b = new Rational( (numerator * a.denominator) + (denominator * a.numerator),(denominator * a.denominator) );
		return b.reduceFraction();
	}
	
	//subtract a fraction
	public Rational subtract(Rational a) {
	
		Rational b = new Rational( (numerator * a.denominator) - (denominator * a.numerator),(denominator * a.denominator) );
		return b.reduceFraction();
	}
	
	//multiply by a fraction
	public Rational multiply(Rational a) {
	
		Rational b = new Rational( (numerator * a.numerator),(denominator * a.denominator) );
		return b.reduceFraction();
	}
	
	//divide by a fraction
	public Rational divide(Rational a) {
	
		Rational b = new Rational( (numerator * a.denominator),(denominator * a.numerator) );
		return b.reduceFraction();
	}
	
	//returns a decimal representation of the fraction
	public double toDecimal() {
		
		return ((double)numerator / (double)denominator);
	}
	
}// end public class Rational