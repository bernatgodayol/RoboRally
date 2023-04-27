package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public interface ActivationPhaseObserver {
	public void winnerFound(String player);
	public void activationPhaseUpdated(ArrayList<Player> players, Board board);
}
