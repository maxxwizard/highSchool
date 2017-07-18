/*
	Matthew Huynh			Homeroom 130
	Term #3, Assignment #2
	January 18, 2006
	I certify that this assignment is entirely my own work. 
*/
import java.util.Random;

public class Card implements Comparable {

	private int rank;
	private String suit;
	private String Spades = "\u0006";
	private String Clubs = "\u0004";
	private String Diamonds = "\u0005";
	private String Hearts = "\u0003";

	//instantiates a Card object of rank 0 and no suit
	public Card() {
		rank = 0;
		suit = "";
	}

	//instantiates a Card object requiring parameters int r and String s
	//the Card's rank will be r and the Card's suit will be s
	public Card(int r, String s) {
		rank = r;
		if (s == "Spades")
			s = Spades;
		else if (s == "Clubs")
			s = Clubs;
		else if (s == "Diamonds")
			s = Diamonds;
		else if (s == "Hearts")
			s = Hearts;
		else suit = s;
	}

	public void setRank(int r) {
		rank = r;
	}

	public void setSuit(String s) {
		suit = s;
	}

	public int getRank() {
		return rank;
	}

	public String getSuit() {
		return suit;
	}

	//displays a card to the user in format of
	//rank + "of" + suit
	//i.e. 8 of Clubs or King of Spades
	public String toString() {

		String r = "";
		if (rank == 11) r = "Jack";
		else if (rank == 12) r = "Queen";
			else if (rank == 13) r = "King";
				else if (rank == 1) r = "Ace";
					else r = "" + rank;
		return r + " of " + suit;
		
	}

	//compareTo method for Card objects
	//will return 0 if Cards are the same
	//will return 1 if first Card is greater than second Card
	//will return -1 if second Card is greater than first Card
	public int compareTo(Object other) {
	
		int holder;
		holder = getRank();
		int holder2;
		holder2 = ((Card)other).getRank();
		if (suit == Clubs)
			holder += 100;
		if (suit == Diamonds)
			holder += 1000;
		if (suit == Hearts)
			holder += 10000;
		
		if (((Card)other).suit == Clubs)
			holder2 += 100;
		if (((Card)other).suit == Diamonds)
			holder2 += 1000;
		if (((Card)other).suit == Hearts)
			holder2 += 10000;
			
		int diff = holder - holder2;
    	return diff;

	}//end compareTo method
	
	//creates 52 different cards, making up a standard deck
	public static void createDeck(Card[] d) {
		String Spades = "\u0006";
		String Clubs = "\u0004";
		String Diamonds = "\u0005";
		String Hearts = "\u0003";
		String s = "";
		for (int i = 0; i <13; i++)
			for (int j = 0; j < 4; j++) {
				if (j == 0) s = Spades;
				if (j == 1) s = Clubs;
				if (j == 2) s = Diamonds;
				if (j == 3) s = Hearts;
				d[j * 13 + i] = new Card(i + 1, s);
			}
	}
	
	//deals out five different cards from the deck
	public static Card[] dealHand(Card[] d, int n) {
	
		int r, s;	
		Random rand = new Random();
		Card [] h = new Card[n];
		for (int i = 0; i < n; i++) {
			r = rand.nextInt(13);
			s = rand.nextInt(4);

			while (d[s * 13 + r].getRank() == -1) {
				r = rand.nextInt(13);
				s = rand.nextInt(4);
			}
			Card copy = new Card();
			copy.setRank(d[s * 13 + r].getRank());
			copy.setSuit(d[s * 13 + r].getSuit());
			h[i] = copy;
			d[s * 13 + r].setRank(-1);
		}
			
		return h;
	}
	
	//sorts a hand by suit and then number from least to greatest
	public static void sortHand(Card[] h) {

		for (int i = 0; i < h.length - 1; i++) {
			for (int j = 0; j < h.length - 1; j++) {
				if (h[j].compareTo(h[j+1]) > 0) {
					Card x = h[j];
					h[j] = h[j+1];
					h[j+1] = x;
				}
			}
		}
	}//end sortHand method
	
	//prints out a hand
	public static void printHand(Card[] h) {
		for (int i = 0; i < h.length; i++)
			System.out.println(h[i]);
	}
	
}//end public class Card
