import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>(); 
	
	public Deck(boolean programmingDeck) {
		if (programmingDeck) {
			for (int i=0; i<5; i++) {
				deck.add(new MoveForwardCard());
			}
			for (int i=0; i<2; i++) {
				deck.add(new UTurnCard());
			}
			for (int i=0; i<5; i++) {
				deck.add(new LeftTurnCard());
			}
			for (int i=0; i<5; i++) {
				deck.add(new RightTurnCard());
			}	
		}
	}
}
