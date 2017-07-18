/*
	Matthew Huynh			Homeroom 130
	Term #2, Assignment #8
	November 2, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class stringReversed {

	public static void main(String args[]) {
	
    KeyboardReader reader = new KeyboardReader();
	
	for (int j = 0; j < 20; j++) {
   	String reverse = "abcdefghijklmnopqrstuvwxyz";
	
	for (int i = 0; i <= input.length() - 1; i++) {
		reverse = input.charAt(i) + reverse;
		}	
	System.out.print(reverse);
		
	if (reverse.equals(input))
		System.out.println(" is a palindrome.");
	else
		System.out.println(" is your input reversed.");
	}	
	}	
}