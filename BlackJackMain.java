package cp317;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;


public class BlackJackMain {
	
	public static void main(String args[]) {
		BlackJackMain b = new BlackJackMain();
		Player p = new Player("Matt", 10);
		JFrame n = new JFrame();
		b.Startup(p, n, 10);
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
	JLabel cpu1Value = new JLabel("0");
	JLabel cpu2Value = new JLabel("0");
	JLabel dealerValue = new JLabel("0");
	JLabel message = new JLabel("");
	JLabel winLoss = new JLabel("+ 0");
	
	//Create buttons
	JButton endGame = new JButton("End Game");
	JButton rules = new JButton("Rules");
	JButton up = new JButton("+");
	JButton down = new JButton("-");
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
	JButton cpu1Card1 = new JButton();
	JButton cpu1Card2 = new JButton();
	JButton cpu1Card3 = new JButton();
	JButton cpu1Card4 = new JButton();
	JButton cpu1Card5 = new JButton();
	JButton cpu1Card6 = new JButton();
	JButton cpu1Card7 = new JButton();
	JButton cpu1Card8 = new JButton();
	JButton cpu1Card9 = new JButton();
	JButton cpu1Card10 = new JButton();
	JButton cpu2Card1 = new JButton();
	JButton cpu2Card2 = new JButton();
	JButton cpu2Card3 = new JButton();
	JButton cpu2Card4 = new JButton();
	JButton cpu2Card5 = new JButton();
	JButton cpu2Card6 = new JButton();
	JButton cpu2Card7 = new JButton();
	JButton cpu2Card8 = new JButton();
	JButton cpu2Card9 = new JButton();
	JButton cpu2Card10 = new JButton();
	JButton dealerCard1 = new JButton();
	JButton dealerCard2 = new JButton();
	JButton dealerCard3 = new JButton();
	JButton dealerCard4 = new JButton();
	JButton dealerCard5 = new JButton();
	JButton dealerCard6 = new JButton();
	JButton dealerCard7 = new JButton();
	JButton dealerCard8 = new JButton();
	JButton dealerCard9 = new JButton();
	JButton dealerCard10 = new JButton();
	
	
	//Create misc
	JTextField input = new JTextField();
	JFrame menuFrame;
	
	//Declare variables
	BlackJackConfig config = new BlackJackConfig();
	int ticks = 0;
	int cardNum;
	int cpu1Num = 0;
	int cpu2Num = 0;
	int dealerNum = 0;
	int val1 = 0;
	boolean cpu1Init = false;
	boolean cpu2Init = false;
	boolean dealerInit = false;
	boolean done = false;
	boolean playerDone = false;
	boolean start = true;
	boolean reset = false;
	boolean didBet = false;
	File file = new File("user_records.txt");
	//File tempFile = new File(file.getAbsolutePath() + ".tmp");
	ImageIcon faceDownCard = config.getCardImage(52);
	ImageIcon cardIcon;
	File f = new File("Card_Images");
	ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
	final JFrame frame = new JFrame("BlackJack");
	PrintWriter pw;
	Bet betting = new Bet();
	Player plyr;
	int numRecords;
	
	
	public void Startup(Player p, JFrame mainFrame, int num) {
		
		//Create the GUI
		numRecords = num;
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuFrame = mainFrame;
		plyr = p;
		
		
		//Set the background
		ImageIcon icon = new ImageIcon("Blackjack_Images/blackjack.jpg");
    	Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
    	ImageIcon background = new ImageIcon(iconTemp);
    	JLabel contentPane = new JLabel();
    	contentPane.setIcon(background);
    	contentPane.setLayout( new BorderLayout() );
    	frame.setContentPane(contentPane);
		
    	//Create the place where buttons and stuff go
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Get amount of player money and set it to label
		player.setText("Player: " + p.getMoney());
		
		//Set the font of stuff
		bet.setFont(new Font("Serif", Font.PLAIN, 30));
		player.setFont(new Font("Serif", Font.BOLD, 20));
		dealer.setFont(new Font("Serif", Font.BOLD, 20));
		cpu1.setFont(new Font("Serif", Font.BOLD, 20));
		cpu2.setFont(new Font("Serif", Font.BOLD, 20));
		playerValue.setFont(new Font("Serif", Font.BOLD, 30));
		cpu1Value.setFont(new Font("Serif", Font.BOLD, 30));
		cpu2Value.setFont(new Font("Serif", Font.BOLD, 30));
		dealerValue.setFont(new Font("Serif", Font.BOLD, 30));
		input.setFont(new Font("Serif", Font.PLAIN, 30));
		timer.setFont(new Font("Serif", Font.PLAIN, 20));
		message.setFont(new Font("Serif", Font.BOLD, 35));
		winLoss.setFont(new Font("Serif", Font.BOLD, 20));
		up.setFont(new Font("Serif", Font.BOLD, 20));
		down.setFont(new Font("Serif", Font.BOLD, 25));
		
		//Make sure text is aligned in the center
		input.setHorizontalAlignment(JTextField.CENTER);
		bet.setHorizontalAlignment(JTextField.CENTER);
		message.setHorizontalAlignment(JTextField.CENTER);
		input.setText("$5");
		
		//Set the text color
		dealer.setForeground(Color.gray);
		endGame.setBackground(Color.gray);
		rules.setBackground(Color.gray);
		cpu1Value.setForeground(Color.white);
		cpu2Value.setForeground(Color.white);
		dealerValue.setForeground(Color.white);
		
		//Set where everything will be placed on the gui (It goes X, Y, Size X, Size Y)
		playerValue.setBounds(660, 575, 100, 50);
		cpu1Value.setBounds(1200, 550, 100, 100);
		cpu2Value.setBounds(130, 550, 100, 100);
		dealerValue.setBounds(660, 200, 100, 100);
		timer.setBounds(700, 300, 100, 100);
		back.setBounds(100, 100, 200, 300);
		rules.setBounds(1200, 0, 200, 100);
		endGame.setBounds(0, 0, 200, 100);
		bet.setBounds(500, 350, 400, 100);
		input.setBounds(650, 425, 125, 50);
		up.setBounds(775, 425, 100, 25);
		down.setBounds(775, 450, 100, 25);
		enter.setBounds(550, 425, 100, 50);
		cpu1.setBounds(1200, 800, 200, 100);
		cpu2.setBounds(100, 800, 200, 100);
		player.setBounds(640, 800, 200, 100);
		dealer.setBounds(650, 0, 100, 25);
		hit.setBounds(475, 425, 200, 100);
		stay.setBounds(725, 425, 200, 100);
		winLoss.setBounds(785, 800, 100, 100);
		
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
		cpu1Card1.setBounds(1170, 650, 125, 175);
		cpu1Card2.setBounds(1140, 650, 125, 175);
		cpu1Card3.setBounds(1110, 650, 125, 175);
		cpu1Card4.setBounds(1080, 650, 125, 175);
		cpu1Card5.setBounds(1050, 650, 125, 175);
		cpu1Card6.setBounds(1020, 650, 125, 175);
		cpu1Card7.setBounds(990, 650, 125, 175);
		cpu1Card8.setBounds(960, 650, 125, 175);
		cpu1Card9.setBounds(930, 650, 125, 175);
		cpu1Card10.setBounds(900, 650, 125, 175);
		cpu2Card1.setBounds(100, 650, 125, 175);
		cpu2Card2.setBounds(70, 650, 125, 175);
		cpu2Card3.setBounds(130, 650, 125, 175);
		cpu2Card4.setBounds(160, 650, 125, 175);
		cpu2Card5.setBounds(190, 650, 125, 175);
		cpu2Card6.setBounds(220, 650, 125, 175);
		cpu2Card7.setBounds(250, 650, 125, 175);
		cpu2Card8.setBounds(280, 650, 125, 175);
		cpu2Card9.setBounds(310, 650, 125, 175);
		cpu2Card10.setBounds(340, 650, 125, 175);
		dealerCard1.setBounds(630, 35, 125, 175);
		dealerCard2.setBounds(600, 35, 125, 175);
		dealerCard3.setBounds(570, 35, 125, 175);
		dealerCard4.setBounds(540, 35, 125, 175);
		dealerCard5.setBounds(510, 35, 125, 175);
		dealerCard6.setBounds(480, 35, 125, 175);
		dealerCard7.setBounds(450, 35, 125, 175);
		dealerCard8.setBounds(420, 35, 125, 175);
		dealerCard9.setBounds(390, 35, 125, 175);
		dealerCard10.setBounds(360, 35, 125, 175);
		message.setBounds(400, 265, 600, 100);
		
		//Add everything to the panel to make things visible
		panel.add(message);
		panel.add(back);
		panel.add(rules);
		panel.add(endGame);
		panel.add(winLoss);
		panel.add(bet);
		panel.add(input);
		panel.add(up);
		panel.add(down);
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
		panel.add(cpu1Card1);
		panel.add(cpu1Card2);
		panel.add(cpu1Card3);
		panel.add(cpu1Card4);
		panel.add(cpu1Card5);
		panel.add(cpu1Card6);
		panel.add(cpu1Card7);
		panel.add(cpu1Card8);
		panel.add(cpu1Card9);
		panel.add(cpu1Card10);
		panel.add(cpu2Card1);
		panel.add(cpu2Card2);
		panel.add(cpu2Card3);
		panel.add(cpu2Card4);
		panel.add(cpu2Card5);
		panel.add(cpu2Card6);
		panel.add(cpu2Card7);
		panel.add(cpu2Card8);
		panel.add(cpu2Card9);
		panel.add(cpu2Card10);
		panel.add(dealerCard1);
		panel.add(dealerCard2);
		panel.add(dealerCard3);
		panel.add(dealerCard4);
		panel.add(dealerCard5);
		panel.add(dealerCard6);
		panel.add(dealerCard7);
		panel.add(dealerCard8);
		panel.add(dealerCard9);
		panel.add(dealerCard10);
		panel.add(playerValue);
		panel.add(cpu1Value);
		panel.add(cpu2Value);
		panel.add(dealerValue);
		
		//Make sure the cards cant be interacted with
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
		cpu1Card1.setEnabled(false);
		cpu1Card2.setEnabled(false);
		cpu1Card3.setEnabled(false);
		cpu1Card4.setEnabled(false);
		cpu1Card5.setEnabled(false);
		cpu1Card6.setEnabled(false);
		cpu1Card7.setEnabled(false);
		cpu1Card8.setEnabled(false);
		cpu1Card9.setEnabled(false);
		cpu1Card10.setEnabled(false);
		cpu2Card1.setEnabled(false);
		cpu2Card2.setEnabled(false);
		cpu2Card3.setEnabled(false);
		cpu2Card4.setEnabled(false);
		cpu2Card5.setEnabled(false);
		cpu2Card6.setEnabled(false);
		cpu2Card7.setEnabled(false);
		cpu2Card8.setEnabled(false);
		cpu2Card9.setEnabled(false);
		cpu2Card10.setEnabled(false);
		dealerCard1.setEnabled(false);
		dealerCard2.setEnabled(false);
		dealerCard3.setEnabled(false);
		dealerCard4.setEnabled(false);
		dealerCard5.setEnabled(false);
		dealerCard6.setEnabled(false);
		dealerCard7.setEnabled(false);
		dealerCard8.setEnabled(false);
		dealerCard9.setEnabled(false);
		dealerCard10.setEnabled(false);
		
		//Set extra cards to be invisible at the start
		playerCard3.setVisible(false);
		playerCard4.setVisible(false);
		playerCard5.setVisible(false);
		playerCard6.setVisible(false);
		playerCard7.setVisible(false);
		playerCard8.setVisible(false);
		playerCard9.setVisible(false);
		playerCard10.setVisible(false);
		cpu1Card3.setVisible(false);
		cpu1Card4.setVisible(false);
		cpu1Card5.setVisible(false);
		cpu1Card6.setVisible(false);
		cpu1Card7.setVisible(false);
		cpu1Card8.setVisible(false);
		cpu1Card9.setVisible(false);
		cpu1Card10.setVisible(false);
		cpu2Card3.setVisible(false);
		cpu2Card4.setVisible(false);
		cpu2Card5.setVisible(false);
		cpu2Card6.setVisible(false);
		cpu2Card7.setVisible(false);
		cpu2Card8.setVisible(false);
		cpu2Card9.setVisible(false);
		cpu2Card10.setVisible(false);
		dealerCard3.setVisible(false);
		dealerCard4.setVisible(false);
		dealerCard5.setVisible(false);
		dealerCard6.setVisible(false);
		dealerCard7.setVisible(false);
		dealerCard8.setVisible(false);
		dealerCard9.setVisible(false);
		dealerCard10.setVisible(false);
		message.setVisible(false);
		winLoss.setVisible(false);
		
		hit.setVisible(false);
		stay.setVisible(false);
		playerValue.setVisible(true);
		input.setEditable(false);

		//Starts the game
		startCode();
		
		//Set the background to work and have everything placed onto the gui
		panel.setOpaque(false);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		//Call button actions
		Listeners();
	}
	
	public void Listeners() {
		//Create button actions
		endGame.addActionListener(new goBack());
		enter.addActionListener(new setBet());
		hit.addActionListener(new addCard());
		up.addActionListener(new raiseBet());
		down.addActionListener(new lowerBet());
		stay.addActionListener(new endTurn());
		rules.addActionListener(new showRules());
	}
	
	public static void removeLineFromFile(String file) {
		//This function deltes the first line of a file by copying the contents of the original file except for the first line
		// and then pasting it to a new file. The old file is delted and the new one is renamed the same as the old one.
		int c = 0;
	    try {

	      File inFile = new File(file);

	      if (!inFile.isFile()) {
	        System.out.println("Parameter is not an existing file");
	      }

	      //Construct the new file that will later be renamed to the original filename.
	      File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

	      BufferedReader br = new BufferedReader(new FileReader(file));
	      PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

	      String line = null;

	      //Read from the original file and write to the new
	      //unless content matches data to be removed.
	      while ((line = br.readLine()) != null) {

	        if (c != 0) {
	        	pw.println(line);
	            pw.flush();
	            c++;
	          }
	        c++;
	        }
	        pw.close();
	        br.close();

	        //Delete the original file
	        if (!inFile.delete()) {
	          System.out.println("Could not delete file");
	          return;
	        }

	        //Rename the new file to the filename the original file had.
	        if (!tempFile.renameTo(inFile))
	          System.out.println("Could not rename file");

	      }
	      catch (FileNotFoundException ex) {
	        ex.printStackTrace();
	      }
	      catch (IOException ex) {
	        ex.printStackTrace();
	      }
	}
	
	public void startCode() {
		//Creates a thread so the game is continuous
		Thread t = new Thread() {
			//Start the thread
			public void run() {
				
				//While the user does not exit the game
				while (!done) {
						//At the start of the hand set the cards so that they are face down until a bet is placed
						while (start) {
							playerCard1.setIcon(faceDownCard);
							playerCard1.setDisabledIcon(faceDownCard);
							playerCard2.setIcon(faceDownCard);
							playerCard2.setDisabledIcon(faceDownCard);
							cpu1Card1.setIcon(faceDownCard);
							cpu1Card1.setDisabledIcon(faceDownCard);
							cpu1Card2.setIcon(faceDownCard);
							cpu1Card2.setDisabledIcon(faceDownCard);
							cpu2Card1.setIcon(faceDownCard);
							cpu2Card1.setDisabledIcon(faceDownCard);
							cpu2Card2.setIcon(faceDownCard);
							cpu2Card2.setDisabledIcon(faceDownCard);
							dealerCard1.setIcon(faceDownCard);
							dealerCard1.setDisabledIcon(faceDownCard);
							dealerCard2.setIcon(faceDownCard);
							dealerCard2.setDisabledIcon(faceDownCard);
							
							playerCard1.setBounds(630, 650, 125, 175);
							playerCard2.setBounds(600, 650, 125, 175);
							cpu1Card1.setBounds(1170, 650, 125, 175);
							cpu1Card2.setBounds(1140, 650, 125, 175);
							cpu2Card1.setBounds(100, 650, 125, 175);
							cpu2Card2.setBounds(70, 650, 125, 175);
							dealerCard1.setBounds(630, 35, 125, 175);
							dealerCard2.setBounds(600, 35, 125, 175);
							
							//Once the bet is made, flip dealers card and the players cards
							if (didBet) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard2.setIcon(cardIcon);
								dealerCard2.setDisabledIcon(cardIcon);
								
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
	
								cardNum = config.getCard("player");
								cardIcon = config.getCardImage(cardNum);
								playerCard1.setIcon(cardIcon);
								playerCard1.setDisabledIcon(cardIcon);
								
								cardNum = config.getCard("player");
								cardIcon = config.getCardImage(cardNum);
								playerCard2.setIcon(cardIcon);
								playerCard2.setDisabledIcon(cardIcon);
								
								playerValue.setText("" + config.getValue("player"));
								start = false;
							}
							
							
						}
						
						//Start the cpu's turn. The cpu will flip cards until they have a card value greater than 16
						while (cpu1Num < 17) {
							
							if (cpu1Init == false) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card1.setIcon(cardIcon);
								cpu1Card1.setDisabledIcon(cardIcon);
								
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card2.setIcon(cardIcon);
								cpu1Card2.setDisabledIcon(cardIcon);
								
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cpu1Init = true;
							}
							
							
							if (cpu1Num > 16) {
								break;
							}
							
							if (!cpu1Card3.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card3.setIcon(cardIcon);
								cpu1Card3.setDisabledIcon(cardIcon);
								
								cpu1Card1.setBounds(1200, 650, 125, 175);
								cpu1Card2.setBounds(1170, 650, 125, 175);
								cpu1Card3.setBounds(1140, 650, 125, 175);
								
								cpu1Card3.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card4.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card4.setIcon(cardIcon);
								cpu1Card4.setDisabledIcon(cardIcon);
								
								cpu1Card4.setBounds(1110, 650, 125, 175);
								
								cpu1Card4.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card5.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card5.setIcon(cardIcon);
								cpu1Card5.setDisabledIcon(cardIcon);
								
								cpu1Card1.setBounds(1230, 650, 125, 175);
								cpu1Card2.setBounds(1200, 650, 125, 175);
								cpu1Card3.setBounds(1170, 650, 125, 175);
								cpu1Card4.setBounds(1140, 650, 125, 175);
								cpu1Card5.setBounds(1110, 650, 125, 175);
								
								cpu1Card5.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card6.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card6.setIcon(cardIcon);
								cpu1Card6.setDisabledIcon(cardIcon);
								
								cpu1Card6.setBounds(1080, 650, 125, 175);
								
								cpu1Card6.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card7.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card7.setIcon(cardIcon);
								cpu1Card7.setDisabledIcon(cardIcon);
								
								cpu1Card1.setBounds(1260, 650, 125, 175);
								cpu1Card2.setBounds(1230, 650, 125, 175);
								cpu1Card3.setBounds(1200, 650, 125, 175);
								cpu1Card4.setBounds(1170, 650, 125, 175);
								cpu1Card5.setBounds(1140, 650, 125, 175);
								cpu1Card6.setBounds(1110, 650, 125, 175);
								cpu1Card7.setBounds(1080, 650, 125, 175);
								
								cpu1Card7.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card8.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card8.setIcon(cardIcon);
								cpu1Card8.setDisabledIcon(cardIcon);
								
								cpu1Card8.setBounds(1050, 650, 125, 175);
								
								cpu1Card8.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card9.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card9.setIcon(cardIcon);
								cpu1Card9.setDisabledIcon(cardIcon);
								
								cpu1Card9.setBounds(1020, 650, 125, 175);
								
								cpu1Card9.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu1Card10.isVisible()) {
								cardNum = config.getCard("cpu1");
								cardIcon = config.getCardImage(cardNum);
								cpu1Card10.setIcon(cardIcon);
								cpu1Card10.setDisabledIcon(cardIcon);
								
								cpu1Card10.setBounds(990, 650, 125, 175);
								
								cpu1Card10.setVisible(true);
								cpu1Num = config.getValue("cpu1");
								cpu1Value.setText("" + cpu1Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						
						//Get players actions
						//============================================
						if (!playerDone) {
							bet.setVisible(true);
							hit.setVisible(true);
							stay.setVisible(true);
						}
						
						while (!playerDone) {
							int v = config.getValue("player");
							if (v > 21) {
								playerDone = true;
								hit.setVisible(false);
								stay.setVisible(false);
								bet.setVisible(false);
								bet.setVisible(false);
							}
						}
						
	
						//============================================
						//Start the cpu's turn. The cpu will flip cards until they have a card value greater than 16
						while (cpu2Num < 17 && playerDone) {
							
							if (cpu2Init == false) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card1.setIcon(cardIcon);
								cpu2Card1.setDisabledIcon(cardIcon);
								
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card2.setIcon(cardIcon);
								cpu2Card2.setDisabledIcon(cardIcon);
								
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								cpu2Init = true;
							}
							
							
							if (cpu2Num > 16) {
								break;
							}
							
							if (!cpu2Card3.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card3.setIcon(cardIcon);
								cpu2Card3.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(100, 650, 125, 175);
								cpu2Card2.setBounds(70, 650, 125, 175);
								cpu2Card3.setBounds(40, 650, 125, 175);
								
								cpu2Card3.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card4.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card4.setIcon(cardIcon);
								cpu2Card4.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(130, 650, 125, 175);
								cpu2Card2.setBounds(100, 650, 125, 175);
								cpu2Card3.setBounds(70, 650, 125, 175);
								cpu2Card4.setBounds(40, 650, 125, 175);
								
								cpu2Card4.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card5.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card5.setIcon(cardIcon);
								cpu2Card5.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(160, 650, 125, 175);
								cpu2Card2.setBounds(130, 650, 125, 175);
								cpu2Card3.setBounds(100, 650, 125, 175);
								cpu2Card4.setBounds(70, 650, 125, 175);
								cpu2Card5.setBounds(40, 650, 125, 175);
								
								cpu2Card5.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card6.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card6.setIcon(cardIcon);
								cpu2Card6.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(190, 650, 125, 175);
								cpu2Card2.setBounds(160, 650, 125, 175);
								cpu2Card3.setBounds(130, 650, 125, 175);
								cpu2Card4.setBounds(100, 650, 125, 175);
								cpu2Card5.setBounds(70, 650, 125, 175);
								cpu2Card6.setBounds(40, 650, 125, 175);
								
								cpu2Card6.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card7.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card7.setIcon(cardIcon);
								cpu2Card7.setDisabledIcon(cardIcon);
								
								
								cpu2Card1.setBounds(220, 650, 125, 175);
								cpu2Card2.setBounds(190, 650, 125, 175);
								cpu2Card3.setBounds(160, 650, 125, 175);
								cpu2Card4.setBounds(130, 650, 125, 175);
								cpu2Card5.setBounds(100, 650, 125, 175);
								cpu2Card6.setBounds(70, 650, 125, 175);
								cpu2Card7.setBounds(40, 650, 125, 175);
								
								cpu2Card7.setVisible(true);
								
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card8.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card8.setIcon(cardIcon);
								cpu2Card8.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(250, 650, 125, 175);
								cpu2Card2.setBounds(220, 650, 125, 175);
								cpu2Card3.setBounds(190, 650, 125, 175);
								cpu2Card4.setBounds(160, 650, 125, 175);
								cpu2Card5.setBounds(130, 650, 125, 175);
								cpu2Card6.setBounds(100, 650, 125, 175);
								cpu2Card7.setBounds(70, 650, 125, 175);
								cpu2Card8.setBounds(40, 650, 125, 175);
								
								cpu2Card8.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card9.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card9.setIcon(cardIcon);
								cpu2Card9.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(280, 650, 125, 175);
								cpu2Card2.setBounds(250, 650, 125, 175);
								cpu2Card3.setBounds(220, 650, 125, 175);
								cpu2Card4.setBounds(190, 650, 125, 175);
								cpu2Card5.setBounds(160, 650, 125, 175);
								cpu2Card6.setBounds(130, 650, 125, 175);
								cpu2Card7.setBounds(100, 650, 125, 175);
								cpu2Card8.setBounds(70, 650, 125, 175);
								cpu2Card9.setBounds(40, 650, 125, 175);
								
								cpu2Card9.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!cpu2Card10.isVisible()) {
								cardNum = config.getCard("cpu2");
								cardIcon = config.getCardImage(cardNum);
								cpu2Card10.setIcon(cardIcon);
								cpu2Card10.setDisabledIcon(cardIcon);
								
								cpu2Card1.setBounds(310, 650, 125, 175);
								cpu2Card2.setBounds(280, 650, 125, 175);
								cpu2Card3.setBounds(250, 650, 125, 175);
								cpu2Card4.setBounds(220, 650, 125, 175);
								cpu2Card5.setBounds(190, 650, 125, 175);
								cpu2Card6.setBounds(160, 650, 125, 175);
								cpu2Card7.setBounds(130, 650, 125, 175);
								cpu2Card8.setBounds(100, 650, 125, 175);
								cpu2Card9.setBounds(70, 650, 125, 175);
								cpu2Card10.setBounds(40, 650, 125, 175);
								
								cpu2Card10.setVisible(true);
								cpu2Num = config.getValue("cpu2");
								cpu2Value.setText("" + cpu2Num);
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						//Start the dealers turn. The dealer will flip cards until they have a card value greater than 16
						while (dealerNum < 17 && playerDone) {
							if (dealerInit == false) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard1.setIcon(cardIcon);
								dealerCard1.setDisabledIcon(cardIcon);
								
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								dealerInit = true;
							}
							
							if (dealerNum > 16) {
								break;
							}
							
							if (!dealerCard3.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard3.setIcon(cardIcon);
								dealerCard3.setDisabledIcon(cardIcon);
								
								dealerCard1.setBounds(660, 35, 125, 175);
								dealerCard2.setBounds(630, 35, 125, 175);
								dealerCard3.setBounds(600, 35, 125, 175);
								
								dealerCard3.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard4.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard4.setIcon(cardIcon);
								dealerCard4.setDisabledIcon(cardIcon);
								
								dealerCard4.setBounds(570, 35, 125, 175);
								dealerCard4.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard5.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard5.setIcon(cardIcon);
								dealerCard5.setDisabledIcon(cardIcon);
								
								dealerCard1.setBounds(690, 35, 125, 175);
								dealerCard2.setBounds(660, 35, 125, 175);
								dealerCard3.setBounds(630, 35, 125, 175);
								dealerCard4.setBounds(600, 35, 125, 175);
								dealerCard5.setBounds(570, 35, 125, 175);
								
								dealerCard5.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard6.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard6.setIcon(cardIcon);
								dealerCard6.setDisabledIcon(cardIcon);
								
								dealerCard6.setBounds(540, 35, 125, 175);
								dealerCard6.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard7.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard7.setIcon(cardIcon);
								dealerCard7.setDisabledIcon(cardIcon);
								
								dealerCard1.setBounds(720, 35, 125, 175);
								dealerCard2.setBounds(690, 35, 125, 175);
								dealerCard3.setBounds(660, 35, 125, 175);
								dealerCard4.setBounds(630, 35, 125, 175);
								dealerCard5.setBounds(600, 35, 125, 175);
								dealerCard6.setBounds(570, 35, 125, 175);
								dealerCard7.setBounds(540, 35, 125, 175);
								
								dealerCard7.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard8.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard8.setIcon(cardIcon);
								dealerCard8.setDisabledIcon(cardIcon);
								
								dealerCard8.setBounds(510, 35, 125, 175);
								dealerCard8.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard9.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard9.setIcon(cardIcon);
								dealerCard9.setDisabledIcon(cardIcon);
								
								dealerCard1.setBounds(750, 35, 125, 175);
								dealerCard2.setBounds(720, 35, 125, 175);
								dealerCard3.setBounds(690, 35, 125, 175);
								dealerCard4.setBounds(660, 35, 125, 175);
								dealerCard5.setBounds(630, 35, 125, 175);
								dealerCard6.setBounds(600, 35, 125, 175);
								dealerCard7.setBounds(570, 35, 125, 175);
								dealerCard8.setBounds(540, 35, 125, 175);
								dealerCard9.setBounds(510, 35, 125, 175);
								
								dealerCard9.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							else if (!dealerCard10.isVisible()) {
								cardNum = config.getCard("dealer");
								cardIcon = config.getCardImage(cardNum);
								dealerCard10.setIcon(cardIcon);
								dealerCard10.setDisabledIcon(cardIcon);
								System.out.println("testing");
								
								dealerCard1.setBounds(750, 35, 125, 175);
								dealerCard2.setBounds(720, 35, 125, 175);
								dealerCard3.setBounds(690, 35, 125, 175);
								dealerCard4.setBounds(660, 35, 125, 175);
								dealerCard5.setBounds(630, 35, 125, 175);
								dealerCard6.setBounds(600, 35, 125, 175);
								dealerCard7.setBounds(570, 35, 125, 175);
								dealerCard8.setBounds(540, 35, 125, 175);
								dealerCard9.setBounds(510, 35, 125, 175);
								dealerCard10.setBounds(480, 35, 125, 175);
								
								dealerCard10.setVisible(true);
								dealerNum = config.getValue("dealer");
								dealerValue.setText("" + dealerNum);
								
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						}
						
						
						//-----------
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
						
						//This checks to see the result of the hand
						//It will display a message to the user, write the result to a file and dish out the appropriate amount of money to the player
						while (dealerNum >= 17 && playerDone && !reset) {
							val1 = config.getValue("player");

							try {
								pw = new PrintWriter(new FileOutputStream(file, true));
								
							//BLACKJACK
							if (config.checkBlackjack() && dealerNum != 21) {
								plyr.changeMoney(betting.getBet() * 3);
								player.setText("Player: " + plyr.getMoney());
								winLoss.setText("+ " + betting.getBet() * 3);
								winLoss.setForeground(Color.GREEN);
								pw.append("Gained " + betting.getBet() * 3 + " playing BlackJack\n");
								message.setText("BLACKJACK!");
							}
							//BLACKJACK BUT TIE DEALER
							else if (config.checkBlackjack() && dealerNum == 21) {
								plyr.changeMoney(betting.getBet());
								player.setText("Player: " + plyr.getMoney());
								winLoss.setText("+ " + betting.getBet());
								winLoss.setForeground(Color.BLACK);
								pw.append("Gained 0 playing BlackJack\n");
								message.setText("You tied the dealer with Blackjack");
							}
							//PLAYER BUSTS
							else if (val1 > 21) {
								//SET TEXT
								message.setText("You bust");
								winLoss.setText("- " + betting.getBet());
								pw.write("Lost " + betting.getBet() + " playing BlackJack\n");
								winLoss.setForeground(Color.RED);
							}
							//DEALER BUSTS
							else if (val1 <= 21 && dealerNum > 21) {
								plyr.changeMoney(betting.getBet() * 2);
								player.setText("Player: " + plyr.getMoney());
								winLoss.setText("+ " + betting.getBet() * 2);
								pw.append("Gained " + betting.getBet() * 2 + " playing BlackJack\n");
								winLoss.setForeground(Color.GREEN);
								message.setText("Dealer busts, you win");
							}
							//PLAYER TIES DEALER
							else if (val1 <= 21 && dealerNum <= 21 && val1 == dealerNum) {
								plyr.changeMoney(betting.getBet());
								player.setText("Player: " + plyr.getMoney());
								winLoss.setText("+ " + betting.getBet());
								pw.append("Gained 0 playing BlackJack\n");
								winLoss.setForeground(Color.BLACK);
								message.setText("You tie");
							}
							//PLAYER LOSES TO DEALER
							else if (val1 <= 21 && dealerNum <= 21 && val1 < dealerNum) {
								//SET TEXT
								message.setText("You lose to the dealer");
								winLoss.setText("- " + betting.getBet());
								pw.append("Lost " + betting.getBet() + " playing BlackJack\n");
								winLoss.setForeground(Color.RED);
							}
							//PLAYER BEATS DEALER
							else if (val1 <= 21 && dealerNum <= 21 && val1 > dealerNum) {
								plyr.changeMoney(betting.getBet() * 2);
								player.setText("Player: " + plyr.getMoney());
								winLoss.setText("+ " + betting.getBet() * 2);
								pw.append("Gained " + betting.getBet() * 2 + " playing BlackJack\n");
								winLoss.setForeground(Color.GREEN);
								message.setText("You beat the Dealer");
							}
							numRecords++;
							winLoss.setVisible(true);
							message.setVisible(true);
							
							if (numRecords > 10) {
								removeLineFromFile("user_records.txt");
							}
							pw.close();
							reset = true;
							
							}
							catch (Exception e1) {
								System.out.println("FILE IO ERROR IN BLACKJACK");
							}
						}
						
						//If the user has no money end the game
						if (plyr.getMoney() == 0) {
							done = true;
							menuFrame.setVisible(true);
							frame.dispose();
						}
						
						//After a hand is done, this will reset everything in the gui and start again
						while (reset)  {
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							config.clearHand();
							winLoss.setVisible(false);
							message.setVisible(false);
							start = true;
							didBet = false;
							playerDone = false;
							playerCard3.setVisible(false);
							playerCard4.setVisible(false);
							playerCard5.setVisible(false);
							playerCard6.setVisible(false);
							playerCard7.setVisible(false);
							playerCard8.setVisible(false);
							playerCard9.setVisible(false);
							playerCard10.setVisible(false);
							cpu1Card3.setVisible(false);
							cpu1Card4.setVisible(false);
							cpu1Card5.setVisible(false);
							cpu1Card6.setVisible(false);
							cpu1Card7.setVisible(false);
							cpu1Card8.setVisible(false);
							cpu1Card9.setVisible(false);
							cpu1Card10.setVisible(false);
							cpu2Card3.setVisible(false);
							cpu2Card4.setVisible(false);
							cpu2Card5.setVisible(false);
							cpu2Card6.setVisible(false);
							cpu2Card7.setVisible(false);
							cpu2Card8.setVisible(false);
							cpu2Card9.setVisible(false);
							cpu2Card10.setVisible(false);
							dealerCard3.setVisible(false);
							dealerCard4.setVisible(false);
							dealerCard5.setVisible(false);
							dealerCard6.setVisible(false);
							dealerCard7.setVisible(false);
							dealerCard8.setVisible(false);
							dealerCard9.setVisible(false);
							dealerCard10.setVisible(false);
							
							dealerNum = config.getValue("dealer");
							dealerValue.setText("" + dealerNum);
							cpu1Num = config.getValue("cpu1");
							cpu1Value.setText("" + cpu1Num);
							cpu2Num = config.getValue("cpu2");
							cpu2Value.setText("" + cpu2Num);
							playerValue.setText("" + config.getValue("player"));
							message.setVisible(false);
							
							config.checkNewDeck();
							
							enter.setVisible(true);
							input.setVisible(true);
							bet.setVisible(true);
							bet.setText("Enter your bet");
							up.setVisible(true);
							down.setVisible(true);
							cpu1Init = false;
							cpu2Init = false;
							dealerInit = false;
							
							
							
							reset = false;
						}
						
				}
				
			}
		};
		t.start();
	}
	
private class endTurn implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		//Ends the players turn
		playerDone = true;
		hit.setVisible(false);
		stay.setVisible(false);
		bet.setVisible(false);
		
	}

}

private class showRules implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		//Ends the players turn
		JOptionPane.showMessageDialog(frame,
				"WELCOME TO BLACKJACK\n"
				+ "You must first bet without seeing your cards\nAfter that, your cards will flip and so will one of the dealers.\n"
				+ "Your goal is to try and get as close to 21 without going over\nEach face card excluding aces have a value of 10\n"
				+ "Aces have a value of 1 or 11 based off the value of your hand\nEvery numerical card has the value of its number\n"
				+ "Once it is your turn you have the option to 'hit' (take another card) or 'stay' (End your turn)\n"
				+ "After that is done, the cpu and dealer will do the same until the dealer has a hand greater or equal to 17\n"
				+ "To win, you must have a greater value than the dealer but not exceed 21 or have a lower value than the dealer"
				+ "when the dealer has a value over 21\nIf you have a jack and an ace as your only two cards you have blackjack!\n\n"
				+ "Here are the following payouts:\n"
				+ "BlackJack pays 3:1\n"
				+ "Beating the dealer pays 2:1\n"
				+ "Losing costs the bet amount");
		
	}

}

private class setBet implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Set the users bet and continue the thread
			playerCard1.setVisible(true);
			playerCard2.setVisible(true);
			enter.setVisible(false);
			input.setVisible(false);
			bet.setVisible(false);
			bet.setText("Hit or Stay");
			playerValue.setVisible(true);
			up.setVisible(false);
			down.setVisible(false);
			
