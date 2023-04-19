package View;

import model.Board;

public class BoardStatus{
	Board board;
	protected int[][] boardGrid;
	
	public BoardStatus(int ROWS, int COLUMNS) {
		boardGrid = new int[ROWS][COLUMNS];
	}

	public void setElementType(int num, int i, int j) {
		boardGrid[i][j] = num;
	}
	
	public int[][] getStatusBoard() {
		return this.boardGrid;
	}

	public void setBoardSize(int ROWS, int COLUMNS) {
		
	}
	
}
