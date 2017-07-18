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