package cp317;

public class Bet {

	
	private final int values[] = {5, 10, 25, 50, 100, 250, 500};
	private int len;
	private int betVal;
	private int index;
	
	public Bet() {
		this.len = 7;
		this.betVal = values[0];
		this.index = 0;
	}
	
	int getBet() {
		return betVal;
	}
	
	int getNextBet() {
		if (index + 1 < 7)
			return values[index + 1];
		return 0;
	}
	
	int getPrevBet() {
		if (index - 1 >= 0)
			return values[index - 1];
		return 0;
	}
	
	void raiseBet() {
		if (index + 1 < len) {
			index++;
			betVal = values[index];
		}
		else {
			System.out.println("RAISE BET INDEX OUT OF RANGE ERROR (TOO HIGH)");
		}
		
	}
	void clearBet() {
		index = 0;
		betVal = values[index];
	}
	
	void lowerBet() {
		if (index - 1 >= 0) {
			index--;
			betVal = values[index];
		}
		else {
			System.out.println("RAISE BET INDEX OUT OF RANGE ERROR (TOO LOW)");
		}
		
	}
	
}
