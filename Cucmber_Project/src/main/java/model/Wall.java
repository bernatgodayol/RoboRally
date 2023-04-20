package model;

public class Wall extends BarrierElement {
	
	@Override
	public boolean equals(Object object) {
	    if (object instanceof Wall) {
	        return true;
	    } else {
	    	return false;
	    }
	}
	
	@Override
    public int hashCode() {
        return 2; // use direction to generate hash code
    }
}
