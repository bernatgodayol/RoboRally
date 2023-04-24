package controller;

import java.util.ArrayList;

public interface PlayerStatusObserver {
	public void playerStatusUpdated(ArrayList<String> players);
}
