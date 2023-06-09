package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardManager {
	
	private ClassLoader classLoader = getClass().getClassLoader();
	private Image image;
	private ImageView imageView;
	
	public ImageView getCardImage(int num){
		//Returns an imageView of a card according to the integer the card is assigned.
		
		if(num == 1) {
			String imageUrl = classLoader.getResource("Cards/MoveForwardCard.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else if(num == 2) {
			String imageUrl = classLoader.getResource("Cards/RightTurnCard.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else if(num == 3) {
			String imageUrl = classLoader.getResource("Cards/LeftTurnCard.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else if(num == 4) {
			String imageUrl = classLoader.getResource("Cards/UTurnCard.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
		else {
			String imageUrl = classLoader.getResource("Cards/DamageCard.png").toExternalForm();
			image = new Image(imageUrl);
			imageView = new ImageView(image);
		}
	
		return imageView;		
	}
	
}
