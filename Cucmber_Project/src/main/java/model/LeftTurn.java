package model;

public class LeftTurn implements Card {
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof LeftTurn) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void execute(Robot robot, Board board) {
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
