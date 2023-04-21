package controller;

import View.CardStatus;

public interface CardObserver {
	
	public void cardUpdated(CardStatus newStatus);
	
}
