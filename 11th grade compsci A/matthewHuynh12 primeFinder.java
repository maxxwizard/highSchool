/*
	Matthew Huynh			Homeroom 130
	Term #2, Assignment #6
	December 16, 2005
	I certify that this assignment is entirely my own work. 
*/

public class primeFinder { 

public static void main(String args[]) {
	
	// declares a new character array of size 100,001
	int[] list = new int[100001];
	
	// uses the three methods for the char array list
	// end result is the printing of all primes onscreen
	loadSieve(list);
	generatePrimes(list);
	writeSieve(list);
	
}// end main program code

// fills an array sequentially, meaning index 0 has value 0 and so on...
public static void loadSieve(int[] a) {

	for (int j = 0; j < a.length; j++)
		a[j] = j;
		
}//end loadSieve method

// filters an array by filling the non-prime number indexes with zeroes
public static void generatePrimes(int[] a) {

	int i = 0;
	int j = 0;
	a[1] = 0;
	
	for (i = 2; i < 14; i++) {
		j = 2 * i;
		while (j < a.length) {
			if (a[j] != 0);
				a[j] = 0;
			j = j + i;
		}//end while loop
	}//end for loop

}//end generatePrimes method

// prints out an array, skipping all indexes that have a value of zero
// in this case, it will print out all the primes
public static void writeSieve(int[] a) {

	for (int i = 0; i < a.length; i++)
		if (a[i] != 0)
			System.out.print(a[i] + " ");
			
}//end writeSieve method

}// end public class primeFinder