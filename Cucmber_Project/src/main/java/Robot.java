
public class Robot extends Element{
	private Color color;
	private Direction direction;
	private Player player;
	
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
