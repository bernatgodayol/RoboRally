package model;

public class Damage implements Card {

	@Override
	public boolean equals(Object otherObject) {
		return (otherObject instanceof Damage);
	}
	
	@Override
	public void execute(Robot robot, Board board) {
		// it does not do anything, this is the damage !
	}

}
