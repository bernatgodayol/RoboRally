package View;

import controller.BoardObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardView implements BoardObserver{
	
	private ImageView imageView;
	private TileManager tilemanager = new TileManager();

//	Group root = new Group();
	GridPane root = new GridPane();
	Scene scene = new Scene(root,1200,650);//setResizeable...
//	Stage stage = new Stage();
	
	@Override
	public void boardUpdated(BoardStatus newStatus) {
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<10; j++) {
				imageView = tilemanager.getImage(newStatus.getStatusBoard()[i][j]);	
				imageView.setFitHeight(48);
				imageView.setFitWidth(48);
				imageView.setRotate(tilemanager.getRotate());
				root.add(imageView, j+2, i);
//				imageView.setX((scene.getWidth()/2-imageView.getFitWidth()*5)+j*imageView.getFitHeight());
//				imageView.setY(i*imageView.getFitWidth());
//				root.getChildren().add(imageView);			
			}
		}
		
		Text t1 = new Text();
		t1.setText("Player 1");
		root.add(t1, 0, 0, 2, 1);
		
		Text t2 = new Text();
		t2.setText("Player 2");
		root.add(t2, 10+2, 0, 2, 1);
		
		for(int i=1; i<10; i++) {
			imageView = tilemanager.getImage(newStatus.getStatusBoard()[1][1]);	
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);
			imageView.setRotate(tilemanager.getRotate());
			imageView.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					System.out.println("Mouse clicked");
				}
			});
			root.add(imageView, 0, i,2,2);
		}
		
		
	}
	
	public void cardsUpdated(CardStatus newStatus) {
		for(int i=0; i<9; i++) {
			
		}
	}
	
	public Scene getScene() {
		return scene;
	}

}
