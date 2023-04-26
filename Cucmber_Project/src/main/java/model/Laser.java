package model;

public class Laser implements WalkableElement {

	@Override
	public boolean equals(Object object) {
	    return (object instanceof Laser);
	}
	
	@Override
    public int hashCode() {
        return 1; // any constant value
    }

	@Override
	public void action(Robot robot, Board board) {
		robot.getPlayer().getProgrammingDeck().getDeck().add(new Damage());
	}
	
}
