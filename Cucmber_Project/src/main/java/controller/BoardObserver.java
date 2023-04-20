package controller;

import View.BoardStatus;

public interface BoardObserver {
	
	public void boardUpdated(BoardStatus newStatus);
	
}
