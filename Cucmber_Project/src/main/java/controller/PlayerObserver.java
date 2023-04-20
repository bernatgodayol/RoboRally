package controller;

import View.PlayerStatus;

public interface PlayerObserver {
	
	public void playerUpdated(PlayerStatus newStatus);
	
}