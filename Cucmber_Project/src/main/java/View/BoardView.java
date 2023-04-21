package View;

import java.util.ArrayList;

import controller.BoardObserver;
import controller.CardObserver;
import controller.PlayerStatusObserver;
import controller.RobotObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class BoardView implements BoardObserver, CardObserver, PlayerStatusObserver, RobotObserver{
	
	private ImageView imageView;
	private ImageView robot1;
	private ImageView robot2;
	private ImageView robot3;
	private ImageView robot4;
	private TileManager tilemanager = new TileManager();
	private CardManager cardManager = new CardManager();
	private RobotManager robotManager = new RobotManager();
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
	
	@Override
	public void robotUpdated(int i, int j, int oldI, int oldJ, int color, int direction) {
		
		if (color == 1) {
			if(robot1 != null) {
				root.getChildren().remove(robot1);
			}
			robot1 = robotManager.getImage(color);	
			robot1.setFitHeight(48);
			robot1.setFitWidth(48);
			robot1.setRotate(direction);
			root.add(robot1, j+4, i);
		}
		else if (color == 2) {
			if(robot2 != null) {
				root.getChildren().remove(robot2);
			}
			robot2 = robotManager.getImage(color);	
			robot2.setFitHeight(48);
			robot2.setFitWidth(48);
			robot2.setRotate(direction);
			root.add(robot2, j+4, i);
		}
		else if (color == 3) {
			if(robot3 != null) {
				root.getChildren().remove(robot3);
			}
			robot3 = robotManager.getImage(color);	
			robot3.setFitHeight(48);
			robot3.setFitWidth(48);
			robot3.setRotate(direction);
			root.add(robot3, j+4, i);
		}
		else {
			if(robot4 != null) {
				root.getChildren().remove(robot4);
			}
			robot4 = robotManager.getImage(color);	
			robot4.setFitHeight(48);
			robot4.setFitWidth(48);
			robot4.setRotate(direction);
			root.add(robot4, j+4, i);
		}
	}
	
	public Scene getScene() {
		return scene;
	}

}
