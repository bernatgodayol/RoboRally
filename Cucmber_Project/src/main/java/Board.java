import java.util.ArrayList;

public class Board {

	protected Tile[][] grid;
//	protected int robotPositionX;
//	protected int robotPositionY;
	
	public Board(int ROWS, int COLUMNS) {
		grid = new Tile[ROWS][COLUMNS];
		
		for (int i=0; i<ROWS; i++) {
			for (int j=0; j<COLUMNS; j++) {
				grid[i][j] = new Tile();
				
			}
		}
	}
	
	public Tile getTile(int positionX, int positionY) {
		return grid[positionX][positionY];
	}
}
