
public class Laser extends Element {
	
	private boolean active;
	
	public Laser() {
		active = false;
	}
	
	
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

	public void active(boolean b) {
		this.active = b;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
}
