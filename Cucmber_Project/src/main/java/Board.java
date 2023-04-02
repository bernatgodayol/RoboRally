import java.util.ArrayList;

public class Board {

	protected Tile[][] grid;
//	protected int robotPositionX;
//	protected int robotPositionY;
	
	public Board(int rows, int columns) {
		grid = new Tile[rows][columns];
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				grid[i][j] = new Tile();
			}
		}
	}
	
	public Tile getGrid(int positionX, int positionY) {
		return grid[positionX][positionY];
	}
}
