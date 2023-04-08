public class Board {

	protected Tile[][] grid;
	protected int rebootPositionX;
	protected int rebootPositionY;
	protected int ROWS;
	protected int COLUMNS;
	
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
		if (grid[oldX][oldY].containsElement(robot)) {
			
			if (card instanceof MoveForwardCard) {
				grid[oldX][oldY].removeElement(robot);
				if (robot.getDirection() == Direction.NORTH) {
					// if the robot goes out of the board
					if ((oldX-1 < 0 && oldX-1 > ROWS-1) || (oldY-1 < 0 && oldY-1 > COLUMNS-1)) {
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						System.out.println("The robot went out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX-1][oldY-1].containsElement(new Wall(Direction.SOUTH))) ||
							   (grid[oldX][oldY]    .containsElement(new Wall(Direction.NORTH)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX-1][oldY-1].addElement(robot);
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
			
			if (card instanceof RightTurnCard) {
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
			
			if (card instanceof LeftTurnCard) {
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
			
			if (card instanceof UTurnCard) {
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
