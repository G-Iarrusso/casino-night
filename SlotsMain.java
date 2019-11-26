package cp317;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class SlotsMain
{

	public static void main(String args[])
	{
		SlotsMain s = new SlotsMain();
		Player p = new Player("Matt", 10);
		JFrame n = new JFrame();
		s.StartupSlots(p, n);
	}

	// creating labels
	JLabel legend = new JLabel("Legend");
	JLabel money = new JLabel("Money: $");
	JLabel earning = new JLabel("Payout: $0");
	JLabel legendval = new JLabel("<html>$5<br><br><br>" + "$10<br><br><br>" + "$25<br><br><br>" + "$100<br><br><br>"
			+ "$250<br><br><br>" + "$1000</html>");
	ImageIcon slot1 = new ImageIcon("Slots_Images/Cherry.jpg");
	Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
	ImageIcon slot1symbol = new ImageIcon(slot1image);

	ImageIcon slot2 = new ImageIcon("Slots_Images/Coin.jpg");
	Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
	ImageIcon slot2symbol = new ImageIcon(slot2image);

	ImageIcon slot3 = new ImageIcon("Slots_Images/Diamond.jpg");
	Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
	ImageIcon slot3symbol = new ImageIcon(slot3image);

	// below used for legend
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

	JButton leftslot = new JButton();
	JButton middleslot = new JButton();
	JButton rightslot = new JButton();
	Player plyr;
	JFrame menuFrame;
	// buttons
	JButton spin = new JButton("Spin");
	JButton endGame = new JButton("End Game");
	JButton rules = new JButton("Rules");

	JLabel Cherry = new JLabel();
	JLabel Coin = new JLabel();
	JLabel DollarSign = new JLabel();
	JLabel FourLeafClover = new JLabel();
	JLabel Diamond = new JLabel();
	JLabel Seven = new JLabel();
	JLabel counter = new JLabel("0");

	int losingstreak = 0;

	File file = new File("user_records.txt");
	File f = new File("Slots_Images");
	// going to need a file of slots images

	final JFrame frame = new JFrame("Slots");

	public void StartupSlots(Player p, JFrame mainFrame)
	{
		frame.setSize(1400, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuFrame = mainFrame;
		plyr = p;

		ImageIcon icon = new ImageIcon("Slots_Images/Slot_Machine.png");
		Image iconTemp = icon.getImage().getScaledInstance(1400, 900, Image.SCALE_DEFAULT);
		ImageIcon background = new ImageIcon(iconTemp);
		JLabel contentPane = new JLabel();

		contentPane.setIcon(background);

		contentPane.setLayout(new BorderLayout());
		frame.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setLayout(null);

		legendval.setBounds(1300, 200, 100, 700);
		legendval.setFont(new Font("Serif", Font.PLAIN, 30));
		leftslot.setBounds(495, 310, 99, 125);
		middleslot.setBounds(615, 310, 99, 125);
		rightslot.setBounds(730, 310, 99, 125);
		legend.setBounds(1200, 100, 100, 100);
		legend.setFont(new Font("Serif", Font.PLAIN, 30));
		endGame.setBounds(0, 0, 200, 100);
		endGame.setFont(new Font("Serif", Font.PLAIN, 30));
		rules.setBounds(1200, 0, 200, 100);
		rules.setFont(new Font("Serif", Font.PLAIN, 30));
		spin.setBounds(560, 590, 200, 100);
		spin.setFont(new Font("Serif", Font.PLAIN, 30));
		money.setBounds(635, 800, 100, 100);
		money.setFont(new Font("Serif", Font.PLAIN, 30));
		earning.setAlignmentX(JTextField.CENTER);
		earning.setBounds(635, 20, 300, 100);
		earning.setFont(new Font("Serif", Font.PLAIN, 30));
		counter.setBounds(100, 400, 100, 100);

		Cherry.setBounds(1200, 200, 100, 100);
		Coin.setBounds(1200, 300, 100, 100);
		DollarSign.setBounds(1200, 400, 100, 100);
		FourLeafClover.setBounds(1200, 500, 100, 100);
		Diamond.setBounds(1200, 600, 100, 100);
		Seven.setBounds(1200, 700, 100, 100);

		panel.add(counter);
		panel.add(legendval);
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

	public void Listeners()
	{
		spin.addActionListener(new spinning());
		endGame.addActionListener(new goBack());
		rules.addActionListener(new procedure());
	}

	// public void strtCode line 398
	int pp69420 = 0;

	private class spinning implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

			plyr.changeMoney(-5);
			// implelment thread line 400
			ArrayList<String> symbols = new ArrayList<String>();
			symbols.add("Cherry.jpg"); // index 0
			symbols.add("Coin.jpg"); // index 1
			symbols.add("DollarSign.jpg"); // index 2
			symbols.add("FourLeafClover.jpg");// index 3
			symbols.add("Diamond.jpg"); // index 4
			symbols.add("Seven.jpg"); // index5
			int payout = 0;
			int first_slot_num;
			int second_slot_num;
			int third_slot_num;
			String first_slot_val = "";
			String second_slot_val = "";
			String third_slot_val = "";
			ImageIcon slot1symbol;
			ImageIcon slot2symbol;
			ImageIcon slot3symbol;

			// System.out.println("\nresults are:");

			do
			{

				first_slot_num = (int) (Math.random() * 100);
				second_slot_num = (int) (Math.random() * 100);
				third_slot_num = (int) (Math.random() * 100);

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

			} while (
				!(first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)) && losingstreak >= 4
			);
			//

			// attempt to make things spin

			Thread t = new Thread()
			{
				public void run()
				{
					counter.setText("" + pp69420++);
					ImageIcon temp1 = new ImageIcon(slot1image);
					ImageIcon temp2 = new ImageIcon(slot2image);
					ImageIcon temp3 = new ImageIcon(slot3image);
					int n = 300;
					int slot1index = 50;
					int slot2index = 35;
					int slot3index = 20;
					int spin1 = 0, spin2 = 0, spin3 = 0;
					for (int i = 1; i <= n; i++)
					{
						try {
							Thread.sleep(10);
						}
						catch(InterruptedException e) {
							e.printStackTrace();
						}
						if (i == slot1index)
						{
							if (spin1 <= 5)
							{
								ImageIcon slot1 = new ImageIcon("Slots_Images/" + symbols.get(spin1));
								Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp1 = new ImageIcon(slot1image);

								leftslot.setIcon(temp1);

								slot1index = slot1index + 50;
								spin1++;
							} else
							{
								spin1 = 0;
								slot1 = new ImageIcon("Slots_Images/" + symbols.get(spin1));
								Image slot1image = slot1.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp1 = new ImageIcon(slot1image);
								leftslot.setIcon(temp1);
								slot1index = slot1index + 50;
								spin1++;
							}
						}
						if (i == slot2index)
						{
							if (spin2 <= 5)
							{
								slot2 = new ImageIcon("Slots_Images/" + symbols.get(spin2));
								Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp2 = new ImageIcon(slot2image);
								middleslot.setIcon(temp2);
								slot2index = slot2index + 30;
								spin2++;
							} else
							{
								spin2 = 0;
								slot2 = new ImageIcon("Slots_Images/" + symbols.get(spin2));
								Image slot2image = slot2.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp2 = new ImageIcon(slot2image);
								middleslot.setIcon(temp2);
								slot2index = slot2index + 30;
								spin2++;
							}

						}
						if (i == slot3index)
						{
							if (spin3 <= 5)
							{
								slot3 = new ImageIcon("Slots_Images/" + symbols.get(spin3));
								Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp3 = new ImageIcon(slot3image);
								rightslot.setIcon(temp3);
								slot3index = slot3index + 20;
								spin3++;
							} else
							{
								spin3 = 0;
								slot3 = new ImageIcon("Slots_Images/" + symbols.get(spin3));
								Image slot3image = slot3.getImage().getScaledInstance(99, 125, Image.SCALE_DEFAULT);
								temp3 = new ImageIcon(slot3image);
								rightslot.setIcon(temp3);
								slot3index = slot3index + 20;
								spin3++;
							}
						}

					}
				}
			};
			t.start();

			if ((first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)))
			{
				losingstreak = 0;
			}

			if (
				first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)
						&& first_slot_val.equals("Seven")
			)
			{
				payout = 1000;
				plyr.changeMoney(1000);

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
			earning.setText("Payout: $" + payout);

			leftslot.setIcon(slot1symbol);

			middleslot.setIcon(slot2symbol);

			rightslot.setIcon(slot3symbol);

			money.setText("Money: $ " + plyr.getMoney());
		}
	}

	private class goBack implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			/*
			 * done = true; menuFrame.setVisible(true); frame.dispose();
			 */}
	}

	private class procedure implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// UIManager.put("OptionPane.okButtonText", "Got it");
			JOptionPane.showMessageDialog(frame,
					"Welcome to slots " + plyr.getID() + ".\n\n\n"
							+ "In this slots game you every spin will cot you $5.\n"
							+ "The payouts are found to the right in the legend going from most to least likely.\n"
							+ "Click spin when you are ready!");
			// UIManager.put("OptionPane.okButtonText", "ok");
		}
	}
}
