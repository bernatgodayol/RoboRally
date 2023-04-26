package controller;

import View.CardStatus;
import model.Card;

public interface CardObserver {
	
//	public void cardUpdated(Card card, int i, int numCard, String player);
	public void cardUpdated(CardStatus newStatus);

//	public void cardUpdated(CardStatus cs);
	
}
