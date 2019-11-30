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
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class RouletteMain {

	public static void main(String[] args) {
		RouletteMain r = new RouletteMain();
		Player p = new Player("Christine", 10);
		JFrame n = new JFrame();
		r.Startup(p, n, 10);
	}
	
	File file = new File("user_records.txt");
	
	JLabel info = new JLabel("Enter a bet");
	JLabel playerMoney = new JLabel("");
	
	JButton enterBet = new JButton("Enter");
	JButton betDown = new JButton("-");
	JButton betUp = new JButton("+");
	JButton red = new JButton("Red");
	JButton black = new JButton("Black");
	JButton enterNum = new JButton("Enter");
	JButton even = new JButton("Even");
	JButton odd = new JButton("Odd");
	JButton left2 = new JButton("");
	JButton left1 = new JButton("");
	JButton middle = new JButton("");
	JButton right1 = new JButton("");
	JButton right2 = new JButton("");
	JButton endGame = new JButton("End Game");
	JButton rules = new JButton("Rules");
	
	JTextField betText = new JTextField("$5");
	JTextField numText = new JTextField("1");
	Bet betting = new Bet();
	
	JFrame frame = new JFrame("Roulette");
	JFrame menuFrame;
	Player plyr;
	
	int num1 = 0;
	int num2 = 0;
	int actualNum = 0;
	int num3 = 0;
	int num4 = 0;
	int numRecords = 0;
	int counter = 0;
	boolean done = false;
	String bet = "";
	Random rand = new Random();
	Color gold = new Color(200,150,15);

	public void Startup(Player p, JFrame mainFrame, int num) {
		
		//Create the GUI
		numRecords = num;
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuFrame = mainFrame;
		plyr = p;
		
		ImageIcon icon = new ImageIcon("Roulette_Images/roulette-wheel.jpg");
    	Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
    	ImageIcon background = new ImageIcon(iconTemp);
    	JLabel contentPane = new JLabel();
    	contentPane.setIcon(background);
    	contentPane.setLayout(new BorderLayout());
    	frame.setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		playerMoney.setText(plyr.getID() + ": $" + plyr.getMoney());
		
		info.setFont(new Font("Serif", Font.PLAIN, 40));
		playerMoney.setFont(new Font("Serif", Font.PLAIN, 40));
		middle.setFont(new Font("Serif", Font.BOLD, 30));
		enterBet.setFont(new Font("Serif", Font.PLAIN, 25));
		endGame.setFont(new Font("Serif", Font.PLAIN, 25));
		betUp.setFont(new Font("Serif", Font.BOLD, 25));
		betDown.setFont(new Font("Serif", Font.BOLD, 25));
		rules.setFont(new Font("Serif", Font.PLAIN, 25));
		enterNum.setFont(new Font("Serif", Font.PLAIN, 25));
		red.setFont(new Font("Serif", Font.PLAIN, 25));
		black.setFont(new Font("Serif", Font.PLAIN, 25));
		even.setFont(new Font("Serif", Font.PLAIN, 25));
		odd.setFont(new Font("Serif", Font.PLAIN, 25));
		betText.setFont(new Font("Serif", Font.PLAIN, 50));
		numText.setFont(new Font("Serif", Font.PLAIN, 50));
		
		
		info.setHorizontalAlignment(JTextField.CENTER);
		playerMoney.setHorizontalAlignment(JTextField.CENTER);
		betText.setHorizontalAlignment(JTextField.CENTER);
		numText.setHorizontalAlignment(JTextField.CENTER);
		
		middle.setBackground(Color.BLACK);
		middle.setText("" + 1);
		info.setForeground(Color.white);
		playerMoney.setForeground(Color.white);
		red.setBackground(Color.red);
		black.setBackground(Color.black);
		black.setForeground(Color.GRAY);
		enterNum.setBackground(gold);
		even.setBackground(gold);
		odd.setBackground(gold);
		endGame.setBackground(gold);
		rules.setBackground(gold);
		enterBet.setBackground(gold);
		betUp.setBackground(gold);
		betDown.setBackground(gold);
		betText.setBackground(gold);
		numText.setBackground(gold);
		
		enterBet.setBounds(200, 0, 200, 150);
		betText.setBounds(400, 0, 400, 150);
		betUp.setBounds(800, 0, 200, 150);
		betDown.setBounds(1000, 0, 200, 150);
		enterNum.setBounds(0, 710, 200, 150);
		numText.setBounds(200, 710, 400, 150);
		red.setBounds(600, 710, 200, 150);
		black.setBounds(800, 710, 200, 150);
		even.setBounds(1000, 710, 200, 150);
		odd.setBounds(1200, 710, 200, 150);
		info.setBounds(350, 80, 700, 300);
		left2.setBounds(200, 350, 200, 150);
		left1.setBounds(400, 350, 200, 150);
		middle.setBounds(500, 300, 400, 250);
		right1.setBounds(800, 350, 200, 150);
		right2.setBounds(1000, 350, 200, 150);
		endGame.setBounds(0, 0, 200, 150);
		rules.setBounds(1200, 0, 200, 150);
		playerMoney.setBounds(350, 470, 700, 300);
		
		panel.add(betText);
		panel.add(enterBet);
		panel.add(betDown);
		panel.add(betUp);
		panel.add(red);
		panel.add(black);
		panel.add(numText);
		panel.add(enterNum);
		panel.add(even);
		panel.add(odd);
		panel.add(info);
		panel.add(left1);
		panel.add(left2);
		panel.add(middle);
		panel.add(right1);
		panel.add(right2);
		panel.add(endGame);
		panel.add(rules);
		panel.add(playerMoney);
		
		left2.setEnabled(false);
		left1.setEnabled(false);
		middle.setEnabled(false);
		right1.setEnabled(false);
		right2.setEnabled(false);
		red.setEnabled(false);
		black.setEnabled(false);
		even.setEnabled(false);
		odd.setEnabled(false);
		enterNum.setEnabled(false);
		numText.setEnabled(false);
		
		left2.setVisible(false);
		left1.setVisible(false);
		right1.setVisible(false);
		right2.setVisible(false);
		
		panel.setOpaque(false);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);
		
		//Call button actions
		StartGame();
		Listeners();
	}
	
	public void Listeners() {
		enterBet.addActionListener(new betEntered());
		endGame.addActionListener(new goBack());
		red.addActionListener(new setRed());
		black.addActionListener(new setBlack());
		even.addActionListener(new setEven());
		odd.addActionListener(new setOdd());
		enterNum.addActionListener(new setNumber());
		betUp.addActionListener(new raiseBet());
		betDown.addActionListener(new lowerBet());
	}
	
