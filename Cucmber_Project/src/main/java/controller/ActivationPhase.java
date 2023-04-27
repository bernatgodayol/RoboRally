package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.scene.media.*;

import model.Board;
import model.Player;

public class ActivationPhase implements ProgrammingPhaseObserver, ActivationViewObserver {
	
	private Set<PhaseShiftObserver> registeredPhaseShiftObservers = new HashSet<PhaseShiftObserver>();
	private Set<ActivationPhaseObserver> registeredActivationPhaseObservers = new HashSet<ActivationPhaseObserver>();
	private boolean end = false;
	private ClassLoader classLoader = getClass().getClassLoader();
	
	@Override
	public void startActivationPhase(ArrayList<Player> players, Board board) {
		
//		continueActivationPhase(players,board);
		notifyActivationPhaseUpdated(players,board,false);
		
//		if (players.size()==2) {
//			for (int i=0; i<5; i++) {
//				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
//				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
//				// End of register: activation of the obstacles (WalkableElement)
//				activateObstacles(players,board,2);
//				
//				if(end) {
//					break;
//				}
//			}
//		}
//		if (players.size()==3) {
//			for (int i=0; i<5; i++) {
//				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
//				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
//				players.get(2).getActionDeck().getCard(i).execute(players.get(2).getRobot(), board);
//				// End of register: activation of the obstacles (WalkableElement)
//				activateObstacles(players,board,3);
//				
//				if(end) {
//					break;
//				}
//			}
//		}
//		if (players.size()==4) {
//			for (int i=0; i<5; i++) {
//				players.get(0).getActionDeck().getCard(i).execute(players.get(0).getRobot(), board);
//				players.get(1).getActionDeck().getCard(i).execute(players.get(1).getRobot(), board);
//				players.get(2).getActionDeck().getCard(i).execute(players.get(2).getRobot(), board);
//				players.get(3).getActionDeck().getCard(i).execute(players.get(3).getRobot(), board);
//				// End of register: activation of the obstacles (WalkableElement)
//				activateObstacles(players,board,4);
//				
//				if(end) {
//					break;
//				}
//			}
//		}
//		
//		for (int i=0; i<players.size(); i++) {
//			players.get(i).getActionDeck().moveCard(0,1,2,3,4, players.get(i).getDiscardDeck());
//		}
		
//		if(!end) {
//			notifyPhaseShift();
//		}
		
	}
	
	@Override
	public void continueActivationPhase(ArrayList<Player> players, Board board) {
		
		if (players.get(0).getActionDeck().getDeckSize()!=0) {
			for (int i=0; i<players.size(); i++) {
				// Execute card:
				players.get(i).getActionDeck().getCard(0).execute(players.get(i).getRobot(), board);
				// Move executed card to discard deck:
				players.get(i).getActionDeck().moveCard(0, players.get(i).getDiscardDeck());
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
				
				String imageUrl = classLoader.getResource("Sounds/robot_damaged.mp3").toExternalForm();
				Media sound = new Media(imageUrl);
				MediaPlayer mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.play();
				
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
