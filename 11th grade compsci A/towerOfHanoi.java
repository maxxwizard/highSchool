/*
	Matthew Huynh			Homeroom 130
	Term #1, Assignment #1
	September 23, 2005
	I certify that this assignment is entirely my own work. 
*/


import TerminalIO.KeyboardReader;

public class Recursive {

	public static void main(String args[]) {
		
		tower(8, "A", "C", "B");
		
	}

int counter = 0;
	
public static void tower(int n, String a, String b, String c) {
	
	if (n > 0) {
		tower(n - 1, a, c, b);
		System.out.println("Move disk " + n + " from " + a + " to " + b);
		tower(n - 1, c, b, a);
		}
}

/*
peg 1 to peg 3
peg 1 to peg 2
peg 3 to peg 2
peg 1 to peg 3
peg 2 to peg 1
peg 2 to peg 3
peg 1 to peg 3
*/

}