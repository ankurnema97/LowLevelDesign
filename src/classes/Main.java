package classes;

public class Main {	
	public static void main(String args[]) {
		TicTacToeGame ticTacGame = new TicTacToeGame();
		String winner=ticTacGame.startGame();
		System.out.println("Winner is: "+winner);
	}
}
