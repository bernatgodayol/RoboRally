package model;

public class AI extends Player {

	public AI() {
		super("AI");
	}

	public void pickCards() {
		getPlayingDeck().moveRandomCards(getActionDeck(), 5);
	}
	
	
}
