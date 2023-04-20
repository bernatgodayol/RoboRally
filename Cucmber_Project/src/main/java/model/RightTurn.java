package model;

public class RightTurn implements Card {
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof RightTurn) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public void execute(Robot robot, Board board) {
		if(robot.getDirection()==Direction.NORTH) {
			robot.setDirection(Direction.EAST);
		}
		if(robot.getDirection()==Direction.EAST) {
			robot.setDirection(Direction.SOUTH);
		}
		if(robot.getDirection()==Direction.SOUTH) {
			robot.setDirection(Direction.WEST);
		}
		if(robot.getDirection()==Direction.WEST) {
			robot.setDirection(Direction.NORTH);
		}

	}

}
