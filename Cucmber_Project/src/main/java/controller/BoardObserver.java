package controller;

import View.BoardStatus;
import javafx.scene.Scene;
import model.Board;

public interface BoardObserver {
	//public void setElementType(int num, int ROWS, int COLUMNS);
	public void boardUpdated(BoardStatus newStatus);
}
