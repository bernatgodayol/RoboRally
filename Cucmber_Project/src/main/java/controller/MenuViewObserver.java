package controller;

import java.util.ArrayList;

public interface MenuViewObserver {
	public void menuViewUpdated(ArrayList<String> names);
	public void menuViewUpdated(int i);
}
