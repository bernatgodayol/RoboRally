package model;

public class MoveForward implements Card {
	
	public boolean equals(Object otherObject) {
		return (otherObject instanceof MoveForward);
	}
	
	public void execute(Robot robot, Board board) {
		if (!board.getTile(robot.geti(), robot.getj()).isExitable(robot.getDirection())) {
			System.out.println("The tile is not exitable! The robot does not move forward.");
		} else {
			if (robot.getDirection() == Direction.NORTH) {
				if (!board.isInsideBoard(robot.geti() - 1, robot.getj())) {
					robot.seti(board.getRebooti());
					robot.setj(board.getRebootj());
					System.out.println("The robot went out of the board. The robot is placed in the reboot cell.");
				} else if (!board.getTile(robot.geti() - 1, robot.getj()).isAccessible(Direction.SOUTH)) {
					System.out.println("The next tile is not accessible! The robot does not move forward.");
				} else if (!(board.whichRobot(robot.geti() - 1, robot.getj()) == null)) {
					System.out.println("There is another robot in the next tile.");
					
					Robot anotherRobot = board.whichRobot(robot.geti() - 1, robot.getj());
					Direction anotherRobotOldDirection = anotherRobot.getDirection();
					int anotherRobotOldi = anotherRobot.geti();
					int anotherRobotOldj = anotherRobot.getj();
					
					anotherRobot.setDirection(robot.getDirection());
					this.execute(anotherRobot, board);
					
					anotherRobot.setDirection(anotherRobotOldDirection);
					
					if (!(anotherRobotOldi == anotherRobot.geti() && anotherRobotOldj == anotherRobot.getj())) {
						System.out.println("The other robot moves forward. The robot moves forward.");
						robot.seti(robot.geti() - 1);
						robot.setj(robot.getj());
					} else {
						System.out.println("The other robot does not move forward. The robot does not move forward.");
					}
				} else {
					robot.seti(robot.geti() - 1);
					robot.setj(robot.getj());
				}
					
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
