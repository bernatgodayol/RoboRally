package controller;

import java.util.ArrayList;

import View.PlayerStatus;

public interface PlayerStatusObserver {
	public void playerStatusUpdated(ArrayList<String> players);
}
