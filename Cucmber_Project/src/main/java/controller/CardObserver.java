package controller;

import View.BoardStatus;
import View.CardStatus;

public interface CardObserver {
	
	public void cardUpdated(CardStatus newStatus);
	
}
