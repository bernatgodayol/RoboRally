package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public class ActivationPhase implements ProgrammingPhaseObserver{
	
	@Override
	public void startActivationPhase(ArrayList<Player> players, Board board) {
		
		if (players.size()==2) {
			for (int i=0; i<5; i++) {
				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				
				// End of register: activation of the obstacles (WalkableElement)
				activateObstacles(players,board,2);
			}
		}
		if (players.size()==3) {
			for (int i=0; i<5; i++) {
				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				players.get(2).getActionDeck().getCard(i).execute(players.get(2).getRobot(), board);
				// End of register: activation of the obstacles (WalkableElement)
				activateObstacles(players,board,3);
			}
		}
		if (players.size()==4) {
			for (int i=0; i<5; i++) {
				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
				players.get(2).getActionDeck().getCard(i).execute(players.get(2).getRobot(), board);
				players.get(3).getActionDeck().getCard(i).execute(players.get(3).getRobot(), board);
				// End of register: activation of the obstacles (WalkableElement)
				activateObstacles(players,board,4);
			}
		}
		
		for (int i=0; i<players.size(); i++) {
			players.get(i).getActionDeck().moveCard(0,1,2,3,4, players.get(i).getDiscardDeck());
		}
	}
	
	private void activateObstacles(ArrayList<Player> players, Board board, int playerNum) {
		for (int j=0; j<playerNum; j++) {
			int i1 = players.get(j).getRobot().geti();
			int j1 = players.get(j).getRobot().getj();
			if (board.getTile(i1, j1).getWalkableElement()!=null) {
				board.getTile(i1, j1).getWalkableElement().action(players.get(j).getRobot(), board);
			}
		}
	}
}
