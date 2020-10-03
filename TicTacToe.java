package com.bridgelabwork;
import java.util.*;

public class TicTacToe {

	//Create a Board of Size 10 and allocate empty space for each block
	private static char[] board = new char[10];
	
	//Initialize Board for game		
	private char[] createBoard() {
		for(int i=0;i<board.length;i++)
		board[i]  = '0';
		return board;
	}
	
	//Choose X or O for user
	private char method() {
		Scanner scan = new Scanner(System.in);
		char user = scan.next().charAt(0);
		char computer = '0';
		
		if(user == 'X')
			computer = 'O';
		
		else
			computer = 'X';	
		scan.close();
		return user;
	}
	
	private static char[] displayBoard() {
		int row =0;
		for(int i=1;i<board.length;i++) {
			if(row==3) {
				System.out.println();
			row = 0;	
			}
			System.out.println(board[i]);
			row++;
		}
		return board;
	}
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	//Welcome to the Tic Tac Toe Game
		System.out.println("Welcome to the Tic Tac Toe Game");
		
		TicTacToe game = new TicTacToe();
		 board = game.createBoard();
		
		System.out.println("Enter the Input: X or O");
		  char choice = game.method();
		  System.out.println(choice);
		  
		  
 
	
		TicTacToe.displayBoard();
	}

	
}
