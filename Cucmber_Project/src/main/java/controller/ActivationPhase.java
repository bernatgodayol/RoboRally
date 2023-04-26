package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public class ActivationPhase implements ProgrammingPhaseObserver{
	
	@Override
	public void startActionPhase(ArrayList<Player> players, Board board, boolean isRobot) {
		
		if (isRobot) {
			players.get(1).getPlayingDeck().moveRandomCards(players.get(1).getActionDeck(), 5);
			
			for (int i=0; i<4; i++) {
				players.get(1).getPlayingDeck().moveCard(0, players.get(1).getDiscardDeck());
			}
		}
		
		if (players.size()==2) {
			if (isRobot) {
				for (int i=0; i<5; i++) {
					players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
					players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				}
				for (int i=0; i<4; i++) {
					players.get(1).getActionDeck().moveCard(0,players.get(1).getDiscardDeck());
				}
				
			}
			else {
				for (int i=0; i<5; i++) {
					players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
					players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				}
			}
		}
		if (players.size()==3) {
			for (int i=0; i<5; i++) {
				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				players.get(2).getActionDeck().getCard(i).execute(players.get(2).getRobot(), board);
			}
		}
		if (players.size()==4) {
			for (int i=0; i<5; i++) {
				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				players.get(2).getActionDeck().getCard(i).execute(players.get(2).getRobot(), board);
				players.get(3).getActionDeck().getCard(i).execute(players.get(3).getRobot(), board);
			}
		}
		
	}

}
