package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public class ActivationPhase implements ProgrammingPhaseObserver{
	
	@Override
	public void startActivationPhase(ArrayList<Player> players, Board board, boolean isRobot) {
		
//		if (isRobot) {
////			if (players.get(1) instanceof AI) {
////				AI playerAI = (AI) players.get(1);
////				playerAI.pickCards(5);
////			}
////			players.get(1).getPlayingDeck().moveCard(0,1,2,3, players.get(1).getDiscardDeck());
////			for (int i=0; i<4; i++) {
////				players.get(1).getPlayingDeck().moveCard(0, players.get(1).getDiscardDeck());
////			}
//		}
		
		if (players.size()==2) {
			if (isRobot) {
				for (int i=0; i<5; i++) {
					players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
					players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
					
					// End of register: activation of the obstacles (WalkableElement)
					activateObstacles(players,board,2);
					
				}
				for (int i=0; i<5; i++) {
					players.get(0).getActionDeck().moveCard(0,players.get(0).getDiscardDeck());
					players.get(1).getActionDeck().moveCard(0,players.get(1).getDiscardDeck());
				}
				
////			try {
////			Thread.sleep(1000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
				
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
