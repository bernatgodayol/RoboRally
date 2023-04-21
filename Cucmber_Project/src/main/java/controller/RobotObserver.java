package controller;

import model.Direction;

public interface RobotObserver {
	public void robotUpdated(int i, int j, int oldI, int oldJ, int color, int direction);
}
