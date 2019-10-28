package cp317;

public class Card implements Comparable<Card>{
	
	//Declare types of cards available in a deck
	public static final String SUIT[] = {"Clubs", "Diamonds", "Hearts", "Spades"};
	public static final String FACE[] = {"2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King", "Ace"};
	
	//*** ADD ENUMERATION TO SIMPLIFY VALUES WITH CARDS ***
	/*public enum Face {
		TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

		private int value;

		Face(final int value) {
		    this.value = value;
		}

	}*/
	
	//Declare variables to instantiate a card
	private int suit = 0;
	private int face = 0;
	private int value = 0;
	private int num = 0;
	
	//Instantiate a card object
	protected Card(final int suit, final int face, final int value, final int num) {
		this.suit = suit;
		this.face = face;
		this.value = value;
		this.num = num;
	}
	
	//Allow a card to be formatted and printed (*** Value is here for testing purposes. Remove Later! ***)
	@Override
	public String toString() {
		String card = FACE[this.face] + " of " + SUIT[this.suit] + " --- Value: " + this.value + " Index: " + this.num;
		
		return card;
	}
	
	//Get the value of a certain card
	public int getValue() {
		return this.value;
	}
	
	//Get the index of the card
	public int getNum() {
		return this.num;
	}
	
	//Set the value of an ace
	public void setAceValue() {
		this.value = 1;
	}
	
	
	//Allow cards to be compared to one another (Might need to be tweaked based on the game)
	@Override
	public int compareTo(Card that) {
		// TODO Auto-generated method stub
		if (this.value > that.value) {
			return 1;
		}
		else if (this.value < that.value) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public static void main(String args[]) {
		Card two = new Card(3, 12, 2, 0);
		System.out.print(two.toString());
	}
}
