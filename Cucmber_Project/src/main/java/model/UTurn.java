package model;

public class UTurn implements Card {

	@Override
	public void execute(Robot robot, Board board) {
		if(robot.getDirection()==Direction.NORTH) {
			robot.setDirection(Direction.SOUTH);
		}
		if(robot.getDirection()==Direction.WEST) {
			robot.setDirection(Direction.EAST);
		}
		if(robot.getDirection()==Direction.SOUTH) {
			robot.setDirection(Direction.NORTH);
		}
		if(robot.getDirection()==Direction.EAST) {
			robot.setDirection(Direction.WEST);
		}

	}

}
