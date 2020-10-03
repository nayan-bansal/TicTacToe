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
		
		return user;
	}
	
	//Display the Board
	
	private static char[] displayBoard() {
		
		System.out.println(board[1]+" | "+board[2]+" | "+board[3]+"\n"+board[4]+" | "+board[5]+" | "+board[6]+"\n"+board[7]+" | "+board[8]+" | "+board[9]);
		return board;
	}
	
	//Make the Move
	
	private char[] makeMove(char choice, int index) {
		
		board[index] = choice;
		
		return board;
	}
	
	//Main Logic of the Program
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		//Welcome to the Tic Tac Toe Game
		System.out.println("Welcome to the Tic Tac Toe Game");
		
		TicTacToe game = new TicTacToe();
		 board = game.createBoard();
		 
		 int toss = (int)Math.floor(Math.random()*10%2);
		 
		 
		System.out.println("Enter the Input: X or O");
		  char choice = game.method();
		  System.out.println(choice);
		 
		  char choice_computer = '0';
		  if(choice =='X')
			  choice_computer = 'O';
			  else
				  choice_computer = 'X';
		if(toss ==0)
			 {
		  
		System.out.println("Enter the index you want to enter:"); 
		int index = sc.nextInt();
		
		boolean check = game.checkValue(index);
		if(check == false)
		board = game.makeMove(choice,index);  
	
		TicTacToe.displayBoard();
		 }
		 else {
			 
		int computer_index = (int)Math.floor(Math.random()*10%9+1);
		 board = game.makeMove(choice_computer,computer_index);
		 TicTacToe.displayBoard();
		 }
	     
		
		 }

	private boolean checkValue(int index) {
		
		if(board[index] == 'X' || board[index] == 'O')
		return true;
		else
		return false;
	}
}