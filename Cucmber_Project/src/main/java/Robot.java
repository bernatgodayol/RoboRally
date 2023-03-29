
public class Robot {
	private Color color;
	
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
	
}
