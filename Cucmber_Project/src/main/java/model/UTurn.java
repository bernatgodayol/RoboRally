package model;

public class UTurn implements Card {
	
	public boolean equals(Object otherObject) {
		if (otherObject instanceof UTurn) {
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
