package controller;

import java.util.ArrayList;

import model.Player;

public class PlayerFactory {

	public static void createPlayers(ArrayList<String> names) {
		
		ArrayList<Player> players = new ArrayList<Player>();
		
		for (String name: names) {
			Player player = new Player(name);
			players.add(player);
		}
		
		// Return players - but where to?? How do we get them into Main?
		
	}
	
}
