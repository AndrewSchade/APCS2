/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		String[] r = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};		
		String[] s = {"Hearts","Spades","Diamond","Clubs"};
		
		int[] p = {2,3,4,5,6,7,8,9,10,10,10,10,1};
		Deck myDeck = new Deck(r,s,p);
	
		System.out.println(myDeck);
		myDeck.shuffle();
		System.out.println(myDeck);
	}
}
