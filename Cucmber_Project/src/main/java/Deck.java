import java.util.ArrayList;
import java.util.Random;

public class Deck {

	// comment 
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public int getDeckSize() {
		return deck.size();
	}
	
	public void addCard(Card card) {
		deck.add(card);
	}

	public boolean contains(Card card) {
		return deck.contains(card);
	}
	
	public Card extractCard(int i) {
		Card card = deck.get(i);
		deck.remove(i);
		return card;
	}
	
	public void moveRandomCards(Deck otherDeck, Integer numCards) {
	    Random rand = new Random();
	    for (int i = 0; i < numCards; i++) {
	        int index = rand.nextInt(deck.size());
	        Card card = deck.get(index);
	        otherDeck.getDeck().set(i, card);
	        deck.remove(index);
	    }
	}
	
	public void initializeProgrammingDeck() {
		for (int i=0; i<5; i++) {
			this.deck.add(Card.MoveForward);
		}
		for (int i=0; i<2; i++) {
			this.deck.add(Card.UTurn);
		}
		for (int i=0; i<5; i++) {
			this.deck.add(Card.LeftTurn);
		}
		for (int i=0; i<5; i++) {
			this.deck.add(Card.RightTurn);
		}
	}
	
	public void moveCard(int index, Deck anotherDeck) {
	    if (this.deck.size()> index && index > -1) {
	    	Card card = this.deck.get(index);
	    	int count = 0;
		    for (Card element : anotherDeck.getDeck()) {
		        if (element == null) {
		            anotherDeck.getDeck().set(count, card);
		            this.deck.set(index, null);
		            break;
		        }
		        count++;
		    }
	    } else {
	    	System.out.println("Index is not valid");
	    }
	}

	public boolean deckIsEmpty() {
		return this.deck.isEmpty();
	}

	public void removeCard(Card card) {
		this.deck.remove(card);
	}

}
