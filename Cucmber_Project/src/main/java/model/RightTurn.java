package model;

public class RightTurn implements Card {
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof RightTurn) {
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
