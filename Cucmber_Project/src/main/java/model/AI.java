package model;

public class AI extends Player {
	
	public AI() {
		super("AI");
	}
	
	public void pickCards(int numCards5) {
		getPlayingDeck().moveRandomCards(getActionDeck(), numCards5);
	}
	
}
