package cp317;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class MainMenu {

	
	public static void main(String args[]) {
		MainMenu menu = new MainMenu();
		menu.RunProgram();
	}
	
	//Initial setup of gui

	public void RunProgram() {

	    	
    	mainFrame.setSize(900, 900);
    	mainFrame.setLocationRelativeTo(null);
    	mainFrame.setResizable(false);
    	mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	mainFrame.setVisible(true);
    	
    	//Creates the background
    	
    	ImageIcon icon = new ImageIcon("Other_Images/Casino.jpg");
    	Image iconTemp = icon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    	ImageIcon background = new ImageIcon(iconTemp);
    	
    	JLabel contentPane = new JLabel();
    	contentPane.setIcon(background);
    	contentPane.setLayout( new BorderLayout() );
    	mainFrame.setContentPane(contentPane);
    	Setup(mainFrame);
	}
	
	final JFrame mainFrame = new JFrame("MENU");
	//Declare items for gui
	JLabel image = new JLabel();
	JLabel name = new JLabel("Casino Games");
	JLabel response = new JLabel("");
	JLabel info = new JLabel("Please enter a username");
	JButton rec1 = new JButton("1. Gained $50 from BlackJack");
	JButton rec2 = new JButton("2. ");
	JButton rec3 = new JButton("3. ");
	JButton rec4 = new JButton("4. ");
	JButton rec5 = new JButton("5. ");
	JButton rec6 = new JButton("6. ");
	JButton rec7 = new JButton("7. ");
	JButton rec8 = new JButton("8. ");
	JButton rec9 = new JButton("9. ");
	JButton rec10 = new JButton("10. ");
	JButton button1 = new JButton("New User");
	JButton button2 = new JButton("Returning User");
	JButton button3 = new JButton("Enter");
	JButton games = new JButton("Games");
	JButton records = new JButton("Records");
	JButton logOut = new JButton("Log Out");
	JButton quit = new JButton("Quit");
	JButton back = new JButton("Back");
	JButton blackjack = new JButton("BlackJack");
	JButton roulette = new JButton("Roulette");
	JButton slots = new JButton("Slots");
	JButton craps = new JButton("Craps");
	JTextField text = new JTextField(10);
	Player puser;
	Color c = Color.magenta;
	
	
	//Declare global variables
	boolean newUser = false;
	boolean sameName = false;
	boolean error = false;
	boolean back1 = true;
	boolean back2 = false;
	final static int START_MONEY = 1000;
	String line;
	String[] user;
	File file = new File("user_data.txt");
	File file1 = new File("Other_Images");
	File file2 = new File("user_records.txt");
	ArrayList<String> pRecords = new ArrayList<String>();
	
	public void Setup(JFrame mainFrame) {
		
		//Create Jpanel and add to Jframe
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		//Create settings for items
		name.setFont(new Font("Serif", Font.BOLD, 80));
		name.setBounds(210, 0, 700, 200);
		button1.setBounds(300, 250, 300, 100);
		button2.setBounds(300, 350, 300, 100);
		quit.setBounds(300, 450, 300, 100);
		button3.setBounds(0, 600, 300, 100);
		text.setBounds(300, 600, 300, 100);
		
		text.setFont(new Font("Serif", Font.PLAIN, 40));
		response.setFont(new Font("Serif", Font.PLAIN, 30));
		response.setBounds(50, 160, 800, 100);
		info.setFont(new Font("Serif", Font.PLAIN, 20));
		rec1.setFont(new Font("Serif", Font.PLAIN, 20));
		rec2.setFont(new Font("Serif", Font.PLAIN, 20));
		rec3.setFont(new Font("Serif", Font.PLAIN, 20));
		rec4.setFont(new Font("Serif", Font.PLAIN, 20));
		rec5.setFont(new Font("Serif", Font.PLAIN, 20));
		rec6.setFont(new Font("Serif", Font.PLAIN, 20));
		rec7.setFont(new Font("Serif", Font.PLAIN, 20));
		rec8.setFont(new Font("Serif", Font.PLAIN, 20));
		rec9.setFont(new Font("Serif", Font.PLAIN, 20));
		rec10.setFont(new Font("Serif", Font.PLAIN, 20));
		
		info.setHorizontalAlignment(JLabel.CENTER);
		response.setHorizontalAlignment(JLabel.CENTER);
		rec1.setHorizontalAlignment(JTextField.LEFT);
		rec2.setHorizontalAlignment(JTextField.LEFT);
		rec3.setHorizontalAlignment(JTextField.LEFT);
		rec4.setHorizontalAlignment(JTextField.LEFT);
		rec5.setHorizontalAlignment(JTextField.LEFT);
		rec6.setHorizontalAlignment(JTextField.LEFT);
		rec7.setHorizontalAlignment(JTextField.LEFT);
		rec8.setHorizontalAlignment(JTextField.LEFT);
		rec9.setHorizontalAlignment(JTextField.LEFT);
		rec10.setHorizontalAlignment(JTextField.LEFT);
		
		
		info.setBounds(200, 550, 500, 50);
		back.setBounds(800, 00, 100, 50);
		games.setBounds(300, 250, 300, 100);
		records.setBounds(300, 350, 300, 100);
		logOut.setBounds(300, 550, 300, 100);
		blackjack.setBounds(100, 300, 300, 200);
		roulette.setBounds(500, 300, 300, 200);
		slots.setBounds(100, 600, 300, 200);
		craps.setBounds(500, 600, 300, 200);
		rec1.setBounds(25, 300, 400, 50);
		rec2.setBounds(25, 400, 400, 50);
		rec3.setBounds(25, 500, 400, 50);
		rec4.setBounds(25, 600, 400, 50);
		rec5.setBounds(25, 700, 400, 50);
		rec6.setBounds(460, 300, 400, 50);
		rec7.setBounds(460, 400, 400, 50);
		rec8.setBounds(460, 500, 400, 50);
		rec9.setBounds(460, 600, 400, 50);
		rec10.setBounds(460, 700, 400, 50);
		
		
		name.setForeground(Color.ORANGE);
		info.setForeground(Color.white);
		response.setForeground(Color.white);
		rec1.setForeground(Color.white);
		rec1.setBackground(Color.black);
		rec2.setForeground(Color.white);
		rec2.setBackground(Color.black);
		rec3.setForeground(Color.white);
		rec3.setBackground(Color.black);
		rec4.setForeground(Color.white);
		rec4.setBackground(Color.black);
		rec5.setForeground(Color.white);
		rec5.setBackground(Color.black);
		rec6.setForeground(Color.white);
		rec6.setBackground(Color.black);
		rec7.setForeground(Color.white);
		rec7.setBackground(Color.black);
		rec8.setForeground(Color.white);
		rec8.setBackground(Color.black);
		rec9.setForeground(Color.white);
		rec9.setBackground(Color.black);
		rec10.setForeground(Color.white);
		rec10.setBackground(Color.black);
		
		rec1.setEnabled(false);
		rec2.setEnabled(false);
		rec3.setEnabled(false);
		rec4.setEnabled(false);
		rec5.setEnabled(false);
		rec6.setEnabled(false);
		rec7.setEnabled(false);
		rec8.setEnabled(false);
		rec9.setEnabled(false);
		rec10.setEnabled(false);
		
		button1.setBackground(c);
		button1.setFont(new Font("Serif", Font.BOLD, 30));
		button2.setBackground(c);
		button2.setFont(new Font("Serif", Font.BOLD, 30));
		quit.setBackground(c);
		quit.setFont(new Font("Serif", Font.BOLD, 30));
		games.setBackground(c);
		games.setFont(new Font("Serif", Font.BOLD, 30));
		records.setBackground(c);
		records.setFont(new Font("Serif", Font.BOLD, 30));
		logOut.setBackground(c);
		logOut.setFont(new Font("Serif", Font.BOLD, 30));
		back.setBackground(c);
		back.setFont(new Font("Serif", Font.BOLD, 15));
		button3.setBackground(c);
		button3.setFont(new Font("Serif", Font.BOLD, 30));
		
		//Add items to Jpanel
		panel.add(name);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(quit);
		panel.add(text);
		panel.add(response);
		panel.add(info);
		panel.add(back);
		panel.add(games);
		panel.add(records);
		panel.add(logOut);
		panel.add(blackjack);
		panel.add(roulette);
		panel.add(slots);
		panel.add(craps);
		panel.add(rec1);
		panel.add(rec2);
		panel.add(rec3);
		panel.add(rec4);
		panel.add(rec5);
		panel.add(rec6);
		panel.add(rec7);
		panel.add(rec8);
		panel.add(rec9);
		panel.add(rec10);
		
		button3.setVisible(false);
		text.setVisible(false);
		response.setVisible(false);
		info.setVisible(false);
		back.setVisible(false);
		games.setVisible(false);
		records.setVisible(false);
		logOut.setVisible(false);
		blackjack.setVisible(false);
		roulette.setVisible(false);
		slots.setVisible(false);
		craps.setVisible(false);
		rec1.setVisible(false);
		rec2.setVisible(false);
		rec3.setVisible(false);
		rec4.setVisible(false);
		rec5.setVisible(false);
		rec6.setVisible(false);
		rec7.setVisible(false);
		rec8.setVisible(false);
		rec9.setVisible(false);
		rec10.setVisible(false);
		
		panel.setVisible(true);
		
		panel.setOpaque(false);
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		
		button1.addActionListener(new openUsername1());
		button2.addActionListener(new openUsername2());
		button3.addActionListener(new enterUsername());
		back.addActionListener(new goBack());
		quit.addActionListener(new goQuit());
		logOut.addActionListener(new goLogOut());
		games.addActionListener(new goGames());
		blackjack.addActionListener(new Blackjack());
		records.addActionListener(new gamesRecords());
	}
	
	private class openUsername1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			button3.setVisible(true);
			text.setVisible(true);
			info.setVisible(true);
			back.setVisible(true);
			response.setVisible(false);
			
			button1.setEnabled(false);
			button2.setEnabled(false);
			quit.setEnabled(false);
			
			response.setForeground(Color.black);
			newUser = true;
			error = false;
		}
	}
	
	private class gamesRecords implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			games.setVisible(false);
			records.setVisible(false);
			logOut.setVisible(false);
			quit.setVisible(false);
			back.setVisible(true);
			response.setVisible(false);
			
			try {
				BufferedReader r1 = new BufferedReader(new FileReader(file2));
				
				while (true) {
					String line = r1.readLine();
					if (line == null) {
						r1.close();
						break;
					}
					pRecords.add(line);
				}
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int num = pRecords.size() - 1, cnt = 0;
			while (cnt < 10) {
				if (cnt == 0)
					rec1.setText("1. " + pRecords.get(num));
				else if (cnt == 1)
					rec2.setText("2. " + pRecords.get(num));
				else if (cnt == 2)
					rec3.setText("3. " + pRecords.get(num));
				else if (cnt == 3)
					rec4.setText("4. " + pRecords.get(num));
				else if (cnt == 4)
					rec5.setText("5. " + pRecords.get(num));
				else if (cnt == 5)
					rec6.setText("6. " + pRecords.get(num));
				else if (cnt == 6)
					rec7.setText("7. " + pRecords.get(num));
				else if (cnt == 7)
					rec8.setText("8. " + pRecords.get(num));
				else if (cnt == 8)
					rec9.setText("9. " + pRecords.get(num));
				else if (cnt == 9)
					rec10.setText("10. " + pRecords.get(num));
				cnt++;
				num--;
			}
			
			
			rec1.setVisible(true);
			rec2.setVisible(true);
			rec3.setVisible(true);
			rec4.setVisible(true);
			rec5.setVisible(true);
			rec6.setVisible(true);
			rec7.setVisible(true);
			rec8.setVisible(true);
			rec9.setVisible(true);
			rec10.setVisible(true);
		}
	}
	
	private class goBack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (back1 && !back2) {
				button3.setVisible(false);
				text.setVisible(false);
				info.setVisible(false);
				back.setVisible(false);
				
				button1.setEnabled(true);
				button2.setEnabled(true);
				quit.setEnabled(true);
			}
			else {
				games.setVisible(true);
				records.setVisible(true);
				logOut.setVisible(true);
				quit.setVisible(true);
				response.setVisible(true);
				name.setVisible(true);
				back.setVisible(false);
				blackjack.setVisible(false);
				roulette.setVisible(false);
				slots.setVisible(false);
				craps.setVisible(false);
				rec1.setVisible(false);
				rec2.setVisible(false);
				rec3.setVisible(false);
				rec4.setVisible(false);
				rec5.setVisible(false);
				rec6.setVisible(false);
				rec7.setVisible(false);
				rec8.setVisible(false);
				rec9.setVisible(false);
				rec10.setVisible(false);
				
			}
		}
	}
	
	private class goLogOut implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			button1.setVisible(true);
			button1.setEnabled(true);
			button2.setVisible(true);
			button2.setEnabled(true);
			button3.setVisible(false);
			quit.setEnabled(true);
			text.setVisible(false);
			info.setVisible(false);
			games.setVisible(false);
			records.setVisible(false);
			back.setVisible(false);
			logOut.setVisible(false);
			response.setText("Sucessfully logged out");
	    	response.setVisible(true);
	    	back1 = true;
	    	back2 = false;
		}
	}
	
	private class goQuit implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
	}
	
	private class goGames implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			games.setVisible(false);
			records.setVisible(false);
			logOut.setVisible(false);
			quit.setVisible(false);
			blackjack.setVisible(true);
			roulette.setVisible(true);
			slots.setVisible(true);
			craps.setVisible(true);
			back.setVisible(true);
		}
	}
	
	private class Blackjack implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			BlackJackMain bj = new BlackJackMain();
			bj.Startup(puser, mainFrame);
			mainFrame.setVisible(false);
		}
	}
	
	private class openUsername2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			button3.setVisible(true);
			text.setVisible(true);
			info.setVisible(true);
			quit.setEnabled(false);
			back.setVisible(true);
			response.setVisible(false);
			
			button1.setEnabled(false);
			button2.setEnabled(false);
			response.setForeground(Color.black);
			newUser = false;
			error = false;
		}
	}
	
	
	private class enterUsername implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String s = text.getText();
			if (s.length() >= 16) {
				error = true;
				response.setText("Error, must be less than 16 characters");
		    	response.setVisible(true);
		    	response.setForeground(Color.red);
			}
			else if (s.length() == 0) {
				error = true;
				response.setText("Error, must have at least 1 character");
		    	response.setVisible(true);
		    	response.setForeground(Color.red);
			}
			
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
				
				//Creates a new user
				if (newUser && !error) {
					//This thing writes to files
					BufferedReader reader2 = new BufferedReader(new FileReader(file));
					//Checks to make sure the name isnt already in the database
					while((line = reader2.readLine()) != null && sameName == false) {
					    user = line.split(",");
					    //If it is, reset menu
					    if (user[0].compareTo(s) == 0) {
					    	response.setText("Sorry, '" + s + "' has been taken. Please try again");
					    	response.setVisible(true);
					    	reader2.close();
					    	sameName = true;
					    	
					    	button3.setVisible(false);
							text.setVisible(false);
							info.setVisible(false);
							back.setVisible(false);
							button1.setEnabled(true);
							button2.setEnabled(true);
							quit.setEnabled(true);
							text.setText("");
							sameName = false;
					    }
					    else {
					    	sameName = false;
					    }
					}
					//Otherwise create user
					if (sameName == false) {
						puser = new Player(s, START_MONEY);
						pw.append(puser.getID() + "," + puser.getMoney() + "\n");
						response.setText("Hello " + s + ", you have $1000");
						response.setVisible(true);
						pw.close();
						
						button1.setVisible(false);
						button2.setVisible(false);
						button3.setVisible(false);
						quit.setEnabled(true);
						text.setVisible(false);
						info.setVisible(false);
						games.setVisible(true);
						records.setVisible(true);
						back.setVisible(false);
						logOut.setVisible(true);
						text.setText("");
						back1 = false;
						back2 = true;
					}
					sameName = false;
			    }
			
				//Checks to see if there is an existing user
				else if (!newUser && !error){
					BufferedReader reader2 = new BufferedReader(new FileReader(file));
					//Checks to see if the user is already in the database
					while((line = reader2.readLine()) != null) {
					    user = line.split(",");
					    //If they are send them through to main menu
					    if (user[0].compareTo(s) == 0) {
					    	int val = Integer.parseInt(user[1]);
					    	puser = new Player(s, val);
					    	response.setText("Hello " + puser.getID() + ", you have $" + puser.getMoney());
					    	response.setVisible(true);
					    	reader2.close();
					    	
					    	button1.setVisible(false);
							button2.setVisible(false);
							button3.setVisible(false);
							quit.setEnabled(true);
							text.setVisible(false);
							info.setVisible(false);
							games.setVisible(true);
							records.setVisible(true);
							back.setVisible(false);
							logOut.setVisible(true);
							text.setText("");
							back1 = false;
							back2 = true;
					    }
					    //Otherwise reset
					    else {
					    	response.setText("Error, '" + s + "' is not registered. Please try again");
					    	response.setVisible(true);
					    	
					    	button1.setEnabled(true);
							button2.setEnabled(true);
							button3.setVisible(false);
							quit.setEnabled(true);
							text.setVisible(false);
							info.setVisible(false);
							back.setVisible(false);
					    }
					}
				}
				//There was an error, reset menu
				else {
			    	button1.setEnabled(true);
					button2.setEnabled(true);
					button3.setVisible(false);
					quit.setEnabled(true);
					text.setVisible(false);
					info.setVisible(false);
					back.setVisible(false);
				}
			}
			catch (Exception e1) {
				System.out.println("File IO error");
			}
			response.setForeground(Color.cyan);
		}
	}
}
