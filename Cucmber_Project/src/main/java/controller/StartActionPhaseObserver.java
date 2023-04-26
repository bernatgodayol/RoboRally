package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public interface StartActionPhaseObserver {
	public void startActionPhase(ArrayList<Player> players, Board board, boolean isRobot);
}
