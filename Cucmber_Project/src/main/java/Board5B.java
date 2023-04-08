
public class Board5B extends Board {
	
	public Board5B() {
		
		super(13,10);
		
		grid[3][3].addElement(new Wall(Direction.NORTH));
		grid[3][3].addElement(new Laser());
		grid[4][3].addElement(new Wall(Direction.SOUTH));
		grid[4][3].addElement(new Laser());
		grid[3][5].addElement(new Wall(Direction.WEST));
		grid[3][5].addElement(new Laser());
		grid[3][6].addElement(new Wall(Direction.EAST));
		grid[3][6].addElement(new Laser());
		grid[6][3].addElement(new Wall(Direction.WEST));
		grid[6][3].addElement(new Laser());
		grid[6][4].addElement(new Wall(Direction.EAST));
		grid[6][4].addElement(new Laser());
		grid[5][6].addElement(new Wall(Direction.NORTH));
		grid[5][6].addElement(new Laser());
		grid[6][6].addElement(new Wall(Direction.SOUTH));
		grid[6][6].addElement(new Laser());
		grid[11][2].addElement(new Wall(Direction.WEST));
		grid[10][4].addElement(new Wall(Direction.NORTH));
		grid[10][5].addElement(new Wall(Direction.NORTH));
		grid[11][7].addElement(new Wall(Direction.EAST));
		
	}
}
