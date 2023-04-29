package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import View.Sound;

import model.Board;
import model.Damage;
import model.Player;

public class ActivationPhase implements ProgrammingPhaseObserver, ActivationViewObserver {
	
	private Set<PhaseShiftObserver> registeredPhaseShiftObservers = new HashSet<PhaseShiftObserver>();
	private Set<ActivationPhaseObserver> registeredActivationPhaseObservers = new HashSet<ActivationPhaseObserver>();
	private boolean end = false;
	private Sound sound = new Sound();
	
	@Override
	public void startActivationPhase(ArrayList<Player> players, Board board) {
		try {
			sound.playSound("Robots_activate");
		} catch (Exception e) {
			e.printStackTrace();
		}
		notifyActivationPhaseUpdated(players,board,false);
	}
	
	@Override
	public void continueActivationPhase(ArrayList<Player> players, Board board) {
		if (players.get(0).getActionDeck().getDeckSize()!=0) {
			for (int i=0; i<players.size(); i++) {
				// Execute card:
				players.get(i).getActionDeck().getCard(0).execute(players.get(i).getRobot(), board);
				// Move executed card to discard deck:
				if (players.get(i).getActionDeck().getCard(0) instanceof Damage) {
					players.get(i).getActionDeck().removeCard(0);
				}else {
					players.get(i).getActionDeck().moveCard(0, players.get(i).getDiscardDeck());
				}
			}
			// End of register: activation of the obstacles (WalkableElement)
			activateObstacles(players,board,players.size());
			
			if (!end) {
				notifyActivationPhaseUpdated(players,board,false);
			}
		
		}else {
			if (!end) {
				notifyActivationPhaseUpdated(players,board,true);
			}
			notifyPhaseShift();
		}
	}

	private void activateObstacles(ArrayList<Player> players, Board board, int playerNum) {
		for (int j=0; j<playerNum; j++) {
			int i1 = players.get(j).getRobot().geti();
			int j1 = players.get(j).getRobot().getj();
			if (board.getTile(i1, j1).getWalkableElement()!=null) {
				board.getTile(i1, j1).getWalkableElement().action(players.get(j).getRobot(), board);
				try {
					sound.playSound("robot_damaged");
				} catch (Exception e) {
					e.printStackTrace();
				}	
			}
			if (board.getEndi()==i1 && board.getEndj()==j1) {
				end = true;
				notifyGameEnds(players.get(j).getName());
			}
		}
	}
	
	private void notifyGameEnds(String name) {
		for(ActivationPhaseObserver o : registeredActivationPhaseObservers) {
			o.winnerFound(name);
		}
	}
	
	private void notifyActivationPhaseUpdated(ArrayList<Player> players, Board board, boolean endActivationPhase) {
		for(ActivationPhaseObserver o : registeredActivationPhaseObservers) {
			o.activationPhaseUpdated(players,board,endActivationPhase);
		}
	}

	private void notifyPhaseShift() {
		for(PhaseShiftObserver o : registeredPhaseShiftObservers) {
			o.startProgrammingPhase();
		}
	}

	public void setRegisteredObservers(PhaseShiftObserver observer) {
		this.registeredPhaseShiftObservers.add(observer);	
	}
	
	public void setRegisteredActivationPhaseObservers(ActivationPhaseObserver observer) {
		this.registeredActivationPhaseObservers.add(observer);	
	}

}
