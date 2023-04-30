package controller;

import View.BoardView;
import View.ActivationView;
import View.CardStatus;
import View.MenuView;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage stage = new Stage();
		MenuView menuView = new MenuView();
		BoardView boardView = new BoardView(menuView.getAnchorPane(), menuView.getGridPaneCenter(), menuView.getScene());
		ActivationView activationView = new ActivationView(boardView.getGridPaneCenter(), boardView.getGridPaneLeft(), boardView.getGridPaneRight());
		
		Setup gameSetup = new Setup(boardView);
		gameSetup.getBoard().setRegisteredObservers(boardView);
		menuView.setRegisteredMenuViewObservers(gameSetup);
		gameSetup.setRegisteredPlayerObservers(boardView);
		
		ProgrammingPhase programmingPhase;
		CardStatus cs = new CardStatus();
		boardView.setCardStatus(cs);
		menuView.setRegisteredMenuViewObservers(cs);
		programmingPhase = new ProgrammingPhase(gameSetup, cs);
		boardView.setRegisteredBoardViewObservers(programmingPhase);
		gameSetup.setRegisteredObservers(programmingPhase);
		
		ActivationPhase activationPhase = new ActivationPhase();
		programmingPhase.setRegisteredProgrammingPhaseObservers(activationPhase);
		activationPhase.setRegisteredObservers(programmingPhase);
		activationPhase.setRegisteredActivationPhaseObservers(activationView);
		activationView.setRegisteredActivationViewObservers(activationPhase);
			
		stage.setScene(menuView.choosePlayerNum());
		stage.setTitle("RoboRally group 4");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}

