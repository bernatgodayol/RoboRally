import java.util.ArrayList;

public class Board {

	protected Tile[][] grid;
	
	public Board(int rows, int columns) {
		grid = new Tile[rows][columns];
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<columns; j++) {
				grid[i][j] = new Tile();
			}
		}
	}
	
}
