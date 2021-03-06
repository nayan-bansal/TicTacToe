package com.bridgelabwork;

import java.util.*;

public class TicTacToe {

	// Create a Board of Size 10 and allocate empty space for each block
	private static char[] board = new char[10];

	// Initialize Board for game
	private char[] createBoard() {
		for (int i = 0; i < board.length; i++)
			board[i] = ' ';
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
	
	private int playToWin( char computerChoice) {	
		if ((board[1] == computerChoice && board[2] == computerChoice || board[5] == computerChoice && board[7] == computerChoice
				|| board[6] == computerChoice && board[9] == computerChoice) && board[3] == ' ')
			return 3;
		else if ((board[4] == computerChoice && board[5] == computerChoice || board[3] == computerChoice && board[9] == computerChoice)
				&& board[6] == ' ')
			return 6;
		else if ((board[7] == computerChoice && board[8] == computerChoice || board[3] == computerChoice && board[6] == computerChoice
				|| board[1] == computerChoice && board[5] == computerChoice) && board[9] == ' ')
			return 9;
		else if ((board[2] == computerChoice && board[3] == computerChoice || board[5] == computerChoice && board[9] == computerChoice
				|| board[7] == computerChoice && board[4] == computerChoice) && board[1] == ' ')
			return 1;
		else if ((board[1] == computerChoice && board[3] == computerChoice || board[5] == computerChoice && board[8] == computerChoice)
				&& board[2] == ' ')
			return 2;
		else if ((board[1] == computerChoice && board[7] == computerChoice || board[5] == computerChoice && board[6] == computerChoice)
				&& board[4] == ' ')
			return 4;
		else if ((board[1] == computerChoice && board[9] == computerChoice || board[7] == computerChoice && board[3] == computerChoice
				|| board[4] == computerChoice && board[6] == computerChoice || board[2] == computerChoice && board[8] == computerChoice)
				&& board[5] == ' ')
			return 5;
		else if ((board[1] == computerChoice && board[4] == computerChoice || board[8] == computerChoice && board[9] == computerChoice
				|| board[5] == computerChoice && board[3] == computerChoice) && board[7] == ' ')
			return 7;
		else if ((board[7] == computerChoice && board[9] == computerChoice || board[2] == computerChoice && board[5] == computerChoice)
				&& board[8] == ' ')
			return 8;
		return 0;
			}

	private int playToBlock( char userChoice, char computerChoice) {
		
		if ((board[1] == userChoice && board[2] == userChoice || board[5] == userChoice && board[7] == userChoice
				|| board[6] == userChoice && board[9] == userChoice) && board[3] == ' ')
			return 3;
		else if ((board[4] == userChoice && board[5] == userChoice || board[3] == userChoice && board[9] == userChoice) && board[6] == ' ')
			return 6;
		else if ((board[7] == userChoice && board[8] == userChoice || board[3] == userChoice && board[6] == userChoice
				|| board[1] == userChoice && board[5] == userChoice) && board[9] == ' ')
			return 9;
		else if ((board[2] == userChoice && board[3] == userChoice || board[5] == userChoice && board[9] == userChoice
				|| board[7] == userChoice && board[4] == userChoice) && board[1] == ' ')
			return 1;
		else if ((board[1] == userChoice && board[3] == userChoice || board[5] == userChoice && board[8] == userChoice) && board[2] == ' ')
			return 2;
		else if ((board[1] == userChoice && board[7] == userChoice || board[5] == userChoice && board[6] == userChoice) && board[4] == ' ')
			return 4;
		else if ((board[1] == userChoice && board[9] == userChoice || board[7] == userChoice && board[3] == userChoice
				|| board[4] == userChoice && board[6] == userChoice || board[2] == userChoice && board[8] == userChoice) && board[5] == ' ')
			return 5;
		else if ((board[1] == userChoice && board[4] == userChoice || board[8] == userChoice && board[9] == userChoice
				|| board[5] == userChoice && board[3] == userChoice) && board[7] == ' ')
			return 7;
		else if ((board[7] == userChoice && board[9] == userChoice || board[2] == userChoice && board[5] == userChoice) && board[8] == ' ')
			return 8;
		return 0;
	}
	
	private char[] computerMove(char choice_computer) {
		
		TicTacToe game = new TicTacToe();
		
			
		//The Corner Moves
		int count=0;
		int[] corner = {1,3,7,9};
	
		int computer_index_corner = (int) Math.floor(Math.random() * 10 % 4 );
		boolean check_corner  = game.checkValue(corner[computer_index_corner]);
		while (check_corner == true && count<4) {
			computer_index_corner = (int) Math.floor(Math.random() * 10 % 4);
			check_corner = game.checkValue(corner[computer_index_corner]);
		}
		if (check_corner == false) {
		board = game.makeMove(choice_computer, corner[computer_index_corner]);
		count++;

		}
		return board;
		
	
	

		}
		
		
		if(count == 4) {
			boolean check_center = game.checkValue(5);
			if(check_center == false)
				board = game.makeMove(choice_computer, 5);
		}
		return board;

	
	}

