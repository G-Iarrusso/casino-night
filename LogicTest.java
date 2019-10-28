
public class LogicTest
{

	public static void main(String[] args)
	{
		int losingstreak = 0;

		for (int i = 0; i < 2000000000; i++)
		{
			System.out.println(i);
			int first_slot_num;
			int second_slot_num;
			int third_slot_num;
			String first_slot_val = "";
			String second_slot_val = "";
			String third_slot_val = "";
			//System.out.println("\nresults are:");
			do 
			{
				first_slot_num = (int) (Math.random() * 100);
				second_slot_num = (int) (Math.random() * 100);
				third_slot_num = (int) (Math.random() * 100);
			
			
			
			if (first_slot_num <= 45)
			{
				first_slot_val = "Cherries";
			}
			else if (first_slot_num <= 65)
			{
				first_slot_val = "Strawberry";
			}
			else if (first_slot_num <= 80)
			{
				first_slot_val = "Coin";
			}
			else if (first_slot_num <= 90)
			{
				first_slot_val = "Coinsx3";
			}
			else if (first_slot_num <= 95)
			{
				first_slot_val = "Four Leaf Clover";
			}
			else if (first_slot_num <= 98)
			{
				first_slot_val = "Diamond";
			}
			else if (first_slot_num <= 100)
			{
				first_slot_val = "Seven";
			}

			if (second_slot_num <= 45)
			{
				second_slot_val = "Cherries";
			}
			else if (second_slot_num <= 65)
			{
				second_slot_val = "Strawberry";
			}
			else if (second_slot_num <= 80)
			{
				second_slot_val = "Coin";
			}
			else if (second_slot_num <= 90)
			{
				second_slot_val = "Coinx3";
			}
			else if (second_slot_num <= 95)
			{
				second_slot_val = "Four Leaf Clover";
			}
			else if (second_slot_num <= 98)
			{
				second_slot_val = "Diamond";
			}
			else if (second_slot_num <= 100)
			{
				second_slot_val = "Seven";
			}

			if (third_slot_num <= 45)
			{
				third_slot_val = "Cherries";
			}
			else if (third_slot_num <= 65)
			{
				third_slot_val = "Strawberry";
			}
			else if (third_slot_num <= 80)
			{
				third_slot_val = "Coin";
			}
			else if (third_slot_num <= 90)
			{
				third_slot_val = "Coinsx3";
			}
			else if (third_slot_num <= 95)
			{
				third_slot_val = "Four Leaf Clover";
			}
			else if (third_slot_num <= 98)
			{
				third_slot_val = "Diamond";
			}
			else if (third_slot_num <= 100)
			{
				third_slot_val = "Seven";
			}
			
			}while(!(first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)) && losingstreak >= 5); 
			if ((first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val))) {
				losingstreak=0;
			}
			
			System.out.println("|" + first_slot_num + "|" + second_slot_num + "|" + third_slot_num + "|");
			
			try
			{
				Thread.sleep(500);
			} catch (InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			System.out.print("|" + first_slot_val + "|");
			try
			{
				Thread.sleep(750);
			} catch (InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			System.out.print(second_slot_val + "|");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
			System.out.println(third_slot_val + "|");
			
			if (first_slot_val.equals(second_slot_val) && first_slot_val.equals(third_slot_val)&&first_slot_val.equals("Diamond"))
			{
				System.out.println("\nWINNER");
				break;
			}
			else
			{
				losingstreak++;
				System.out.println("\nloser");

			}
		}
	}

}
