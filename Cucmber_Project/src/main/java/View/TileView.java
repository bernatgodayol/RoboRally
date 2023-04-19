package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public class TileView extends StackPane{
	private ArrayList<Object> tiles = new ArrayList<Object>();
	
	public Object getTileImage(int num) {
		return this.tiles.get(num);
	}
	
	public void addImage(Image image) {
		this.tiles.add(image);
	}
	
//	public TileView(String value) {
//		tiles[0]
//		
//		
//		Rectangle border = new Rectangle(50,50);
//		border.setFill(null);
//		border.setStroke(Color.BLACK);
//		
//		Text text = new Text(value);
//		text.setFont(Font.font(30));
//		
//		setAlignment(Pos.CENTER);
//		getChildren().addAll(border,text);
//		
//	}
}
