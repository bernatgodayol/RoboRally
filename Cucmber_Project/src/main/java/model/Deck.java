package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	    if (this.deck.size() > numCards) {
	        for (int i = 0; i < numCards; i++) {
	            int index = rand.nextInt(deck.size());
	            Card card = this.deck.get(index);
	            otherDeck.getDeck().add(card);
	            this.deck.remove(index);
	        }
	        // System.out.println("Successfully moved random cards!");
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

		// System.out.println("Successfully initialized programming deck !!!!!");
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
	    if (((this.getDeckSize() > int1-1) && (int1-1 > -1)) &&
	    	((this.getDeckSize() > int2-1) && (int2-1 > -1)) &&
	    	((this.getDeckSize() > int3-1) && (int3-1 > -1)) &&
	    	((this.getDeckSize() > int4-1) && (int4-1 > -1)) &&
	    	((this.getDeckSize() > int5-1) && (int5-1 > -1))) {
	    	Card card1 = this.getCard(int1-1);
	    	Card card2 = this.getCard(int2-1);
	    	Card card3 = this.getCard(int3-1);
	    	Card card4 = this.getCard(int4-1);
	    	Card card5 = this.getCard(int5-1);	
	    	ArrayList<Integer> arraylist = new ArrayList<Integer>();
	    	
	    	arraylist.add(int1-1);
	        arraylist.add(int2-1);
	        arraylist.add(int3-1);
	        arraylist.add(int4-1);
	        arraylist.add(int5-1);
	        
	    	// Sorting ArrayList in descending order
		     Collections.sort(arraylist, new Comparator<Integer>() {
		    	 @Override
		         public int compare(Integer o1, Integer o2) {
		            return o2.compareTo(o1);
		         }
		      });
	    	for (int i : arraylist) {
	    		this.removeCard(i);
	    	}
	    	otherDeck.addCard(card1);
	    	otherDeck.addCard(card2);
	    	otherDeck.addCard(card3);
	    	otherDeck.addCard(card4);
	    	otherDeck.addCard(card5);
	    } else {
	    	System.out.println("Indexes are not valid");
	    }
	}
	
	public boolean deckIsEmpty() {
		return this.deck.isEmpty();
	}
	
	public void removeCard(int index) {
		this.deck.remove(index);
	}

}
