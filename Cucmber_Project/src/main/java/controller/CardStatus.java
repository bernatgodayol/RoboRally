package controller;

import java.util.ArrayList;

public class CardStatus implements MenuViewPlayerObserver {
	
	private ArrayList<ArrayList<Integer>> cardGrids = new ArrayList<ArrayList<Integer>>();
	
	public void setCards(int index, int player) {		
		cardGrids.get(player).add(index);
	}
	
	public ArrayList<ArrayList<Integer>> getCardGrids() {
		return cardGrids;
	}

	@Override
	public void menuViewUpdated(ArrayList<String> names) {
		for (int i=0; i<names.size(); i++) {
			cardGrids.add(new ArrayList<Integer>());
		}
	}		
}
