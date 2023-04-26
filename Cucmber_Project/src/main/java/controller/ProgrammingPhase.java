package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import View.View;
import model.Board;
import model.Player;

public class ProgrammingPhase implements ViewObserver{
	
	View view;
	ArrayList<Player> players;
	Board board;
	int numplayer;
	private Set<StartActionPhaseObserver> registeredActionObservers = new HashSet<StartActionPhaseObserver>();
	
	public ProgrammingPhase(ArrayList<Player> players, View view, Board board) {
		this.view = view;
		this.players = players;
		this.board = board;
//		if (this.players.size()>1) {
//			this.players.get(0).getProgrammingDeck().moveRandomCards(this.players.get(0).getPlayingDeck(), 9);
//			this.players.get(1).getProgrammingDeck().moveRandomCards(this.players.get(1).getPlayingDeck(), 9);
//		}
//		else if (players.size()>2) {
//			players.get(2).getProgrammingDeck().moveRandomCards(players.get(2).getPlayingDeck(), 9);
//		}
//		else if (players.size()>3) {
//			players.get(3).getProgrammingDeck().moveRandomCards(players.get(3).getPlayingDeck(), 9);
//		}
	}

	@Override
	public void menuViewUpdated(ArrayList<String> names) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuViewUpdated(int index, String player) {
		
		if (players.size()>1) {
			if (players.get(0).getName() == player) {
				numplayer = 0;
			}
			if (players.get(1).getName() == player) {
				numplayer = 1;
			}
		}
		if (players.size()>2) {
			if (players.get(2).getName() == player) {
				numplayer = 2;
			}
		}
		if (players.size()>3) {
			if (players.get(3).getName() == player) {
				numplayer = 3;
			}
		}
		
		
		if (players.size()==2) {
			if (players.get(0).getActionDeck().getDeckSize() == 5 && 
					players.get(1).getActionDeck().getDeckSize() == 5) {
				notifyActionPhaseStart();				
			}
		}
		else if (players.size()==3) {
			if (players.get(0).getActionDeck().getDeckSize() == 5 && 
					players.get(1).getActionDeck().getDeckSize() == 5 &&
					players.get(2).getActionDeck().getDeckSize() == 5) {
				notifyActionPhaseStart();			
			}
		}
		else if (players.size()==4) {
			if (players.get(0).getActionDeck().getDeckSize() == 5 && 
					players.get(1).getActionDeck().getDeckSize() == 5 &&
					players.get(2).getActionDeck().getDeckSize() == 5 &&
					players.get(3).getActionDeck().getDeckSize() == 5) {
				notifyActionPhaseStart();				
			}
		}
		
		if (players.get(numplayer).getActionDeck().getDeckSize() < 5) {
			players.get(numplayer).getPlayingDeck().moveCard(index, players.get(numplayer).getActionDeck());
		}
		else {
			System.out.println("No more cards can be choosen for player " + player);
			for (int i=0; i<players.get(numplayer).getPlayingDeck().getDeckSize(); i++) {
				players.get(numplayer).getPlayingDeck().moveCard(i, players.get(numplayer).getDiscardDeck());
			}
		}
//			if (card.equals()) {
//				MoveForward forward = new MoveForward();
//				players.get(numplayer).getActionDeck().addCard(forward);
////				forward.execute(players.get(numplayer).getRobot(), board);
//			}
//			else if (num == 2) {
//				RightTurn right = new RightTurn();
//				players.get(numplayer).getActionDeck().addCard(right);
////				right.execute(players.get(numplayer).getRobot(), board);
//			}
//			else if (num == 3) {
//				LeftTurn left = new LeftTurn();
//				players.get(numplayer).getActionDeck().addCard(left);
////				left.execute(players.get(numplayer).getRobot(), board);
//			}
//			else if (num == 4) {
//				UTurn uturn = new UTurn();
//				players.get(numplayer).getActionDeck().addCard(uturn);
////				uturn.execute(players.get(numplayer).getRobot(), board);
//			}
	}
	
	public void setRegisteredActionObservers(StartActionPhaseObserver actionObserver) {
		this.registeredActionObservers.add(actionObserver);	
	}

	private void notifyActionPhaseStart() {
		for(StartActionPhaseObserver o : registeredActionObservers) {
			o.startActionPhase(players, board);
		}
	}	
}