private class goBack implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//Ends the game and returns to the main menu
			menuFrame.setVisible(true);
			plyr.updateFileNum(numRecords);
			done = true;
			frame.dispose();
		}
	}

private class setRed implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends the game and returns to the main menu
		red.setEnabled(false);
		black.setEnabled(false);
		even.setEnabled(false);
		odd.setEnabled(false);
		enterNum.setEnabled(false);
		numText.setEnabled(false);
		bet = "Red";
		info.setText("You chose red");
	}
}

private class setBlack implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends the game and returns to the main menu
		red.setEnabled(false);
		black.setEnabled(false);
		even.setEnabled(false);
		odd.setEnabled(false);
		enterNum.setEnabled(false);
		numText.setEnabled(false);
		bet = "Black";
		info.setText("You chose black");
	}
}

private class setEven implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends the game and returns to the main menu
		red.setEnabled(false);
		black.setEnabled(false);
		even.setEnabled(false);
		odd.setEnabled(false);
		enterNum.setEnabled(false);
		numText.setEnabled(false);
		bet = "Even";
		info.setText("You chose even");
	}
}

private class setOdd implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends the game and returns to the main menu
		red.setEnabled(false);
		black.setEnabled(false);
		even.setEnabled(false);
		odd.setEnabled(false);
		enterNum.setEnabled(false);
		numText.setEnabled(false);
		bet = "Odd";
		info.setText("You chose odd");
	}
}

private class setNumber implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends the game and returns to the main menu
		bet = numText.getText();
		int temp = Integer.parseInt(bet);
		if (temp > 0 && temp < 37) {
			red.setEnabled(false);
			black.setEnabled(false);
			even.setEnabled(false);
			odd.setEnabled(false);
			enterNum.setEnabled(false);
			numText.setEnabled(false);
			info.setText("You chose the number " + temp);
		}
		else {
			info.setText("Please enter a number between 1 and 35");
		}
		
		
	}
}

