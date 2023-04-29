package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import View.PlayerStatus;
import View.BoardView;
import model.AI;
import model.Board;
import model.Color;
import model.Deck;
import model.Player;
import model.Robot;

public class Setup implements MenuViewObserver {
	
	private Board board;
	private ArrayList<Player> players = new ArrayList<Player>();
	private PlayerStatus playerStatus;
	private BoardView view;
	private boolean isAI = false;
	private Set<PhaseShiftObserver> registeredObservers = new HashSet<PhaseShiftObserver>();
	
	public Setup(BoardView view, PlayerStatus playerStatus) {
		this.view = view;
		this.playerStatus = playerStatus;
		board = new Board();
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
	
	@Override
	public void menuViewUpdated(ArrayList<String> names) {
				
		int length = names.size();
		
		// Initializing robots and decks and assigning them to players
		if (length>0) {
			Player player1 = new Player(names.get(0));
			player1.setRegisteredPlayerObservers(playerStatus);
			players.add(player1);
			
			Robot robot1 = new Robot(Color.GREEN);
			robot1.setRegisteredRobotObservers(view);
			players.get(0).setRobot(robot1);	
			Deck programmingDeck1 = new Deck();
			assignDecks(0,programmingDeck1);	
		}
		if (length>1) {
			Player player2 = new Player(names.get(1));
			player2.setRegisteredPlayerObservers(playerStatus);
			players.add(player2);
			
			Robot robot2 = new Robot(Color.YELLOW);
			robot2.setRegisteredRobotObservers(view);
			players.get(1).setRobot(robot2);
			Deck programmingDeck2 = new Deck();
			assignDecks(1,programmingDeck2);
		}
		if (length>2) {
			Player player3 = new Player(names.get(2));
			player3.setRegisteredPlayerObservers(playerStatus);
			players.add(player3);
			
			Robot robot3 = new Robot(Color.RED);
			robot3.setRegisteredRobotObservers(view);
			players.get(2).setRobot(robot3);
			Deck programmingDeck3 = new Deck();
			assignDecks(2,programmingDeck3);
		}
		if (length>3) {
			Player player4 = new Player(names.get(3));
			player4.setRegisteredPlayerObservers(playerStatus);
			players.add(player4);
			
			Robot robot4 = new Robot(Color.BLUE);
			robot4.setRegisteredRobotObservers(view);
			players.get(3).setRobot(robot4);
			Deck programmingDeck4 = new Deck();
			assignDecks(3,programmingDeck4);
		}	
		if (length==1) {
			Player player2 = new AI();
			player2.setRegisteredPlayerObservers(playerStatus);
			players.add(player2);
			
			Robot robot2 = new Robot(Color.YELLOW);
			robot2.setRegisteredRobotObservers(view);
			players.get(1).setRobot(robot2);
			Deck programmingDeck2 = new Deck();
			assignDecks(1,programmingDeck2);
			
			isAI = true;
		}
	
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
//	@Override
//	public void menuHandlerUpdated(int i) {
//				
//		notifyPhaseShift();
//		
//		if (i==1) {
//			board.initializeEASY();
//			setRobots();
//		}
//		else if (i==2) {
//			board.initializeMEDIUM();
//			setRobots();
//		}
//		else if (i==3) {
//			board.initializeHARD();
//			setRobots();
//		}
//	}
	
	private void notifyPhaseShift() {
		for(PhaseShiftObserver o : registeredObservers) {
			o.startProgrammingPhase();
		}
	}

	public void setRegisteredObservers(PhaseShiftObserver observer) {
		this.registeredObservers.add(observer);	
	}	
}
