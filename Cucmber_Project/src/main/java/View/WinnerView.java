package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.ActivationPhaseObserver;
import controller.ActivationViewObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.Board;
import model.Player;

public class WinnerView implements ActivationPhaseObserver{
	
	private GridPane gridPaneLeft;
	private GridPane gridPaneRight;
	private GridPane gridPaneCenter;
	private Set<ActivationViewObserver> registeredActivationViewObservers = new HashSet<ActivationViewObserver>();
	
	
	
	public WinnerView(GridPane gridPaneCenter, GridPane gridPaneLeft, GridPane gridPaneRight) {
		this.gridPaneCenter = gridPaneCenter;
		this.gridPaneLeft = gridPaneLeft;
		this.gridPaneRight = gridPaneRight;
	}

	@Override
	public void winnerFound(String player) {
		gridPaneCenter.getChildren().clear();
		gridPaneLeft.getChildren().clear();
		gridPaneRight.getChildren().clear();
		
		Label text = new Label(player + " has won!");
		text.setStyle("-fx-text-fill: red;-fx-font-size: 16px;");
		gridPaneCenter.add(text,0,0);
		
		Sound sound = new Sound();
		try {
			sound.playSound("fanfare");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void activationPhaseUpdated(ArrayList<Player> players, Board board, boolean endActivationPhase) {
		if (!endActivationPhase) {
			Button nextButton = new Button("Next");
			gridPaneRight.add(nextButton, 0, 15);
			nextButton.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					notifyActivationViewUpdated(players,board);
				}
			});
		}else {
			gridPaneRight.getChildren().removeIf(node -> GridPane.getColumnIndex(node)==0 && 
					GridPane.getRowIndex(node)==15);
		}	
	}
	
	public void setRegisteredActivationViewObservers(ActivationViewObserver observer) {
		this.registeredActivationViewObservers.add(observer);	
	}
	
	private void notifyActivationViewUpdated(ArrayList<Player> players, Board board) {
		for(ActivationViewObserver o : registeredActivationViewObservers) {
			o.continueActivationPhase(players, board);
		}		
	}
}
