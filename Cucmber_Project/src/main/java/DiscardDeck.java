import java.util.ArrayList;

public class DiscardDeck extends DynamicDeck {
	
	public DiscardDeck() {
		deck = new ArrayList<Card>(); 
	}

	public void addCard(Card card) {
		// TODO Auto-generated method stub
		deck.add(card);
	}

	public boolean contains(Card card) {
		// TODO Auto-generated method stub
		return deck.contains(card);
	}
}
