package ticTacToe;

public class TicTacToeGame {
	
	char[] gamearr = new char[10];
	//method for clearing TicTacToe game board
	public void clearGameBoard(){
		
		int i = 1; 
		while(i < 10) {
			gamearr[i] = ' ';
			i++;
		}
	}
	public static void main(String[] args) {
		
		TicTacToeGame t = new TicTacToeGame();
		t.clearGameBoard();
	}
}
