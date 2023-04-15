import java.util.HashSet;
import java.util.Set;

public class Tile {
	
	private Set<Element> elements = new HashSet<Element>();
	
	public void addElement(Element element) {
		elements.add(element);
	}
	
	public Set<Element> getElement() {
		return elements;
	}
	
	public void removeElement(Element element) {
		elements.remove(element);
	}
	
	public boolean containsElement(Element element) {
		return elements.contains(element);
	}	
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}
}
