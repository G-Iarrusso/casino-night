package cp317;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;


public class BlackJackMain {
	
	public static void main(String args[]) {
		BlackJackMain b = new BlackJackMain();
		Player p = new Player("Matt", 1000);
		b.Startup(p);
	}
	
	//Create labels
	JLabel back = new JLabel("");
	JLabel timer = new JLabel("0");
	JLabel bet = new JLabel("Enter your bet");
	JLabel cpu1 = new JLabel("CPU #1");
	JLabel cpu2 = new JLabel("CPU #2");
	JLabel player = new JLabel("Player");
	JLabel dealer = new JLabel("Dealer");
	JLabel playerValue = new JLabel("0");
	
	//Create buttons
	JButton endGame = new JButton("End Game");
	JButton rules = new JButton("Rules");
	JButton enter = new JButton("Enter");
	JButton hit = new JButton("Hit");
	JButton stay = new JButton("Stay");
	JButton playerCard1 = new JButton();
	JButton playerCard2 = new JButton();
	JButton playerCard3 = new JButton();
	JButton playerCard4 = new JButton();
	JButton playerCard5 = new JButton();
	JButton playerCard6 = new JButton();
	JButton playerCard7 = new JButton();
	JButton playerCard8 = new JButton();
	JButton playerCard9 = new JButton();
	JButton playerCard10 = new JButton();
	
	
	//Create misc
	JTextField input = new JTextField();
	
	//Declare variables
	BlackJackConfig config = new BlackJackConfig();
	int ticks = 0;
	int cardNum;
	ImageIcon cardIcon;
	File f = new File("Card_Images");
	ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
	final JFrame frame = new JFrame("BlackJack");
	
	public void Startup(Player p) {
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("Other_Images/blackjack.jpg");
    	Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
    	ImageIcon background = new ImageIcon(iconTemp);
    	JLabel contentPane = new JLabel();
    	contentPane.setIcon(background);
    	contentPane.setLayout( new BorderLayout() );
    	frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		player.setText("Player: " + p.getMoney());
		
		bet.setFont(new Font("Serif", Font.PLAIN, 20));
		player.setFont(new Font("Serif", Font.PLAIN, 20));
		dealer.setFont(new Font("Serif", Font.PLAIN, 20));
		cpu1.setFont(new Font("Serif", Font.PLAIN, 20));
		cpu2.setFont(new Font("Serif", Font.PLAIN, 20));
		playerValue.setFont(new Font("Serif", Font.BOLD, 30));
		
		endGame.setBackground(Color.gray);
		rules.setBackground(Color.gray);
		
		back.setBounds(100, 100, 200, 300);
		rules.setBounds(1200, 0, 200, 100);
		endGame.setBounds(0, 0, 200, 100);
		timer.setBounds(0, 0, 100, 100);
		bet.setBounds(650, 350, 400, 100);
		input.setBounds(650, 425, 125, 50);
		enter.setBounds(550, 425, 100, 50);
		cpu1.setBounds(1200, 800, 200, 100);
		cpu2.setBounds(100, 800, 200, 100);
		player.setBounds(650, 800, 200, 100);
		dealer.setBounds(650, 0, 100, 25);
		hit.setBounds(475, 425, 200, 100);
		stay.setBounds(725, 425, 200, 100);
		playerCard1.setBounds(630, 650, 125, 175);
		playerCard2.setBounds(600, 650, 125, 175);
		playerCard3.setBounds(570, 650, 125, 175);
		playerCard4.setBounds(540, 650, 125, 175);
		playerCard5.setBounds(510, 650, 125, 175);
		playerCard6.setBounds(480, 650, 125, 175);
		playerCard7.setBounds(450, 650, 125, 175);
		playerCard8.setBounds(420, 650, 125, 175);
		playerCard9.setBounds(390, 650, 125, 175);
		playerCard10.setBounds(360, 650, 125, 175);
		playerValue.setBounds(660, 575, 100, 50);
		
		panel.add(back);
		panel.add(rules);
		panel.add(endGame);
		panel.add(timer);
		panel.add(bet);
		panel.add(input);
		panel.add(enter);
		panel.add(cpu1);
		panel.add(cpu2);
		panel.add(player);
		panel.add(dealer);
		panel.add(hit);
		panel.add(stay);
		panel.add(playerCard1);
		panel.add(playerCard2);
		panel.add(playerCard3);
		panel.add(playerCard4);
		panel.add(playerCard5);
		panel.add(playerCard6);
		panel.add(playerCard7);
		panel.add(playerCard8);
		panel.add(playerCard9);
		panel.add(playerCard10);
		panel.add(playerValue);
		
		playerCard1.setEnabled(false);
		playerCard2.setEnabled(false);
		playerCard3.setEnabled(false);
		playerCard4.setEnabled(false);
		playerCard5.setEnabled(false);
		playerCard6.setEnabled(false);
		playerCard7.setEnabled(false);
		playerCard8.setEnabled(false);
		playerCard9.setEnabled(false);
		playerCard10.setEnabled(false);
		playerCard1.setVisible(false);
		playerCard2.setVisible(false);
		playerCard3.setVisible(false);
		playerCard4.setVisible(false);
		playerCard5.setVisible(false);
		playerCard6.setVisible(false);
		playerCard7.setVisible(false);
		playerCard8.setVisible(false);
		playerCard9.setVisible(false);
		playerCard10.setVisible(false);
		hit.setVisible(false);
		stay.setVisible(false);
		playerValue.setVisible(false);
		
		panel.setOpaque(false);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
		Listeners();
	}
	
