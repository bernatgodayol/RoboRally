public class Move {
	private int i;
	private int j;
	private Direction direction;
	
	public Move(int i, int j, Direction direction) {
		this.i = i;
		this.j = j;
		this.direction = direction;
	}
	
	public int geti() {
		return this.i;
	}
	
	public int getj() {
		return this.j;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public void seti(int i) {
		this.i = i;
	}
	
	public void setj(int j) {
		this.j = j;
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
