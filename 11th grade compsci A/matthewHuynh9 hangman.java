/*
	Matthew Huynh			Homeroom 130
	Term #2, Assignment #9
	November 10, 2005
	I certify that this assignment is entirely my own work. 
*/

// imports TerminalIO needed for user input reading
// imports needed for to retrive a random word from hangman.txt
import TerminalIO.KeyboardReader;
import java.io.*;
import java.util.Random;

public class hangman {

	public static void main(String args[]) {
	
		// declares needed to get a random word from hangman.txt
		String wordFromFile = getWord();	
		int comma = wordFromFile.indexOf(",");
		String wordType = wordFromFile.substring(comma + 1);
		String toGuess = wordFromFile.substring(0, comma);

      	KeyboardReader reader = new KeyboardReader();

    	// creates an integer guessTimes which will limit the
      	// amount of bad guesses a user can make
    	int guessTimes = 7;

		// creates String guessAlready which will hold the user's guesses so far
		String guessAlready = "";

      	// creates character array guessNotYet, which
      	// contains as many underscores as the word length
    	char[] guessNotYet = new char[toGuess.length()];
    	for (int i = 0; i < guessNotYet.length; i++) {
        	guessNotYet[i] = '_';
    	}//end for
    	
    	// tells the user what type of word it is
    	String toGuessUnderscores = "";
    	for (int i = 0; i < toGuess.length(); i++)
    		toGuessUnderscores += "_ ";
		System.out.println(toGuessUnderscores + " is a " + wordType);
		System.out.println();

    	// loops with guessTimes as limit
    	while (guessTimes != 0) {

        	// prints out user's current status
          	// i.e. character array guessNotYet plus spaces inbetween
        	for (int k = 0; k < guessNotYet.length; k++)
            	System.out.print(guessNotYet[k] + " ");
        	System.out.println();//new line

          	// if user has guessed all letters in the word, tells them they
          	// have done so and ends the program by setting guessTimes to -1
          	int win = 0;

          	for (int m = 0; m < guessNotYet.length; m++) {
              	if (guessNotYet[m] == toGuess.charAt(m))
                win += 1; 
         	}//end for

          	if (win == toGuess.length()) {
              System.out.println();
              System.out.println("YOU WIN!");
              System.out.println();
              System.out.println("You guessed the word:");
              System.out.println(toGuess);
              guessTimes = -1;
              break;
          	}//end if
        
			// asks user for guess
          	String input = reader.readLine("What is your guess? ");

        	// checks if input is only one character
        	if (input.length() == 1) {

            // creates user's String input as character guessLetter
            char guessLetter = input.charAt(0);

			// adds the user's input to String guessAlready
			guessAlready += input + " ";

            // declare integer n with value of 0
            // and boolean goodGuess with value of false
            int n = 0;
            boolean goodGuess = false;

            // checks if guessLetter is in String word
            // if so, replace the character at occurence index #
            // with guessLetter
            	while (n < toGuess.length()) {
				int index = toGuess.indexOf(guessLetter,n);
                	if (index != -1) {
                      	goodGuess = true;
                		guessNotYet[index] = guessLetter;
                      	n = index + 1;
                	}//end if

                  	// if all occurences are found and replaced,
                  	// break out of current while loop
                  	if (goodGuess == true && index == -1)
                      	break;

                  	// if no occurences are found, decrement guessTimes by one
                  	// and break out of current while loop
                	if (goodGuess == false) {
                		guessTimes--;
                		break;
                	}//end if

            	}//end while loop

        	}//end if

          // decrements guessTimes by one if user makes a bad guess
          // bad guesses are ones that contain more than 1 character or no character
			    else guessTimes--;
			    
		System.out.println();//skip line
		// prints out the user's guesses so far
		System.out.println("Your guesses so far: " + guessAlready);          

		}//end while

		// will display drawing of hangman of user uses up all guessTimes
		if (guessTimes == 0) {
			System.out.println();
			System.out.println("YOU LOSE!               ");
			System.out.println();
			System.out.println("The word was:           ");
			System.out.println(toGuess);
			System.out.println();
			System.out.println("       _________        ");
			System.out.println("       |       |        ");
			System.out.println("      _|_      |        ");
			System.out.println("     |   |     |        ");
			System.out.println("     |_ _|     |        ");
			System.out.println("       |       |        ");
			System.out.println("       |       |        ");
			System.out.println("      '|'      |        ");
			System.out.println("     ' | '     |        ");
			System.out.println("    '  |  '    |        ");
			System.out.println("       |       |        ");
			System.out.println("      ' '      |        ");
			System.out.println("     '   '     |        ");
			System.out.println("    '     '    |        ");
			System.out.println("         ______|______  ");
			}//end if
        
   }//end public static void main
   
   // method needed to get a random word from hangman.txt
   public static String getWord() {
		String line = "", fileName = "hangman.txt";
		Random rand = new Random();
		
		try {
			FileInputStream stream = new FileInputStream (fileName);
			InputStreamReader iStrReader = new InputStreamReader (stream);
			BufferedReader reader = new BufferedReader (iStrReader);
			try {
				int r = rand.nextInt(310);
				for (int k = 0; k < r; k++)
					line = reader.readLine();
					
				} catch (IOException e) {
					System.out.println("Error in file input:\n"+e.toString());
				}

			stream.close();
			} catch (IOException e) {
				System.out.println("Error in opening file input:\n"+e.toString());
				}
			
		return line;
	}

}//end public class hangman