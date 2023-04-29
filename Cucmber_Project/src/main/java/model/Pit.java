package model;

public class Pit implements WalkableElement {
	
	@Override
	public boolean equals(Object object) {
	    return (object instanceof Pit);
	}
	
	public void action(Robot robot, Board board) {
		robot.seti(board.getRebooti());
		robot.setj(board.getRebootj());
		
		robot.getPlayer().getProgrammingDeck().addCard(new Damage());
	}
	
}
