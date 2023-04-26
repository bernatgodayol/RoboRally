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
	    
//	    CardStatus cs = notifyCardsUpdated(numCards, player.getName());
	    
	    if (this.deck.size() > numCards) {
	        for (int i = 0; i < numCards; i++) {
	            int index = rand.nextInt(deck.size());
	            Card card = this.deck.get(index);
	            otherDeck.getDeck().add(card);
	            this.deck.remove(index);
	            
	            if (numCards == 9) {
	            	notifyCardsUpdated(card, i, player.getName());
	            }
	   
	        }
	    } else {
	        System.out.println("Cannot move random cards!");
	    }
	}
	

	public void initializeProgrammingDeck() {
		for (int i=0; i<10; i++) {
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
	    	if (i < 0 || i > (this.getDeckSize()-1)) {
	    		System.out.println("Index of card not valid");
	    	} else {
	    		// add to action deck
	    		otherDeck.addCard(this.getCard(i));
	    	}
	    }
	    // Sort the array in descending order
	    Arrays.sort(indices, Collections.reverseOrder());
	    // remove from the playing deck
	    for(int i : indices) {
	    	this.removeCard(i);
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
	
	private void notifyCardsUpdated(Card card, int index, String player) {
		
		int numCard;
		
		if (card instanceof MoveForward) {
			numCard = 1;
		}
		else if (card instanceof RightTurn) {
			numCard = 2;
		}
		else if (card instanceof LeftTurn) {
			numCard = 3;
		}
		else if (card instanceof UTurn) {
			numCard = 4;
		}
		else {
			numCard = 5;
		}
		
		for(CardObserver o : registeredCardObservers) {
			o.cardUpdated(card, index, numCard, player);
		}		
	}
	
}
