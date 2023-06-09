package model;

public class UTurn implements Card {
	
	public boolean equals(Object otherObject) {
		return (otherObject instanceof UTurn);
	}
	
	@Override
	public void execute(Robot robot, Board board) {

		if(robot.getDirection() == Direction.NORTH) {
			robot.setDirection(Direction.SOUTH);
		} else if (robot.getDirection() == Direction.WEST) {
			robot.setDirection(Direction.EAST);
		} else if (robot.getDirection() == Direction.SOUTH) {
			robot.setDirection(Direction.NORTH);
		} else if (robot.getDirection() == Direction.EAST) {
			robot.setDirection(Direction.WEST);
		}
	}

}
