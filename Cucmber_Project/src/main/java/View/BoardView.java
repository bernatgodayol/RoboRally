package View;

import controller.BoardObserver;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BoardView implements BoardObserver{
	
	private ImageView imageView;
	private TileManager tilemanager = new TileManager();

	Group root = new Group();
	Scene scene = new Scene(root,500,650);//setResizeable...
	Stage stage = new Stage();
	
	@Override
	public void boardUpdated(BoardStatus newStatus) {
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<10; j++) {
				imageView = tilemanager.getImage(newStatus.getStatusBoard()[i][j]);	
				imageView.setFitHeight(40);
				imageView.setFitWidth(40);
				imageView.setRotate(tilemanager.getRotate());
				imageView.setX(j*imageView.getFitHeight());
				imageView.setY(i*imageView.getFitWidth());
				root.getChildren().add(imageView);				
			}
		}
	}
	
	public Scene getScene() {
		return scene;
	}

}
