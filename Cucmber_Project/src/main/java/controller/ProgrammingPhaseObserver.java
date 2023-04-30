package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public interface ProgrammingPhaseObserver {
	public void startActivationPhase(ArrayList<Player> players, Board board);
}