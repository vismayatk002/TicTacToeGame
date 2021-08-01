package ticTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	
	Scanner sc = new Scanner(System.in);
	char[] gamearr = new char[10];
	
	//method for clearing TicTacToe game board
	public void clearGameBoard(){
		
		int i = 1; 
		while(i < 10) {
			gamearr[i] = ' ';
			i++;
		}
	}
	//method for reading a letter 
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
	//method for print TicTocToeBoard
	public void showBoard(){
		
		System.out.println("Your TicTacToe board : ");
		for(int i=1; i<10; i++) {
			System.out.print(gamearr[i] + " ");
			//print value in new line when position reaches 3 & 6
			if(i == 3 || i == 6){
				System.out.println("\n");
			}
		}
	}
	public static void main(String[] args) {
		
		TicTacToeGame game = new TicTacToeGame();
		game.clearGameBoard();
		char letter = game.chooseLetter();
		System.out.println("Player Choose the letter : " + letter);
		game.showBoard();
		
	}
}
