
public class Robot extends Element{
	private Color color;
	private Direction direction;
	
	public Robot(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return color;
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

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
}
