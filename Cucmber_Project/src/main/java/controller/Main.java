package controller;

import View.BoardView;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Board;

public class Main extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		Group root = new Group();
//		Scene scene = new Scene(root,500,650);//setResizeable...

		BoardView boardView = new BoardView();
		Board board = new Board();
		board.setRegisteredObservers(boardView);
		board.initialize5B();

		Stage stage = new Stage();
		stage.setScene(boardView.getScene());
		stage.setResizable(false);
		stage.setTitle("RoboRally group 4");
		stage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}	
}

