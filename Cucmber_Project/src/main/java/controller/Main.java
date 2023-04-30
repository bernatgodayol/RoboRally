package controller;

import View.BoardView;
import View.ActivationView;
import View.CardStatus;
import View.MenuView;
import View.PlayerStatus;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage stage = new Stage();
		MenuView menuView = new MenuView();
		BoardView view = new BoardView(menuView.getAnchorPane(), menuView.getGridPaneCenter(), menuView.getScene());
		ActivationView winnerView = new ActivationView(view.getGridPaneCenter(), view.getGridPaneLeft(), view.getGridPaneRight());
		PlayerStatus playerStatus = new PlayerStatus();
		playerStatus.setRegisteredPlayerStatusObservers(view);
		
		Setup gameSetup = new Setup(view,playerStatus);
		gameSetup.getBoard().setRegisteredObservers(view);
		menuView.setRegisteredMenuViewObservers(gameSetup);
		
		ProgrammingPhase gameProgramming;
		CardStatus cs = new CardStatus();
		view.setCardStatus(cs);
		
		menuView.setRegisteredMenuViewObservers(cs);
		gameProgramming = new ProgrammingPhase(gameSetup, cs);
		view.setRegisteredBoardViewObservers(gameProgramming);
		ActivationPhase actionPhase = new ActivationPhase();
		gameProgramming.setRegisteredActionObservers(actionPhase);
		actionPhase.setRegisteredObservers(gameProgramming);
		gameSetup.setRegisteredObservers(gameProgramming);
		actionPhase.setRegisteredActivationPhaseObservers(winnerView);
		winnerView.setRegisteredActivationViewObservers(actionPhase);
			
		stage.setScene(menuView.choosePlayerNum());
		stage.setTitle("RoboRally group 4");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}

