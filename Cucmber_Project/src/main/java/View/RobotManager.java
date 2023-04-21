package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RobotManager {
	
	ClassLoader classLoader = getClass().getClassLoader();
	private Image image;
	private ImageView imageView;
	
	public ImageView getImage(int num){
		if(num == 1) {
			String imageUrl = classLoader.getResource("Robots/BlueRobot.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else if(num == 2) {
			String imageUrl = classLoader.getResource("Robots/GreenRobot.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else if(num == 3) {
			String imageUrl = classLoader.getResource("Robots/RedRobot.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else {
			String imageUrl = classLoader.getResource("Robots/YellowRobot.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
	
		return imageView;		
	}
	
}
