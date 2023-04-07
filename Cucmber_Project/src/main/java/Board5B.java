
public class Board5B extends Board {
	
	public Board5B() {
		super(13,10);
		
		grid[3][3].setElement(new Wall(Direction.NORTH));
		grid[3][3].setElement(new Laser());
		grid[4][3].setElement(new Wall(Direction.SOUTH));
		grid[4][3].setElement(new Laser());
		grid[3][5].setElement(new Wall(Direction.WEST));
		grid[3][5].setElement(new Laser());
		grid[3][6].setElement(new Wall(Direction.EAST));
		grid[3][6].setElement(new Laser());
		grid[6][3].setElement(new Wall(Direction.WEST));
		grid[6][3].setElement(new Laser());
		grid[6][4].setElement(new Wall(Direction.EAST));
		grid[6][4].setElement(new Laser());
		grid[5][6].setElement(new Wall(Direction.NORTH));
		grid[5][6].setElement(new Laser());
		grid[6][5].setElement(new Wall(Direction.SOUTH));
		grid[6][5].setElement(new Laser());
		grid[11][2].setElement(new Wall(Direction.WEST));
		grid[10][4].setElement(new Wall(Direction.NORTH));
		grid[10][5].setElement(new Wall(Direction.NORTH));
		grid[11][7].setElement(new Wall(Direction.EAST));
		
	}
}
