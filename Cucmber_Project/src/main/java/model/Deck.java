package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import View.CardStatus;
import controller.CardObserver;
import java.util.Arrays;

public class Deck {
	
	private Player player;
	private ArrayList<Card> deck = new ArrayList<Card>();
	private Set<CardObserver> registeredCardObservers = new HashSet<CardObserver>();
	
	public ArrayList<Card> getDeck() {
		return this.deck;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
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
	
	public Card getCard(int index) {
		return this.deck.get(index);
	}
	
	public Card extractCard(int index) {
		Card card = this.deck.get(index);
		this.deck.remove(index);
		System.out.print(this.deck.isEmpty());
		System.out.println("Successfully extracted card !!!!");
		return card;
	}
	
	public void moveRandomCards(Deck otherDeck, Integer numCards) {
	    Random rand = new Random();
	    
	    CardStatus cs = notifyCardsUpdated(numCards, player.getName());
	    
	    if (this.deck.size() > numCards) {
	        for (int i = 0; i < numCards; i++) {
	            int index = rand.nextInt(deck.size());
	            Card card = this.deck.get(index);
	            otherDeck.getDeck().add(card);
	            this.deck.remove(index);
	            
	            notifyCardsUpdated(card, i, cs);
	   
	        }
	    } else {
	        System.out.println("Cannot move random cards!");
	    }
	}
	

	public void initializeProgrammingDeck() {
		for (int i=0; i<5; i++) {
			this.deck.add(new MoveForward());
		}
		for (int i=0; i<2; i++) {
			this.deck.add(new UTurn());
		}
		for (int i=0; i<5; i++) {
			this.deck.add(new LeftTurn());
		}
		for (int i=0; i<5; i++) {
			this.deck.add(new RightTurn());
		}
	}
	
	public void moveCard(int index, Deck otherDeck) {
	    if (this.deck.size() > index && index > -1) {
	    	Card card = this.deck.get(index);
	    	this.deck.remove(index);
	    	otherDeck.addCard(card);
	    } else {
	    	System.out.println("Index is not valid");
	    }
	}
	
	public void moveCard(int int1, int int2, int int3, int int4, int int5, Deck otherDeck) { 
	    Integer [] indices = {int1, int2, int3, int4, int5};
	    for (int i : indices) {
	    	if (i < 1 || i > this.getDeckSize()) {
	    		System.out.println("Index of card not valid");
	    	}
	    // add to the action deck
	    } 
	    for (int i : indices) {
	    	otherDeck.addCard(this.getCard(i-1));
	    	
	    } 
	    // Sort the array in descending order
	    Arrays.sort(indices, Collections.reverseOrder());
	    // remove from the playing deck
	    for( int i : indices) {
	    	this.removeCard(i-1);
	    }
	}
	
	public boolean deckIsEmpty() {
		return this.deck.isEmpty();
	}
	
	public void removeCard(int index) {
		this.deck.remove(index);
	}
	
	public void setRegisteredCardObservers(CardObserver cardObserver) {
		this.registeredCardObservers.add(cardObserver);	
	}
	
	private void notifyCardsUpdated(Card card, int i, CardStatus cs) {

		if (card instanceof MoveForward) {
			cs.setCards(1, i);
		}
		else if (card instanceof RightTurn) {
			cs.setCards(2, i);
		}
		else if (card instanceof LeftTurn) {
			cs.setCards(3, i);
		}
		else if (card instanceof UTurn) {
			cs.setCards(4, i);
		}
		else {
			cs.setCards(5, i);
		}
		
		for(CardObserver o : registeredCardObservers) {
			o.cardUpdated(cs);
		}
		
	}
		
		private CardStatus notifyCardsUpdated(int numCards, String player) {
			CardStatus cs = new CardStatus(numCards, player);
			for(CardObserver o : registeredCardObservers) {
				o.cardUpdated(cs);
			}
			return cs;
		}
}
