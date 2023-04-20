package View;

public class CardStatus {
	protected int[] cardGrid;
	
	public CardStatus(int i) {
		cardGrid = new int[i];
	}

	public void setCardType(int num, int i) {
		cardGrid[i] = num;
	}
	
	public int[] getStatusBoard() {
		return this.cardGrid;
	}
	
}
