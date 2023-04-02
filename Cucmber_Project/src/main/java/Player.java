import java.util.ArrayList;

public class Player {
	private String name;
	private Robot robot;
	private Deck programmingDeck;

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

	public void setProgrammingDeck(Deck deck) {
		this.programmingDeck = deck;
	}
	
	public Deck getProgrammingDeck() {
		return programmingDeck;
	}
	
	
	
}
