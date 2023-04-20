package model;

public class LeftTurn implements Card {
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof LeftTurn) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void execute(Robot robot, Board board) {
		if(robot.getDirection()==Direction.NORTH) {
			robot.setDirection(Direction.WEST);
		}
		if(robot.getDirection()==Direction.WEST) {
			robot.setDirection(Direction.SOUTH);
		}
		if(robot.getDirection()==Direction.SOUTH) {
			robot.setDirection(Direction.EAST);
		}
		if(robot.getDirection()==Direction.EAST) {
			robot.setDirection(Direction.NORTH);
		}
		

	}

}
