package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import View.Sound;
import model.AI;
import model.Player;

public class ProgrammingPhase implements BoardViewObserver, PhaseShiftObserver{
	
	private Setup gamesetup;
	private ArrayList<Player> players;
	private CardStatus cs;
	private int numplayer;
	private Set<ProgrammingPhaseObserver> registeredProgrammingPhaseObservers = new HashSet<ProgrammingPhaseObserver>();
	private Sound sound = new Sound();
	
	public ProgrammingPhase(Setup gamesetup, CardStatus cs) {
		this.players = gamesetup.getPlayers();
		this.gamesetup = gamesetup;
		this.cs = cs;
	}
	
	@Override
	public void startProgrammingPhase() {
		/*The indexes saved in the cardstatus are removed in the beginning of each 
		 * programming phase*/
		
		if (gamesetup.getIsAI()){
			if (cs.getCardGrids().get(0).size()!=0) {
				for (int j=0; j<5; j++) {
					cs.getCardGrids().get(0).remove(0);
				}
			}
		} 
		else {
			for (int i=0; i<players.size(); i++) {
				if (cs.getCardGrids().get(i).size()!=0) {
					for (int j=0; j<5; j++) {
						cs.getCardGrids().get(i).remove(0);
					}
				}
			}
		}
		
		
		/*Refills the programming deck with the cards from the discard deck if the
		 * programming deck is too small*/
		for(int i=0; i<players.size(); i++) {
			
			if (players.get(i).getProgrammingDeck().getDeckSize()<10) {
				players.get(i).getProgrammingDeck().refillDeck(players.get(i).getDiscardDeck());
			}
			
			//The players playing deck is filled with cards from the programming deck
			players.get(i).getProgrammingDeck().moveRandomCards(players.get(i).getPlayingDeck(),9);

		}
		
		//A sound is played
		try {
			sound.playSound("Start_programming");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public void boardViewUpdated(int index, String player) {
		//Assigns each player an integer 'numplayer'.
		
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

		/*If the players actiondeck is not full yet, the int index is saved in the players 
		 * cardstatus*/
		
		if (cs.getCardGrids().get(numplayer).size() < 5) {
			cs.setCards(index, numplayer);
		}
		
		
		/*Checking that the all the players actiondecks are full before starting the 
		 * activation phase*/
		if (players.size()==2) {
			if (cs.getCardGrids().get(0).size() == 5 && gamesetup.getIsAI()) {
				initializeActivationPhase();				
			}
			else if (cs.getCardGrids().get(0).size() == 5 && 
					cs.getCardGrids().get(1).size() == 5) {
					
				initializeActivationPhase();				
			}
		}
		else if (players.size()==3) {
			if (cs.getCardGrids().get(0).size() == 5 && 
					cs.getCardGrids().get(1).size() == 5 &&
					cs.getCardGrids().get(2).size() == 5) {
					
				initializeActivationPhase();			
			}
		}
		else if (players.size()==4) {
			if (cs.getCardGrids().get(0).size() == 5 && 
					cs.getCardGrids().get(1).size() == 5 &&
					cs.getCardGrids().get(2).size() == 5 &&
					cs.getCardGrids().get(3).size() == 5) {
					
				initializeActivationPhase();				
			}
		}
	}
	
	public void initializeActivationPhase() {
		/*The chosen cards from the players playing deck is moved to the action deck. 
		 * The remaining cards in the playing deck is moved to the discard deck.*/
		
		if (gamesetup.getIsAI()) {
			if (players.get(1) instanceof AI) {
				AI playerAI = (AI) players.get(1);
				playerAI.pickCards(5);
			}
			
			int index1 = cs.getCardGrids().get(0).get(0);
			int index2 = cs.getCardGrids().get(0).get(1);
			int index3 = cs.getCardGrids().get(0).get(2);
			int index4 = cs.getCardGrids().get(0).get(3);
			int index5 = cs.getCardGrids().get(0).get(4);
			
			players.get(0).getPlayingDeck().moveCard(index1, index2, index3, index4, index5, players.get(0).getActionDeck());
			
			for (int j=0; j<4; j++) {
				players.get(0).getPlayingDeck().moveCard(0, players.get(0).getDiscardDeck());
				players.get(1).getPlayingDeck().moveCard(0, players.get(1).getDiscardDeck());
			}
		}
		else {
			for (int i=0; i<players.size(); i++) {
				int index1 = cs.getCardGrids().get(i).get(0);
				int index2 = cs.getCardGrids().get(i).get(1);
				int index3 = cs.getCardGrids().get(i).get(2);
				int index4 = cs.getCardGrids().get(i).get(3);
				int index5 = cs.getCardGrids().get(i).get(4);
				
				players.get(i).getPlayingDeck().moveCard(index1, index2, index3, index4, index5, players.get(i).getActionDeck());
				
				for (int j=0; j<4; j++) {
					players.get(i).getPlayingDeck().moveCard(0, players.get(i).getDiscardDeck());
				}
			}
		}
		
		notifyActivationPhaseStart();
	}
	
	public void setRegisteredProgrammingPhaseObservers(ProgrammingPhaseObserver actionObserver) {
		this.registeredProgrammingPhaseObservers.add(actionObserver);	
	}

	private void notifyActivationPhaseStart() {
		//The ProgrammingPhaseObservers are notified that the activation phase can start.
		for(ProgrammingPhaseObserver o : registeredProgrammingPhaseObservers) {
			o.startActivationPhase(players, gamesetup.getBoard());
		}
	}

}
