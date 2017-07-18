/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #4
	October 6, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class quadraticFormula {

	public static void main(String args[]) {
		
		KeyboardReader reader = new KeyboardReader();
		
		int a = reader.readInt("Input the X^2 Coefficient: ");
		int b = reader.readInt("Input the X Coefficient: ");
		int c = reader.readInt("Input the constant: ");
		
		double discriminant = Math.pow(b,2) - (4*a*c);

	    double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
	    double root2 = (-b - Math.sqrt(discriminant)) / (2*a);
	    double root1i =(-b + Math.sqrt(-discriminant)) / (2*a);
	    double root2i = (-b - Math.sqrt(-discriminant)) / (2*a);

	    double formula1 = -b / (2*a);
	    double formula2 = Math.sqrt(-discriminant) / (2*a);
		
		if (discriminant == 0) 
      		{
			System.out.println("Double Root: " + root1);
			}
			
		else if (discriminant > 0) 
      		{
     		 System.out.println("Root 1: " + root1);
     		 System.out.println("Root 2: " + root2);
			}
		
   		else if (b == 0) 
    		{
		    System.out.println("Root 1: " + root1i + "i");
		    System.out.println("Root 2: " + root2i + "i");
		    }
      
		else
      		{
			System.out.println("Root 1: " + formula1 + " + " + formula2 + "i");
      		System.out.println("Root 2: " + formula1 + " - " + formula2 + "i");
			}
			
	}
}

