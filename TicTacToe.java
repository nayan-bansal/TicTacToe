package com.bridgelabwork;

import java.util.*;

public class TicTacToe {

	// Create a Board of Size 10 and allocate empty space for each block
	private static char[] board = new char[10];

	// Initialize Board for game
	private char[] createBoard() {
		for (int i = 0; i < board.length; i++)
			board[i] = '0';
		return board;
	}


	
	private int toss() {
		 int toss = (int)Math.floor(Math.random()*10%2); 
		 
		 if(toss == 1)
			 System.out.println("Toss is Lost, First Turn Computer");
		 
		 return toss;
	}
	
	// Choose X or O for user
	private char ChoiceUser() {
		Scanner scan = new Scanner(System.in);
		char user = scan.next().charAt(0);
		char computer = '0';

		if (user == 'X')
			computer = 'O';

		else
			computer = 'X';

		System.out.println("The Choice of User is : "+user);
		
		return user;
	}
	
	// Choice of Computer
	private char ChoiceComputer(char choice) {
	char computer_choice;
		if (choice == 'X')
			computer_choice = 'O';

		else
			computer_choice = 'X';

		System.out.println("The Choice of Computer is : "+computer_choice);
		
		return computer_choice;
	}

	// Display the Board

	private static char[] displayBoard() {

		System.out.println(board[1] + " | " + board[2] + " | " + board[3] + "\n" + board[4] + " | " + board[5] + " | "
				+ board[6] + "\n" + board[7] + " | " + board[8] + " | " + board[9]);
		System.out.println();
		return board;
	}

	// Make the Move

	private char[] makeMove(char choice, int index) {

		board[index] = choice;

		return board;
	}
	
	private char[] userMove(char choice) {
		
		Scanner sc = new Scanner(System.in);
		TicTacToe game = new TicTacToe();
		
		System.out.println("Enter the index you want to enter:");
		int index = sc.nextInt();

		boolean check = game.checkValue(index);
		while (check == true) {
			System.out.println("Sorry, Place Occupied. Please Enter again:");
			index = sc.nextInt();
			check = game.checkValue(index);
		}
		if (check == false)
			board = game.makeMove(choice, index);
		return board;
	}
	
	private char[] computerMove(char choice_computer) {
		
		TicTacToe game = new TicTacToe();
		int computer_index = (int) Math.floor(Math.random() * 10 % 9 + 1);

		boolean check = game.checkValue(computer_index);
		while (check == true) {
			computer_index = (int) Math.floor(Math.random() * 10 % 9 + 1);
			check = game.checkValue(computer_index);
		}
		if (check == false)
			board = game.makeMove(choice_computer, computer_index);
		return board;
	}

	// Main Logic of the Program
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
	// Welcome to the Tic Tac Toe Game
		System.out.println("Welcome to the Tic Tac Toe Game");

	//Command to create Board
		TicTacToe game = new TicTacToe();
		board = game.createBoard();

	// Choice of the User for input and computer
		char[] choice = new char[2];
		System.out.println("Enter the Input: X or O");
		 choice[0] = game.ChoiceUser();
		 choice[1] = game.ChoiceComputer(choice[0]);
		 
		 
	// Toss for the Game
		int toss = game.toss();

	//Total Iterations
		int total_cases = 9;
	
	while (total_cases != 0) {
		if (toss == 0) {

	//User Choice
		board = game.userMove(choice[0]);
	    TicTacToe.displayBoard();
	    game.checkWinner(choice[0],choice[1]);
	    
	    if(game.checkWinner(choice[0],choice[1]) == true)
	    	System.exit(0);
	    
	    board= game.computerMove(choice[1]);
	    TicTacToe.displayBoard();
	    game.checkWinner(choice[0],choice[1]);
	    if(game.checkWinner(choice[0],choice[1]) == true)
	    	System.exit(0);
			}
		else {
		
		board= game.computerMove(choice[1]);
	    TicTacToe.displayBoard();
	    game.checkWinner(choice[0],choice[1]);
	    if(game.checkWinner(choice[0],choice[1]) == true)
	    	System.exit(0);
		board = game.userMove(choice[0]);
	    TicTacToe.displayBoard();
		   game.checkWinner(choice[0],choice[1]);
		    
		 if(game.checkWinner(choice[0],choice[1]) == true)
			 System.exit(0);

		}
		total_cases--;
		}
		
	//To Check for Draw
		if(total_cases == 0)
			System.out.println("The Game is Draw");
		
	}
	private boolean checkWinner(char user, char computer) {
		// Horizontal Lines
		if ((board[1] == user && board[2] == user && board[3] == user)
				|| (board[4] == user && board[5] == user && board[6] == user)
				|| (board[7] == user && board[8] == user && board[9] == user)) {
			System.out.println("Player is the Winner");
			System.exit(0);

		} else if (board[1] == computer && board[2] == computer && board[3] == computer
				|| board[4] == computer && board[5] == computer && board[6] == computer
				|| board[7] == computer && board[8] == computer && board[9] == computer) {
			System.out.println("COmputer is the Winner");
			System.exit(0);
		}
		// Vertical Lines
		if (board[1] == user && board[4] == user && board[7] == user
				|| board[2] == user && board[5] == user && board[8] == user
				|| board[3] == user && board[6] == user && board[9] == user) {
			
			System.out.println("Player is the Winner");
			System.exit(0);
		} else if (board[1] == computer && board[4] == computer && board[7] == computer
				|| board[2] == computer && board[5] == computer && board[8] == computer
				|| board[3] == computer && board[6] == computer && board[9] == computer) {
			System.out.println("COmputer is the Winner");
			System.exit(0);
		}
		
		//Diagonals
		else if((board[1] == user && board[5] == user && board[9] == user ) || (board[3] == user && board[5] == user && board[7] == user))
			{
		System.out.println("Player is the Winner");
		System.exit(0);
		}
		else if((board[1] == computer && board[5] == computer && board[9] == computer ) || (board[3] == computer && board[5] == computer && board[7] == computer))
		{
			System.out.println("Computer is the Winner");
			System.exit(0);
		}

		return false;
	}

	private boolean checkValue(int index) {

		if (board[index] == 'X' || board[index] == 'O')
			return true;
		else
			return false;
	}
}