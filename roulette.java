package cp317;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class roulette {

	public static void main(String[] args) {
		roulette r = new roulette();
		Player p = new Player("Christine", 10);
		JFrame n = new JFrame();
		r.Startup(p, n, 10);
	}

	Scanner keyboard = new Scanner(System.in);
	Random generator = new Random();
	double total = 0;
	double amount;
	int roulettebet;
	int choice, colour = 0;
	int number;
	int rouletteNum, colourNum;
	int result;
	char response = 'y';

	final JFrame frame = new JFrame("Roulette");
	int numRecords;
	Player plyr;
	JFrame menuFrame;
	Bet betting = new Bet();

	JButton bet = new JButton("bet");
	JButton betup = new JButton("betup");
	JButton betdown = new JButton("betdown");
	JTextField betamount = new JTextField("1");
	JButton even = new JButton("even");
	JButton odd = new JButton("odd");
	JButton betnumber = new JButton("number");
	JTextField userbetnum = new JTextField("");
	JButton red = new JButton("red");
	JButton black = new JButton("black");

	public void Startup(Player p, JFrame mainFrame, int num) {

		// Create the GUI
		numRecords = num;
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuFrame = mainFrame;
		plyr = p;

		// Set the background
		ImageIcon icon = new ImageIcon("roulette_images/roulette-wheel.jpg");
		Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
		ImageIcon background = new ImageIcon(iconTemp);
		JLabel contentPane = new JLabel();
		contentPane.setIcon(background);
		contentPane.setLayout(new BorderLayout());
		frame.setContentPane(contentPane);

		// Create the place where buttons and stuff go
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		// Set bounds of buttons/labels
		bet.setBounds(50, 100, 200, 100);
		betup.setBounds(250, 100, 200, 100);
		betdown.setBounds(250, 200, 200, 100);
		betamount.setBounds(50, 200, 200, 100);
		even.setBounds(50, 400, 200, 100);
		odd.setBounds(50, 500, 200, 100);
		betnumber.setBounds(50, 600, 200, 100);
		userbetnum.setBounds(250, 600, 200, 100);
		red.setBounds(500, 500, 200, 100);
		black.setBounds(500, 600, 200, 100);

		// add to panel
		panel.add(bet);
		panel.add(betup);
		panel.add(betdown);
		panel.add(betamount);
		panel.add(even);
		panel.add(odd);
		panel.add(betnumber);
		panel.add(userbetnum);
		panel.add(red);
		panel.add(black);

		// set colour of buttons		
		bet.setBackground(Color.green);
		betup.setBackground(Color.green);
		betdown.setBackground(Color.green);
		even.setBackground(Color.gray);
		odd.setBackground(Color.gray);
		betnumber.setBackground(Color.gray);
		red.setBackground(Color.red);
		red.setForeground(Color.white);
		black.setBackground(Color.black);
		black.setForeground(Color.white);
		
		// Set the background to work and have everything placed onto the gui
		panel.setOpaque(false);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);

		Listeners();
	}

	public void Listeners() {
		// Create button actions
		bet.addActionListener(new setbet());
		betup.addActionListener(new betup());
		betdown.addActionListener(new betdown());
		even.addActionListener(new even());
		odd.addActionListener(new odd());
		betnumber.addActionListener(new betnumber());
		betnumber.addActionListener(new betnumber());
	}

	private class setbet implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// Ends the players turn
			betup.setEnabled(false);
			betdown.setEnabled(false);
			roulettebet = Integer.parseInt(betamount.getText());
			Startgame();
		}
	}

	private class betup implements ActionListener {

		// Raises the users bet
		@Override
		public void actionPerformed(ActionEvent e) {
			if (plyr.getMoney() >= betting.getNextBet()) {
				betting.raiseBet();
				betamount.setText("" + betting.getBet());
			} else {
				bet.setText("NOT ENOUGH MONEY!");
			}
		}
	}

	private class betdown implements ActionListener {
		// Lowers the users bet
		@Override
		public void actionPerformed(ActionEvent e) {
			betting.lowerBet();
			betamount.setText("" + betting.getBet());
		}
	}

	private class even implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			choice = 0;
		}
	}

	private class odd implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			choice = 1;
		}
	}

	private class betnumber implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			choice = 2;
		}
	}

	private class userbetnum implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			number = Integer.parseInt(userbetnum.getText());
		}
	}

	private class red implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	private class black implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	public void Startgame() {
		while (response == 'y' || response == 'Y') {
			System.out.print("Enter your bet amount: ");
			amount = roulettebet;

			// choose between even, odd or choose your own number
			System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
			choice = -1;
//			while (choice < 0 || choice > 2) {
//				System.out.print("Place your bet on: ");
//				choice = keyboard.nextInt();
//				System.out.print("Choose your colour (0 - red, 1 - black): ");
//				colour = keyboard.nextInt();
//			}
			number = 0;
			while ( choice == - 1) {
				if (choice == 0) {
					System.out.print("Place your bet on: ");
					choice = keyboard.nextInt();
					System.out.print("Choose your colour (0 - red, 1 - black): ");
					colour = keyboard.nextInt();
				}
				// odd number 
				else if (choice == 1) {
					System.out.print("Place your bet on: ");
					choice = keyboard.nextInt();
					System.out.print("Choose your colour (0 - red, 1 - black): ");
					colour = keyboard.nextInt();
				}
				// choose your own number
				else if (choice == 2) {
					while (number < 1 || number > 36) {
						System.out.print("Place your bet on number from 1-36: ");
						number = keyboard.nextInt();
					}
				}
			}
			// even number

			// random number generator & colour generator
			rouletteNum = generator.nextInt(37);
			colourNum = generator.nextInt(2);
			System.out.println("Roulette number: " + rouletteNum);
			if (colourNum == 0) {
				System.out.println("Colour: Red");
			} else {
				System.out.println("Colour: Black ");
			}

			// check win conditions
			if (choice == 2) { // if you chose your number
				if (rouletteNum == number && colourNum == colour) // same number and colour
					result = 1;
				else
					result = 0;
			} else {
				if (rouletteNum == 0 || rouletteNum % 2 != choice) // chosen even or odd matching the random int
					result = 0;
				else
					result = 1;
			}

			// print results
			if (result > 0) {
				System.out.printf("You have won $%.2f \n", amount);

			} else {
				System.out.printf("You have lost $%.2f \n", amount);
			}
			System.out.print("\nPlay again? (y or n)?");
			response = keyboard.next().charAt(0);
		}
	}
}
