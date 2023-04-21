package View;

import java.util.ArrayList;

import controller.BoardObserver;
import controller.CardObserver;
import controller.PlayerObserver;
import controller.PlayerStatusObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardView implements BoardObserver, CardObserver, PlayerStatusObserver{
	
	private ImageView imageView;
	private TileManager tilemanager = new TileManager();
	private CardManager cardManager = new CardManager();
	private ArrayList<String> players = new ArrayList<String>();

	GridPane root = new GridPane();
	Scene scene = new Scene(root,800,650);
	
	@Override
	public void boardUpdated(BoardStatus newBoardStatus) {
		
		root.setAlignment(Pos.CENTER);
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<10; j++) {
				imageView = tilemanager.getImage(newBoardStatus.getStatusBoard()[i][j]);	
				imageView.setFitHeight(48);
				imageView.setFitWidth(48);
				imageView.setRotate(tilemanager.getRotate());
				root.add(imageView, j+4, i);		
			}
		}
	}
	
	@Override
	public void playerStatusUpdated(ArrayList<String> players) {
		this.players = players;
		
	}
	
		
	@Override
	public void cardUpdated(CardStatus newCardStatus) {
		
		int j = 0;

		if(players.get(0) == newCardStatus.getPlayer()) {
			Text t1 = new Text();
			t1.setText("  " + newCardStatus.getPlayer());
			root.add(t1, 0, 0, 2, 1);
			j = 0;
		}
		
		else if(players.get(1) == newCardStatus.getPlayer()) {
			Text t2 = new Text();
			t2.setText("  " + newCardStatus.getPlayer());
			root.add(t2, 10+7, 0, 2, 1);
			j = 17;
		}
		
		else if(players.size()>=3 && players.get(2) == newCardStatus.getPlayer()) {
			Text t3 = new Text();
			t3.setText("  " + newCardStatus.getPlayer());
			root.add(t3, 2, 0, 2, 1);
			j = 2;
		}
		
		else if(players.size()>=4 && players.get(3) == newCardStatus.getPlayer()) {
			Text t4 = new Text();
			t4.setText("  " + newCardStatus.getPlayer());
			root.add(t4, 10+9, 0, 2, 1);
			j = 19;
		}
		
		for(int i=1; i<10; i++) {
			
			imageView = cardManager.getCard(newCardStatus.getCards()[i-1]);	
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);
			imageView.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					System.out.println("Mouse clicked");
				}
			});
		
			root.add(imageView,j,i,2,2);
		}
	}
	
	public Scene getScene() {
		return scene;
	}
}
