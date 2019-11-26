package cp317;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*; 
/*
craps

function:
get listener -> get bets
rolls-> generate random numbers
check-> corespond those bets with the inputs
show results -> shows the result
write - > global function that writes to file





 */

public class craps 
{
	File file = new File("user_records.txt");

	boolean snakeeyes;
	boolean aceduece;
	boolean nat7;
	boolean nat11;
	boolean boxcars;
	int bets[] = {5,10,25,50,100,250,500};
	int index = 0;
	PrintWriter pw;
	int lines  = 0;
	int count = 0;
	int target= 0;
	boolean done = false;

	Player ply;

	JLabel targetVal = new JLabel("0");
	JLabel outcomeVal = new JLabel("");
	JLabel totVal;
	JLabel betVal = new JLabel("5");
	JFrame frame = new JFrame("Craps");

	ImageIcon dice_1 = new ImageIcon ("1.png");
	Image dice1image = dice_1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon die1 =new ImageIcon (dice1image);

	ImageIcon dice_2 = new ImageIcon ("2.png");
	Image dice2image = dice_2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon die2 =new ImageIcon (dice2image);

	ImageIcon dice_3 = new ImageIcon ("3.png");
	Image dice3image = dice_3.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon die3 =new ImageIcon (dice3image);

	ImageIcon dice_4 = new ImageIcon ("4.png");
	Image dice4image = dice_4.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon die4 =new ImageIcon (dice4image);

	ImageIcon dice_5 = new ImageIcon ("5.png");
	Image dice5image = dice_5.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon die5 =new ImageIcon (dice5image);

	ImageIcon dice_6 = new ImageIcon ("6.png");
	Image dice6image = dice_6.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
	ImageIcon die6 =new ImageIcon (dice6image);

	JLabel dice1 = new JLabel();
	JLabel dice2 = new JLabel();

	JFrame home = new JFrame();

	JButton endGame = new JButton("End Game");
	JButton rules = new JButton("Rules");
	JButton roll = new JButton("Roll");
	JButton betup = new JButton("+");
	JButton betdown = new JButton("-");
	JButton clear = new JButton("Clear");

	JButton snake = new JButton("Snake Eyes");
	JButton aceDuece = new JButton("Ace Duece");
	JButton seven = new JButton("7");
	JButton eleven = new JButton("11");
	JButton boxcars1 = new JButton("Boxcars");

