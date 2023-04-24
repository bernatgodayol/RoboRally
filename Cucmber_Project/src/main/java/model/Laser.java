package model;

public class Laser implements WalkableElement {

	@Override
	public boolean equals(Object object) {
	    if (object instanceof Laser) {
	        return true;
	    } else {
	    	return false;
	    }
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
