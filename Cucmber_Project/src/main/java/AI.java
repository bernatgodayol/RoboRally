
public class AI extends Player {

	public AI() {
		super("AI");
	}

	public void pickCards() {
		playingDeck.moveRandomCards(actionDeck, 5);
	}
	
	
}
