package model;
public class Board {
	

	private Tile[][] grid;
	private int rebooti;
	private int rebootj;
	private int ROWS=13;
	private int COLUMNS=10;
	
	private Robot robot1;
	private Robot robot2;
	private Robot robot3;
	private Robot robot4;
	
	public Board() {
		grid = new Tile[ROWS][COLUMNS];
		
		for (int i=0; i<ROWS; i++) {
			for (int j=0; j<COLUMNS; j++) {
				grid[i][j] = new Tile();
			}
		}
	}
	
	public Tile getTile(int i, int j) {
		return grid[i][j];
	}
	
	public int getRebooti() {
		return rebooti;
	}
	
	public int getRebootj() {
		return rebootj;
	}
	
	public int getROWS() {
		return ROWS;
	}
	
	public int getCOLUMNS() {
		return COLUMNS;
	}
	
	public void initialize5B() {
		this.getTile(3, 3).setNorthBarrier(new Wall());
		this.getTile(3, 3).setWalkableElement(new Laser());
		this.getTile(4, 3).setSouthBarrier(new Wall());
		this.getTile(4, 3).setWalkableElement(new Laser());
		this.getTile(3, 5).setWestBarrier(new Wall());
		this.getTile(3, 5).setWalkableElement(new Laser());
		this.getTile(3, 6).setEastBarrier(new Wall());
		this.getTile(3, 6).setWalkableElement(new Laser());
		this.getTile(6, 3).setWestBarrier(new Wall());
		this.getTile(6, 3).setWalkableElement(new Laser());
		this.getTile(6, 4).setEastBarrier(new Wall());
		this.getTile(6, 4).setWalkableElement(new Laser());
		this.getTile(5, 6).setNorthBarrier(new Wall());
		this.getTile(5, 6).setWalkableElement(new Laser());
		this.getTile(6, 6).setSouthBarrier(new Wall());
		this.getTile(6, 6).setWalkableElement(new Laser());
		this.getTile(11, 2).setWestBarrier(new Wall());
		this.getTile(10, 4).setNorthBarrier(new Wall());
		this.getTile(10, 5).setNorthBarrier(new Wall());
		this.getTile(11, 7).setEastBarrier(new Wall());
	}
	
	public void setRobots(Robot robot1) {
		robot1.setDirection(Direction.NORTH);
		robot1.seti(12);
		robot1.setj(3);
		this.robot1 = robot1;
	}
	
	public void setRobots(Robot robot1, Robot robot2) {
		robot1.setDirection(Direction.NORTH);
		robot1.seti(12);
		robot1.setj(3);
		this.robot1 = robot1;
		robot2.setDirection(Direction.NORTH);
		robot2.seti(12);
		robot2.setj(6);
		this.robot2 = robot2;
		}
	
	public void setRobots(Robot robot1, Robot robot2, Robot robot3) {
		robot1.setDirection(Direction.NORTH);
		robot1.seti(12);
		robot1.setj(3);
		this.robot1 = robot1;
		robot2.setDirection(Direction.NORTH);
		robot2.seti(12);
		robot2.setj(6);
		this.robot2 = robot2;
		robot3.setDirection(Direction.NORTH);
		robot3.seti(11);
		robot3.setj(4);
		this.robot3 = robot3;
	}
	
	public void setRobots(Robot robot1, Robot robot2, Robot robot3, Robot robot4) {
		robot1.setDirection(Direction.NORTH);
		robot1.seti(12);
		robot1.setj(3);
		this.robot1 = robot1;
		robot2.setDirection(Direction.NORTH);
		robot2.seti(12);
		robot2.setj(6);
		this.robot2 = robot2;
		robot3.setDirection(Direction.NORTH);
		robot3.seti(11);
		robot3.setj(4);
		this.robot3 = robot3;
		robot4.setDirection(Direction.NORTH);
		robot4.seti(11);
		robot4.setj(5);
		this.robot4 = robot4;
	}

	
	public boolean isInsideBoard(int i, int j) {
		return ((i > -1) && (i < this.ROWS) && (j > -1) && (j < this.COLUMNS));
	}
	
	public Robot whichRobot(int i, int j) {
		if (!(robot1 == null)) {
			if (robot1.geti()==i && robot1.getj()==j) {
				return robot1;
			}
		} else if (!(robot2 == null)) {
			if (robot2.geti()==i && robot2.getj()==j) {
				return robot2;
			}
		} else if (!(robot3 == null)) {
			if (robot3.geti()==i && robot3.getj()==j) {
				return robot3;
			}
		} else if (!(robot4 == null)) {
			if (robot4.geti()==i && robot4.getj()==j) {
				return robot4;
			}
		}
		return null;
	}
}
