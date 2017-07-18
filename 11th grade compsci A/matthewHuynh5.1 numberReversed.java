/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #5
	October 12, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class numberReversed {

	public static void main(String args[]) {
		
		KeyboardReader reader = new KeyboardReader();
		
		int number = reader.readInt("Input your 5 digit number: "); // input 5 digit number
		
		if (number < 10000 || number > 99999) 		// check if inputted number is 5 digits
			System.out.println("The number you inputted was not 5 digits.");
			
		else
			{
			System.out.print("Your inputted number reversed is: ");	
			for (int x = 0; x < 5; x++) 			// loops 5 times
				{
				System.out.print(number % 10);		// prints out last digit of current number
				number = number / 10;				// takes off last digit of current number
				}
			}
		
	}
}