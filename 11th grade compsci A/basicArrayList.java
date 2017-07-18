import java.util.*;
import java.io.*;
import TerminalIO.KeyboardReader;

public class WordLadder {

	public static void main(String[] args) {
	  
		ArrayList list = new ArrayList();        
		int i = 1;
		int j = 0;
		int choice;

		KeyboardReader reader = new KeyboardReader();
		
		while (i > 0) {
		
		System.out.println();		
		System.out.println(list);
		System.out.println();
		System.out.println("What do you want to do with the current list?");
		System.out.println("1) Delete a word.");
		System.out.println("2) Add words.");
		System.out.println("3) Exit program.");
		System.out.println();
		choice = reader.readInt("Your choice: ");
		
		if (choice == 1) {
			String delete = reader.readLine("What word would you like to delete? ");
			if (list.contains(delete) == false)
				System.out.println("Word does not exist in list.");
			else if (list.indexOf(delete) >= 0)
				list.remove(list.indexOf(delete));
		}//end choice 1
		
		else if (choice == 2) {
				j = 0;
				int p = 0;
				int m = 0;
				while (j == 0) {
				String addition = reader.readLine("What word would you like to add? ");
				if (addition.length() == 0)
					j = -1;
				else if (list.contains(addition) == true)
					System.out.println("Word exists in list already.");
				else if (list.contains(addition) == false) {
					if (list.size() == 0)
						list.add(addition);
					else if (p == 0){
						for (m = 0; m < list.size(); m++) {
							if (addition.compareTo( (String)list.get(m) ) < 0) {
								list.add(m,addition);
								break;
							}
						}
					}
					}
					if (addition.compareTo((String)list.get(list.size()-1)) > 0)
						list.add(addition);
				}//end while loop
		}//end choice 2
				
		else if (choice == 3)
			i = -1;
		
		}//end main while loop
		
	}//end main program code
	
}//end public class WordLadder