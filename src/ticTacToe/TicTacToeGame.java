package ticTacToe;

import java.util.Scanner;
import java.lang.Math;

public class TicTacToeGame {
	
	Scanner sc = new Scanner(System.in);
	char[] gameArr = new char[10];
	
	//method for clearing TicTacToe game board
	public void clearGameBoard() {
		
		int i = 1; 
		while(i < 10) {
			gameArr[i] = ' ';
			i++;
		}
	}
	//method for reading a letter 
	public char chooseLetter() {
		
		System.out.print("Choose your letter X or O : ");
		char letter = sc.next().charAt(0);
		//if input not equal to X or O then returns '' 
		if(letter != 'X' && letter != 'O') {
			System.out.println("Invalid Input");
			letter = ' ';
		}
		return letter;
	}
	//method to print TicTocToeBoard
	public void showBoard() {
		
		System.out.println("\nYour TicTacToe board : ");
		for(int i=1; i<10; i++) {
			System.out.print(gameArr[i] + " ");
			//print value in new line when position reaches 3 & 6
			if(i % 3 == 0) {
				if(i != 9) {
					System.out.print("\n---------\n");
				}
			}
			else {
				System.out.print("|");
			}
		}
	}
	//method to move to a desired location
	public void playGame(char letter, char computerLetter) {
		
		int position;
		if(letter == computerLetter) {
			int min = 1, max = 9;
			position = (int)(Math.random() * (max - min +1) + min);
		}
		else {
			System.out.print("\nSelect a position from 1 to 9 : ");
			position = sc.nextInt();
		}
		if(checkFreeSpace(position)) {
			gameArr[position] = letter;
		}
		else {
			System.out.println("\nSelected position is not free, Play again ");
			playGame(letter ,computerLetter);
		}
	}
	//method to check free space
	public boolean checkFreeSpace(int position ) {
		
		if(gameArr[position] == ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	//toss to check who plays first
	public int toss() {
		
		return (int)(Math.floor (Math.random() * 10) % 2);
	}
	//method to check game status
	public char checkWinner() {
		
		int isEmptyFlag = 0;
		//iterate to check winning combination
		for (int i = 1; i < 9; i++) {
            String line = null;
            StringBuilder sb = new StringBuilder();
            switch (i) {
            case 1:
                line = sb.append(gameArr[1]).append(gameArr[2]).append(gameArr[3]).toString();
                break;
            case 2:
            	line = sb.append(gameArr[4]).append(gameArr[5]).append(gameArr[6]).toString();
                break;
            case 3:
                line = sb.append(gameArr[7]).append(gameArr[8]).append(gameArr[9]).toString();
                break;
            case 4:
                line = sb.append(gameArr[1]).append(gameArr[4]).append(gameArr[7]).toString();
                break;
            case 5:
                line = sb.append(gameArr[2]).append(gameArr[5]).append(gameArr[8]).toString();
                break;
            case 6:
                line = sb.append(gameArr[3]).append(gameArr[6]).append(gameArr[9]).toString();
                break;
            case 7:
                line = sb.append(gameArr[1]).append(gameArr[5]).append(gameArr[9]).toString();
                break;
            case 8:
                line = sb.append(gameArr[3]).append(gameArr[5]).append(gameArr[7]).toString();
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return 'X';
            }
            // For O winner
            else if (line.equals("OOO")) {
                return 'O';
            }
        }
		//iterate to check tie
		for(int i=1; i<10; i++) {
			if(gameArr[i] == ' ') {
				isEmptyFlag = 1;
			}
		}
		//return C to continue game
		//return T for tie 
		if(isEmptyFlag == 1) {
			return 'C';
		}
		else {
			return 'T';
		}
	}
	public static void main(String[] args){
		
		char computerLetter, playerLetter, checkStatus, player1, player2, playAgain;
		Scanner sc = new Scanner(System.in);
		TicTacToeGame game = new TicTacToeGame();
		do {
			game.clearGameBoard();
			playerLetter = game.chooseLetter();
			System.out.println("Player Choose the letter : " + playerLetter);
			computerLetter = (playerLetter == 'X') ? 'O':'X';
			System.out.print("\nChoose Head(1) or Tail(0) : ");
			int tossOption = sc.nextInt();
			//comparing value user input and toss value
			if(tossOption == game.toss()) {
				System.out.println("Player won the toss");
				player1 = playerLetter;
				player2 = computerLetter;
			}
			else {
				System.out.println("Computer won the toss");
				player1 = computerLetter;
				player2 =  playerLetter;
			}
			do{
				game.showBoard();
				game.playGame(player1,computerLetter);
				game.showBoard();
				checkStatus = game.checkWinner();
				if(checkStatus == 'X' || checkStatus == 'O') {
					break;
				}
				game.playGame(player2,computerLetter);
				game.showBoard();
				checkStatus = game.checkWinner();
			}while(checkStatus == 'C');
			System.out.println("Final game board");
			game.showBoard();
			if(checkStatus == playerLetter) {
				System.out.println("\nPlayer Wins");
			}
			else if(checkStatus == computerLetter) {
				System.out.println("\nComputer Wins");
			}
			else {
				System.out.println("\n Both are in Tie");
			}
			System.out.print("\nDo you want to continue the game? Press Y :");
			playAgain = sc.next().charAt(0);
		}while(playAgain == 'Y');
		System.out.println("\nGame over!");
		sc.close();
	}
}
