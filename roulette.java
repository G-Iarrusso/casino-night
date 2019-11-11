package roulette;

import java.util.Random;
import java.util.Scanner;

public class roulette {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Random generator = new Random();
		double total = 0;
		double amount;
		int choice, colour = 0;
		int number;
		int rouletteNum, colourNum;
		int result;
		char response = 'y';

		while (response == 'y') {
		System.out.print("Enter your bet amount: ");
		amount = keyboard.nextDouble();
		
		// choose between even, odd or choose your own number
		System.out.print("0 - Even\n1 - Odd\n2 - Number\n");
		choice = -1;
		while (choice < 0 || choice > 2) {
			System.out.print("Place your bet on: ");
			choice = keyboard.nextInt();
			System.out.print("Choose your colour (0 - red, 1 - black): ");
			colour = keyboard.nextInt();
		}
		number = 0;
		
		// choose your own number
		if (choice == 2) {
			while (number < 1 || number > 36) {
				System.out.print("Place your bet on number from 1-36: ");
				number = keyboard.nextInt();
			}
		}
		
		// random number generator & colour generator
		rouletteNum = generator.nextInt(37);
		colourNum = generator.nextInt(2);
		System.out.println("Roulette number: " + rouletteNum);
		if (colourNum == 0) {
			System.out.println("Colour: Red");
		}
		else {
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
			System.out.println("You win");
			System.out.printf("You have won $%.2f \n", amount);

		} else {
			System.out.println("You lose");
			System.out.printf("You have lost $%.2f \n", amount);
		}
		System.out.print("\nPlay again? (y or n)?");
		response = keyboard.next().charAt(0);
		}
	}

}