private class betEntered implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Ends the game and returns to the main menu
		red.setEnabled(true);
		black.setEnabled(true);
		even.setEnabled(true);
		odd.setEnabled(true);
		enterNum.setEnabled(true);
		numText.setEnabled(true);
		
		enterBet.setEnabled(false);
		betText.setEnabled(false);
		betUp.setEnabled(false);
		betDown.setEnabled(false);
		plyr.changeMoney(-betting.getBet());
		playerMoney.setText(plyr.getID() + ": $" + plyr.getMoney());
	}
}

private class raiseBet implements ActionListener {
	
	//Raises the users bet
	@Override
	public void actionPerformed(ActionEvent e) {
		if (plyr.getMoney() >= betting.getNextBet()) {
			betting.raiseBet();
			betText.setText("$" + betting.getBet());
		}
	}
}

private class lowerBet implements ActionListener {
	//Lowers the users bet
	@Override
	public void actionPerformed(ActionEvent e) {
		betting.lowerBet();
		betText.setText("$" + betting.getBet());
	}
}


	public void StartGame() {
		
		Thread t = new Thread() {
			
			public void run() {
				
				while (!done) {
					
					while (enterBet.isEnabled()) {
						info.setText("Enter a bet");
					}
					
					while (enterNum.isEnabled()) {
						info.setText("Pick a colour, number, even or odd");
					}
					
					while (counter < 20) {
						actualNum = rand.nextInt(36);
						if (actualNum == 0) {
							actualNum = rand.nextInt(36);
						}
						
						if (actualNum % 2 == 0) {
							middle.setBackground(Color.RED);
							middle.setText("" + actualNum);
							
						}
						else {
							middle.setBackground(Color.BLACK);
							middle.setText("" + actualNum);
						}
						
						counter++;
						
						try {
							Thread.sleep(200);
						}
						catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					try {
						PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
						String temp = "" + actualNum;
						if (bet.equals("Red") && actualNum % 2 == 0) {
							info.setText("Congratulations you won $" + betting.getBet() * 2 + "!");
							plyr.changeMoney(betting.getBet() * 2);
							pw.append("Won $" + betting.getBet() * 2 + " playing Roulette");
						}
						else if (bet.equals("Black") && actualNum % 2 == 1) {
							info.setText("Congratulations you won $" + betting.getBet() * 2 + "!");
							plyr.changeMoney(betting.getBet() * 2);
							pw.append("Won $" + betting.getBet() * 2 + " playing Roulette");
						}
						else if (bet.equals("Even") && actualNum % 2 == 0) {
							info.setText("Congratulations you won $" + betting.getBet() * 2 + "!");
							plyr.changeMoney(betting.getBet() * 2);
							pw.append("Won $" + betting.getBet() * 2 + " playing Roulette");
						}
						else if (bet.equals("Odd") && actualNum % 2 == 1) {
							info.setText("Congratulations you won $" + betting.getBet() * 2 + "!");
							plyr.changeMoney(betting.getBet() * 2);
							pw.append("Won $" + betting.getBet() * 2 + " playing Roulette");
						}
						else if (bet.equals(temp)) {
							info.setText("Congratulations you won $" + betting.getBet() * 5 + "!");
							plyr.changeMoney(betting.getBet() * 5);
							pw.append("Won $" + betting.getBet() * 5 + " playing Roulette");
						}
						else {
							info.setText("You lost $" + betting.getBet());
							pw.append("Lost $" + betting.getBet() + " playing Roulette");
						}
						pw.close();
					}
					catch (Exception e1) {
						System.out.println("FILE IO ERROR IN ROULETTE");
					}
					
					numRecords++;
					if (numRecords > 10) {
						removeLineFromFile("user_records.txt");
					}
					
					try {
						Thread.sleep(3000);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
					counter = 0;
					red.setEnabled(false);
					black.setEnabled(false);
					even.setEnabled(false);
					odd.setEnabled(false);
					enterNum.setEnabled(false);
					numText.setEnabled(false);
					
					enterBet.setEnabled(true);
					betText.setEnabled(true);
					betUp.setEnabled(true);
					betDown.setEnabled(true);
					playerMoney.setText(plyr.getID() + ": $" + plyr.getMoney());
					
					if (plyr.getMoney() == 0) {
						done = true;
						menuFrame.setVisible(true);
						frame.dispose();
					}
				}
			}
		};
		t.start();	
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
}