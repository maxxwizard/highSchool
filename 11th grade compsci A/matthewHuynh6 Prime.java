/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #6
	October 21, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class Prime {

	public static void main(String args[]) {
		
		KeyboardReader reader = new KeyboardReader();
		
		boolean prime = true;
		int i = 2;
		int number = reader.readInt("Enter a number to check if it is prime: "); // asks for number
		
		if (number > 0) 									// will check if number is greater than 0, therefore 0 and negative numbers won't work 
			{ 									
			while ((prime) && (i <= Math.sqrt(number)))		// if prime is true and divisor is less than the sqrt of the inputted number, loop will run
				{	
				if (number % i == 0) prime = false; 		// if the number divides evenly, it's not a prime number; this kicks you out of the loop
				i++; 										// adds 1 to the counter
				}
			if (!prime) System.out.println("Your number is composite.");
			else System.out.println("Your number is prime.");
		    }
		    
		else System.out.println("Your inputted number is not valid.");
		
	}
}