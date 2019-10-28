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
	private int numPlayerCards = 0;
	private int numDealerCards = 0;
	private int numCpu1Cards = 0;
	private int numCpu2Cards = 0;
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

	
	public int getCard() {
		Card card = deck.getRandomCard();
		player.add(card);
		
		if (this.checkForAce(card)) {
			if (playerTotal + card.getValue() > 21) {
				this.deck.getSetAceValue(card);
			}
		}
		
		playerTotal += card.getValue();
		
		return card.getNum();
	}
	
	public int getValue(String s) {
		int i = 0;
		
		if (s.compareTo("player") == 0) {
			int n = player.size();
			playerTotal = 0;
			for (i = 0; i < n; i++) {
				playerTotal += player.get(i).getValue();
			}
			return playerTotal;
		}
		else if (s.compareTo("dealer") == 0) {
			int n = dealer.size();
			dealerTotal = 0;
			for (i = 0; i < n; i++) {
				dealerTotal += dealer.get(i).getValue();
			}
			return dealerTotal;
		}
		else if (s.compareTo("cpu1") == 0) {
			int n = player.size();
			cpu1Total = 0;
			for (i = 0; i < n; i++) {
				cpu1Total += cpu1.get(i).getValue();
			}
			return cpu1Total;
		}
		else if (s.compareTo("cpu2") == 0) {
			int n = player.size();
			cpu2Total = 0;
			for (i = 0; i < n; i++) {
				cpu2Total += cpu2.get(i).getValue();
			}
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
	
}
