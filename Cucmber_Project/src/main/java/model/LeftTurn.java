package model;

public class LeftTurn implements Card {
	
	@Override
	public boolean equals(Object otherObject) {
		return (otherObject instanceof LeftTurn);
	}
	
	@Override
	public void execute(Robot robot, Board board) {
		System.out.println("The robot turns left.");
		if (robot.getDirection() == Direction.NORTH) {
			robot.setDirection(Direction.WEST);
		} else if(robot.getDirection() == Direction.WEST) {
			robot.setDirection(Direction.SOUTH);
		} else if(robot.getDirection() == Direction.SOUTH) {
			robot.setDirection(Direction.EAST);
		} else if(robot.getDirection() == Direction.EAST) {
			robot.setDirection(Direction.NORTH);
		}
	}

}
