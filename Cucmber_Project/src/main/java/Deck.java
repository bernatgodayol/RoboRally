import java.util.ArrayList;
import java.util.Random;

public class Deck {

	// comment 
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public int getDeckSize() {
		return this.deck.size();
	}
	
	public void addCard(Card card) {
		this.deck.add(card);
	}

	public boolean contains(Card card) {
		return this.deck.contains(card);
	}
	
	public Card extractCard(int i) {
		Card card = this.deck.get(i);
		this.deck.remove(i);
		System.out.println("Successfully extracted card !!!!");
		return card;
	}
	
	public void moveRandomCards(Deck otherDeck, Integer numCards) {
	    Random rand = new Random();
	    if (this.deck.size() > numCards) {
	        for (int i = 0; i < numCards; i++) {
	            int index = rand.nextInt(deck.size());
	            Card card = this.deck.get(index);
	            otherDeck.getDeck().add(card);
	            this.deck.remove(index);
	        }
	        System.out.println("Successfully moved random cards!");
	    } else {
	        System.out.println("Cannot move random cards!");
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

		// int initialSizeProgrammingDeck = deck.size();
		// System.out.println(initialSizeProgrammingDeck);
		System.out.println("Successfully initialized programming deck !!!!!");
	}
	
	public void moveCard(int index, Deck otherDeck) {
	    if (this.deck.size() > index && index > -1) {
	    	Card card = this.deck.get(index);
	    	this.deck.remove(index);
	    	otherDeck.addCard(card);
	    } else {
	    	System.out.println("Index is not valid");
	    }
	    System.out.println("Successfully moved cards !!!!!");
	}

	public boolean deckIsEmpty() {
		return this.deck.isEmpty();
	}

	public void removeCard(Card card) {
		this.deck.remove(card);
	}

}
