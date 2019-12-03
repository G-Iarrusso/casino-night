package cp317;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

public class SlotsMain
{
//used to run the game for testing 
	public static void main(String args[])
	{
		SlotsMain s = new SlotsMain();
		Player p = new Player("Matt", 5);
		JFrame n = new JFrame();
		int numrecords = 0;
		s.StartupSlots(p, n, numrecords);
	}

	// creating labels
	Color gold = new Color(200,150,15);
	int payout = 0;
	JLabel legend = new JLabel("Legend");
	JLabel money = new JLabel("Money: $");
	JLabel earning = new JLabel("Payout: $0");
	JLabel cherryLab = new JLabel("$5");
	JLabel coinLab = new JLabel("$10");
	JLabel dollarLab = new JLabel("$25");
	JLabel cloverLab = new JLabel("$100");
	JLabel diamondLab = new JLabel("$250");
	JLabel sevenLab = new JLabel("$5000");
	boolean flag = false;
	ImageIcon slot1 = new ImageIcon("Slots_Images/Cherry.jpg");
	Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
	ImageIcon slot1symbol = new ImageIcon(slot1image);

	ImageIcon slot2 = new ImageIcon("Slots_Images/Coin.jpg");
	Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
	ImageIcon slot2symbol = new ImageIcon(slot2image);

	ImageIcon slot3 = new ImageIcon("Slots_Images/Diamond.jpg");
	Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
	ImageIcon slot3symbol = new ImageIcon(slot3image);
	//creating images used in the icon
	ImageIcon cherryi = new ImageIcon("Slots_Images/Cherry.jpg");
	Image cherryimage = cherryi.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon cherry = new ImageIcon(cherryimage);

	ImageIcon coini = new ImageIcon("Slots_Images/Coin.jpg");
	Image coinimage = coini.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon coin = new ImageIcon(coinimage);

	ImageIcon dollari = new ImageIcon("Slots_Images/DollarSign.jpg");
	Image dollarimage = dollari.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon dollarSign = new ImageIcon(dollarimage);

	ImageIcon FourLCi = new ImageIcon("Slots_Images/FourLeafClover.jpg");
	Image FourLCimage = FourLCi.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon fourleafclover = new ImageIcon(FourLCimage);

	ImageIcon diamondi = new ImageIcon("Slots_Images/Diamond.jpg");
	Image diamondimage = diamondi.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon diamond = new ImageIcon(diamondimage);

	ImageIcon seveni = new ImageIcon("Slots_Images/Seven.jpg");
	Image sevenimage = seveni.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
	ImageIcon seven = new ImageIcon(sevenimage);
	
	//creating the buttons used in the GUI

	JButton leftslot = new JButton();
	JButton middleslot = new JButton();
	JButton rightslot = new JButton();
	Player plyr;
	JFrame menuFrame;
	// buttons
	JButton spin = new JButton("");
	
	JButton endGame = new JButton("End Game");
	JButton rules = new JButton("Rules");

	//creating the labels for the legend 
	JLabel Cherry = new JLabel();
	JLabel Coin = new JLabel();
	JLabel DollarSign = new JLabel();
	JLabel FourLeafClover = new JLabel();
	JLabel Diamond = new JLabel();
	JLabel Seven = new JLabel();
	
	//temp icons used for spinning the slots
	ImageIcon temp1 = new ImageIcon(slot1image);
	ImageIcon temp2 = new ImageIcon(slot2image);
	ImageIcon temp3 = new ImageIcon(slot3image);
	
	//declaration of other variables needed to run the game
	int n = 600;
	int slot1index = 50;
	int slot2index = 35;
	int slot3index = 20;
	int spin1 = 0, spin2 = 0, spin3 = 0;
	int losingstreak = 0;
	String first_slot_val = "";
	String second_slot_val = "";
	String third_slot_val = "";

	PrintWriter pw;
	File file = new File("user_records.txt");
	File f = new File("Slots_Images");
	// going to need a file of slots images

	final JFrame frame = new JFrame("Slots");

