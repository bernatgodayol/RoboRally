import java.util.ArrayList;
import java.util.Random;

public class ProgrammingDeck extends DynamicDeck {

	public ProgrammingDeck() {
		
		deck = new ArrayList<Card>(35); 
		
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
	
	public void moveRandomCards(PlayingDeck playingDeck, Integer int1) {
		Random rand = new Random();
		for (int i = 0; i < 9; i++) {
            int index = rand.nextInt(this.deck.size());
            Card card = deck.get(index);
            playingDeck.getDeck()[i] = card;
            deck.remove(index);
        }
		
	}

}
