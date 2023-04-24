package model;

public class Damage implements Card {
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Damage) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public void execute(Robot robot, Board board) {
		// The damage is a blank card that doesn't do anything
	}

}
