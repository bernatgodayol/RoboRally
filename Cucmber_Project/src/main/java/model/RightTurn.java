package model;

public class RightTurn implements Card {
	
	public boolean equals(Object otherObject) {
		return (otherObject instanceof RightTurn);
	}
	
	
	@Override
	public void execute(Robot robot, Board board) {
		System.out.println("The robot turns right.");

		if (robot.getDirection() == Direction.NORTH) {
			robot.setDirection(Direction.EAST);
		} else if(robot.getDirection()==Direction.EAST) {
			robot.setDirection(Direction.SOUTH);
		} else if(robot.getDirection()==Direction.SOUTH) {
			robot.setDirection(Direction.WEST);
		} else if(robot.getDirection()==Direction.WEST) {
			robot.setDirection(Direction.NORTH);
		}
	}

}
