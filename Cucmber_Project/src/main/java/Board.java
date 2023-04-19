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
		this.setObstacle(new Wall(Direction.SOUTH), 4, 3);
		this.setObstacle(new Laser(), 4, 3);
		this.setObstacle(new Wall(Direction.WEST), 3, 5);
		this.setObstacle(new Laser(), 3, 5);
		this.setObstacle(new Wall(Direction.EAST), 3, 6);
		this.setObstacle(new Laser(), 3, 6);
		this.setObstacle(new Wall(Direction.WEST), 6, 3);
		this.setObstacle(new Laser(), 6, 3);
		this.setObstacle(new Wall(Direction.EAST), 6, 4);
		this.setObstacle(new Laser(), 6, 4);
		this.setObstacle(new Wall(Direction.NORTH), 5, 6);
		this.setObstacle(new Laser(), 5, 6);
		this.setObstacle(new Wall(Direction.SOUTH), 6, 6);
		this.setObstacle(new Laser(), 6, 6);
		this.setObstacle(new Wall(Direction.WEST), 11, 2);
		this.setObstacle(new Wall(Direction.NORTH), 10, 4);
		this.setObstacle(new Wall(Direction.NORTH), 10, 5);
		this.setObstacle(new Wall(Direction.EAST), 11, 7);
	}
	
	public void setRobots(Robot robot1) {
		robot1.setDirection(Direction.NORTH);
		this.robot1 = robot1;
		this.setRobot(robot1, robot1PositionX, robot1PositionY);
	}
	
	// now we only have two players, if we had 3 or 4 players we can have different versions on setRobots method
		public void setRobots(Robot robot1, Robot robot2) {
			this.robot1 = robot1;
			this.robot1.setDirection(Direction.NORTH);
			this.setRobot(robot1, robot1PositionX, robot1PositionY);
			this.robot2 = robot2;
			this.robot2.setDirection(Direction.NORTH);
			this.setRobot(robot2, robot2PositionX, robot2PositionY);
		}
		
	public void setObstacle(Wall wall, int positionX, int positionY) {
		grid[positionX][positionY].getElement().add(wall);
	}
		
	public void setObstacle(Laser laser, int positionX, int positionY) {
		grid[positionX][positionY].getElement().add(laser);
	}
	
	public void setRobot(Robot robot, int positionX, int positionY) {
		// System.out.println(robot1PositionX);
	    // System.out.println(robot1PositionY);
		grid[positionX][positionY].getElement().add(robot);
		this.setRobotPositionX(positionX, robot);
		this.setRobotPositionY(positionY, robot);
		// System.out.println(robot1PositionX);
	    // System.out.println(robot1PositionY);
	}
	
	public void setRobotPositionX(int X, Robot robot) {
		if (robot.equals(robot1)) {
			this.robot1PositionX = X;
		} else {
			this.robot2PositionX = X;
		}
	}
	
	public void setRobotPositionY(int Y, Robot robot) {
		if (robot.equals(robot1)) {
			this.robot1PositionY = Y;
		} else {
			this.robot2PositionY = Y;
		}
	}
	
	public void setObstacle(Pit pit, int positionX, int positionY) {
		grid[positionX][positionY].addElement(pit);
	}
	
	public boolean containsElement(Element element, int positionX, int positionY) {
		return grid[positionX][positionY].getElement().contains(element);
	}
	
	public boolean isEmpty(int positionX, int positionY) {
		return grid[positionX][positionY].getElement().isEmpty();
	}
	
	public boolean removeElement(Element element, int positionX, int positionY) {
		return grid[positionX][positionY].getElement().remove(element);
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
					this.removeElement(robot, oldX, oldY);
					this.setRobot(robot, rebootPositionX, rebootPositionY);
					System.out.println("The robot went out of the board!");
				// if the robot hits a wall
				} else if ((this.containsElement(new Wall(Direction.SOUTH), oldX-1, oldY)) ||
					       (this.containsElement(new Wall(Direction.NORTH), oldX  , oldY))) {
					System.out.println("The robot hitted a wall! ");
				} else {
					this.removeElement(robot, oldX, oldY);
					this.setRobot(robot, oldX-1, oldY);
				}
			} else if (robot.getDirection() == Direction.EAST) {
				// if the robot goes out of the board
				if (oldY+1 == COLUMNS) {
					this.removeElement(robot, oldX, oldY);
					this.setRobot(robot, rebootPositionX, rebootPositionY);
					System.out.println("The robot went out of the board!");
				// if the robot hits a wall
				} else if ((this.containsElement(new Wall(Direction.WEST), oldX, oldY-1)) ||
						   (this.containsElement(new Wall(Direction.EAST), oldX, oldY))) {
					System.out.println("The robot hitted a wall!");
				} else {
					this.removeElement(robot, oldX, oldY);
					this.setRobot(robot, oldX, oldY-1);
					}
				} else if (robot.getDirection() == Direction.WEST) {
					// if the robot goes out of the board
					if (oldY == 0) {
						this.removeElement(robot, oldX, oldY);
						this.setRobot(robot, rebootPositionX, rebootPositionY);
						System.out.println("The robot went out of the board!");
					// if the robot hits a wall
					} else if ((this.containsElement(new Wall(Direction.EAST), oldX, oldY+1)) ||
							   (this.containsElement(new Wall(Direction.WEST), oldX, oldY))) {
						System.out.println("The robot hitted a wall!");
					} else {
						this.removeElement(robot, oldX, oldY);
						this.setRobot(robot, oldX, oldY+1);
					}
				} else if (robot.getDirection() == Direction.SOUTH) {
					// if the robot goes out of the board
					if (oldX+1 == ROWS) {
						this.removeElement(robot, oldX, oldY);
						this.setRobot(robot, rebootPositionX, rebootPositionY);
						System.out.println("The robot went out of the board!");
					// if the robot hits a wall
					} else if ((this.containsElement(new Wall(Direction.NORTH), oldX+1, oldY)) ||
							   (this.containsElement(new Wall(Direction.SOUTH), oldX, oldY))) {
						System.out.println("The robot hitted a wall!");
					} else {
						this.removeElement(robot, oldX, oldY);
						this.setRobot(robot, oldX+1, oldY);
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