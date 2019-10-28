package cp317;

public class Player {

	private int money = 0;
	private String id = "";
	
	public Player(String id, int money) {
		this.money = money;
		this.id = id;
	}
	
	public void changeMoney(int x) {
		this.money += x;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public String getID() {
		return this.id;
	}
}