	// Main Logic of the Program
	public static void main(String[] args) {

		while(true) {
		
		
		Scanner sc = new Scanner(System.in);
		
	// Welcome to the Tic Tac Toe Game
		System.out.println("Welcome to the Tic Tac Toe Game");
		
		TicTacToe game = new TicTacToe();
		
	// Choice of the User for input and computer
		char[] choice = new char[2];
		System.out.println("Enter the Input: X or O");
		choice[0] = game.ChoiceUser();
		choice[1] = game.ChoiceComputer(choice[0]);
		
		//Command to create Board
			board = game.createBoard();
				 
		// Toss for the Game
			int toss = game.toss();
		
		//Total Iterations
		int total_cases = 9;
	
	while (total_cases != 0) {

		if (toss == 0) {

			//User Choice
		board = game.userMove(choice[0]);
	    TicTacToe.displayBoard();
	   // game.checkWinner(choice[0],choice[1]);
	    
	    if(game.checkWinner(choice[0],choice[1]) == true)
	    break;
	    
	    int position  = 0;
		position = game.playToWin(choice[1]);
		if(position>0)
			{
			board[position] = choice[1];
		
			TicTacToe.displayBoard();}
		else {
		position = game.playToBlock(choice[0],choice[1]);
		if(position>0)
			board[position] = choice[1];
		else
		{
			board = game.computerMove(choice[1]);
		}
		TicTacToe.displayBoard();
		}
	    
	   // game.checkWinner(choice[0],choice[1]);
	    
	    if(game.checkWinner(choice[0],choice[1]) == true)
		    break;
	 
			}
		else {
		int position  = 0;
		position = game.playToWin( choice[1]);
		if(position>0)
			{
			board[position] = choice[1];
		
			TicTacToe.displayBoard();}
		else {
		position = game.playToBlock(choice[0],choice[1]);
		if(position>0)
			board[position] = choice[1];
		else
		{
			board = game.computerMove(choice[1]);
		}
		TicTacToe.displayBoard();
		}
	    //game.checkWinner(choice[0],choice[1]);
	    
	    if(game.checkWinner(choice[0],choice[1]) == true)
		    break;
	 
		board = game.userMove(choice[0]);
	    TicTacToe.displayBoard();
		  // game.checkWinner(choice[0],choice[1]);
		   
		   if(game.checkWinner(choice[0],choice[1]) == true)
			    break;
		    
		}
		total_cases--;
		}
		
	System.out.println("Do you Want to Play another game?\nPress 1 for Yes\nPress 2 for exit");
	int new_game = sc.nextInt();
	if(new_game==1)
		continue;
	else
		break;
	}
	}
	private boolean checkWinner(char user, char c) {
		// Horizontal Lines
		if ((board[1] == user && board[2] == user && board[3] == user)
				|| (board[4] == user && board[5] == user && board[6] == user)
				|| (board[7] == user && board[8] == user && board[9] == user)) {
			System.out.println("Player is the Winner");
			return true ;}
		
		
		else if ((board[1] == c && board[2] == c && board[3] == c)
				|| (board[4] == c && board[5] == c && board[6] == c)
				|| (board[7] == c && board[8] == c && board[9] == c)) {
			System.out.println("Computer is the Winner");
			return true ;

		} 
		// Vertical Lines
		else if (board[1] == user && board[4] == user && board[7] == user
				|| board[2] == user && board[5] == user && board[8] == user
				|| board[3] == user && board[6] == user && board[9] == user) {
			
			System.out.println("Player is the Winner");
			return true ;
		} 
		else if ((board[1] == c && board[4] == c && board[7] == c)
				|| (board[2] == c && board[5] == c && board[8] == c)
				|| (board[3] == c && board[6] == c && board[9] == c)) {
			System.out.println("Computer is the Winner");
			return true ;

		}
		//Diagonals
		else if((board[1] == user && board[5] == user && board[9] == user ) || (board[3] == user && board[5] == user && board[7] == user))
			{
		System.out.println("Player is the Winner");
		return true ;
		}
		else if((board[1] == c && board[5] == c && board[9] == c ) || (board[3] == c && board[5] == c && board[7] == c))
		{
	System.out.println("Computer is the Winner");
	return true ;
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
