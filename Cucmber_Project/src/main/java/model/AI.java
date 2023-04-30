package model;

public class AI extends Player {
	
	public AI() {
		super("AI");
	}
	
	// method to pick numCards from the playing deck to the action deck
	public void pickCards(int numCards) {
		getPlayingDeck().moveRandomCards(getActionDeck(), numCards);
	}
	
}
