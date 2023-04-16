
public class Laser extends Element {
	
	private boolean active;
	
	public Laser() {
		this.active = false;
	}
	
	public Laser(boolean active) {
		this.active = active;
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

	public void setStatus(boolean active) {
		this.active = active;
	}
	
	public boolean getStatus() {
		return this.active;
	}


	public void hit(Robot robot) {
		robot.getPlayer().getProgrammingDeck().getDeck().add(Card.Damage);
	}
	
}