	public void Listeners() {
		endGame.addActionListener(new goBack());
		enter.addActionListener(new setBet());
		hit.addActionListener(new addCard());
	}
	
private class setBet implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			cardNum = config.getCard();
			cardIcon = config.getCardImage(cardNum);
			playerCard1.setIcon(cardIcon);
			playerCard1.setDisabledIcon(cardIcon);
			
			cardNum = config.getCard();
			cardIcon = config.getCardImage(cardNum);
			playerCard2.setIcon(cardIcon);
			playerCard2.setDisabledIcon(cardIcon);
			
			playerValue.setText("" + config.getValue("player"));
			
			playerCard1.setVisible(true);
			playerCard2.setVisible(true);
			enter.setVisible(false);
			input.setVisible(false);
			bet.setText("Hit or Stay");
			hit.setVisible(true);
			stay.setVisible(true);
			playerValue.setVisible(true);
		}
	}

	private class addCard implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!playerCard3.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard3.setIcon(cardIcon);
				playerCard3.setDisabledIcon(cardIcon);
				
				playerCard1.setBounds(660, 650, 125, 175);
				playerCard2.setBounds(630, 650, 125, 175);
				playerCard3.setBounds(600, 650, 125, 175);
				
				playerCard3.setVisible(true);
			}
			else if (!playerCard4.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard4.setIcon(cardIcon);
				playerCard4.setDisabledIcon(cardIcon);
				
				playerCard4.setBounds(570, 650, 125, 175);
				playerCard4.setVisible(true);
			}
			else if (!playerCard5.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard5.setIcon(cardIcon);
				playerCard5.setDisabledIcon(cardIcon);
				
				playerCard1.setBounds(690, 650, 125, 175);
				playerCard2.setBounds(660, 650, 125, 175);
				playerCard3.setBounds(630, 650, 125, 175);
				playerCard4.setBounds(600, 650, 125, 175);
				playerCard5.setBounds(570, 650, 125, 175);
				
				playerCard5.setVisible(true);	
			}
			else if (!playerCard6.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard6.setIcon(cardIcon);
				playerCard6.setDisabledIcon(cardIcon);
				
				playerCard6.setBounds(540, 650, 125, 175);
				playerCard6.setVisible(true);
			}
			else if (!playerCard7.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard7.setIcon(cardIcon);
				playerCard7.setDisabledIcon(cardIcon);
				
				playerCard1.setBounds(720, 650, 125, 175);
				playerCard2.setBounds(690, 650, 125, 175);
				playerCard3.setBounds(660, 650, 125, 175);
				playerCard4.setBounds(630, 650, 125, 175);
				playerCard5.setBounds(600, 650, 125, 175);
				playerCard6.setBounds(570, 650, 125, 175);
				playerCard7.setBounds(540, 650, 125, 175);
				
				playerCard7.setVisible(true);	
			}
			else if (!playerCard8.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard8.setIcon(cardIcon);
				playerCard8.setDisabledIcon(cardIcon);
				
				playerCard8.setBounds(510, 650, 125, 175);
				playerCard8.setVisible(true);
			}
			else if (!playerCard9.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard9.setIcon(cardIcon);
				playerCard9.setDisabledIcon(cardIcon);
				
				playerCard1.setBounds(750, 650, 125, 175);
				playerCard2.setBounds(720, 650, 125, 175);
				playerCard3.setBounds(690, 650, 125, 175);
				playerCard4.setBounds(660, 650, 125, 175);
				playerCard5.setBounds(630, 650, 125, 175);
				playerCard6.setBounds(600, 650, 125, 175);
				playerCard7.setBounds(570, 650, 125, 175);
				playerCard8.setBounds(540, 650, 125, 175);
				playerCard9.setBounds(510, 650, 125, 175);
				
				playerCard9.setVisible(true);
			}
			else if (!playerCard10.isVisible()) {
				cardNum = config.getCard();
				cardIcon = config.getCardImage(cardNum);
				playerCard10.setIcon(cardIcon);
				playerCard10.setDisabledIcon(cardIcon);
				
				playerCard10.setBounds(480, 650, 125, 175);
				playerCard10.setVisible(true);
			}
			playerValue.setText("" + config.getValue("player"));
		}
	}
	
	private class goBack implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	}

	private class b1t implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Thread t = new Thread() {
				public void run() {
					while (ticks < 500) {
						ticks++;
						timer.setText("" + ticks);
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			};
			t.start();
		}
	}
	
	
	
//LAST LINE
}