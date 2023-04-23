package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class MenuView {

	GridPane root = new GridPane();
	Scene scene = new Scene(root,800,650);
	
	public void choosePlayerNum() {
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		
		
	}
	
	public Scene getScene() {
		return scene;
	}
	
	
}
