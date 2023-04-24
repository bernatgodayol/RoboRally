package controller;

import java.util.ArrayList;

public interface ViewObserver {
	public void menuViewUpdated(ArrayList<String> names);
	public void menuViewUpdated();
}
