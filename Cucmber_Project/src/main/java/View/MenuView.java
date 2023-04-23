package View;

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
	
	public void choosePlayerNum() {
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
//		root.setPadding(new Insets(25,25,25,25)); 
		
		Label text = new Label("How many players are playing?");
		root.add(text,0,0,4,1);
		
		Button button1 = new Button("1");
		root.add(button1,0,1);
		
		Button button2 = new Button("2");
		root.add(button2,1,1);
		
		Button button3 = new Button("3");
		root.add(button3,2,1);
		
		Button button4 = new Button("4");
		root.add(button4,3,1);
		
	}
	
	public void typePlayerNames() {
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
//		root.setPadding(new Insets(5,5,5,5));
		
		Label text1 = new Label("Type the name of player 1 (Blue robot):");
		root.add(text1,0,0);
		
		TextField textField1 = new TextField();
		root.add(textField1,0,1);
		
		Label text2 = new Label("Type the name of player 2 (Green robot):");
		root.add(text2,0,2);
		
		TextField textField2 = new TextField();
		root.add(textField2,0,3);
		
		Label text3 = new Label("Type the name of player 3 (Red robot):");
		root.add(text3,0,4);
		
		TextField textField3 = new TextField();
		root.add(textField3,0,5);
		
		Label text4 = new Label("Type the name of player 4 (Yellow robot):");
		root.add(text4,0,6);
		
		TextField textField4 = new TextField();
		root.add(textField4,0,7);
		
		Button button = new Button("Next");
		root.add(button,0,8);
		
	}
	
	public void chooseDifficulty() {
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
//		root.setPadding(new Insets(5,5,5,5));
		
		Label text = new Label("Choose difficulty:");
		root.add(text,0,0,2,1);
		
		Button easyButton = new Button("Easy");
		root.add(easyButton,0,1);

		Button hardButton = new Button("Hard");
		root.add(hardButton,1,1);
		
	}
	
	public Scene getScene() {
		return scene;
	}
	
	
}
