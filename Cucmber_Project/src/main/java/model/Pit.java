package model;

public class Pit extends Element {
	
	@Override
	public boolean equals(Object object) {
	    if (object instanceof Pit) {
	        return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
    public int hashCode() {
        return 1; // any constant value
    }
	
	public void fall(Robot robot, Board board) {
		board.setRobotPositionX(board.getRebootPositionX(), robot);
		board.setRobotPositionY(board.getRebootPositionY(), robot);
	}
}
