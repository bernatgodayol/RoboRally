package View;

import javafx.scene.image.Image;

public class TileManager {
	private TileView tiles;
	Image image;
	
	public TileManager(){
		tiles = new TileView();
		image = new Image("/Images/Tiles/BasicTile.png");
		tiles.addImage(image);
		
		image = new Image("/Images/Tiles/rebootTile2.png");
		tiles.addImage(image);
		
		image = new Image("/Images/Tiles/Wall2Tile.png");
		tiles.addImage(image);
		
		image = new Image("/Images/Tiles/WallWithLaserTile.png");
		tiles.addImage(image);
	}
}
