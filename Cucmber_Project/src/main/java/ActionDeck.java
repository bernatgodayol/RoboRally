public class ActionDeck extends StaticDeck {
	
	public ActionDeck() {
		deck = new Card[5];
	}
	
//	public Card extractFirstCard() {
//		Card extractedCard = deck.get(1);
//		deck.remove(1);
//		return extractedCard;
//	}
	
	public Card extractFirstCard() {
		
		int count = 0;
		for (Card card : deck) {
			if (card != null) {
				Card extractedCard = card;
				deck[count] = null;
				return extractedCard;
			}
		count++;	
		}
		
		return null;
	}
	
}
