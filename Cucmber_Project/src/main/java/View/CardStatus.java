package View;

import controller.PlayerObserver;

public class CardStatus implements PlayerObserver {
	
	private String player1;
	private String player2;
	private String player3;
	private String player4;
	private String activePlayer;
	private int[] cardGrid;
	private int[] cardGrid1;
	private int[] cardGrid2;
	private int[] cardGrid3;
	private int[] cardGrid4;
	
	@Override
	public void playerUpdated(PlayerStatus newStatus) {
		if(this.player1 == null &&
		this.player2 != newStatus.getPlayerStatus() &&
		this.player3 != newStatus.getPlayerStatus() &&
		this.player4 != newStatus.getPlayerStatus()) { 
			this.player1 = newStatus.getPlayerStatus();
		}
		else if(this.player2 == null &&
		this.player1 != newStatus.getPlayerStatus() &&
		this.player3 != newStatus.getPlayerStatus() &&
		this.player4 != newStatus.getPlayerStatus()) { 
			this.player2 = newStatus.getPlayerStatus();
		}
		else if(this.player3 == null &&
		this.player1 != newStatus.getPlayerStatus() &&
		this.player2 != newStatus.getPlayerStatus() &&
		this.player4 != newStatus.getPlayerStatus()) { 
			this.player3 = newStatus.getPlayerStatus();
		}
		else if(this.player4 == null &&
		this.player1 != newStatus.getPlayerStatus() &&
		this.player2 != newStatus.getPlayerStatus() &&
		this.player3 != newStatus.getPlayerStatus()) { 
			this.player4 = newStatus.getPlayerStatus();
		}
		
		activePlayer = newStatus.getPlayerStatus();
	}
	
	
	public CardStatus(int i) {
		this.cardGrid = new int[i];
		
		if(this.player1 == activePlayer) {
			this.cardGrid1 = this.cardGrid;
		}
		else if(this.player2 == activePlayer) {
			this.cardGrid2 = this.cardGrid;
		}
		else if(this.player3 == activePlayer) {
			this.cardGrid3 = this.cardGrid;
		}
		else if(this.player4 == activePlayer) {
			this.cardGrid4 = this.cardGrid;
		}
	}
	
	public void setCards(int num, int i) {		
		if(this.player1 == activePlayer) {
			this.cardGrid1[i] = num;
		}
		else if(this.player2 == activePlayer) {
			this.cardGrid2[i] = num;
		}
		else if(this.player3 == activePlayer) {
			this.cardGrid3[i] = num;
		}
		else if(this.player4 == activePlayer) {
			this.cardGrid4[i] = num;
		}
	}	
}
