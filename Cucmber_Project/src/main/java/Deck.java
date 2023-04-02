import java.util.ArrayList;
import java.util.Random;

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
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public void moveRandomCards(Deck playingDeck, Integer int1) {
		Random rand = new Random();
		for (int i = 0; i < 9; i++) {
            int index = rand.nextInt(this.deck.size());
            Card card = deck.get(index);
            playingDeck.getDeck().add(card);
            deck.remove(index);
        }
		
	}
}
