package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.MenuViewBoardObserver;
import controller.MenuViewPlayerObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MenuView {
	
	private BorderPane anchorPane = new BorderPane();
	private GridPane gridPaneCenter = new GridPane();
	private Scene scene = new Scene(anchorPane,800,650);
	private Set<MenuViewPlayerObserver> registeredMenuViewPlayerObservers = new HashSet<MenuViewPlayerObserver>();
	private Set<MenuViewBoardObserver> registeredMenuViewBoardObservers = new HashSet<MenuViewBoardObserver>();
	
	public Scene getScene() {
		return scene;
	}
	public BorderPane getAnchorPane() {
		return anchorPane;
	}
	public GridPane getGridPaneCenter() {
		return gridPaneCenter;
	}
	
	public Scene choosePlayerNum() {
		/*A scene is created where the player can choose the number of players 
		 *playing the game */
		
		anchorPane.setCenter(gridPaneCenter);		
		gridPaneCenter.setAlignment(Pos.CENTER);
		gridPaneCenter.setHgap(10);
		gridPaneCenter.setVgap(10);
		
		//A background color is created and drawn
		BackgroundFill backgroundFill = new BackgroundFill(
		                Color.valueOf("#add8e6"),
		                new CornerRadii(10),
		                new Insets(10)
		                );

		Background background = new Background(backgroundFill);
		gridPaneCenter.setBackground(background);
		
		//The label is drawn
		Label text = new Label("How many players are playing?");
		gridPaneCenter.add(text,0,0,4,1);
		
		//The buttons are drawn and if pressed on, the method typePlayerNames is run
		Button button1 = new Button("1");
		gridPaneCenter.add(button1,0,1);
		button1.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(1);
			}
		});
		
		Button button2 = new Button("2");
		gridPaneCenter.add(button2,1,1);
		button2.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(2);
			}
		});
		
		Button button3 = new Button("3");
		gridPaneCenter.add(button3,2,1);
		button3.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(3);
			}
		});
		
		Button button4 = new Button("4");
		gridPaneCenter.add(button4,3,1);
		button4.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				typePlayerNames(4);
			}
		});
		
		return scene;
	}
	
	public void typePlayerNames(int i) {
		//Scene where the players names are written so the players can be initialized
		
		//The scene is cleared
		gridPaneCenter.getChildren().clear();
		ArrayList<String> names = new ArrayList<String>();
		
		TextField textField1 = new TextField();
		TextField textField2 = new TextField();
		TextField textField3 = new TextField();
		TextField textField4 = new TextField();
		
		//The textfields are drawn according to the number of players
		if (i>0 && i<5) {
			if (i>0) {
				Label text1 = new Label("Type the name of player 1 (Green robot):");
				gridPaneCenter.add(text1,0,0);
				gridPaneCenter.add(textField1,0,1);
			}
		
			if (i>1) {
				Label text2 = new Label("Type the name of player 2 (Yellow robot):");
				gridPaneCenter.add(text2,0,2);
				gridPaneCenter.add(textField2,0,3);
			}
			
			if (i>2) {
				Label text3 = new Label("Type the name of player 3 (Red robot):");
				gridPaneCenter.add(text3,0,4);
				gridPaneCenter.add(textField3,0,5);
			}
			
			if (i>3) {
				Label text4 = new Label("Type the name of player 4 (Blue robot):");
				gridPaneCenter.add(text4,0,6);
				gridPaneCenter.add(textField4,0,7);
			}
		}
		
		/*Checking that the textfields contains unique names, no field is blank or 
		 *contains the string 'AI' when nutton 'next' is clicked on. The methods 
		 *'notifyMenuViewUpdated' and 'chooseDifficulty' are called */
		Button button = new Button("Next");
		gridPaneCenter.add(button,0,i*2);			
		button.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				if (i == 1 && !textField1.getText().isEmpty() && !textField1.getText().equals("AI")) {
					names.add(textField1.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else if (i == 2 && !textField1.getText().isEmpty() && !textField2.getText().isEmpty() && 
						!textField1.getText().equals("AI") && !textField2.getText().equals("AI") &&
						!textField1.getText().equals(textField2.getText())) {
					names.add(textField1.getText());
					names.add(textField2.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else if (i == 3 && !textField1.getText().isEmpty() && !textField2.getText().isEmpty() && 
						!textField3.getText().isEmpty() && !textField1.getText().equals("AI") && 
						!textField2.getText().equals("AI") && !textField3.getText().equals("AI") &&
						!textField1.getText().equals(textField2.getText()) && 
						!textField1.getText().equals(textField3.getText()) && 
						!textField3.getText().equals(textField2.getText())){
					names.add(textField1.getText());
					names.add(textField2.getText());
					names.add(textField3.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else if (i == 4 && !textField1.getText().isEmpty() && !textField2.getText().isEmpty() && 
						!textField3.getText().isEmpty() && !textField4.getText().isEmpty() &&
						!textField1.getText().equals("AI") && !textField2.getText().equals("AI") && 
						!textField3.getText().equals("AI") && !textField4.getText().equals("AI") &&
						!textField1.getText().equals(textField2.getText()) && 
						!textField1.getText().equals(textField3.getText()) && 
						!textField3.getText().equals(textField2.getText()) &&
						!textField1.getText().equals(textField4.getText()) &&
						!textField2.getText().equals(textField4.getText()) &&
						!textField3.getText().equals(textField4.getText())){
					names.add(textField1.getText());
					names.add(textField2.getText());
					names.add(textField3.getText());
					names.add(textField4.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else {
					//An error message is printed on the scene
					Label text1 = new Label("Please choose a unique name for each player.\n"
							+ "Player cannot be named 'AI'");
					text1.setStyle("-fx-text-fill: red;");
					gridPaneCenter.add(text1,0,(i*2+1));
				}
			}
		});
	}
	
	public void chooseDifficulty() {
		//The player can chooses the difficulty of the game so the board can be initialized
		
		//The scene is cleared 
		gridPaneCenter.getChildren().clear();
		
		//The label is drawn
		Label text = new Label("Choose difficulty:");
		gridPaneCenter.add(text,0,0,3,1);
		
		/*Three buttons 'easy', 'medium' and 'hard' are printed on the scene. If a button is
		 *clicked on, the method 'notifyMenuViewUpdated' is called*/
		Button easyButton = new Button("Easy");
		gridPaneCenter.add(easyButton,0,1);
		easyButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				notifyMenuViewUpdated(1);
			}
		});
		
		Button mediumButton = new Button("Medium");
		gridPaneCenter.add(mediumButton,1,1);
		mediumButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				notifyMenuViewUpdated(2);
			}
		});

		Button hardButton = new Button("Hard");
		gridPaneCenter.add(hardButton,2,1);
		hardButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				notifyMenuViewUpdated(3);
			}
		});	
	}
	
	public void setRegisteredMenuViewPlayerObservers(MenuViewPlayerObserver observer) {
		this.registeredMenuViewPlayerObservers.add(observer);	
	}
	
	public void setRegisteredMenuViewBoardObservers(MenuViewBoardObserver observer) {
		this.registeredMenuViewBoardObservers.add(observer);	
	}
	
	//MenuViewPlayerObservers are notified that the player names are updated
	private void notifyMenuViewUpdated(ArrayList<String> names) {
		for(MenuViewPlayerObserver o : registeredMenuViewPlayerObservers) {
			o.menuViewUpdated(names);
		}
	}
	
	//MenuViewBoardObservers are notified that the board difficulty is updated
	private void notifyMenuViewUpdated(int i) {
		for(MenuViewBoardObserver o : registeredMenuViewBoardObservers) {
			o.menuViewUpdated(i);
		}
	}
}
