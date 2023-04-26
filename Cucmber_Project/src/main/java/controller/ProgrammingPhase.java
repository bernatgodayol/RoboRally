package controller;

import java.util.HashSet;
import java.util.Set;

import View.CardStatus;
import model.AI;
import model.Card;

public class ProgrammingPhase implements BoardViewObserver{
	
	Setup gamesetup;
	CardStatus cs;
	private int numplayer;
	private Set<ProgrammingPhaseObserver> registeredActionObservers = new HashSet<ProgrammingPhaseObserver>();
	
	public ProgrammingPhase(Setup gamesetup, CardStatus cs) {
		this.gamesetup = gamesetup;
		this.cs = cs;
	}
	
	public void initializeActionPhase() {
		
		if (gamesetup.getIsAI()) {
			if (gamesetup.getPlayers().get(1) instanceof AI) {
				AI playerAI = (AI) gamesetup.getPlayers().get(1);
				playerAI.pickCards(5);
			}
			
			int index1 = cs.getCardGrids().get(0).get(0);
			int index2 = cs.getCardGrids().get(0).get(1);
			int index3 = cs.getCardGrids().get(0).get(2);
			int index4 = cs.getCardGrids().get(0).get(3);
			int index5 = cs.getCardGrids().get(0).get(4);
			
			gamesetup.getPlayers().get(0).getPlayingDeck().moveCard(index1, index2, index3, index4, index5, gamesetup.getPlayers().get(0).getActionDeck());
			
			for (int j=0; j<4; j++) {
				gamesetup.getPlayers().get(0).getPlayingDeck().moveCard(0, gamesetup.getPlayers().get(0).getDiscardDeck());
				gamesetup.getPlayers().get(1).getPlayingDeck().moveCard(0, gamesetup.getPlayers().get(1).getDiscardDeck());
			}
		}
		else {
			for (int i=0; i<gamesetup.getPlayers().size(); i++) {
				int index1 = cs.getCardGrids().get(i).get(0);
				int index2 = cs.getCardGrids().get(i).get(1);
				int index3 = cs.getCardGrids().get(i).get(2);
				int index4 = cs.getCardGrids().get(i).get(3);
				int index5 = cs.getCardGrids().get(i).get(4);
				
				gamesetup.getPlayers().get(i).getPlayingDeck().moveCard(index1, index2, index3, index4, index5, gamesetup.getPlayers().get(i).getActionDeck());
				
				for (int j=0; j<4; j++) {
					gamesetup.getPlayers().get(i).getPlayingDeck().moveCard(0, gamesetup.getPlayers().get(i).getDiscardDeck());
				}
			}
		}
				
		notifyActionPhaseStart();
	}

	@Override
	public void boardViewUpdated(int index, String player) {
		
		if (gamesetup.getPlayers().size()>1) {
			if (gamesetup.getPlayers().get(0).getName() == player) {
				numplayer = 0;
			}
			if (gamesetup.getPlayers().get(1).getName() == player) {
				numplayer = 1;
			}
		}
		if (gamesetup.getPlayers().size()>2) {
			if (gamesetup.getPlayers().get(2).getName() == player) {
				numplayer = 2;
			}
		}
		if (gamesetup.getPlayers().size()>3) {
			if (gamesetup.getPlayers().get(3).getName() == player) {
				numplayer = 3;
			}
		}

		
		if (cs.getCardGrids().get(numplayer).size() < 5) {
			cs.setCards(index, numplayer);
			System.out.println(cs.getCardGrids());
		}
		else {
			System.out.println("No more cards can be choosen for player " + player);
		}
		
		
		
		if (gamesetup.getPlayers().size()==2) {
			if (gamesetup.getIsAI()) {
				if (cs.getCardGrids().get(0).size() == 5) {
					initializeActionPhase();				
				}
			}
			else {
				if (cs.getCardGrids().get(0).size() == 5 && 
						cs.getCardGrids().get(1).size() == 5) {
					
					initializeActionPhase();				
				}
			}
		}
		else if (gamesetup.getPlayers().size()==3) {
			if (cs.getCardGrids().get(0).size() == 5 && 
					cs.getCardGrids().get(1).size() == 5 &&
					cs.getCardGrids().get(2).size() == 5) {
					
				initializeActionPhase();			
			}
		}
		else if (gamesetup.getPlayers().size()==4) {
			if (cs.getCardGrids().get(0).size() == 5 && 
					cs.getCardGrids().get(1).size() == 5 &&
					cs.getCardGrids().get(2).size() == 5 &&
					cs.getCardGrids().get(3).size() == 5) {
					
				initializeActionPhase();				
			}
		}
	}
	
	public void setRegisteredActionObservers(ProgrammingPhaseObserver actionObserver) {
		this.registeredActionObservers.add(actionObserver);	
	}

	private void notifyActionPhaseStart() {
		for(ProgrammingPhaseObserver o : registeredActionObservers) {
			o.startActivationPhase(gamesetup.getPlayers(), gamesetup.getBoard());
		}
	}	
}
