package controller;

import View.View;
import View.CardStatus;
import View.PlayerStatus;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Stage stage = new Stage();
		View view = new View();
		PlayerStatus playerStatus = new PlayerStatus();
		playerStatus.setRegisteredPlayerStatusObservers(view);
		
		Setup gameSetup = new Setup(view,playerStatus);
		gameSetup.getBoard().setRegisteredObservers(view);
		view.setRegisteredObservers(gameSetup);
		
		MenuHandler handler = new MenuHandler(view);
		ProgrammingPhase gameProgramming;
		CardStatus cs = new CardStatus();
		view.setRegisteredObservers(cs);
		gameProgramming = new ProgrammingPhase(gameSetup, cs);
		view.setRegisteredObservers(gameProgramming);
		handler.setRegisteredObservers(gameSetup);
		view.setMenuHandler(handler);
		ActivationPhase actionPhase = new ActivationPhase();
		gameProgramming.setRegisteredActionObservers(actionPhase);
				
		stage.setScene(view.choosePlayerNum());		
		stage.setTitle("RoboRally group 4");
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}

