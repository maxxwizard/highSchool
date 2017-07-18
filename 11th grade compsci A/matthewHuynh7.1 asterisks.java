/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #7
	October 21, 2005
	I certify that this assignment is entirely my own work. 
*/

import TerminalIO.KeyboardReader;

public class asterisks {

	public static void main(String args[]) {

    KeyboardReader reader = new KeyboardReader();

    int input = reader.readInt("How many lines do you want to print out? ");
    int x;
    int i;

    for (x = 0; x < input; x++) {
        for(i = 0; i <= x; i++) {
            System.out.print("*");
            }
        i = 0;
        System.out.println("");
        }
	}
}