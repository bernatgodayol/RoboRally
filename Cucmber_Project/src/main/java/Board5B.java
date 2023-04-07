
public class Board5B extends Board {
	
	public Board5B() {
		super(13,10);
		
		grid[3][3].setObstacle(new Wall(Direction.NORTH));
		grid[3][3].setObstacle(new Laser());
		grid[4][3].setObstacle(new Wall(Direction.SOUTH));
		grid[4][3].setObstacle(new Laser());
		grid[3][5].setObstacle(new Wall(Direction.WEST));
		grid[3][5].setObstacle(new Laser());
		grid[3][6].setObstacle(new Wall(Direction.EAST));
		grid[3][6].setObstacle(new Laser());
		grid[6][3].setObstacle(new Wall(Direction.WEST));
		grid[6][3].setObstacle(new Laser());
		grid[6][4].setObstacle(new Wall(Direction.EAST));
		grid[6][4].setObstacle(new Laser());
		grid[5][6].setObstacle(new Wall(Direction.NORTH));
		grid[5][6].setObstacle(new Laser());
		grid[6][5].setObstacle(new Wall(Direction.SOUTH));
		grid[6][5].setObstacle(new Laser());
		grid[11][2].setObstacle(new Wall(Direction.WEST));
		grid[10][4].setObstacle(new Wall(Direction.NORTH));
		grid[10][5].setObstacle(new Wall(Direction.NORTH));
		grid[11][7].setObstacle(new Wall(Direction.EAST));
		
	}
}
