package View;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TileManager {
	
	private ClassLoader classLoader = getClass().getClassLoader();
	private Image image;
	private ImageView imageView;
	private int rotate;
	
	public ImageView getImage(int num){
		/*Returns an imageView of a tile according to the integer the element is assigned. 
		 * The images are rotated to fit the direction of the element. The basic tile is 
		 * rotated randomly.*/
		
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
		else if(num == 9) {
			String imageUrl = classLoader.getResource("Tiles/PitWithWallTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(0);
		}
		else if(num == 10) {
			String imageUrl = classLoader.getResource("Tiles/PitWithWallTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(180);
		}
		else if(num == 11) {
			String imageUrl = classLoader.getResource("Tiles/PitWithWallTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(90);
		}
		else if(num == 12) {
			String imageUrl = classLoader.getResource("Tiles/PitWithWallTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(270);
		}
		else if(num == 13) {
			String imageUrl = classLoader.getResource("Tiles/PitTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(0);
		}
		else if(num == 14) {
			String imageUrl = classLoader.getResource("Tiles/BasicTile.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			Random rand = new Random();
			int index = rand.nextInt(4);
			int[] rot = new int[]{0, 90, 180, 270};
			setRotate(rot[index]);
		}
		else if(num == 15) {
			String imageUrl = classLoader.getResource("Tiles/RebootTile3.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
			setRotate(0);
		}
		else {
			String imageUrl = classLoader.getResource("Tiles/EndTile.png").toExternalForm();
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
