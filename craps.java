package cp317;
import java.io.*;
import java.util.Scanner; 
/*
craps

function:
get listener -> get bets
rolls-> generate random numbers
check-> corespond those bets with the inputs
show results -> shows the result
write - > global function that writes to file





 */

public class craps {
	static boolean snakeeyes = false;
	static boolean aceduece = false; 
	static boolean nat7 = false;
	static boolean nat11  = false;
	static boolean boxcars = false;
	static int total = 1000;
	public static int spin(int bet)
	{
		

		int target= 0;

		boolean done = false;
		for(int i = 0; i < 100 ; i++)
		{
			target = 0;
			done = false;
			while(!done)
			{
				int roll = (int) (Math.random()*(12-2+1) + 2);
				System.out.println("ROLL IS: " + roll);
				if(snakeeyes || aceduece || nat7||nat11||boxcars)
				{
					if(snakeeyes && roll == 2 )
					{
						total += 5*bet;
						done = true;
						System.out.println("YOU GOT A SNAKEEYES AND CALLED IT");
					}
					else if(aceduece  && roll == 3)
					{
						total += 5*bet;
						done = true;
						System.out.println("YOU GOT AN ACE DUECE AND CALLED IT");
					}
					else if(nat7 && roll == 7)
					{
						total += 5*bet;
						done = true;
						System.out.println("YOU GOT A NATURAL 7 AND CALLED IT");
					}
					else if(nat11 && roll == 11)
					{
						total += 5*bet;
						done = true;
						System.out.println("YOU GOT A NATURAL 11 AND CALLED IT");
					}
					else if(boxcars && roll == 12)
					{
						total += 5*bet;
						done = true;
						System.out.println("YOU GOT BOXCARS AND CALLED IT");
					}
					else
					{
						total -= bet;
						done = true;
						System.out.println("ALL PROPS FAILED");
					}
				}
				else {

					if ((roll == 7 || roll == 11) && target == 0)
					{
						total += 2*bet;
						done = true;
						System.out.println("NATUARLLY");
					}
					else if((roll == 2|| roll == 3 || roll == 12) && target == 0)
					{
						total -= bet;
						done = true;
						System.out.println("CRAPS");
					}
					else if(target == 0)
					{
						target = roll;
						System.out.println("LINE SET AT: "+ roll);

					}
					else if(target > 1 && roll == 7)
					{
						total -= bet;
						done = true;
						System.out.println("CRAPPED OUT ON THE LINE");
					}
					else if(target == roll)
					{
						total += 2*bet;
						done = true;
						System.out.println("YOU GOT THE LINE");
					}
				}
				System.out.println("AT END OF LOOP YOUR SCORE IS: " + total);
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		return 0;
	}
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		int bet = Integer.parseInt(scan.nextLine());
		total = Integer.parseInt(scan.nextLine());
		spin(bet);
		scan.close();
	}
}


