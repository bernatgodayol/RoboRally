package model;

public class Wall extends BarrierElement {
	
	@Override
	public boolean equals(Object object) {
	    return (object instanceof Wall);
	}
	
	@Override
    public int hashCode() {
        return 2;
    }
}
