public class Board {

	protected Tile[][] grid;
	protected int rebootPositionX;
	protected int rebootPositionY;
	protected int ROWS=13;
	protected int COLUMNS=10;
	
	public Board() {
		grid = new Tile[ROWS][COLUMNS];
		
		for (int i=0; i<ROWS; i++) {
			for (int j=0; j<COLUMNS; j++) {
				grid[i][j] = new Tile();
			}
		}
	}
	
	public void initialize5B() {

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
	
	public Tile getTile(int positionX, int positionY) {
		return grid[positionX][positionY];
	}
	
	public int getRebootPositionX() {
		return rebootPositionX;
	}
	
	public int getRebootPositionY() {
		return rebootPositionY;
	}
	
	public int getROWS() {
		return ROWS;
	}
	
	public int getCOLUMNS() {
		return COLUMNS;
	}
	
	public void moveRobot(int oldX, int oldY, Robot robot, Card card) {
		
		if (oldX > 0 && oldX < ROWS && oldY > 0 && oldY > COLUMNS && grid[oldX][oldY].containsElement(robot)) {
			
			if (card.equals(Card.MoveForward)) {
				grid[oldX][oldY].removeElement(robot);
				if (robot.getDirection() == Direction.NORTH) {
					// if the robot goes out of the board
					if (oldX-1 < 0 && oldX-1 > ROWS) {
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						System.out.println("The robot went out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX-1][oldY].containsElement(new Wall(Direction.SOUTH))) ||
							   (grid[oldX][oldY]  .containsElement(new Wall(Direction.NORTH)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX-1][oldY].addElement(robot);
					}
				} else if (robot.getDirection() == Direction.EAST) {
					// if the robot goes out of the board
					if ((oldX+1 < 0 && oldX+1 > ROWS-1) || (oldY-1 < 0 && oldY-1 > COLUMNS-1)) {
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						System.out.println("The robot went to out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX+1][oldY-1].containsElement(new Wall(Direction.WEST))) ||
							   (grid[oldX][oldY]    .containsElement(new Wall(Direction.EAST)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX+1][oldY-1].addElement(robot);
					}
				} else if (robot.getDirection() == Direction.WEST) {
					// if the robot goes out of the board
					if ((oldX-1 < 0 && oldX-1 > ROWS-1) || (oldY+1 < 0 && oldY+1 > COLUMNS-1)) {
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						System.out.println("The robot went to out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX-1][oldY+1].containsElement(new Wall(Direction.EAST))) ||
							   (grid[oldX][oldY]    .containsElement(new Wall(Direction.WEST)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX-1][oldY+1].addElement(robot);
					}
				} else if (robot.getDirection() == Direction.SOUTH) {
					// if the robot goes out of the board
					if ((oldX+1 < 0 && oldX+1 > ROWS-1) || (oldY+1 < 0 && oldY+1 > COLUMNS-1)) {
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						System.out.println("The robot went to out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX+1][oldY+1].containsElement(new Wall(Direction.NORTH))) ||
							   (grid[oldX][oldY]    .containsElement(new Wall(Direction.SOUTH)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX+1][oldY+1].addElement(robot);
					}
				}
			}
			
			if (card.equals(Card.RightTurn)) {
				if (robot.getDirection() == Direction.NORTH) {
					robot.setDirection(Direction.EAST);
				} else if (robot.getDirection() == Direction.EAST) {
					robot.setDirection(Direction.SOUTH);
				} else if (robot.getDirection() == Direction.SOUTH) {
					robot.setDirection(Direction.WEST);
				} else if (robot.getDirection() == Direction.WEST) {
					robot.setDirection(Direction.NORTH);
				}
			}
			
			if (card.equals(Card.LeftTurn)) {
				if (robot.getDirection() == Direction.NORTH) {
					robot.setDirection(Direction.WEST);
				} else if (robot.getDirection() == Direction.EAST) {
					robot.setDirection(Direction.NORTH);
				} else if (robot.getDirection() == Direction.SOUTH) {
					robot.setDirection(Direction.EAST);
				} else if (robot.getDirection() == Direction.WEST) {
					robot.setDirection(Direction.SOUTH);
				}
			}
			
			if (card.equals(Card.UTurn)) {
				if (robot.getDirection() == Direction.NORTH) {
					robot.setDirection(Direction.SOUTH);
				} else if (robot.getDirection() == Direction.EAST) {
					robot.setDirection(Direction.WEST);
				} else if (robot.getDirection() == Direction.SOUTH) {
					robot.setDirection(Direction.NORTH);
				} else if (robot.getDirection() == Direction.WEST) {
					robot.setDirection(Direction.EAST);
				}
			}
			
		} else {
			System.out.println("The old position is not valid, there is not robot to move there.");
		}
		
	}
	
}
