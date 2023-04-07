import java.util.HashSet;
import java.util.Set;

public class Tile {
	
	private Set<Element> elements = new HashSet<Element>();
	
	public void setElement(Element element) {
		elements.add(element);
	}
	
	public Set<Element> getElement() {
		return elements;
	}
	
	public boolean containsObstacle(Element element) {
		return elements.contains(element);
	}
	
	
}
