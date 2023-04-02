
public class Board5B extends Board {
	
	public Board5B() {
		super(13,10);
		
		grid[3][3].setObstacle(new Wall());
		grid[3][3].setObstacle(new Laser());
		grid[4][3].setObstacle(new Wall());
		grid[4][3].setObstacle(new Laser());
		grid[3][5].setObstacle(new Wall());
		grid[3][5].setObstacle(new Laser());
		grid[3][6].setObstacle(new Wall());
		grid[3][6].setObstacle(new Laser());
		grid[6][3].setObstacle(new Wall());
		grid[6][3].setObstacle(new Laser());
		grid[6][4].setObstacle(new Wall());
		grid[6][4].setObstacle(new Laser());
		grid[5][6].setObstacle(new Wall());
		grid[5][6].setObstacle(new Laser());
		grid[11][2].setObstacle(new Wall());
		grid[11][7].setObstacle(new Wall());
		grid[10][4].setObstacle(new Wall());
		grid[10][5].setObstacle(new Wall());
		
	}
}
