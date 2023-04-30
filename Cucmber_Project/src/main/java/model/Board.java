package model;
import java.util.HashSet;
import java.util.Set;

import View.BoardStatus;
import controller.BoardObserver;

public class Board {

    private static Board instance = new Board();
    private Set<BoardObserver> registeredBoardObservers = new HashSet<BoardObserver>();

    private Tile[][] grid;
    private int rebooti;
    private int rebootj;
    private int endi;
    private int endj;
    private int ROWS = 13;
    private int COLUMNS = 10;

    private Robot robot1;
    private Robot robot2;
    private Robot robot3;
    private Robot robot4;

    private Board() {
        grid = new Tile[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                grid[i][j] = new Tile();
            }
        }
    }

    public static Board getInstance() {
    	if (instance == null) {
            instance = new Board();
        }
        return instance;
    }
    
    public void emptyBoard() {
    	grid = new Tile[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
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
	
	public int getEndi() {
		return endi;
	}

	public int getEndj() {
		return endj;
	}
	
	public int getROWS() {
		return ROWS;
	}

	public int getCOLUMNS() {
		return COLUMNS;
	}
	
	public void initializeEASY() {
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
		
		this.rebooti = 5;
		this.rebootj = 3;
		
		this.endi = 0;
		this.endj = 3;

		notifyBoardUpdated();
	}
	
	public void initializeMEDIUM() {
		this.getTile(2, 2).setNorthBarrier(new Wall());
		this.getTile(3, 2).setSouthBarrier(new Wall());
		this.getTile(2, 3).setWestBarrier(new Wall());
		this.getTile(2, 4).setEastBarrier(new Wall());
		this.getTile(2, 6).setWestBarrier(new Wall());
		this.getTile(2, 7).setEastBarrier(new Wall());
		
		this.getTile(3, 7).setNorthBarrier(new Wall());
		this.getTile(4, 7).setSouthBarrier(new Wall());
		this.getTile(5, 2).setNorthBarrier(new Wall());
		this.getTile(6, 2).setSouthBarrier(new Wall());
		this.getTile(7, 2).setWestBarrier(new Wall());
		this.getTile(7, 3).setEastBarrier(new Wall());
		this.getTile(7, 5).setWestBarrier(new Wall());
		this.getTile(7, 6).setEastBarrier(new Wall());
		this.getTile(7, 7).setSouthBarrier(new Wall());
		this.getTile(6, 7).setNorthBarrier(new Wall());
		
		this.getTile(11, 2).setWestBarrier(new Wall());
		this.getTile(10, 4).setNorthBarrier(new Wall());
		this.getTile(10, 5).setNorthBarrier(new Wall());
		this.getTile(11, 7).setEastBarrier(new Wall());
		
		this.getTile(1, 4).setWalkableElement(new Pit());
		this.getTile(4, 8).setWalkableElement(new Pit());
		this.getTile(5, 1).setWalkableElement(new Pit());
		this.getTile(8, 5).setWalkableElement(new Pit());
		
		for (int i=2; i<8; i++) {
			if (i!=4) {
				this.getTile(i, 2).setWalkableElement(new Laser());;
			}
		}
		
		for (int i=2; i<8; i++) {
			if (i!=5) {
				this.getTile(i, 7).setWalkableElement(new Laser());;
			}		
		}
		
		for (int j=2; j<8; j++) {
			if (j!=5) {
				this.getTile(2, j).setWalkableElement(new Laser());;
			}		
		}
		
		for (int j=2; j<8; j++) {
			if (j!=4) {
				this.getTile(7, j).setWalkableElement(new Laser());;
			}		
		}
		
		this.rebooti = 9;
		this.rebootj = 7;
		
		this.endi = 0;
		this.endj = 3;
		
		notifyBoardUpdated();
	}
	
	public void initializeHARD() {
		this.getTile(5, 3).setWestBarrier(new Wall());
		
		this.getTile(3, 0).setNorthBarrier(new Wall());
		this.getTile(4, 0).setSouthBarrier(new Wall());
		this.getTile(3, 9).setNorthBarrier(new Wall());
		this.getTile(4, 9).setSouthBarrier(new Wall());
		
		this.getTile(0, 6).setWestBarrier(new Wall());
		this.getTile(0, 7).setEastBarrier(new Wall());
		this.getTile(9, 1).setWestBarrier(new Wall());
		this.getTile(9, 2).setEastBarrier(new Wall());
		
		this.getTile(3, 4).setWestBarrier(new Wall());
		this.getTile(3, 5).setEastBarrier(new Wall());
		this.getTile(6, 4).setWestBarrier(new Wall());
		this.getTile(6, 5).setEastBarrier(new Wall());
		
		this.getTile(2, 2).setNorthBarrier(new Wall());
		this.getTile(3, 2).setSouthBarrier(new Wall());
		this.getTile(6, 2).setNorthBarrier(new Wall());
		this.getTile(7, 2).setSouthBarrier(new Wall());
		this.getTile(2, 7).setNorthBarrier(new Wall());
		this.getTile(3, 7).setSouthBarrier(new Wall());
		this.getTile(6, 7).setNorthBarrier(new Wall());
		this.getTile(7, 7).setSouthBarrier(new Wall());
		
		this.getTile(11, 2).setWestBarrier(new Wall());
		this.getTile(10, 4).setNorthBarrier(new Wall());
		this.getTile(10, 5).setNorthBarrier(new Wall());
		this.getTile(11, 7).setEastBarrier(new Wall());
		
		this.getTile(2, 3).setWalkableElement(new Pit());
		this.getTile(3, 3).setWalkableElement(new Pit());
		this.getTile(6, 3).setWalkableElement(new Pit());
		this.getTile(7, 3).setWalkableElement(new Pit());
		this.getTile(2, 6).setWalkableElement(new Pit());
		this.getTile(3, 6).setWalkableElement(new Pit());
		this.getTile(6, 6).setWalkableElement(new Pit());
		this.getTile(7, 6).setWalkableElement(new Pit());
		
		for (int j=6; j<8; j++) {
			this.getTile(0, j).setWalkableElement(new Laser());;
		}
		
		for (int j=1; j<3; j++) {
			this.getTile(9, j).setWalkableElement(new Laser());;
		}
		
		for (int j=4; j<6; j++) {
			this.getTile(3, j).setWalkableElement(new Laser());;
		}
		
		for (int j=4; j<6; j++) {
			this.getTile(6, j).setWalkableElement(new Laser());;
		}
		
		for (int i=2; i<8; i++) {
			if (i!=4 && i!=5) {
				this.getTile(i, 2).setWalkableElement(new Laser());;
			}
		}
		
		for (int i=2; i<8; i++) {
			if (i!=4 && i!=5) {
				this.getTile(i, 7).setWalkableElement(new Laser());;
			}		
		}
		
		this.rebooti = 8;
		this.rebootj = 5;
		
		this.endi = 0;
		this.endj = 4;
		
		notifyBoardUpdated();
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
		if ((!(robot1 == null)) && (robot1.geti()==i && robot1.getj()==j)) {
			return robot1;
		} else if ((!(robot2 == null)) && (robot2.geti()==i && robot2.getj()==j)) {
			return robot2;
		} else if ((!(robot3 == null)) && (robot3.geti()==i && robot3.getj()==j)) {
			return robot3;
		} else if ((!(robot4 == null)) && (robot4.geti()==i && robot4.getj()==j)) {
			return robot4;
		}
		return null;
	}
	

	public void setRegisteredObservers(BoardObserver boardObserver) {
		this.registeredBoardObservers.add(boardObserver);	
	}	
	
	private void notifyBoardUpdated() {
		
		BoardStatus bs = new BoardStatus(ROWS, COLUMNS);
		
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLUMNS; j++) {
				if ((this.getTile(i, j).getNorthBarrier() instanceof Wall) &&
				   !(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(1, i, j);
				}
				else if ((this.getTile(i, j).getSouthBarrier() instanceof Wall) &&
						!(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(2, i, j);
				}
				else if ((this.getTile(i, j).getEastBarrier() instanceof Wall) &&
						!(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(3, i, j);
				}
				else if ((this.getTile(i, j).getWestBarrier() instanceof Wall) &&
						!(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(4, i, j);
				}	
				else if ((this.getTile(i, j).getNorthBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(5, i, j);
				}
				else if ((this.getTile(i, j).getSouthBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(6, i, j);
				}
				else if ((this.getTile(i, j).getEastBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(7, i, j);
				}
				else if ((this.getTile(i, j).getWestBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Laser)) {
					bs.setElementType(8, i, j);
				}
				else if ((this.getTile(i, j).getNorthBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Pit)) {
					bs.setElementType(9, i, j);
				}
				else if ((this.getTile(i, j).getSouthBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Pit)) {
					bs.setElementType(10, i, j);
				}
				else if ((this.getTile(i, j).getEastBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Pit)) {
					bs.setElementType(11, i, j);
				}
				else if ((this.getTile(i, j).getWestBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Pit)) {
					bs.setElementType(12, i, j);
				}
				else if (!(this.getTile(i, j).getNorthBarrier() instanceof Wall) &&
						!(this.getTile(i, j).getSouthBarrier() instanceof Wall) &&
						!(this.getTile(i, j).getEastBarrier() instanceof Wall) &&
						!(this.getTile(i, j).getWestBarrier() instanceof Wall) &&
						(this.getTile(i, j).getWalkableElement() instanceof Pit)) {
					bs.setElementType(13, i, j);
				}
				else {
					bs.setElementType(14, i, j);
				}
			}
		bs.setElementType(15, rebooti, rebootj);
		bs.setElementType(16, endi, endj);
			
		for(BoardObserver o : registeredBoardObservers) {
				o.boardUpdated(bs);
		}
		}
	}
	
}
