/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #5
	October 12, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class numberReversedNoLimits {

	public static void main(String args[]) {
		
		KeyboardReader reader = new KeyboardReader();
		
		int number = reader.readInt("Input the integer to be reversed: "); // asks for integer
		
		if (number >= 10) { // will check if number is greater than or equal to 10, therefore 001's won't work, or negative numbers
			System.out.print("Your inputted number reversed is: ");
			while (number >= 10) { 				// starts the loop
				System.out.print(number % 10);  // prints out the last digit of the current number
				number = number / 10;			// removes the last digit of the current number
				}
				System.out.print(number % 10);	// prints out the first digit of the number after it has been reduced to less than 10
			}
		else
			System.out.println("Your inputted number is not a valid integer."); // will inform the user that the inputted number is invalid
			
	}
}