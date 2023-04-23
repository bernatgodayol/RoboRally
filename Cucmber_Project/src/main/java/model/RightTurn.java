package model;

public class RightTurn implements Card {

	@Override
	public void execute(Robot robot, Board board) {
		if(robot.getDirection()==Direction.NORTH) {
			robot.setDirection(Direction.EAST);
		}
		else if(robot.getDirection()==Direction.EAST) {
			robot.setDirection(Direction.SOUTH);
		}
		else if(robot.getDirection()==Direction.SOUTH) {
			robot.setDirection(Direction.WEST);
		}
		else if(robot.getDirection()==Direction.WEST) {
			robot.setDirection(Direction.NORTH);
		}

	}

}
