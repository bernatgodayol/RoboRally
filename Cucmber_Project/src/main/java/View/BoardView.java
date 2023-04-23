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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

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

	BorderPane anchorPane = new BorderPane();
	GridPane gridPaneCenter = new GridPane();
	GridPane gridPaneLeft = new GridPane();
	GridPane gridPaneRight = new GridPane();
	Scene scene = new Scene(anchorPane,800,650);
	
	@Override
	public void boardUpdated(BoardStatus newBoardStatus) {
		
		anchorPane.setCenter(gridPaneCenter);
		gridPaneCenter.setAlignment(Pos.CENTER);
		
		for(int i=0; i<13; i++) {
			for(int j=0; j<10; j++) {
				imageView = tilemanager.getImage(newBoardStatus.getStatusBoard()[i][j]);	
				imageView.setFitHeight(48);
				imageView.setFitWidth(48);
				imageView.setRotate(tilemanager.getRotate());
				gridPaneCenter.add(imageView, j, i);		
			}
		}
	}
	
	@Override
	public void playerStatusUpdated(ArrayList<String> players) {
		this.players = players;
		
	}
	
		
	@Override
	public void cardUpdated(CardStatus newCardStatus) {
		
		anchorPane.setLeft(gridPaneLeft);
		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
		anchorPane.setRight(gridPaneRight);
		gridPaneRight.setAlignment(Pos.TOP_CENTER);
		
		int j = 0;
		boolean left = true;

		if(players.get(0) == newCardStatus.getPlayer()) {
			Label t1 = new Label(newCardStatus.getPlayer());
			gridPaneLeft.add(t1, 0, 0);
			j = 0;
			left = true;
		}
		
		else if(players.get(1) == newCardStatus.getPlayer()) {
			Label t2 = new Label(newCardStatus.getPlayer());
			gridPaneRight.add(t2, 0, 0);
			j = 0;
			left = false;
		}
		
		else if(players.size()>=3 && players.get(2) == newCardStatus.getPlayer()) {
			Label t3 = new Label(newCardStatus.getPlayer());
			gridPaneLeft.add(t3, 1, 0);
			j = 1;
			left = true;
		}
		
		else if(players.size()>=4 && players.get(3) == newCardStatus.getPlayer()) {
			Label t4 = new Label(newCardStatus.getPlayer());
			gridPaneRight.add(t4, 1, 0);
			j = 1;
			left = false;
		}
		
		
		
		for(int i=0; i<9; i++) {
			
			imageView = cardManager.getCard(newCardStatus.getCards()[i]);	
			imageView.setFitHeight(40);
			imageView.setFitWidth(40);
			imageView.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					System.out.println("Mouse clicked");
				}
			});
			
			if (left) {
				gridPaneLeft.add(imageView,j,i+1,1,1);
			} else {
				gridPaneRight.add(imageView,j,i+1,1,1);
			}
		
		}
	}
	
	@Override
	public void robotUpdated(int i, int j, int oldI, int oldJ, int color, int direction) {
		
		if (color == 1) {
			if(robot1 != null) {
				gridPaneCenter.getChildren().remove(robot1);
			}
			robot1 = robotManager.getImage(color);	
			robot1.setFitHeight(48);
			robot1.setFitWidth(48);
			robot1.setRotate(direction);
			gridPaneCenter.add(robot1, j, i);
		}
		else if (color == 2) {
			if(robot2 != null) {
				gridPaneCenter.getChildren().remove(robot2);
			}
			robot2 = robotManager.getImage(color);	
			robot2.setFitHeight(48);
			robot2.setFitWidth(48);
			robot2.setRotate(direction);
			gridPaneCenter.add(robot2, j, i);
		}
		else if (color == 3) {
			if(robot3 != null) {
				gridPaneCenter.getChildren().remove(robot3);
			}
			robot3 = robotManager.getImage(color);	
			robot3.setFitHeight(48);
			robot3.setFitWidth(48);
			robot3.setRotate(direction);
			gridPaneCenter.add(robot3, j, i);
		}
		else {
			if(robot4 != null) {
				gridPaneCenter.getChildren().remove(robot4);
			}
			robot4 = robotManager.getImage(color);	
			robot4.setFitHeight(48);
			robot4.setFitWidth(48);
			robot4.setRotate(direction);
			gridPaneCenter.add(robot4, j, i);
		}
	}
	
	public Scene getScene() {
		return scene;
	}

}
