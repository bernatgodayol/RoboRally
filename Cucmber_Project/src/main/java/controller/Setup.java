package controller;

import java.util.ArrayList;

import View.PlayerStatus;
import View.View;
import model.Board;
import model.Color;
import model.Deck;
import model.Player;
import model.Robot;

public class Setup implements ViewObserver, MenuHandlerObserver {
	
	private Board board = new Board();
	private ArrayList<Player> players = new ArrayList<Player>();
	private PlayerStatus playerStatus = new PlayerStatus();
	private View view;
	
	public Setup(View view) {
		this.view = view;
		playerStatus.setRegisteredPlayerStatusObservers(view);
	}
	
	public Board getBoard() {
		return board;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
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
		
//		// Initialize players
//		for (String name: names) {
//			players.add(new Player(name));
//		}
//		
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
	
	}
	
	@Override
	public void menuViewUpdated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menuHandlerUpdated(int i) {
		if (i==1) {
			board.initialize5B();
			System.out.println("1");
		}
		else if (i==2) {
			board.initialize2B();
			System.out.println("2");
		}
		else if (i==3) {
			board.initialize4A();
			System.out.println("3");
		}
	}
	
//	private Player player1;
//	private Player player2;
//	private Player player3;
//	private Player player4;
//	
//	private Robot robot1;
//	private Robot robot2;
//	private Robot robot3;
//	private Robot robot4;
//	
//	private Deck programmingDeck1;
//	private Deck programmingDeck2;
//	private Deck programmingDeck3;
//	private Deck programmingDeck4;
//	
//	private Deck playingDeck1;
//	private Deck playingDeck2;
//	private Deck playingDeck3;
//	private Deck playingDeck4;
//	
//	private Deck actionDeck1;
//	private Deck actionDeck2;
//	private Deck actionDeck3;
//	private Deck actionDeck4;
//	
//	private Deck discardDeck1;
//	private Deck discardDeck2;
//	private Deck discardDeck3;
//	private Deck discardDeck4;
	
	
	
	
}