	public void StartupSlots(Player p, JFrame mainFrame, int numrecords)
	{
		
		//sets the resolution specified to run the game
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuFrame = mainFrame;
		plyr = p;
		//setting the background
		ImageIcon icon = new ImageIcon("Slots_Images/Slot_Machine.png");
		Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
		ImageIcon background = new ImageIcon(iconTemp);
		JLabel contentPane = new JLabel();

		contentPane.setIcon(background);

		contentPane.setLayout(new BorderLayout());
		frame.setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setLayout(null);

		//creating the GUI
		leftslot.setBounds(495, 310, 99, 125);
		middleslot.setBounds(615, 310, 99, 125);
		rightslot.setBounds(730, 310, 99, 125);
		legend.setBounds(1200, 100, 100, 100);
		legend.setFont(new Font("Serif", Font.PLAIN, 30));
		endGame.setBounds(0, 0, 200, 100);
		endGame.setFont(new Font("Serif", Font.PLAIN, 30));
		endGame.setBackground(gold);
		rules.setBounds(1200, 0, 200, 100);
		rules.setFont(new Font("Serif", Font.PLAIN, 30));
		rules.setBackground(gold);
		spin.setBounds(870, 270, 100, 230);
		spin.setFont(new Font("Serif", Font.PLAIN, 30));
		spin.setOpaque(false);
		spin.setContentAreaFilled(false);
		spin.setBorderPainted(false);
		
		money.setBounds(600, 780, 400, 100);
		money.setFont(new Font("Serif", Font.PLAIN, 30));
		earning.setAlignmentX(JTextField.CENTER);
		earning.setForeground(Color.yellow);
		earning.setBounds(600, 145, 300, 100);
		earning.setFont(new Font("Serif", Font.PLAIN, 30));

		money.setText("Money: $"+plyr.getMoney());
		
		Cherry.setBounds(1200, 200, 100, 100);
		Coin.setBounds(1200, 300, 100, 100);
		DollarSign.setBounds(1200, 400, 100, 100);
		FourLeafClover.setBounds(1200, 500, 100, 100);
		Diamond.setBounds(1200, 600, 100, 100);
		Seven.setBounds(1200, 700, 100, 100);
		
		cherryLab.setBounds(1300, 200, 100, 100);
		coinLab.setBounds(1300, 300, 100, 100);
		dollarLab.setBounds(1300, 400, 100, 100);
		cloverLab.setBounds(1300, 500, 100, 100);
		diamondLab.setBounds(1300, 600, 100, 100);
		sevenLab.setBounds(1300, 700, 100, 100);
		
		cherryLab.setFont(new Font("Serif", Font.PLAIN, 30));
		coinLab.setFont(new Font("Serif", Font.PLAIN, 30));
		dollarLab.setFont(new Font("Serif", Font.PLAIN, 30));
		cloverLab.setFont(new Font("Serif", Font.PLAIN, 30));
		diamondLab.setFont(new Font("Serif", Font.PLAIN, 30));
		sevenLab.setFont(new Font("Serif", Font.PLAIN, 30));
		
		
		
		panel.add(cherryLab);
		panel.add(coinLab);
		panel.add(dollarLab);
		panel.add(cloverLab);
		panel.add(diamondLab);
		panel.add(sevenLab);
		
		panel.add(Cherry);
		panel.add(Coin);
		panel.add(DollarSign);
		panel.add(FourLeafClover);
		panel.add(Diamond);
		panel.add(Seven);
		panel.add(leftslot);
		panel.add(middleslot);
		panel.add(rightslot);
		panel.add(legend);
		panel.add(endGame);
		panel.add(rules);
		panel.add(spin);
		panel.add(earning);
		panel.add(money);

		//the slots of the actual machine
		leftslot.setIcon(slot1symbol);
		middleslot.setIcon(slot2symbol);
		rightslot.setIcon(slot3symbol);
		Cherry.setIcon(cherry);
		Coin.setIcon(coin);
		DollarSign.setIcon(dollarSign);
		FourLeafClover.setIcon(fourleafclover);
		Diamond.setIcon(diamond);
		Seven.setIcon(seven);

		panel.setOpaque(false);
		panel.setVisible(true);
		frame.add(panel);
		frame.setVisible(true);

		Listeners();

	}
	//the three buttons of this game are spin, rules, and end game
	public void Listeners()
	{
		spin.addActionListener(new spinning());
		endGame.addActionListener(new goBack());
		rules.addActionListener(new procedure());
	}


