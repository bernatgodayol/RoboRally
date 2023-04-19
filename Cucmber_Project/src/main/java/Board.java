public class Board {


	private Tile[][] grid;
	private int rebootPositionX;
	private int rebootPositionY;
	private int ROWS=13;
	private int COLUMNS=10;
	
	private Robot robot1;
	private int robot1PositionX=12;
	private int robot1PositionY=3;
	
	private Robot robot2;
	private int robot2PositionX=12;
	private int robot2PositionY=6;
	
	public Board() {
		grid = new Tile[ROWS][COLUMNS];
		
		for (int i=0; i<ROWS; i++) {
			for (int j=0; j<COLUMNS; j++) {
				grid[i][j] = new Tile();
			}
		}
	}
	
	public void initialize5B() {

		this.setObstacle(new Wall(Direction.NORTH), 3, 3);
		this.setObstacle(new Laser(), 3, 3);
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
	
	public void setRobots(Robot robot1) {
		robot1.setDirection(Direction.NORTH);
		this.robot1 = robot1;
		grid[robot1PositionX][robot1PositionY].addElement(robot1);
	}
	
	// now we only have two players, if we had 3 or 4 players we can have different versions on setRobots method
		public void setRobots(Robot robot1, Robot robot2) {
			
			this.robot1 = robot1;
			this.robot1.setDirection(Direction.NORTH);
			grid[robot1PositionX][robot1PositionY].addElement(robot1);
			this.robot2 = robot2;
			this.robot2.setDirection(Direction.NORTH);
			grid[robot2PositionX][robot2PositionY].addElement(robot2);
		}
		
	public void setObstacle(Wall wall, int positionX, int positionY) {
		grid[positionX][positionY].addElement(wall);
	}
		
	public void setObstacle(Laser laser, int positionX, int positionY) {
		grid[positionX][positionY].addElement(laser);
	}
	
	public void setObstacle(Pit pit, int positionX, int positionY) {
		grid[positionX][positionY].addElement(pit);
	}
	
	public boolean containsElement(Element element, int positionX, int positionY) {
		return grid[positionX][positionY].containsElement(element);
	}
	
	public boolean isEmpty(int positionX, int positionY) {
		return grid[positionX][positionY].isEmpty();
	}
	
	public int getRobotPositionX(Robot robot) {
		if (robot.equals(robot1)) {
			return robot1PositionX;
		} else {
			return robot2PositionX;
		}
	}

	public int getRobotPositionY(Robot robot) {
		if (robot.equals(robot1)) {
			return robot1PositionY;
		} else {
			return robot2PositionY;
		}
	}
	
	public void setRobotPositionX(int X, Robot robot) {
		if (robot.equals(robot1)) {
			robot1PositionX = X;
		} else {
			robot2PositionX = X;
		}
	}
	
	public void setRobotPositionY(int Y, Robot robot) {
		if (robot.equals(robot1)) {
			robot1PositionY = Y;
		} else {
			robot2PositionY = Y;
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
	
	public void activateObstacles() {
		if (this.containsElement(new Laser(), robot1PositionX, robot1PositionX)) {
			Laser laser = new Laser(true);
			laser.hit(robot1);
		} else if (this.containsElement(robot1, rebootPositionX, rebootPositionY)) {
			Reboot reboot = new Reboot();
			reboot.punishPlayer(robot1);
		}
		if (this.containsElement(new Laser(), robot2PositionX, robot2PositionX)) {
			Laser laser = new Laser(true);
			laser.hit(robot2);
		} else if (this.containsElement(robot2, rebootPositionX, rebootPositionY)) {
			Reboot reboot = new Reboot();
			reboot.punishPlayer(robot2);
		}
	}
	
	public void playCard(Robot robot, Card card) {
		int oldX = this.getRobotPositionX(robot);
		int oldY = this.getRobotPositionY(robot);
		if (card == Card.MoveForward) {
			
			if (robot.getDirection() == Direction.NORTH) {
				// if the robot goes out of the board
				if (oldX == 0) {
					grid[oldX][oldY].removeElement(robot);
					grid[rebootPositionX][rebootPositionY].addElement(robot);
					this.setRobotPositionX(rebootPositionX, robot);
					this.setRobotPositionY(rebootPositionY, robot);
					System.out.println("The robot went out of the board!");
				// if the robot hits a wall
				} else if ((this.containsElement(new Wall(Direction.SOUTH), oldX-1, oldY)) ||
					       (this.containsElement(new Wall(Direction.NORTH), oldX  , oldY))) {
					System.out.println("The robot hitted a wall! ");
				} else {
					grid[oldX][oldY].removeElement(robot);
					grid[oldX-1][oldY].addElement(robot);
					this.setRobotPositionX(oldX-1, robot);
					this.setRobotPositionY(oldY, robot);
				}
			} else if (robot.getDirection() == Direction.EAST) {
				// if the robot goes out of the board
				if (oldY+1 == COLUMNS) {
					grid[oldX][oldY].removeElement(robot);
					grid[rebootPositionX][rebootPositionY].addElement(robot);
					this.setRobotPositionX(rebootPositionX, robot);
					this.setRobotPositionY(rebootPositionY, robot);
					System.out.println("The robot went out of the board!");
				// if the robot hits a wall
				} else if ((grid[oldX][oldY-1].containsElement(new Wall(Direction.WEST))) ||
						   (grid[oldX][oldY]  .containsElement(new Wall(Direction.EAST)))) {
					System.out.println("The robot hitted a wall!");
				} else {
						grid[oldX][oldY].removeElement(robot);
						grid[oldX][oldY-1].addElement(robot);
						this.setRobotPositionX(oldX, robot);
						this.setRobotPositionY(oldY-1, robot);
					}
				} else if (robot.getDirection() == Direction.WEST) {
					// if the robot goes out of the board
					if (oldY == 0) {
						grid[oldX][oldY].removeElement(robot);
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						this.setRobotPositionX(rebootPositionX, robot);
						this.setRobotPositionY(rebootPositionY, robot);
						System.out.println("The robot went out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX][oldY+1].containsElement(new Wall(Direction.EAST))) ||
							   (grid[oldX][oldY]  .containsElement(new Wall(Direction.WEST)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX][oldY].removeElement(robot);
						grid[oldX][oldY+1].addElement(robot);
						this.setRobotPositionX(oldX, robot);
						this.setRobotPositionY(oldY+1, robot);
					}
				} else if (robot.getDirection() == Direction.SOUTH) {
					// if the robot goes out of the board
					if (oldX+1 == ROWS) {
						grid[oldX][oldY].removeElement(robot);
						grid[rebootPositionX][rebootPositionY].addElement(robot);
						this.setRobotPositionX(rebootPositionX, robot);
						this.setRobotPositionY(rebootPositionY, robot);
						System.out.println("The robot went out of the board!");
					// if the robot hits a wall
					} else if ((grid[oldX+1][oldY].containsElement(new Wall(Direction.NORTH))) ||
							   (grid[oldX][oldY]  .containsElement(new Wall(Direction.SOUTH)))) {
						System.out.println("The robot hitted a wall!");
					} else {
						grid[oldX][oldY].removeElement(robot);
						grid[oldX+1][oldY].addElement(robot);
						this.setRobotPositionX(oldX+1, robot);
						this.setRobotPositionY(oldY, robot);
					}
				}
			} else if (card.equals(Card.RightTurn)) {
				if (robot.getDirection() == Direction.NORTH) {
					robot.setDirection(Direction.EAST);
				} else if (robot.getDirection() == Direction.EAST) {
					robot.setDirection(Direction.SOUTH);
				} else if (robot.getDirection() == Direction.SOUTH) {
					robot.setDirection(Direction.WEST);
				} else if (robot.getDirection() == Direction.WEST) {
					robot.setDirection(Direction.NORTH);
				}
			} else if (card.equals(Card.LeftTurn)) {
				if (robot.getDirection() == Direction.NORTH) {
					robot.setDirection(Direction.WEST);
				} else if (robot.getDirection() == Direction.EAST) {
					robot.setDirection(Direction.NORTH);
				} else if (robot.getDirection() == Direction.SOUTH) {
					robot.setDirection(Direction.EAST);
				} else if (robot.getDirection() == Direction.WEST) {
					robot.setDirection(Direction.SOUTH);
				}
			} else if (card.equals(Card.UTurn)) {
				if (robot.getDirection() == Direction.NORTH) {
					robot.setDirection(Direction.SOUTH);
				} else if (robot.getDirection() == Direction.EAST) {
					robot.setDirection(Direction.WEST);
				} else if (robot.getDirection() == Direction.SOUTH) {
					robot.setDirection(Direction.NORTH);
				} else if (robot.getDirection() == Direction.WEST) {
					robot.setDirection(Direction.EAST);
				}
			} else {
				System.out.println("The old position is not valid, there is not robot to move there.");
			}
		}
	}