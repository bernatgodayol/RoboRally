package controller;

import View.BoardView;
import View.MenuView;
import View.PlayerStatus;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Board;
import model.Color;
import model.Deck;
import model.Direction;
import model.Player;
import model.Robot;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		BoardView boardView = new BoardView();
		PlayerStatus playerStatus = new PlayerStatus();
		Board board = new Board();
		board.setRegisteredObservers(boardView);
		board.initialize5B();
		playerStatus.setRegisteredPlayerStatusObservers(boardView);
		
		Player player1 = new Player("Mejseeeeee");
		player1.setRegisteredPlayerObservers(playerStatus);
		Player player2 = new Player("Bernattttt");
		player2.setRegisteredPlayerObservers(playerStatus);
		Player player3 = new Player("Mathieuuuu");
		player3.setRegisteredPlayerObservers(playerStatus);
		Player player4 = new Player("Ireneeeeee");
		player4.setRegisteredPlayerObservers(playerStatus);
		
		Deck pd1 = new Deck();
		pd1.initializeProgrammingDeck();
		player1.setProgrammingDeck(pd1);
		Deck pld1 = new Deck();
		player1.setPlayingDeck(pld1);
		pd1.setRegisteredCardObservers(boardView);
		pd1.moveRandomCards(player1.getPlayingDeck(), 9);
		
		Deck pd2 = new Deck();
		pd2.initializeProgrammingDeck();
		player2.setProgrammingDeck(pd2);
		Deck pld2 = new Deck();
		player2.setPlayingDeck(pld2);
		pd2.setRegisteredCardObservers(boardView);
		pd2.moveRandomCards(player2.getPlayingDeck(), 9);
		
		Deck pd3 = new Deck();
		pd3.initializeProgrammingDeck();
		player3.setProgrammingDeck(pd3);
		Deck pld3 = new Deck();
		player3.setPlayingDeck(pld3);
		pd3.setRegisteredCardObservers(boardView);
		pd3.moveRandomCards(player3.getPlayingDeck(), 9);
		
		Deck pd4 = new Deck();
		pd4.initializeProgrammingDeck();
		player4.setProgrammingDeck(pd4);
		Deck pld4 = new Deck();
		player4.setPlayingDeck(pld4);
		pd4.setRegisteredCardObservers(boardView);
		pd4.moveRandomCards(player4.getPlayingDeck(), 9);
		
		Robot robot1 = new Robot(Color.RED);
		robot1.setRegisteredRobotObservers(boardView);
		player1.setRobot(robot1);
		board.setRobots(robot1);
		robot1.seti(4);
		robot1.setDirection(Direction.EAST);
		robot1.setj(8);
		

		Stage stage = new Stage();
		stage.setScene(boardView.getScene());
//		stage.setResizable(false);
		stage.setTitle("RoboRally group 4");
		stage.show();
		
//		GridPane root = new GridPane();
//		Scene scene = new Scene(root,700,650);
//		
//		root.setAlignment(Pos.CENTER);
//		root.setHgap(10);
//		root.setVgap(10);
////		root.setPadding(new Insets(5,5,5,5));
//		
//		Label text = new Label("Choose difficulty:");
//		root.add(text,0,0,2,1);
//		
//		Button easyButton = new Button("Easy");
//		root.add(easyButton,0,1);
//
//		Button hardButton = new Button("Hard");
//		root.add(hardButton,1,1);
//		
//		
//		Stage stage = new Stage();
//		stage.setScene(scene);
////		stage.setResizable(false);
//		stage.setTitle("RoboRally group 4");
//		stage.show();
		

	}
	public static void main(String[] args) {
		launch(args);
	}	
}