	private class spinning implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			
			//prevents the user from clicking spin before the spin function has finished
			spin.setEnabled(false);
		
			//removing $5 from the player to spin the slot.
			plyr.changeMoney(-5);
			if (plyr.getMoney() < 5) {
				flag = true;
			}
			//array list used to implement the spin
			ArrayList<String> symbols = new ArrayList<String>();
			symbols.add("Cherry.jpg"); // index 0
			symbols.add("Coin.jpg"); // index 1
			symbols.add("DollarSign.jpg"); // index 2
			symbols.add("FourLeafClover.jpg");// index 3
			symbols.add("Diamond.jpg"); // index 4
			symbols.add("Seven.jpg"); // index5
			
			
			int first_slot_num;
			int second_slot_num;
			int third_slot_num;
			first_slot_val = "";
			second_slot_val = "";
			third_slot_val = "";

			do
			{
				//creating the results of the slots but not showing them yet
				first_slot_num = (int) (Math.random() * 100);
				second_slot_num = (int) (Math.random() * 100);
				third_slot_num = (int) (Math.random() * 100);
				//setting the first slots to the appropriate result 
				if (first_slot_num <= 35)
				{
					first_slot_val = "Cherry";
					ImageIcon slot1 = new ImageIcon("Slots_Images/Cherry.jpg");
					Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot1symbol = new ImageIcon(slot1image);
					leftslot.setIcon(slot1symbol);

				} else if (first_slot_num <= 52)
				{
					first_slot_val = "Coin";
					ImageIcon slot1 = new ImageIcon("Slots_Images/Coin.jpg");
					Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot1symbol = new ImageIcon(slot1image);
					leftslot.setIcon(slot1symbol);
				} else if (first_slot_num <= 67)
				{
					first_slot_val = "Dollar Sign";
					ImageIcon slot1 = new ImageIcon("Slots_Images/DollarSign.jpg");
					Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot1symbol = new ImageIcon(slot1image);
					leftslot.setIcon(slot1symbol);
				} else if (first_slot_num <= 80)
				{
					first_slot_val = "Four Leaf Clover";
					ImageIcon slot1 = new ImageIcon("Slots_Images/FourLeafClover.jpg");
					Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot1symbol = new ImageIcon(slot1image);
					leftslot.setIcon(slot1symbol);
				} else if (first_slot_num <= 91)
				{
					ImageIcon slot1 = new ImageIcon("Slots_Images/Diamond.jpg");
					Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot1symbol = new ImageIcon(slot1image);
					first_slot_val = "Diamond";

				} else
				{
					ImageIcon slot1 = new ImageIcon("Slots_Images/Seven.jpg");
					Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot1symbol = new ImageIcon(slot1image);

					first_slot_val = "Seven";
				}

				
				//setting the second slot to the appropriate result 
				if (second_slot_num <= 35)
				{
					ImageIcon slot2 = new ImageIcon("Slots_Images/Cherry.jpg");
					Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot2symbol = new ImageIcon(slot2image);
					second_slot_val = "Cherry";
				} else if (second_slot_num <= 52)
				{
					ImageIcon slot2 = new ImageIcon("Slots_Images/Coin.jpg");
					Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot2symbol = new ImageIcon(slot2image);
					second_slot_val = "Coin";
				} else if (second_slot_num <= 67)
				{
					ImageIcon slot2 = new ImageIcon("Slots_Images/DollarSign.jpg");
					Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot2symbol = new ImageIcon(slot2image);
					second_slot_val = "Dollar Sign";
				} else if (second_slot_num <= 80)
				{
					ImageIcon slot2 = new ImageIcon("Slots_Images/FourLeafClover.jpg");
					Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot2symbol = new ImageIcon(slot2image);
					second_slot_val = "Four Leaf Clover";
				} else if (second_slot_num <= 91)
				{
					ImageIcon slot2 = new ImageIcon("Slots_Images/Diamond.jpg");
					Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot2symbol = new ImageIcon(slot2image);
					second_slot_val = "Diamond";
				} else
				{
					ImageIcon slot2 = new ImageIcon("Slots_Images/Seven.jpg");
					Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot2symbol = new ImageIcon(slot2image);
					second_slot_val = "Seven";
				}
				
				//setting the third slot to the appropriate result 
				if (third_slot_num <= 35)
				{
					ImageIcon slot3 = new ImageIcon("Slots_Images/Cherry.jpg");
					Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot3symbol = new ImageIcon(slot3image);
					rightslot.setIcon(slot3symbol);
					third_slot_val = "Cherry";
				} else if (third_slot_num <= 52)
				{
					ImageIcon slot3 = new ImageIcon("Slots_Images/Coin.jpg");
					Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot3symbol = new ImageIcon(slot3image);
					third_slot_val = "Coin";
				} else if (third_slot_num <= 67)
				{
					ImageIcon slot3 = new ImageIcon("Slots_Images/DollarSign.jpg");
					Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot3symbol = new ImageIcon(slot3image);
					third_slot_val = "Dollar Sign";
				} else if (third_slot_num <= 80)
				{
					ImageIcon slot3 = new ImageIcon("Slots_Images/FourLeafClover.jpg");
					Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot3symbol = new ImageIcon(slot3image);
					third_slot_val = "Four Leaf Clover";
				} else if (third_slot_num <= 91)
				{
					ImageIcon slot3 = new ImageIcon("Slots_Images/Diamond.jpg");
					Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot3symbol = new ImageIcon(slot3image);
					third_slot_val = "Diamond";
				} else
				{
					ImageIcon slot3 = new ImageIcon("Slots_Images/Seven.jpg");
					Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
					slot3symbol = new ImageIcon(slot3image);
					third_slot_val = "Seven";

				}

			} while (!(first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)) && losingstreak >= 4);
			//if the player has lost the previous 4 spins then keep rerolling until one of them are a winner

			//set up the variables that we will need for the spinning effect
			temp1 = new ImageIcon(slot1image);
			temp2 = new ImageIcon(slot2image);
			temp3 = new ImageIcon(slot3image);
			n = 2000;
			slot1index = 200;
			slot2index = 100;
			slot3index = 50;
			
			// the function that will make the images look like they spin

			Thread t = new Thread()
			{
				public void run()
				{
					//run a for loop 2000 times 
					for (int i = 1; i <= n; i++)
					{
						try
						{
							Thread.sleep(2);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						//slot1index will increment by 200 every time it enters this if
						//if there has been over 1000 iterations it will no longer update the picture for the first slot
						if (i == slot1index&& i < 1000)
						{
							//if it is time to update the picture for slot 1 and it is not at the end index of the list that holds all the pictures 							
							if (spin1 <= 5 )
							{
								ImageIcon slot1 = new ImageIcon("Slots_Images/" + symbols.get(spin1));
								Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp1 = new ImageIcon(slot1image);

								leftslot.setIcon(temp1);

								slot1index = slot1index + 200;
								spin1++;
							}
							//reset the index of the list array for the first slot if it is about to go out of index
							else {
								spin1 = 0;
								slot1 = new ImageIcon("Slots_Images/" + symbols.get(spin1));
								Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp1 = new ImageIcon(slot1image);
								leftslot.setIcon(temp1);
								slot1index = slot1index + 200;
								spin1++;
							}
							//last update of the picture for the first slot
						} else if (i > 1000)
							leftslot.setIcon(slot1symbol);
						//slot2index will increment by 100 every time it enters this if
						//if there has been over 1500 iterations it will no longer update the picture for the second slot
						if (i == slot2index && i < 1500)
						{
							//if it is time to update the picture for slot 2 and it is not at the end index of the list that holds all the pictures 
							if (spin2 <= 5)
							{
								slot2 = new ImageIcon("Slots_Images/" + symbols.get(spin2));
								Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp2 = new ImageIcon(slot2image);
								middleslot.setIcon(temp2);
								slot2index = slot2index + 100;
								spin2++;
							} 
							//reset the index of the list array for the second slot if it is about to go out of index
							else
							{
								spin2 = 0;
								slot2 = new ImageIcon("Slots_Images/" + symbols.get(spin2));
								Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp2 = new ImageIcon(slot2image);
								middleslot.setIcon(temp2);
								slot2index = slot2index + 100;
								spin2++;
							}

						} 
						else if (i > 1500)					
							middleslot.setIcon(slot2symbol);
						//slot3index will increment by 50 every time it enters this if
						//if there has been over 2000 iterations it will no longer update the picture for the third slot
						if (i == slot3index && i < 2000)
						{
							//if it is time to update the picture for slot 3 and it is not at the end index of the list that holds all the pictures 
							if (spin3 <= 5)
							{
								slot3 = new ImageIcon("Slots_Images/" + symbols.get(spin3));
								Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp3 = new ImageIcon(slot3image);
								rightslot.setIcon(temp3);
								slot3index = slot3index + 50;
								spin3++;
							}
							//reset the index of the list array for the third slot if it is about to go out of index
							else
							{
								spin3 = 0;
								slot3 = new ImageIcon("Slots_Images/" + symbols.get(spin3));
								Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp3 = new ImageIcon(slot3image);
								rightslot.setIcon(temp3);
								slot3index = slot3index + 50;
								spin3++;
							}

						} else if (i == 2000)
							rightslot.setIcon(slot3symbol);
					}

					//determine if they win  and how much or if the losing streak is continued 
					if ((first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)))
					{
						losingstreak = 0;
					}

					if (
						first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
								&& first_slot_val.equals("Seven")
					)
					{
						payout = 5000;
						plyr.changeMoney(5000);

					} else if (
						first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
								&& first_slot_val.equals("Diamond")
					)
					{
						plyr.changeMoney(250);
						payout = 250;
					} else if (
						first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
								&& first_slot_val.equals("Four Leaf Clover")
					)
					{
						plyr.changeMoney(100);
						payout = 100;
					} else if (
						first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
								&& first_slot_val.equals("Dollar Sign")
					)
					{
						plyr.changeMoney(25);
						payout = 25;
					} else if (
						first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
								&& first_slot_val.equals("Coin")
					)
					{
						plyr.changeMoney(10);
						payout = 10;
					} else if (
						first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
								&& first_slot_val.equals("Cherry")
					)
					{
						plyr.changeMoney(5);
						payout = 5;
					} else
					{
						losingstreak++;
						payout = 0;
					}
					//update labels 
					earning.setText("Payout: $" + payout);
					money.setText("Money: $ " + plyr.getMoney());
					//re enabled the button for use
					//force the user to leave if they dont have enough money to play
					if(flag)
					{
						frame.dispose();
						menuFrame.setVisible(true);
						
					}
					spin.setEnabled(true);
					//write to the file and delete line if there are too many records
					try
					{
						pw = new PrintWriter(new FileOutputStream(file, true));

						if (payout == 5)
						{
							pw.append("Broke even playing Slots\n");
						} else if (payout < 5)
						{
							pw.append("Lost $5 playing Slots\n");
						} else
						{
							pw.append("Gained $" + (payout - 5) + " playing Slots\n");
						}
					} catch (Exception e1)
					{
						System.out.println("FILE IO ERROR IN SLOTS");
					}
					pw.close();
					
				}
				
				
			};
			t.start();
			
			
		}

		
	}
	//goes back to game menu
	private class goBack implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{

			menuFrame.setVisible(true);
			frame.dispose();
		}
	}
	
	