	public void spin(int bet)
	{	
		if(count == 0)
		{
			target = 0;
			done = false;
		}
		int die_1 =  (int) (Math.random()*(6-1+1) + 1);
		int die_2 =(int) (Math.random()*(6-1+1) + 1);
		int roll = die_1+die_2;
		face1(die_1);
		face2(die_2);
		try {
			pw = new PrintWriter(new FileOutputStream(file, true));
			if(snakeeyes || aceduece || nat7||nat11||boxcars)
			{
				if(snakeeyes && roll == 2 )
				{
					ply.changeMoney(5*bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("HIT PROP");
					pw.append("Gained " + bet * 5 + " playing Craps\n");
				}
				else if(aceduece  && roll == 3)
				{
					ply.changeMoney(5*bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("HIT PROP");
					pw.append("Gained " + bet * 5 + " playing Craps\n");
				}
				else if(nat7 && roll == 7)
				{
					ply.changeMoney(5*bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("HIT PROP");
					pw.append("Gained " + bet * 5 + " playing Craps\n");
				}
				else if(nat11 && roll == 11)
				{
					ply.changeMoney(5*bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("HIT PROP");
					pw.append("Gained " + bet * 5 + " playing Craps\n");
				}
				else if(boxcars && roll == 12)
				{
					ply.changeMoney(5*bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("HIT PROP");
					pw.append("Gained " + bet * 5 + " playing Craps\n");
				}
				else
				{
					ply.changeMoney(-bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("MISSED PROP");
					pw.append("Lost " + bet + " playing Craps\n");
				}
			}
			else {

				if ((roll == 7 || roll == 11) && target == 0)
				{
					ply.changeMoney(bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("NATUARLLY");
					lines++;
					pw.append("Gained " + bet * 2 + " playing Craps\n");
				}
				else if((roll == 2|| roll == 3 || roll == 12) && target == 0)
				{
					ply.changeMoney(-bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("CRAPS");
					pw.append("Lost " + bet + " playing Craps\n");
					lines++;
				}
				else if(target == 0)
				{
					target = roll;
					outcomeVal.setText("LINE SET AT: "+ roll);
					targetVal.setText(Integer.toString(target));
					count++;
					lines++;

				}
				else if(target > 1 && roll == 7)
				{
					ply.changeMoney(-bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("CRAPPED OUT ON THE LINE");
					pw.append("Lost " + bet + " playing Craps\n");
					lines++;
				}
				else if(target == roll)
				{
					ply.changeMoney(bet);
					done = true;
					totVal.setText(Integer.toString(ply.getMoney()));
					outcomeVal.setText("YOU GOT THE LINE");
					pw.append("Gained " + bet+ " playing Craps\n");
					lines++;
				}
			}
			pw.close();
			if (lines > 10) {
				removeLineFromFile("user_records.txt");
			}
		}
		catch (Exception e1) {
			System.out.println("FILE IO ERROR IN BLACKJACK");
		}		
		if(!done)
		{
			rules.setEnabled(false);
			betup.setEnabled(false);
			betdown.setEnabled(false);
			clear.setEnabled(false);

			snake.setEnabled(false);
			aceDuece.setEnabled(false);
			seven.setEnabled(false);
			eleven.setEnabled(false);
			boxcars1.setEnabled(false);
		}
		if(done)
		{
			rules.setEnabled(true);
			betup.setEnabled(true);
			betdown.setEnabled(true);
			clear.setEnabled(true);

			snake.setEnabled(true);
			aceDuece.setEnabled(true);
			seven.setEnabled(true);
			eleven.setEnabled(true);
			boxcars1.setEnabled(true);
			count = 0;
			index = 0;
			betVal.setText(Integer.toString(bets[index]));
		}
		if(ply.getMoney() == 0)
		{
			done = true;
			home.setVisible(true);
			frame.dispose();
		}
	}

	public void face1 (int value)
	{
		if(value ==1)
		{
			dice1.setIcon(die1);
		}
		if(value ==2)
		{

			dice1.setIcon(die2);
		}
		if(value ==3)
		{
			dice1.setIcon(die3);
		}
		if(value ==4)
		{
			dice1.setIcon(die4);
		}
		if(value ==5)
		{
			dice1.setIcon(die5);
		}
		if(value ==6)
		{
			dice1.setIcon(die6);
		}
	}
	public void face2 (int value)
	{
		if(value ==1)
		{
			dice2.setIcon(die1);
		}
		if(value ==2)
		{
			dice2.setIcon(die2);
		}
		if(value ==3)
		{
			dice2.setIcon(die3);
		}
		if(value ==4)
		{
			dice2.setIcon(die4);
		}
		if(value ==5)
		{
			dice2.setIcon(die5);
		}
		if(value ==6)
		{
			dice2.setIcon(die6);
		}
	}

	public static void removeLineFromFile(String file) {
		//This function deltes the first line of a file by copying the contents of the original file except for the first line
		// and then pasting it to a new file. The old file is delted and the new one is renamed the same as the old one.
		int c = 0;
		try {

			File inFile = new File(file);

			if (!inFile.isFile()) {
				System.out.println("Parameter is not an existing file");
				return;
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

	public void startup(Player p,JFrame mainFrame)
	{

		home = mainFrame;
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ImageIcon icon = new ImageIcon("craps.jpg");
		Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
		ImageIcon background = new ImageIcon(iconTemp);
		JLabel contentPane = new JLabel();
		contentPane.setIcon(background);
		contentPane.setLayout( new BorderLayout() );
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		//Create labels

		ply = p;

		snakeeyes = false;
		aceduece = false; 
		nat7 = false;
		nat11  = false;
		boxcars = false;

		index = 0;

		totVal = new JLabel(Integer.toString(ply.getMoney()));

		JLabel target = new JLabel("Line:");
		JLabel betl  = new JLabel("Bet:");
		JLabel outcome = new JLabel("Outcome:");
		JLabel tot  = new JLabel("Total:");
		//Create buttons

		dice1.setBackground(Color.BLACK);
		dice2.setBackground(Color.BLACK);

		dice1.setIcon(die1);
		dice2.setIcon(die2);

		betl.setFont(new Font("Serif", Font.PLAIN, 25));
		betl.setForeground(Color.WHITE);
		betVal.setFont(new Font("Serif", Font.BOLD, 25));
		betVal.setForeground(Color.WHITE);
		target.setFont(new Font("Serif", Font.PLAIN, 25));
		target.setForeground(Color.WHITE);
		targetVal.setFont(new Font("Serif", Font.BOLD, 25));
		targetVal.setForeground(Color.WHITE);

		outcome.setFont(new Font("Serif", Font.PLAIN, 25));
		outcome.setForeground(Color.WHITE);
		outcomeVal.setFont(new Font("Serif", Font.BOLD, 25));
		outcomeVal.setForeground(Color.WHITE);
		tot.setFont(new Font("Serif", Font.PLAIN, 25));
		tot.setForeground(Color.WHITE);
		totVal.setFont(new Font("Serif", Font.BOLD, 25));
		totVal.setForeground(Color.WHITE);

		Color customB = new Color(15,125,75);

		endGame.setBounds	(0, 0,1400/6,200);
		endGame.setBackground(customB);
		endGame.setFont(new Font("Serif", Font.BOLD, 25));
		rules.setBounds		(1400/6,0,1400/6,200);
		rules.setBackground(customB);
		rules.setFont(new Font("Serif", Font.BOLD, 25));
		roll.setBounds		(2*1400/6,0,1400/6,200);
		roll.setBackground(customB);
		roll.setFont(new Font("Serif", Font.BOLD, 25));
		betup.setBounds		(3*1400/6, 0,1400/6,200);
		betup.setBackground(customB);
		betup.setFont(new Font("Serif", Font.BOLD, 25));
		betdown.setBounds	(4*1400/6, 0,1400/6,200);
		betdown.setBackground(customB);
		betdown.setFont(new Font("Serif", Font.BOLD, 25));
		clear.setBounds		(5*1400/6,0,1400/6,200);
		clear.setBackground(customB);
		clear.setFont(new Font("Serif", Font.BOLD, 25));

		betl.setBounds		(100, 300,1400/4,100);
		betVal.setBounds	(1400/4, 300,1400/4,100);
		target.setBounds	(2*1400/4+100, 300, 1400/4,100);
		targetVal.setBounds	(3*1400/4, 300, 1400/4,100);

		outcome.setBounds		(100, 200,1400/4,100);
		outcomeVal.setBounds	(1400/4, 200,1400/4,100);
		tot.setBounds	(2*1400/4+100, 200, 1400/4,100);
		totVal.setBounds	(3*1400/4, 200, 1400/4,100);

		dice1.setBounds		(425, 400, 275, 275);
		dice2.setBounds		(725, 400, 275, 275);

		snake.setBounds		(0, 700, 1400/5,200);
		snake.setBackground(customB);
		snake.setFont(new Font("Serif", Font.BOLD, 25));
		aceDuece.setBounds	(1400/5,700, 1400/5,200);
		aceDuece.setBackground(customB);
		aceDuece.setFont(new Font("Serif", Font.BOLD, 25));
		seven.setBounds		(2*1400/5,700,  1400/5,200);
		seven.setBackground(customB);
		seven.setFont(new Font("Serif", Font.BOLD, 25));
		eleven.setBounds	( 3*1400/5,700, 1400/5,200);
		eleven.setBackground(customB);
		eleven.setFont(new Font("Serif", Font.BOLD, 25));
		boxcars1.setBounds	( 4*1400/5,700, 1400/5,200);
		boxcars1.setBackground(customB);
		boxcars1.setFont(new Font("Serif", Font.BOLD, 25));

		setprop se = new setprop();
		snake.addActionListener(se);
		setprop ad = new setprop();
		aceDuece.addActionListener(ad);
		setprop n7 = new setprop();
		seven.addActionListener(n7);
		setprop n11 = new setprop();
		eleven.addActionListener(n11);
		setprop bc = new setprop();
		boxcars1.addActionListener(bc);

		rolld rl = new rolld();
		roll.addActionListener(rl);

		plus pl = new plus();
		betup.addActionListener(pl);

		minus mn = new minus();
		betdown.addActionListener(mn);

		clear cl = new clear();
		clear.addActionListener(cl);

		rules ru = new rules();
		rules.addActionListener(ru);

		end ed = new end();
		endGame.addActionListener(ed);

		panel.add(betl);
		panel.add(betVal);
		panel.add(target);
		panel.add(targetVal);

		panel.add(outcome);
		panel.add(outcomeVal);
		panel.add(tot);
		panel.add(totVal);

		panel.add(endGame);
		panel.add(rules);
		panel.add(roll);
		panel.add(betup);
		panel.add(betdown);
		panel.add(clear);

		panel.add(snake);
		panel.add(aceDuece);
		panel.add(seven);
		panel.add(eleven);
		panel.add(boxcars1);

		panel.add(dice1);
		panel.add(dice2);



		panel.setOpaque(false);
		panel.setVisible(true);

		frame.add(panel);
		frame.setVisible(true);

	}

	private class setprop implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton)e.getSource();
			if(button.getText() == "Snake Eyes")
			{
				snakeeyes = true;
			}
			if(button.getText() == "Ace Duece")
			{
				aceduece = true;
			}
			if(button.getText() == "7")
			{
				nat7 = true;
			}
			if(button.getText() == "11")
			{
				nat11 = true;
			}
			if(button.getText() == "Boxcars")
			{
				boxcars = true;
			}
		}
	}

	private class rolld implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			targetVal.setText("0");
			spin(bets[index]);
			snakeeyes = false;
			aceduece = false; 
			nat7 = false;
			nat11  = false;
			boxcars = false;
		}
	}

	private class plus implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(index != 6 & bets[index+1] <= ply.getMoney())
			{
				index++;
				betVal.setText(Integer.toString(bets[index]));
			}
		}
	}

	private class minus implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(index != 0)
			{
				index--;
				betVal.setText(Integer.toString(bets[index]));
			}
		}
	}

	private class	clear  implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			snakeeyes = false;
			aceduece = false; 
			nat7 = false;
			nat11  = false;
			boxcars = false;
			index = 0;
			outcomeVal.setText("");
			betVal.setText(Integer.toString(bets[index]));
			targetVal.setText("0");
		}
	}

	private class	rules  implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "WELCOME TO CRAPS"
					+ "\nThe point of this game is to roll a 7 or an 11"
					+ "\nWhile avoiding rolling 2,3,12"
					+ "\nIf u roll something else the line is set"
					+ "\nThe goal is to reroll that value before rolling a 7"
					+ "\nThere are also props that u can bet on: "
					+ "\nSnake eye----------1 , 1"
					+ "\nAce duece----------1 , 2"
					+ "\n7-----------------------any 7"
					+ "\n11---------------------any 11"
					+ "\nBoxcars-------------6 , 6"
					+ "\nALL PROPS RESET ON NEXT ROLL");

		}
	}
	
	private class end  implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (target != 0)
			{
				ply.changeMoney(-bets[index]);
			}
			home.setVisible(true);
			frame.dispose();
		}
	}

}


