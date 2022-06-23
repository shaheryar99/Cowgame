/** 
 * @author Shaheryar Syed
 * @ucid 30052162
 * @Assignment 1
 * Random Dice Generation from:
 * https://teamtreehouse.com/community/how-does-mathfloormathrandom-6-1-work
 */

package cowgame;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CowGame {
	
	
	// Main method, only used to invoke promptInput method
	public static void main(String[] args) {
		
		// Did not want to call the main function so I created a new method
			promptInput();
	}
	
	// Prompt for user input and determine what to do with that input
	static void promptInput() {
		
		// Scanner Class loading in
			Scanner input = new Scanner(System.in);
				
				// Prompt user for input
				System.out.print("\nHello, Welcome to the Game of Cow\n\nSelect any option from below\n\n1. Problem 1: Rolling a die\n2. Problem 2: Expected Value\n3. Problem 3: Expected Rolls\n4. Problem 4: The Computer's Turn\n5. Problem 5: The Computer's Strategy\n6. Problem 6: The Solitaire Cow\n7. Problem 7: Computer vs. Computer\n8. Exit");
				System.out.print("\n\nEnter the option: ");
				
				// Read the user input
				int selection = input.nextInt();
				
				// Determine what to do with user input
				if (selection == 1) {
					pR1();
				}
				else if (selection == 2) {
					pR2();
				}
				else if (selection == 3) {
					pR3();
				}
				else if (selection == 4) {
					pR4();
				}
				else if (selection == 5) {
					pR5();
				}
				else if (selection == 6) {
					pR6();
				}
				else if (selection == 7) {
					pR7();
				}
				else if (selection == 8) {
					System.out.print("Thank you for playing the Cow game.");
					System.exit(0);
				}
				else {
					System.out.print("You have selected an invalid input, Please try again.\n");
					promptInput();
				}
				
				// Close the input to prevent resource leak
				input.close();
		
	}
	
	// Problem 1 Method
	static void pR1() {
		
		// Roll a random number between 1 - 6
		int roll1 = (int)(Math.random()*6+1);
		
		// Print that output out 
		System.out.println("You selected a random role and got: " + roll1);
		
		// Invoke the input prompt method once again to continue the program
		promptInput();
	}
	
	// Problem 2 Method
	static void pR2() {
		
		// Create new scanner function to ask how many roles the user wants
		Scanner pr2RolesScanner = new Scanner(System.in);
		
		// User input for amount of roles
		System.out.print("How many random roles would you like to average?: ");
		
		// Grab this number from user
		int totalroles = pr2RolesScanner.nextInt();
		
		// Define initial variables
		int roles = 0;
		int sum = 0;
		
		// Loop that checks total roles to number of current roles, while doing summation
		while(roles <= totalroles) {
			int number = (int)(Math.random()*6+1);
			sum += number;
			roles++;
		}
		
		// Calculate the average using double for decimal points
		double average = (double) sum/totalroles;
		
		// Print the calculated average
		System.out.println("The estimated average is: " + average);
		
		
		// Go back to prompt function
		promptInput();
		
		// Close the scanner to prevent resource leak
		pr2RolesScanner.close();
	}

	// Problem 3 Method
	static void pR3() {
	
		// Scanner Input function for number of rolls
		Scanner input = new Scanner(System.in);
		
		// Prompt for number of roles 
		System.out.print("How many turns should I stimulate?: ");
		
		// Store number of stimulated rolls
		int stimrolls = input.nextInt();
		
		// Define initial variables
		int roles = 0;
		int cowout = 0;
		
		// While loop that counts the number of roles and assesses other factors
		while (roles < stimrolls) {
			int number = (int)(Math.random()*6+1);
			roles++;
			
			// Check to see if number = 1 for cowout
			if (number == 1) {
				cowout++;
			}
		}
		
		// Calculate estimated number of times we can get a cowout
		double average = (double) stimrolls/cowout;
		
		// Show number of turns to stimulate
		System.out.println("Now stimulating " + roles + " turns...");
		
		DecimalFormat two = new DecimalFormat("0.00");
		
		// Show average per cow out
		System.out.println("The estimated expectation for rolling a cow is every: " + two.format(average) + " rounds");
		System.out.println(cowout);
		
		// Go back to prompt function
		promptInput();
		
		// Close scanner class
		input.close();
		
	}
	
	//Problem 4 Method
	static void pR4() {
		
		// Define initial variable
		int totalscore = 0;
		
		// While loop controlling score and randomly rolling
		while (totalscore <= 20) {
			int number = (int)(Math.random()*6+1);
			System.out.println("The computer just rolled a: " + number);
			totalscore += number;
			
			// If cow out then:
			if (number == 1) {
				totalscore = 0;
				System.out.println("That's a cow out!");
				break;
			}
			
			// If the score hits 20
			if (totalscore == 20) {
				break;
			}
		}
		
		System.out.println("The total turn score is: " + totalscore);
		
		promptInput();
	}
	
	// Problem 5 Method
	static void pR5() {
		
		// Activate the scanner
		
		Scanner score = new Scanner(System.in);
		
		// Ask for the initial score
		System.out.print("Please enter the initial score: ");
		
		// Read the initial score from user input
		int Scoreinput = score.nextInt();
		
		// Define some variables
		int totalscore = 0;
		int turnscore = 0;
		
		// What to do if the score is less than 80
		if (Scoreinput <= 79)
		{
			
			totalscore = Scoreinput;
			
			// Keep going until you are +20 from the user inputted score
			while (totalscore <= Scoreinput + 20) {
				
				// Just let the program do its thing bro
				int number = (int)(Math.random()*6+1);
				System.out.println("The computer rolled a: " + number);
				totalscore += number;
				turnscore += number;
				
				// What happens if we have a cow out
				if (number == 1) {
					turnscore = 0;
					totalscore = Scoreinput;
					System.out.println("\nThat's a cow out! The turn ends here, Resetting turn score");
					break;
				}
			}
			
			System.out.println("\nThe turn score is: " + turnscore);
			System.out.println("\nThe new total score is: " + totalscore);
		}
		
		else if (Scoreinput >= 80) {
			totalscore = Scoreinput;
			
			// Go for the 100
			while (totalscore <= 100) {
				
				int number = (int)(Math.random()*6+1);
				System.out.println("The computer rolled a: " + number);
				totalscore += number;
				turnscore += number;
				
				if (number == 1) {
					turnscore = 0;
					totalscore = Scoreinput;
					System.out.println("\nThat's a cow out! The turn ends here, Resetting turn score");
					break;
				}
			}
			
			System.out.println("\nThe turn score is: " + turnscore);
			System.out.println("\nThe new total score is: " + totalscore);
		}
		
		// Go back to prompt function
		promptInput();
		
		// Close the scanner to prevent resource leak
		score.close();
		
		
	}
	
	// Problem 6 Method
	static void pR6() {
		
		int totalscore = 0;
		int turnscore = 0;
		
		while (totalscore < 100) {
			
			turnscore = 0;
			
			System.out.println("\n****NEW TURN****");
			
			while (turnscore < 20) {
				
				int number = (int)(Math.random()*6+1);
				System.out.println("The computer rolled a: " + number);
				totalscore += number;
				turnscore += number;
				
				if (number == 1) {
					totalscore -= turnscore;
					turnscore = 0;
					System.out.println("\nThat's a cow out! The turn ends here, Resetting turn score.\n");
					System.out.println("Turn score " + turnscore);
					System.out.println("Total Score " + totalscore + "\n");
					System.out.println("****NEW TURN****");
				}
			
			}
			System.out.println("\nTurn score " + turnscore);
			System.out.println("Total Score " + totalscore);
		}
			System.out.println("\nTURN SCORE: " + turnscore);
			System.out.println("TOTAL SCORE: " + totalscore);
			System.out.println("\n***THE END***");
			
			promptInput();
	}

	// Generate a random player turn
	static int playerTurn() {
		
		double player;
		player = (Math.random());
		
		int roll;
		
		if (player <= 0.5) { 
			roll = 0;
		}
		else {
			roll = 1;
		}
		
		return roll;
		
	}
	
	// Problem 7 Method
	static void pR7() {
		
		int turn = playerTurn();
		int totalscore1 = 0;
		int totalscore2 = 0;
		int turnscore1 = 0;
		int turnscore2 = 0;
		
		if (turn == 0) {
			System.out.println("** PLAYER 1 PLAYS FIRST **\n");
		}
		else {
			System.out.println("** PLAYER 2 PLAYS FIRST **\n");
		}
		
		while (totalscore1 <= 100 && totalscore2 <= 100) {
			turnscore1 = 0;
			turnscore2 = 0;
			
			while (turnscore1 < 20 && turnscore2 < 20) {
				
				if (turn == 0) {
					//System.out.println("** IT IS PLAYER 1's TURN **");
					int number = (int)(Math.random()*6 + 1);
					System.out.println("Player 1 rolled a: " + number);
					totalscore1 += number;
					turnscore1 += number;
					
					if (number == 1) {
						totalscore1 -= turnscore1;
						turnscore1 = 0;
						System.out.println("Cow out. Switching turns.\n");
						System.out.println("Turn score: " + turnscore1 + "\n");
						//System.out.println("\nPLAYER 1'S SCORE: " + totalscore1);
						//System.out.println("PLAYER 2'S SCORE: " + totalscore2 + "\n");
						turn = 1;
					}
					
				}
				
				if (turn == 1) {
					//System.out.println("** IT IS PLAYER 2's TURN **");
					int number = (int)(Math.random()*6 + 1);
					System.out.println("Player 2 rolled a: " + number);
					totalscore2 += number;
					turnscore2 += number;
					
					if (number == 1) {
						totalscore2 -= turnscore2;
						turnscore2 = 0;
						System.out.println("Cow out. Switching turns.\n");
						System.out.println("Turn score: " + turnscore2 + "\n");
						System.out.println("PLAYER 1'S SCORE: " + totalscore1);
						System.out.println("PLAYER 2'S SCORE: " + totalscore2 + "\n");
						turn = 0;
					}
					
					
				}
				
				
			}
			
			if (turn == 0) { 
				
				System.out.println("Turn score: " + turnscore1);
				turn = 1; 
				
			}
			else {
				System.out.println("Turn score: " + turnscore2);
				turn = 0;
				
			
			}
			
			System.out.println("\nPLAYER 1'S SCORE: " + totalscore1);
			System.out.println("PLAYER 2'S SCORE: " + totalscore2 + "\n");
			
			if (totalscore1 >= 100) {
				System.out.println("Final Score: " + totalscore1 + " vs " + totalscore2);
				System.out.println("Player 1 wins.");
				
			}
			
			else if (totalscore2 >= 100) {
				System.out.println("Final Score: " + totalscore1 + " vs " + totalscore2);
				System.out.println("Player 2 wins.");
			}
			
		}
	
		promptInput();
		
	}
	
}