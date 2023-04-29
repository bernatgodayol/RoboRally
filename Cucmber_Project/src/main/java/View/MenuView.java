package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.MenuViewObserver;
import controller.ViewHandler;
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
	
	private ViewHandler handler;
	private BorderPane anchorPane = new BorderPane();
	private GridPane gridPaneCenter = new GridPane();
	private Scene scene = new Scene(anchorPane,800,650);
	
	private Set<MenuViewObserver> registeredMenuViewObservers = new HashSet<MenuViewObserver>();
	
	
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
			
			anchorPane.setCenter(gridPaneCenter);		
			gridPaneCenter.setAlignment(Pos.CENTER);
			gridPaneCenter.setHgap(10);
			gridPaneCenter.setVgap(10);
			
			BackgroundFill backgroundFill =
			        new BackgroundFill(
			                Color.valueOf("#add8e6"),
			                new CornerRadii(10),
			                new Insets(10)
			                );
	
			Background background =
			        new Background(backgroundFill);
	
			gridPaneCenter.setBackground(background);
			
			Label text = new Label("How many players are playing?");
			gridPaneCenter.add(text,0,0,4,1);
			
			Button button1 = new Button("1");
			gridPaneCenter.add(button1,0,1);
			button1.setOnMouseClicked(handler);
			
			Button button2 = new Button("2");
			gridPaneCenter.add(button2,1,1);
			button2.setOnMouseClicked(handler);
			
			Button button3 = new Button("3");
			gridPaneCenter.add(button3,2,1);
			button3.setOnMouseClicked(handler);
			
			Button button4 = new Button("4");
			gridPaneCenter.add(button4,3,1);
			button4.setOnMouseClicked(handler);
			
			return scene;
		}
	
	public void typePlayerNames(int i) {
		gridPaneCenter.getChildren().clear();
		ArrayList<String> names = new ArrayList<String>();
		
		TextField textField1 = new TextField();
		TextField textField2 = new TextField();
		TextField textField3 = new TextField();
		TextField textField4 = new TextField();
		
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
					Label text1 = new Label("Please choose a unique name for each player.\n"
							+ "Player cannot be named called 'AI'");
					text1.setStyle("-fx-text-fill: red;");
					gridPaneCenter.add(text1,0,(i*2+1));
				}
			
			}
		});
	}
	
	public void chooseDifficulty() {
		gridPaneCenter.getChildren().clear();
		
		Label text = new Label("Choose difficulty:");
		gridPaneCenter.add(text,0,0,3,1);
		
		Button easyButton = new Button("Easy");
		gridPaneCenter.add(easyButton,0,1);
		easyButton.setOnMouseClicked(handler);
		
		Button mediumButton = new Button("Medium");
		gridPaneCenter.add(mediumButton,1,1);
		mediumButton.setOnMouseClicked(handler);

		Button hardButton = new Button("Hard");
		gridPaneCenter.add(hardButton,2,1);
		hardButton.setOnMouseClicked(handler);
		
	}
	
	
	public void setRegisteredMenuViewObservers(MenuViewObserver observer) {
		this.registeredMenuViewObservers.add(observer);	
	}
	
	public void notifyMenuViewUpdated(ArrayList<String> names) {
		for(MenuViewObserver o : registeredMenuViewObservers) {
			o.menuViewUpdated(names);
		}
	}
	public void setMenuHandler(ViewHandler handler) {
		this.handler = handler;
		
	}
	
}
