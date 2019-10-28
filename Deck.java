package cp317;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private Random random = new Random();
	//Size of 1 deck of cards
	private final int SIZE = 52;
	private int maxCards = 0;
	protected int currentCards = 0;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	
	//Instantiates a deck of cards in order
	public Deck(int deckSize) {
		
		//See how many decks of cards will be in one "pack"
		this.maxCards = deckSize * SIZE;
		int tempMaxCards = this.maxCards;
		int i = 0;
		int v = 2;
		
		//Assign cards to deck until deckSize amount reached
		while (i < tempMaxCards) {
			
			//First 13 cards are one suit
			if (i < 13) {
				
				//Assign number cards their numerical value
				if (v < 10) {
					cards.add(new Card(0, i, v, i));
					this.currentCards++;
				}
				//Face cards (excluding Aces) are assigned a value of 10
				else if (v < 14) {
					cards.add(new Card(0, i, 10, i));
					this.currentCards++;
				}
				//Ace assigned a value of 11
				else {
					cards.add(new Card(0, i, 11, i));
					this.currentCards++;
				}
			}
			
			//Next 13 cards are one suit
			else if (i < 26) {
				
				//Assign number cards their numerical value
				if (v < 10) {
					cards.add(new Card(1, i - 13, v, i));
					this.currentCards++;
				}
				//Face cards (excluding Aces) are assigned a value of 10
				else if (v < 14) {
					cards.add(new Card(1, i - 13, 10, i));
					this.currentCards++;
				}
				//Ace assigned a value of 11
				else {
					cards.add(new Card(1, i - 13, 11, i));
					this.currentCards++;
				}
			}
			
			//Next 13 cards are one suit
			else if (i < 39) {
				//Assign number cards their numerical value
				if (v < 10) {
					cards.add(new Card(2, i - 26, v, i));
					this.currentCards++;
				}
				//Face cards (excluding Aces) are assigned a value of 10
				else if (v < 14) {
					cards.add(new Card(2, i - 26, 10, i));
					this.currentCards++;
				}
				//Ace assigned a value of 11
				else {
					cards.add(new Card(2, i - 26, 11, i));
					this.currentCards++;
				}
			}
			
			//Next 13 cards are one suit
			else if (i < 52) {
				//Assign number cards their numerical value
				if (v < 10) {
					cards.add(new Card(3, i - 39, v, i));
					this.currentCards++;
				}
				//Face cards (excluding Aces) are assigned a value of 10
				else if (v < 14) {
					cards.add(new Card(3, i - 39, 10, i));
					this.currentCards++;
				}
				//Ace assigned a value of 11
				else {
					cards.add(new Card(3, i - 39, 11, i));
					this.currentCards++;
				}
			}
			
			//Add next deck if possible
			else if (tempMaxCards > 52) {
				i = 0;
				tempMaxCards = tempMaxCards - 52;
			}
			//Increment I and V
			i++;
			v++;
			
			//Reset the v so each card gets correct value in next suit
			if (v > 14) {
				v = 2;
			}
			
			
		}
	}
	
	//Be able to print the deck
	@Override
	public String toString() {
		String deck = "";
		int i = 0;
		
		while (i < this.currentCards) {
			deck += cards.get(i).toString() + "\n";
			i += 1;
		}
		
		return deck;
	}
	
	//Pick a random card from the deck
	public Card getRandomCard() {
		int num = random.nextInt(this.currentCards);
		Card c = cards.remove(num);
		this.currentCards--;
		return c;
	}
	
	
	//Made for testing purposes only
	public Card getSameIndex() {
		int n = 4;
		Card c = cards.remove(n);
		this.currentCards--;
		return c;
		
	}
	
	public int findCardValue(int n) {
		return cards.get(n).getValue();
	}
	
	//Getter for remaining amount of cards (***For testing purposes***)
	public int getNumRemainingCards() {
		return this.currentCards;
	}
	
	public void getSetAceValue(Card c) {
		c.setAceValue();
	}
	
	public static void main(String args[]) {
		Deck deck1 = new Deck(1);
		System.out.println(deck1);
		System.out.println("\n");
		Card c = deck1.getRandomCard();
		System.out.println("Removed: " + c + "\n");
		Card c1 = deck1.getSameIndex();
		System.out.println("INDEX: " + c1 + "\n");
		Card c2 = deck1.getSameIndex();
		System.out.println("INDEX: " + c2 + "\n");
		System.out.println(deck1);
		System.out.println("\n");
	}
	
}
