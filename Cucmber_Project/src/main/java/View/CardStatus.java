package View;

import java.util.ArrayList;

import controller.MenuViewObserver;

public class CardStatus implements MenuViewObserver {
	
	ArrayList<ArrayList<Integer>> cardGrids = new ArrayList<ArrayList<Integer>>();
	
	public void setCards(int index, int player) {		
		
		cardGrids.get(player).add(index);
		
//		
//		if (players.size()>1) {
//			
//			if (players.get(0).getName() == player) {
//				cardGrids.get(0).add(index);
//			}
//			
//			else if (players.get(1).getName() == player) {
//				cardGrids.get(1).add(index);
//			}
//		}
//		if (players.size()>2) {
//			
//			if (players.get(2).getName() == player) {
//				cardGrids.get(2).add(index);
//			}
//			
//		}
//		if (players.size()>3) {
//			if (players.get(3).getName() == player) {
//				cardGrids.get(3).add(index);
//			}
//		}
	}
	
	public ArrayList<ArrayList<Integer>> getCardGrids() {
		return cardGrids;
	}
//	
//	public String getPlayer() {
//		return player;
//	}


	@Override
	public void menuViewUpdated(ArrayList<String> names) {
		for (int i=0; i<names.size(); i++) {
			cardGrids.add(new ArrayList<Integer>());
		}
		
	}
}
