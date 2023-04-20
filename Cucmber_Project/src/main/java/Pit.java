
public class Pit implements WalkableElement {
	
	public void action(Robot robot, Board board) {
		robot.seti(board.getRebooti());
		robot.setj(board.getRebootj());
	}
}
