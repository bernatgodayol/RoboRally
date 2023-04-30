package model;

public class MoveForward implements Card {
	
	public boolean equals(Object otherObject) {
		return (otherObject instanceof MoveForward);
	}
	
	public void execute(Robot robot, Board board) {
		// check if the tile is exitable
		if (!board.getTile(robot.geti(), robot.getj()).isExitable(robot.getDirection())) {
			// --> the tile is not exitable ! the robot does not move forward
		} else {
			// check if robot direction is north
			if (robot.getDirection() == Direction.NORTH) {
				// check if next tile is inside the board
				if (!board.isInsideBoard(robot.geti() - 1, robot.getj())) {
					// --> move robot to reboot cell
					robot.seti(board.getRebooti());
					robot.setj(board.getRebootj());
					System.out.println("The robot went out of the board. The robot is placed in the reboot cell.");
				// check if next tile is accessible
				} else if (!board.getTile(robot.geti() - 1, robot.getj()).isAccessible(Direction.SOUTH)) {
					// --> the next tile is not accessible ! the robot does not move forward
				// check if in the next tile there is another robot
				} else if (!(board.whichRobot(robot.geti() - 1, robot.getj()) == null)) {
					System.out.println("There is another robot in the next tile.");
					// --> try to push other robot ! call recursive method execute again ... :)
					Robot anotherRobot = board.whichRobot(robot.geti() - 1, robot.getj());
					Direction anotherRobotOldDirection = anotherRobot.getDirection();
					int anotherRobotOldi = anotherRobot.geti();
					int anotherRobotOldj = anotherRobot.getj();
					
					anotherRobot.setDirection(robot.getDirection());
					this.execute(anotherRobot, board);
					
					anotherRobot.setDirection(anotherRobotOldDirection);
					// check if the other robot moved forward
					if (!(anotherRobotOldi == anotherRobot.geti() && anotherRobotOldj == anotherRobot.getj())) {
						// --> the other robot moves forward. the robot moves forward
						robot.seti(robot.geti() - 1);
						robot.setj(robot.getj());
					} else {
						// --> the other robot does not move forward. the robot does not move forward
					}
				} else {
					// --> move robot forward
					robot.seti(robot.geti() - 1);
					robot.setj(robot.getj());
				}
			// check if robot direction is south
			} else if (robot.getDirection() == Direction.SOUTH) {
					if (!board.isInsideBoard(robot.geti() + 1, robot.getj())) {
						robot.seti(board.getRebooti());
						robot.setj(board.getRebootj());
						System.out.println("The robot went out of the board. The robot is placed in the reboot cell.");
					} else if (!board.getTile(robot.geti() + 1, robot.getj()).isAccessible(Direction.NORTH)) {
						System.out.println("The next tile is not accessible! The robot does not move forward.");
					} else if (!(board.whichRobot(robot.geti() + 1, robot.getj()) == null)) {
						System.out.println("There is another robot in the next tile.");
						
						Robot anotherRobot = board.whichRobot(robot.geti() + 1, robot.getj());
						Direction anotherRobotOldDirection = anotherRobot.getDirection();
						int anotherRobotOldi = anotherRobot.geti();
						int anotherRobotOldj = anotherRobot.getj();
						
						anotherRobot.setDirection(robot.getDirection());
						this.execute(anotherRobot, board);
						
						anotherRobot.setDirection(anotherRobotOldDirection);
						
						if (!(anotherRobotOldi == anotherRobot.geti() && anotherRobotOldj == anotherRobot.getj())) {
							System.out.println("The other robot moves forward. The robot moves forward.");
							robot.seti(robot.geti() + 1);
							robot.setj(robot.getj());
						} else {
							System.out.println("The other robot does not move forward. The robot does not move forward.");
						}
					} else {
						robot.seti(robot.geti() + 1);
						robot.setj(robot.getj());
					}
			// check if robot direction is east		
			} else if (robot.getDirection() == Direction.EAST) {
						if (!board.isInsideBoard(robot.geti(), robot.getj() + 1)) {
							robot.seti(board.getRebooti());
							robot.setj(board.getRebootj());
							System.out.println("The robot went out of the board. The robot is placed in the reboot cell.");
						} else if (!board.getTile(robot.geti(), robot.getj() + 1).isAccessible(Direction.WEST)) {
							System.out.println("The next tile is not accessible! The robot does not move forward.");
						} else if (!(board.whichRobot(robot.geti(), robot.getj()+1) == null)) {
							System.out.println("There is another robot in the next tile.");
							
							Robot anotherRobot = board.whichRobot(robot.geti(), robot.getj() + 1);
							Direction anotherRobotOldDirection = anotherRobot.getDirection();
							int anotherRobotOldi = anotherRobot.geti();
							int anotherRobotOldj = anotherRobot.getj();
							
							anotherRobot.setDirection(robot.getDirection());
							this.execute(anotherRobot, board);
							
							anotherRobot.setDirection(anotherRobotOldDirection);
							
							if (!(anotherRobotOldi == anotherRobot.geti() && anotherRobotOldj == anotherRobot.getj())) {
								System.out.println("The other robot moves forward. The robot moves forward.");
								robot.seti(robot.geti());
								robot.setj(robot.getj() + 1);
							} else {
								System.out.println("The other robot does not move forward. The robot does not move forward.");
							}
						} else {
							robot.seti(robot.geti());
							robot.setj(robot.getj()+1);
						}
			// check if robot direction is west					
			} else if (robot.getDirection() == Direction.WEST) {
							if (!board.isInsideBoard(robot.geti(), robot.getj() - 1)) {
								robot.seti(board.getRebooti());
								robot.setj(board.getRebootj());
								System.out.println("The robot went out of the board. The robot is placed in the reboot cell.");
							} else if (!board.getTile(robot.geti(), robot.getj() - 1).isAccessible(Direction.EAST)) {
								System.out.println("The next tile is not accessible! The robot does not move forward.");
							} else if (!(board.whichRobot(robot.geti(), robot.getj() - 1) == null)) {
								System.out.println("There is another robot in the next tile.");
								
								Robot anotherRobot = board.whichRobot(robot.geti(), robot.getj()-1);
								Direction anotherRobotOldDirection = anotherRobot.getDirection();
								int anotherRobotOldi = anotherRobot.geti();
								int anotherRobotOldj = anotherRobot.getj();
								
								anotherRobot.setDirection(robot.getDirection());
								this.execute(anotherRobot, board);
								
								anotherRobot.setDirection(anotherRobotOldDirection);
								
								if (!(anotherRobotOldi == anotherRobot.geti() && anotherRobotOldj == anotherRobot.getj())) {
									robot.seti(robot.geti());
									robot.setj(robot.getj() - 1);
								} else {
									System.out.println("The other robot does not move forward. The robot does not move forward.");
									}
							} else {
								robot.seti(robot.geti());
								robot.setj(robot.getj() - 1);
								}
							}
			}
	}
	
}