			plyr.changeMoney(-betting.getBet());
			player.setText("Player: " + plyr.getMoney());
			didBet = true;
			
		}
	}

	private class addCard implements ActionListener {
		//Adds players cards if the user selects hit
		@Override
		public void actionPerformed(ActionEvent e) {
			if (!playerCard3.isVisible()) {
				cardNum = config.getCard("player");
				cardIcon = config.getCardImage(cardNum);
				playerCard3.setIcon(cardIcon);
				playerCard3.setDisabledIcon(cardIcon);
				
				playerCard1.setBounds(660, 650, 125, 175);
				playerCard2.setBounds(630, 650, 125, 175);
				playerCard3.setBounds(600, 650, 125, 175);
				
				playerCard3.setVisible(true);
			}
			else if (!playerCard4.isVisible()) {
				cardNum = config.getCard("player");
				cardIcon = config.getCardImage(cardNum);
				playerCard4.setIcon(cardIcon);
				playerCard4.setDisabledIcon(cardIcon);
				
				playerCard4.setBounds(570, 650, 125, 175);
				playerCard4.setVisible(true);
			}
			else if (!playerCard5.isVisible()) {
				cardNum = config.getCard("player");
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
				cardNum = config.getCard("player");
				cardIcon = config.getCardImage(cardNum);
				playerCard6.setIcon(cardIcon);
				playerCard6.setDisabledIcon(cardIcon);
				
				playerCard6.setBounds(540, 650, 125, 175);
				playerCard6.setVisible(true);
			}
			else if (!playerCard7.isVisible()) {
				cardNum = config.getCard("player");
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
				cardNum = config.getCard("player");
				cardIcon = config.getCardImage(cardNum);
				playerCard8.setIcon(cardIcon);
				playerCard8.setDisabledIcon(cardIcon);
				
				playerCard8.setBounds(510, 650, 125, 175);
				playerCard8.setVisible(true);
			}
			else if (!playerCard9.isVisible()) {
				cardNum = config.getCard("player");
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
				cardNum = config.getCard("player");
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
			//Ends the game and returns to the main menu
			done = true;
			menuFrame.setVisible(true);
			plyr.updateFileNum(numRecords);
			frame.dispose();
		}
	}
	
	private class raiseBet implements ActionListener {
		
		//Raises the users bet
		@Override
		public void actionPerformed(ActionEvent e) {
			if (plyr.getMoney() >= betting.getNextBet()) {
				betting.raiseBet();
				input.setText("$" + betting.getBet());
			}
		}
	}
	
	private class lowerBet implements ActionListener {
		//Lowers the users bet
		@Override
		public void actionPerformed(ActionEvent e) {
			betting.lowerBet();
			input.setText("$" + betting.getBet());
		}
	}


	
	
//LAST LINE
}
