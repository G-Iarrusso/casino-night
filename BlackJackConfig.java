package cp317;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class BlackJackConfig {
	
	final static int DECKS = 2;
	private ArrayList<Card> player = new ArrayList<Card>();
	private ArrayList<Card> dealer = new ArrayList<Card>();
	private ArrayList<Card> cpu1 = new ArrayList<Card>();
	private ArrayList<Card> cpu2 = new ArrayList<Card>();
	private int playerTotal = 0;
	private int dealerTotal = 0;
	private int cpu1Total = 0;
	private int cpu2Total = 0;
	private Deck deck;
	
	File f = new File("Card_Images");
	ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
	
	public BlackJackConfig() {
		deck = new Deck(DECKS);
	}
	
	
	
	public ImageIcon getCardImage(int num) {
		ImageIcon playerCard1 = new ImageIcon("Card_Images/" + names.get(num));
		Image playerImage1 = playerCard1.getImage().getScaledInstance(125, 175, Image.SCALE_DEFAULT);
		ImageIcon cardImage = new ImageIcon(playerImage1);
		
		return cardImage;
	}

	
	public int getCard(String s) {
		Card card = deck.getRandomCard();
		
		if (s.equals("player")) {
			player.add(card);
			
			if (this.checkForAce(card)) {
				if (playerTotal + card.getValue() > 21) {
					this.deck.getSetAceValue(card);
				}
			}
			
			
			playerTotal += card.getValue();
		}
		else if (s.equals("cpu1")) {
			cpu1.add(card);
			if (this.checkForAce(card)) {
				if (cpu1Total + card.getValue() > 21) {
					this.deck.getSetAceValue(card);
				}
			}
			
			cpu1Total += card.getValue();
		}
		else if (s.equals("cpu2")) {
			cpu2.add(card);
			
			if (this.checkForAce(card)) {
				if (cpu2Total + card.getValue() > 21) {
					this.deck.getSetAceValue(card);
				}
			}
			
			cpu2Total += card.getValue();

		}
		else {
			dealer.add(card);
			
			if (this.checkForAce(card)) {
				if (dealerTotal + card.getValue() > 21) {
					this.deck.getSetAceValue(card);
				}
			}
			
			dealerTotal += card.getValue();
		}
		
		return card.getNum();
	}
	
	public int getValue(String s) {
		
		if (s.compareTo("player") == 0) {
			return playerTotal;
		}
		else if (s.compareTo("dealer") == 0) {
			return dealerTotal;
		}
		else if (s.compareTo("cpu1") == 0) {
			return cpu1Total;
		}
		else if (s.compareTo("cpu2") == 0) {
			return cpu2Total;
		}
		return 0;
	}
	
	public boolean checkForAce(Card card) {
		if (card.getNum() == 12 || card.getNum() == 25 || card.getNum() == 38 || card.getNum() == 51)  {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkForJack(Card card) {
		if (card.getNum() == 9 || card.getNum() == 22 || card.getNum() == 35 || card.getNum() == 48)  {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkBlackjack() {
		if (player.size() > 2) {
			return false;
		}
		else if ((checkForAce(player.get(0)) && checkForJack(player.get(1))) || (checkForJack(player.get(0)) && checkForAce(player.get(1)))){
			return true;
		}
		else
			return false;
	}
	
	public void clearHand() {
		player.clear();
		dealer.clear();
		cpu1.clear();
		cpu2.clear();
		
		playerTotal = 0;
		dealerTotal = 0;
		cpu1Total = 0;
		cpu2Total = 0;
	}
	
	public void checkNewDeck() {
		
		if (deck.getNumRemainingCards() < 27) {
			deck = new Deck(DECKS);
		}
		
	}
	
	
	
	
}
