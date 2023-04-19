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
		
		Group root = new Group();
		Scene scene = new Scene(root,500,650);//setResizeable...
		Stage stage = new Stage();
		
		BoardView boardView = new BoardView();
		Board board = new Board();
		board.setRegisteredObservers(boardView);
		board.initialize5B();

		
		stage.setScene(boardView.getScene());
		stage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}	
}

