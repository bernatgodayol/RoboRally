package model;

import java.util.HashSet;
import java.util.Set;

import View.BoardStatus;
import View.PlayerStatus;
import controller.BoardObserver;
import controller.CardObserver;
import controller.PlayerObserver;

public class Player {
	private String name;
	private Robot robot;
	private Deck programmingDeck;
	private Deck discardDeck;
	private Deck playingDeck;
	private Deck actionDeck;
	
	Set<PlayerObserver> registeredPlayerObservers = new HashSet<PlayerObserver>();

	public Player(String name) {
		this.name = name;
		
		notifyPlayerShift(this.name);
		
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
		
	public void setPlayingDeck(Deck playingDeck) {
		this.playingDeck = playingDeck;
	}
	
	public Deck getPlayingDeck() {
		return playingDeck;
	}
	
	public void setActionDeck(Deck actionDeck) {
		this.actionDeck = actionDeck;
	}
	
	public Deck getActionDeck() {
		return actionDeck;
	}
	
	public void setRegisteredPlayerObservers(PlayerObserver playerObserver) {
		this.registeredPlayerObservers.add(playerObserver);	
	}
	
	private void notifyPlayerShift(String name) {
		PlayerStatus ps = new PlayerStatus(name);
		for(PlayerObserver o : registeredPlayerObservers) {
			o.playerUpdated(ps);
		}
	}
}
