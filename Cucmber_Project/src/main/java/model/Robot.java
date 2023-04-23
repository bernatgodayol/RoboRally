package model;

import java.util.HashSet;
import java.util.Set;

import controller.CardObserver;
import controller.RobotObserver;

public class Robot {
	
	private Set<RobotObserver> registeredRobotObservers = new HashSet<RobotObserver>();
	private Color color;
	private Direction direction;
	private Player player;
	private int i;
	private int j;
	
	public Robot(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
		int oldI = i;
		int oldJ = j;
		notifyRobotUpdated(i,j, oldI, oldJ);
	}
	

	public Direction getDirection() {
		return direction;
	}
	
	public int geti() {
		return i;
	}
	
	public int getj() {
		return j;
	}
	
	public void seti(int iPosition) {
		int oldI = this.i;
		int oldJ = this.j;
		this.i = iPosition;
		
		notifyRobotUpdated(i,j,oldI,oldJ);
	}

	public void setj(int jPosition) {
		int oldI = this.i;
		int oldJ = this.j;
		this.j = jPosition;
		
		notifyRobotUpdated(i,j,oldI,oldJ);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Robot) {
			Robot otherRobot = (Robot) obj;
			return (this.color == otherRobot.getColor());
		} else {
			return false;
		}
	}
	
	public void setRegisteredRobotObservers(RobotObserver robotObserver) {
		this.registeredRobotObservers.add(robotObserver);	
	}
	
	private void notifyRobotUpdated(int i2, int j2, int oldI, int oldJ) {
		int robotColor;
		int robotDirection;
		
		if (color == Color.BLUE) {
			robotColor = 1;
		}
		else if (color == Color.GREEN) {
			robotColor = 2;
		}
		else if (color == Color.RED) {
			robotColor = 3;
		}
		else {
			robotColor = 4;
		}
		
		if (direction == Direction.NORTH) {
			robotDirection = 0;
		}
		else if (direction == Direction.SOUTH) {
			robotDirection = 180;
		}
		else if (direction == Direction.WEST) {
			robotDirection = 270;
		}
		else {
			robotDirection = 90;
		}
		
		for(RobotObserver o : registeredRobotObservers) {
			o.robotUpdated(i2, j2, oldI, oldJ, robotColor, robotDirection);
		}	
	}
	

}
