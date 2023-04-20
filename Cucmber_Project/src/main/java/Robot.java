
public class Robot {
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
		this.i = iPosition;
	}
	
	public void setj(int jPosition) {
		this.j = jPosition;
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
	
}
