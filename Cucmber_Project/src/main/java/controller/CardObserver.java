package controller;

import model.Card;

public interface CardObserver {
	
	public void cardUpdated(Card card, int i, int numCard, String player);
	
}
