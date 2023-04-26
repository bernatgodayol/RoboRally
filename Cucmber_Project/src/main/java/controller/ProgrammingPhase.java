package controller;

import java.util.HashSet;
import java.util.Set;

import View.CardStatus;
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
		
		if (gamesetup.getIsRobot()) {
			for (int j=0; j<5; j++) {
				Card card = gamesetup.getPlayers().get(0).getPlayingDeck().getCard(cs.getCardGrids().get(0).get(j));
				gamesetup.getPlayers().get(0).getActionDeck().addCard(card);
			}
			
			for (int j=0; j<9; j++) {
				gamesetup.getPlayers().get(0).getPlayingDeck().moveCard(0, gamesetup.getPlayers().get(0).getDiscardDeck());
			}
		}
		else {
			for (int i=0; i<gamesetup.getPlayers().size(); i++) {
					
				for (int j=0; j<5; j++) {
					Card card = gamesetup.getPlayers().get(i).getPlayingDeck().getCard(cs.getCardGrids().get(i).get(j));
					gamesetup.getPlayers().get(i).getActionDeck().addCard(card);
				}
				
				for (int j=0; j<9; j++) {
					gamesetup.getPlayers().get(i).getPlayingDeck().moveCard(0, gamesetup.getPlayers().get(i).getDiscardDeck());
				}
			}
		}
				
		notifyActionPhaseStart(gamesetup.getIsRobot());
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
			if (gamesetup.getIsRobot()) {
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

	private void notifyActionPhaseStart(boolean isRobot) {
		for(ProgrammingPhaseObserver o : registeredActionObservers) {
			o.startActivationPhase(gamesetup.getPlayers(), gamesetup.getBoard(), isRobot);
		}
	}	
}
