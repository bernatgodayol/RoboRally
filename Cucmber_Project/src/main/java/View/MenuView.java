package View;

import java.util.ArrayList;

import controller.PlayerFactory;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MenuView {

	GridPane root = new GridPane();
	Scene scene = new Scene(root,700,650);
	
	public Scene choosePlayerNum() {
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
//		root.setPadding(new Insets(25,25,25,25)); 
		
		Label text = new Label("How many players are playing?");
		root.add(text,0,0,4,1);
		
		Button button1 = new Button("1");
		root.add(button1,0,1);
		button1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {		
				typePlayerNames(1);
			}
		});
		
		Button button2 = new Button("2");
		root.add(button2,1,1);
		button2.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(2);
			}
		});
		
		Button button3 = new Button("3");
		root.add(button3,2,1);
		button3.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(3);
			}
		});
		
		Button button4 = new Button("4");
		root.add(button4,3,1);
		button4.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(4);
			}
		});
		
		return scene;
	}
	
	public void typePlayerNames(int i) {
		root.getChildren().clear();
		ArrayList<String> names = new ArrayList<String>();
		
		if (i>0 && i<5) {
			if (i>0) {
				Label text1 = new Label("Type the name of player 1 (Blue robot):");
				root.add(text1,0,0);
				
				TextField textField1 = new TextField();
				root.add(textField1,0,1);
				
				names.add(textField1.getText());
			}
		
			if (i>1) {
				Label text2 = new Label("Type the name of player 2 (Green robot):");
				root.add(text2,0,2);
				
				TextField textField2 = new TextField();
				root.add(textField2,0,3);
				
				names.add(textField2.getText());
			}
			
			if (i>2) {
				Label text3 = new Label("Type the name of player 3 (Red robot):");
				root.add(text3,0,4);
				
				TextField textField3 = new TextField();
				root.add(textField3,0,5);
				
				names.add(textField3.getText());
			}
			
			if (i>3) {
				Label text4 = new Label("Type the name of player 4 (Yellow robot):");
				root.add(text4,0,6);
				
				TextField textField4 = new TextField();
				root.add(textField4,0,7);
				
				names.add(textField4.getText());
			}
			
			Button button = new Button("Next");
			root.add(button,0,i*2);
			button.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					PlayerFactory.createPlayers(names); // Not sure this is the way to go (Mejse)
					chooseDifficulty();
				}
			});
					
		}else {
			System.out.println("There cannot be less than 1 player or more than 4 players");
		}		
	}
	
	public void chooseDifficulty() {
		root.getChildren().clear();
		
		Label text = new Label("Choose difficulty:");
		root.add(text,0,0,3,1);
		
		Button easyButton = new Button("Easy");
		root.add(easyButton,0,1);
		easyButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				// Create 5B board
			}
		});
		
		Button mediumButton = new Button("Medium");
		root.add(mediumButton,1,1);
		mediumButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				// Create 2B board
			}
		});

		Button hardButton = new Button("Hard");
		root.add(hardButton,2,1);
		hardButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				// Create 4A board
			}
		});
		
	}
	
}
