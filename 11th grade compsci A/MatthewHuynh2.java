/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #2
	September 23, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class Program2 {

	public static void main(String args[]) {
		
		KeyboardReader reader = new KeyboardReader();
		
		int X = reader.readInt("How about an integer?: ");
		int Y = reader.readInt("How about another one?: ");
		
		System.out.println((X) + " / " + (Y) + " equals " + ((double)X/(double)Y));
		System.out.println((X) + " / " + (Y) + " is " + (X/Y) + " with a remainder of " + (X%Y));
	}
}
