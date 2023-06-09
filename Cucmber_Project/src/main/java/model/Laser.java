package model;

public class Laser implements WalkableElement {

	@Override
	public boolean equals(Object object) {
	    return (object instanceof Laser);
	}

	@Override
	public void action(Robot robot, Board board) {
		robot.getPlayer().getProgrammingDeck().getDeck().add(new Damage());
	}
	
}
