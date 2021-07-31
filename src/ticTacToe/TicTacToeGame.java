package ticTacToe;

public class TicTacToeGame {
	
	char[] gamearr = new char[10];
	
	public void emptyArr(){
		
		int i = 1; 
		while(i < 10) {
			gamearr[i] = ' ';
			i++;
		}
	}
	public static void main(String[] args) {
		
		TicTacToeGame t = new TicTacToeGame();
		t.emptyArr();
	}
}
