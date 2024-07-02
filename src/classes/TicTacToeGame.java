package classes;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {

	Deque<Player> deque;
	Board board;
	
	public TicTacToeGame() {
		Option1 cross = new Option1();
		Player p1 = new Player("ABC", cross);
		
		Option2 circle = new Option2();
		Player p2 = new Player("XYZ", circle);
			
		deque = new LinkedList<>();
		board = new Board(3);
		
		deque.add(p1);
		deque.add(p2);
	}
	
	public String startGame() {
		String Winner="Match is DRAW";
		int count=0;
		board.printBoard();
	    while(true) {
			
			System.out.println("Enter block (i,j)");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			String[] values = input.split(",");
			int row = Integer.valueOf(values[0]);
			int col = Integer.valueOf(values[1]);
			
			Player chance = deque.getFirst();
			if(board.isValid(row,col) && board.addChance(row, col, chance.playingoptions)) {
				deque.pop();
				deque.add(chance);
				count+=1;
				board.printBoard();
				boolean winner = board.checkForWinner(row, col, chance.playingoptions);
				if(winner) {
					Winner = chance.getName();
					break;
				}
				if(count==9)
					break;
			}
			else {
				System.out.println("Wrong input/block, Enter correct block");
			}
		}
		
		return Winner;
	}
}
