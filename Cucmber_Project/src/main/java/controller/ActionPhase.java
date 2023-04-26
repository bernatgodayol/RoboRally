package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public class ActionPhase implements StartActionPhaseObserver{
	
	//private ArrayList<Player> players;
	
	@Override
	public void startActionPhase(ArrayList<Player> players, Board board) {
		//this.players = players;
		
		if (players.size()>1) {
			for (int i=0; i<5; i++) {
				players.get(0).getActionDeck().extractCard(i).execute(players.get(0).getRobot(), board);
			}
			for (int i=0; i<5; i++) {
				players.get(1).getActionDeck().extractCard(i).execute(players.get(1).getRobot(), board);
			}
		}
		if (players.size()>2) {
			for (int i=0; i<5; i++) {
				players.get(2).getActionDeck().extractCard(i).execute(players.get(2).getRobot(), board);
			}
		}
		if (players.size()>3) {
			for (int i=0; i<5; i++) {
				players.get(3).getActionDeck().extractCard(i).execute(players.get(3).getRobot(), board);
			}
		}
		
	}

}
