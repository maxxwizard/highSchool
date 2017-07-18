/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #7
	October 28, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class pascalTriangle {

	public static void main(String args[]) {
	
    KeyboardReader reader = new KeyboardReader();
	
    int input = reader.readInt("How many lines do you want to print out? ");
    int row = 0;
    int col = 0;
    int spacecounter;
    int value;
	
    for (row = 0; row < input; row++) { // loop that runs as many times as the user's input
  		
    	for (spacecounter = 0; spacecounter <= (3*(input - row)); spacecounter++) // puts spaces in front of the row of numbers
    		System.out.print(" ");
    		
        for (col = 0; col <= row; col++) {
        	value = factorial(row) / ( factorial(col) * factorial(row-col) );
        	System.out.print(pad(value)); // prints out pascal's triangle with spaces inbetween the numbers
            }
            
        System.out.println(""); // new line
        }
        
	}
	
	// a function that puts spaces between the numbers
	public static String pad(long n) {
	
		String s = String.valueOf(n);
		
		for (int i = s.length();i <= 5; i++)
			s = s + " ";
			
		return s;
		}
	
	// a function that computes factorial
	public static int factorial(int n) {
	
		int fact = 1;
		
		for (int i = 1; i <= n; i++)
			fact = fact * i;
				
		return fact;
		}
}