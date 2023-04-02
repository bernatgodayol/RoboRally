import java.util.HashSet;
import java.util.Set;

public class Tile {
	
	private Set<Element> obstacles = new HashSet<Element>();
	
	public void setObstacle(Element obstacle) {
		obstacles.add(obstacle);
	}
	
	public Set<Element> getObstacle() {
		return obstacles;
	}
	
	
	
}
