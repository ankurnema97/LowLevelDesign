package classes;

public class Board {

	int size;
	PlayingOptions board[][];
	
	public Board(int size) {
		this.size=size;
		board=new PlayingOptions[size][size];
	}
	
	public boolean addChance(int row, int col, PlayingOptions options) {
		if(board[row][col]==null) {
			board[row][col]=options;
			return true;
	    }
		return false;
	}
	
	public void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j]!=null)
					System.out.print(board[i][j].options.name()+" _|");
				else
				System.out.print("___|");
			}
			System.out.println();
		}
	}
	
	public boolean isValid(int row, int col) {
		if(row<size && row>=0 && col<size && col>=0)
			return true;
		else
			return false;
	}
	
	
	public boolean checkForWinner(int row, int col, PlayingOptions options) {
		boolean row_check = true;
		boolean col_check = true;
		boolean diag_check1 = false;
		boolean diag_check2 = false;
		//checking for row
		for(int i=0;i<size;i++) {
			if(board[row][i]!=null && board[row][i].options==options.options) {
				row_check=row_check & true;
			}
			else
				row_check=row_check & false;
		}
		
		
		for(int i=0;i<size;i++) {
			if(board[i][col]!=null && board[i][col].options==options.options) {
				col_check=col_check & true;
			}
			else
				col_check=col_check & false;
		}
		
		if(row==col) {
			diag_check1 = true;
			for(int i=0,j=0;i<size;i++,j++) {
				if(board[i][j]!=null && board[i][j].options==options.options) {
					diag_check1 = diag_check1 & true;
				}
				else
					diag_check1 = diag_check1 & false;
			}
		}
		
		if((row+col)==(size-1)) {
			diag_check2 = true;
			for(int i=0,j=size-1;i<size;i++,j--) {
				if(board[i][j]!=null && board[i][j].options==options.options) {
					diag_check2 = diag_check2 & true;
				}
				else
					diag_check2 = diag_check2 & false;
			}
		}
		
		return row_check | col_check | diag_check1 | diag_check2;
		
	}
}
