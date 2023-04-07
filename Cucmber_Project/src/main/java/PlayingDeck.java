
public class PlayingDeck extends StaticDeck {
	
	public PlayingDeck() {
		deck = new Card[9];
	}
	
	public void moveCard(int index, ActionDeck actionDeck) {
		Card card = this.deck[index];
		
		int count = 0;
		for (Card element : actionDeck.getDeck()) {
			if (element == null) {
				actionDeck.getDeck()[count] = card;
				this.deck[index] = null;
				break;
			}
			count++;
		}
		
	}

}
