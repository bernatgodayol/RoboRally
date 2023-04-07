
public class Wall extends Element {
	
	private Direction direction;
	
	public Wall(Direction direction) {
		this.direction= direction;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Wall) {
			Wall otherWall = (Wall) obj;
			return (this.direction == otherWall.getDirection());
		} else {
			return false;
		}
	}
	
	public Direction getDirection() {
		return direction;
	}
	
}
