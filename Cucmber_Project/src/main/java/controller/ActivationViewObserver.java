package controller;

import java.util.ArrayList;

import model.Board;
import model.Player;

public interface ActivationViewObserver {
	public void continueActivationPhase(ArrayList<Player> players, Board board);
}
