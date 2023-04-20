package View;

public class BoardStatus{
	
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
	
}
