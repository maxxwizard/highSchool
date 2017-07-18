/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #3
	October 3, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class greatestOfIntegers {

	public static void main(String args[]) {
		
		KeyboardReader reader = new KeyboardReader();
		
		int firstInt = reader.readInt("Input the first integer: ");
		int secondInt = reader.readInt("Input the second integer: ");
		int thirdInt = reader.readInt("Input the third integer: ");
		
		if (firstInt >= secondInt && firstInt >= thirdInt)
			System.out.println("The greatest integer of your three is: " + firstInt);
		else if (secondInt >= firstInt && secondInt >= thirdInt)
			System.out.println("The greatest integer of your three is: " + secondInt);
		else if (thirdInt >= firstInt && thirdInt >= secondInt)
			System.out.println("The greatest integer of your three is: " + thirdInt);
	}
}
