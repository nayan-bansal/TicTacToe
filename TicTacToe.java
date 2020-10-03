package com.tictactoegame;
import java.util.*;

public class TicTacToe {

	//Create a Board of Size 10 and allocate empty space for each block
	
	//Initialize Board for game		
	public void createBoard() {
		char[] game = new char[10];
		game  = null;
	}
	
	//Choose X or O for user
	public void method() {
		Scanner scan = new Scanner(System.in);
		char choice_user = scan.next().charAt(0);
		char choice_computer = '0';
		
		if(choice_user == 'X')
			choice_computer = 'O';
		
		else
			choice_computer = 'X';	
		
	}
			
	public static void main(String[] args) {
		
	//Welcome to the Tic Tac Toe Game
		System.out.println("Welcome to the Tic Tac Toe Game");
		
		TicTacToe game = new TicTacToe();
		game.createBoard();
		
		System.out.println("Enter the Input: X or O");
		game.method();
	}
	
}