package View;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
	
	private ClassLoader classLoader = getClass().getClassLoader();
	
	public void playSound(String name) throws Exception {
		
		try {
			String imageUrl = classLoader.getResource("Sounds/"+name+".mp3").toExternalForm();
			Media sound = new Media(imageUrl);
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
		}catch(Exception e) {
			System.out.println("Sound could not play");
		}

	}

}
