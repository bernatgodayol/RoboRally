package model;

public class Pit implements WalkableElement {
	
	public void action(Robot robot, Board board) {
		robot.seti(board.getRebooti());
		robot.setj(board.getRebootj());
		System.out.println("The robot fell into a pit. The robot is placed in the reboot cell.");
		
		robot.getPlayer().getProgrammingDeck().addCard(new Damage());
	}
	
}
