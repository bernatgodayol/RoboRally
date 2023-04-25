package controller;

import java.util.ArrayList;

import View.View;
import model.Board;
import model.LeftTurn;
import model.MoveForward;
import model.Player;
import model.RightTurn;
import model.UTurn;

public class ProgrammingPhase implements ViewObserver{
	
	View view;
	ArrayList<Player> players;
	Board board;
	int numplayer;
	
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
	public void menuViewUpdated(int num, String player) {
		System.out.println("menuViewUpdated");
		if (players.size()>1) {
			if (players.get(0).getName() == player) {
				numplayer = 0;
				System.out.println("player 1 choosen");
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
		
		if (num == 1) {
			System.out.println("player 1 moved forward");
			MoveForward forward = new MoveForward();
			forward.execute(players.get(numplayer).getRobot(), board);
		}
		else if (num == 2) {
			RightTurn right = new RightTurn();
			right.execute(players.get(numplayer).getRobot(), board);
		}
		else if (num == 3) {
			LeftTurn left = new LeftTurn();
			left.execute(players.get(numplayer).getRobot(), board);
		}
		else if (num == 4) {
			UTurn uturn = new UTurn();
			uturn.execute(players.get(numplayer).getRobot(), board);
		}
		
	}
	
	
	
	
	
	
}
