package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.PlayerObserver;
import controller.PlayerStatusObserver;

public class PlayerStatus implements PlayerObserver{
	
	private ArrayList<String> players = new ArrayList<String>();
	Set<PlayerStatusObserver> registeredPlayerStatusObservers = new HashSet<PlayerStatusObserver>();
	
	@Override
	public void playerUpdated(String name) {
		if(!players.contains(name) && players.size()<5) {
			players.add(name);
			
			notifyPlayerStatusUpdated();
			
		}	
	}
	
	private void notifyPlayerStatusUpdated() {
		for(PlayerStatusObserver o : registeredPlayerStatusObservers) {
			o.playerStatusUpdated(this.players);
		}
	}

	public ArrayList<String> getPlayerStatus() {
		return players;
	}

	public void setRegisteredPlayerStatusObservers(PlayerStatusObserver observer) {
		this.registeredPlayerStatusObservers.add(observer);	
	}
		
}
