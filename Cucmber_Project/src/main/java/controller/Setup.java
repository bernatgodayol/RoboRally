package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import View.BoardView;
import model.AI;
import model.Board;
import model.Color;
import model.Deck;
import model.Player;
import model.Robot;

public class Setup implements MenuViewPlayerObserver, MenuViewBoardObserver {
	
	private Board board;
	private ArrayList<Player> players = new ArrayList<Player>();
	private BoardView view;
	private boolean isAI = false;
	private Set<PhaseShiftObserver> registeredPhaseShiftObservers = new HashSet<PhaseShiftObserver>();
	private Set<PlayerStatusObserver> registeredPlayerObservers = new HashSet<PlayerStatusObserver>();
	
	public Setup(BoardView view) {
		this.view = view;
		board = Board.getInstance();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public BoardView getView() {
		return view;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public boolean getIsAI() {
		return isAI;
	}
	
	@Override
	public void menuViewUpdated(ArrayList<String> names) {	
		int playerNum = names.size();
		
		// Initializing robots and decks and assigning them to players
		if (playerNum>0) {
			Player player1 = new Player(names.get(0));
			notifyPlayerUpdated(names.get(0));
			players.add(player1);
			
			Robot robot1 = new Robot(Color.GREEN);
			robot1.setRegisteredRobotObservers(view);
			players.get(0).setRobot(robot1);	
			Deck programmingDeck1 = new Deck();
			assignDecks(0,programmingDeck1);	
		}
		if (playerNum>1) {
			Player player2 = new Player(names.get(1));
			notifyPlayerUpdated(names.get(1));
			players.add(player2);
			
			Robot robot2 = new Robot(Color.YELLOW);
			robot2.setRegisteredRobotObservers(view);
			players.get(1).setRobot(robot2);
			Deck programmingDeck2 = new Deck();
			assignDecks(1,programmingDeck2);
		}
		if (playerNum>2) {
			Player player3 = new Player(names.get(2));
			notifyPlayerUpdated(names.get(2));
			players.add(player3);
			
			Robot robot3 = new Robot(Color.RED);
			robot3.setRegisteredRobotObservers(view);
			players.get(2).setRobot(robot3);
			Deck programmingDeck3 = new Deck();
			assignDecks(2,programmingDeck3);
		}
		if (playerNum>3) {
			Player player4 = new Player(names.get(3));
			notifyPlayerUpdated(names.get(3));
			players.add(player4);
			
			Robot robot4 = new Robot(Color.BLUE);
			robot4.setRegisteredRobotObservers(view);
			players.get(3).setRobot(robot4);
			Deck programmingDeck4 = new Deck();
			assignDecks(3,programmingDeck4);
		}	
		if (playerNum==1) {
			Player player2 = new AI();
			notifyPlayerUpdated("AI");
			players.add(player2);
			
			Robot robot2 = new Robot(Color.YELLOW);
			robot2.setRegisteredRobotObservers(view);
			players.get(1).setRobot(robot2);
			Deck programmingDeck2 = new Deck();
			assignDecks(1,programmingDeck2);
			
			isAI = true;
		}
	}

	@Override
	public void menuViewUpdated(int i) {
	notifyPhaseShift();
		
		if (i==1) {
			board.initializeEASY();
			setRobots();
		}
		else if (i==2) {
			board.initializeMEDIUM();
			setRobots();
		}
		else if (i==3) {
			board.initializeHARD();
			setRobots();
		}
	}
	
	private void assignDecks(int playerNo, Deck programmingDeck) {
		// Programming deck
		programmingDeck.initializeProgrammingDeck();
		players.get(playerNo).setProgrammingDeck(programmingDeck);
		programmingDeck.setRegisteredCardObservers(view);
		
		// Playing deck
		players.get(playerNo).setPlayingDeck(new Deck());
		
		// Action deck
		players.get(playerNo).setActionDeck(new Deck());
		
		// Discard deck
		players.get(playerNo).setDiscardDeck(new Deck());		
	}
	
	private void setRobots() {
		if (players.size()==2) {
			board.setRobots(players.get(0).getRobot(), players.get(1).getRobot());
		}
		else if (players.size()==3) {
			board.setRobots(players.get(0).getRobot(), players.get(1).getRobot(), players.get(2).getRobot());
		}
		else if (players.size()==4) {
			board.setRobots(players.get(0).getRobot(), players.get(1).getRobot(), players.get(2).getRobot(), players.get(3).getRobot());
		}
	}
	
	public void setRegisteredObservers(PhaseShiftObserver observer) {
		this.registeredPhaseShiftObservers.add(observer);	
	}

	public void setRegisteredPlayerObservers(PlayerStatusObserver observer) {
		this.registeredPlayerObservers.add(observer);	
	}
	
	private void notifyPhaseShift() {
		for(PhaseShiftObserver o : registeredPhaseShiftObservers) {
			o.startProgrammingPhase();
		}
	}
	
	private void notifyPlayerUpdated(String name) {
		for(PlayerStatusObserver o : registeredPlayerObservers) {
			o.playerStatusUpdated(name);
		}
	}


}
