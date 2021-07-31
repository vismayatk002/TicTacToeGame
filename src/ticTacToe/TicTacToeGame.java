package ticTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	
	char[] gamearr = new char[10];
	Scanner sc = new Scanner(System.in);
	//method for clearing TicTacToe game board
	public void clearGameBoard(){
		
		int i = 1; 
		while(i < 10) {
			gamearr[i] = ' ';
			i++;
		}
	}
	//return type character
	public char chooseLetter(){
		
		System.out.print("Choose your letter X or O : ");
		char letter = sc.next().charAt(0);
		//if input not equal to X or O then returns '' 
		if(letter != 'X' && letter != 'O'){
			System.out.println("Invalid Input");
			letter = ' ';
		}
		return letter;
	}
	public static void main(String[] args) {
		
		TicTacToeGame tg = new TicTacToeGame();
		tg.clearGameBoard();
		char letter = tg.chooseLetter();
		System.out.println("Player Choose the letter : " + letter);
		
	}
}
