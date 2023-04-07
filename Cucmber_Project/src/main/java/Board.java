public class Board {
	
	protected Tile[][] grid;
	protected int rebootPositionX;
	protected int rebootPositionY;
	private int ROWS;
	private int COLUMNS;
	
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
	
	public int returnRebootPositionX() {
		return rebootPositionX;
	}
	
	public int returnRebootPositionY() {
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
					if ((oldX > 0 && oldX < ROWS - 1) && (oldY > 0 && oldY < COLUMNS - 1)) {
						grid[oldX-1][oldY-1].addElement(robot);
					}
					else {
						System.out.println("The robot went to the reboot cell!");
						grid[rebootPositionX][rebootPositionY].addElement(robot);
					}
					
				} else if (robot.getDirection() == Direction.EAST) {
					grid[oldX+1][oldY-1].addElement(robot);
				} else if (robot.getDirection() == Direction.WEST) {
					grid[oldX-1][oldY+1].addElement(robot);
				} else if (robot.getDirection() == Direction.SOUTH) {
					grid[oldX+1][oldY+1].addElement(robot);
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