//displays a message box of the rules
	private class procedure implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(frame,
					"WELCOME TO SLOTS\n"
							+ "In this slots game you every spin will cot you $5\n"
							+ "The payouts are found to the right in the legend going from most to least likely\n"
							+ "Click the lever to spin when you are ready!");

		}
	}

	public static void removeLineFromFile(String file)
	{
		// This function deltes the first line of a file by copying the contents of the
		// original file except for the first line
// and then pasting it to a new file. The old file is delted and the new one is renamed the same as the old one.
		int c = 0;
		try
		{

			File inFile = new File(file);

			if (!inFile.isFile())
			{
				System.out.println("Parameter is not an existing file");
				return;
			}

			// Construct the new file that will later be renamed to the original filename.
			File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

			String line = null;

			// Read from the original file and write to the new
			// unless content matches data to be removed.
			while ((line = br.readLine()) != null)
			{

				if (c != 0)
				{
					pw.println(line);
					pw.flush();
					c++;
				}
				c++;
			}
			pw.close();
			br.close();

			// Delete the original file
			if (!inFile.delete())
			{
				System.out.println("Could not delete file");
				return;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(inFile))
				System.out.println("Could not rename file");

		} catch (FileNotFoundException ex)
		{
			ex.printStackTrace();
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
	}
}