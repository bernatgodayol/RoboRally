package controller;

import java.util.ArrayList;

import model.Card;

public interface ViewObserver {
	public void menuViewUpdated(ArrayList<String> names);
	public void menuViewUpdated(int i, String player);
}
