package model;

public class Tile {
	
	private WalkableElement walkableElement;
	private BarrierElement northBarrier;
	private BarrierElement eastBarrier;
	private BarrierElement southBarrier;
	private BarrierElement westBarrier;
	
	public void setNorthBarrier(BarrierElement northBarrier) {
		this.northBarrier = northBarrier;
	}
	
	public void setEastBarrier(BarrierElement eastBarrier) {
		this.eastBarrier = eastBarrier;
	}
	
	public void setSouthBarrier(BarrierElement southBarrier) {
		this.southBarrier = southBarrier;
	}
	
	public void setWestBarrier(BarrierElement westBarrier) {
		this.westBarrier = westBarrier;
	}
	
	public BarrierElement getNorthBarrier() {
		return this.northBarrier;
	}
	
	public BarrierElement getEastBarrier() {
		return this.eastBarrier;
	}
	
	public BarrierElement getSouthBarrier() {
		return this.southBarrier;
	}
	
	public BarrierElement getWestBarrier() {
		return this.westBarrier;
	}
	
	public void setWalkableElement(WalkableElement walkableElement) {
		this.walkableElement = walkableElement;
	}
	
	public WalkableElement getWalkableElement() {
		return this.walkableElement;
	}
	
	public boolean isAccessible(Direction direction) {
		if (direction == Direction.NORTH) {
			return (northBarrier == null);
		} else if (direction == Direction.EAST) {
			return (eastBarrier == null);
		} else if (direction == Direction.SOUTH){
			return (southBarrier == null);
		} else {
			return (westBarrier == null);
		}
	}
	
	public boolean isExitable(Direction direction) {
		if (direction == Direction.NORTH) {
			return (northBarrier == null);
		} else if (direction == Direction.EAST) {
			return (eastBarrier == null);
		} else if (direction == Direction.SOUTH){
			return (southBarrier == null);
		} else {
			return (westBarrier == null);
		}
	}
	
	public boolean isEmpty() {
		return ((this.northBarrier == null) &&
				(this.eastBarrier == null) &&
				(this.southBarrier == null) &&
				(this.westBarrier == null) &&
				(this.walkableElement == null));
	}
	
}
