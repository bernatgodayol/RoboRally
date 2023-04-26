package View;

import model.Card;
import model.LeftTurn;
import model.MoveForward;
import model.RightTurn;
import model.UTurn;

public class CardStatus {
	
	private String player;
	private Card[] cardGrid;
	private int[] cardNumGrid;
	
	public CardStatus(int i, String player) {
		this.cardGrid = new Card[i];
		this.player = player;

	}
	
//	public void setCards(int num, int i) {		
//		cardGrid[i] = num;
//	}
	public void setCards(Card card, int i) {
		if (card instanceof MoveForward) {
			cardNumGrid[i] = 1;
		}
		else if (card instanceof RightTurn) {
			cardNumGrid[i] = 2;
		}
		else if (card instanceof LeftTurn) {
			cardNumGrid[i] = 3;
		}
		else if (card instanceof UTurn) {
			cardNumGrid[i] = 4;
		}
		else {
			cardNumGrid[i] = 5;
		}
		
		cardGrid[i] = card;
	}
	
	public Card[] getCards() {
		return cardGrid;
	}
	
	public int[] getCardsNum() {
		return cardNumGrid;
	}
	
	public String getPlayer() {
		return player;
	}
}
