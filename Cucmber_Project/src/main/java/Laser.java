
public class Laser extends Element {
	@Override
	public boolean equals(Object object) {
	    if (object instanceof Laser) {
	        return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
    public int hashCode() {
        return 1; // any constant value
    }
	
}
