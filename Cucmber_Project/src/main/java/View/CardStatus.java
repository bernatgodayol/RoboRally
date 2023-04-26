package View;

public class CardStatus {
	
	private String player;
	private int[] cardGrid;
	
//	public CardStatus(int i, String player) {
//		this.cardGrid = new int[i];
//		this.player = player;
//	}
	
	public void setCards(int num, int i) {		
		cardGrid[i] = num;
	}
	
	public int[] getCards() {
		return cardGrid;
	}
	
	public String getPlayer() {
		return player;
	}
}
