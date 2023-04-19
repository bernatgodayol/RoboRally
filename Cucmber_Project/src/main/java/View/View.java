package View;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class View extends Application{
	
//	private static final int NUM_OF_PAIRS = 8;
//	private static final int NUM_PER_ROW = 4;
	
//	private Parent createContent() {
//		Pane root = new Pane();
//		root.setPrefSize(600, 600);
//		
//		
//		return root;
//	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Group root = new Group();
		Scene scene = new Scene(root,500,650);//setResizeable...
		Stage stage = new Stage();
		
//		TileView tiles = new TileView();
//		TileManager tilemanager = new TileManager();
//		
		ClassLoader classLoader = getClass().getClassLoader();
		String imageUrl = classLoader.getResource("Images.Tiles/BasicTile.png").toExternalForm();
		Image image = new Image(imageUrl);
		
		ImageView imageView = new ImageView(image);
		imageView.setX(300);
		imageView.setY(300);
		
//		Image image = new Image("BasicTile.png");
//		ImageView imageView = new ImageView(image);
//		imageView.setX(300);
//		imageView.setY(300);
//		
		//root.getChildren();
		
		
		stage.setScene(scene);
		stage.show();
//		primaryStage.setScene(new Scene(createContent()));
//		primaryStage.show();
		
		//System.printlnstage.getWidth();
		//stage.getHeight();
		
		
	}


	public static void main(String[] args) {
		launch(args);
	}
}
