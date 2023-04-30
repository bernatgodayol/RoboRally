package model;

public class Player {
	private String name;
	private Robot robot;
	private Deck programmingDeck;
	private Deck discardDeck;
	private Deck playingDeck;
	private Deck actionDeck;

	public Player(String name) {
		this.name = name;
	}

	public void setRobot(Robot robot) {
		robot.setPlayer(this);
		this.robot = robot;
	}

	public Robot getRobot() {
		return robot;
	}
	
	public String getName() {
		return name;
	}

	public void setProgrammingDeck(Deck programmingDeck) {
		programmingDeck.setPlayer(this);
		this.programmingDeck = programmingDeck;
	}
	
	public Deck getProgrammingDeck() {
		return this.programmingDeck;
	}

	public void setDiscardDeck(Deck discardDeck) {
		discardDeck.setPlayer(this);
		this.discardDeck = discardDeck;
	}
	
	public Deck getDiscardDeck() {
		return discardDeck;
	}
		
	public void setPlayingDeck(Deck playingDeck) {
		playingDeck.setPlayer(this);
		this.playingDeck = playingDeck;
	}
	
	public Deck getPlayingDeck() {
		return playingDeck;
	}
	
	public void setActionDeck(Deck actionDeck) {
		actionDeck.setPlayer(this);
		this.actionDeck = actionDeck;
	}
	
	public Deck getActionDeck() {
		return actionDeck;
	}
	
}
