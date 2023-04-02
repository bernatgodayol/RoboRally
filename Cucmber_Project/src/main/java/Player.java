import java.util.ArrayList;

public class Player {
	private String name;
	private Robot robot;
	private Deck programmingDeck;
	private Deck discardDeck;

	public Player(String name) {
		this.name = name;
	}
	
	public void setRobot(Robot robot) {
		this.robot = robot;
	}
	
	public Robot getRobot() {
		return robot;
	}
	
	public String getName() {
		return name;
	}

	public void setProgrammingDeck(Deck programmingDeck) {
		this.programmingDeck = programmingDeck;
	}
	
	public Deck getProgrammingDeck() {
		return programmingDeck;
	}

	public void setDiscardDeck(Deck discardDeck) {
		this.discardDeck = discardDeck;
	}
	
	public Deck getDiscardDeck() {
		return discardDeck;
	}
	
	
	
}
