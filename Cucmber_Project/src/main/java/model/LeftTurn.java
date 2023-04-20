package model;

public class LeftTurn implements Card {
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof LeftTurn) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void execute(Robot robot, Board board) {
		// TODO Auto-generated method stub

	}

}
