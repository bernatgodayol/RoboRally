package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileManager {
	//private TileView tiles;
	ClassLoader classLoader = getClass().getClassLoader();
	private Image image;
	private ImageView imageView;
	private int rotate;
	
	public ImageView getImage(int num){
		if(num == 1) {
			String imageUrl = classLoader.getResource("Tiles/Wall2Tile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(0);
		}
		else if(num == 2) {
			String imageUrl = classLoader.getResource("Tiles/Wall2Tile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(180);
		}
		else if(num == 3) {
			String imageUrl = classLoader.getResource("Tiles/Wall2Tile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(90);
		}
		else if(num == 4) {
			String imageUrl = classLoader.getResource("Tiles/Wall2Tile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(270);
		}
		else if(num == 5) {
			String imageUrl = classLoader.getResource("Tiles/WallWithLaserTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(0);
		}
		else if(num == 6) {
			String imageUrl = classLoader.getResource("Tiles/WallWithLaserTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(180);
		}
		else if(num == 7) {
			String imageUrl = classLoader.getResource("Tiles/WallWithLaserTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(90);
		}
		else if(num == 8) {
			String imageUrl = classLoader.getResource("Tiles/WallWithLaserTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(270);
		}
		else {
			String imageUrl = classLoader.getResource("Tiles/BasicTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(0);
		}
		return imageView;		
	}
	
	public void setRotate(int rotate) {
		this.rotate = rotate;
	}
	
	public int getRotate() {
		return this.rotate;
	}
}
