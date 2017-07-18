/*
	Trivial application that displays a string
*/

public class CardDriver {

	public static void main(String args[]) {
		
		final int numCards = 5;
		
		Card [] hand1 = new Card[numCards];
		Card [] hand2 = new Card[numCards];		
		Card [] deck = new Card[52];
		Card.createDeck(deck);
		hand1 = Card.dealHand(deck, numCards);
		hand2 = Card.dealHand(deck, numCards);
		System.out.println("Hand 1:");
		Card.printHand(hand1);
		System.out.println();
		System.out.println("Hand 2:");
		Card.printHand(hand2);
		System.out.println();
		System.out.println("Hand 1 sorted:");
		Card.sortHand(hand1);
		Card.printHand(hand1);
		System.out.println();
		System.out.println("Hand 2 sorted:");
		Card.sortHand(hand2);
		Card.printHand(hand2);

	}
				
}//end public class CardDriver