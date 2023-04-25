package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.BoardObserver;
import controller.CardObserver;
import controller.MenuHandler;
import controller.ViewObserver;
import controller.PlayerStatusObserver;
import controller.ProgrammingPhase;
import controller.RobotObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Card;
import model.MoveForward;

public class View implements BoardObserver, CardObserver, PlayerStatusObserver, RobotObserver{
	
	private ImageView imageView;
	private ImageView robot1;
	private ImageView robot2;
	private ImageView robot3;
	private ImageView robot4;
	private TileManager tilemanager = new TileManager();
	private CardManager cardManager = new CardManager();
	private RobotManager robotManager = new RobotManager();
	private ArrayList<String> players = new ArrayList<String>();
	private Set<ViewObserver> registeredMenuViewObservers = new HashSet<ViewObserver>();
	private MenuHandler handler;

	private BorderPane anchorPane = new BorderPane();
	private GridPane gridPaneCenter = new GridPane();
	private GridPane gridPaneLeft = new GridPane();
	private GridPane gridPaneRight = new GridPane();
	Scene scene = new Scene(anchorPane,800,650);
	
	private String name;
	private int j;
	private boolean left;
	
	public Scene getScene() {
		return scene;
	}
	
	public void setMenuHandler(MenuHandler handler) {
		this.handler = handler;
	}
	
	@Override
	public void boardUpdated(BoardStatus newBoardStatus) {
		
		gridPaneCenter.getChildren().clear();
		gridPaneCenter.setHgap(0);
		gridPaneCenter.setVgap(0);
		
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
	
//	@Override
//	public void playerStatusUpdated(ArrayList<String> players) {
//		this.players = players;
//		
//	}	
	
	@Override
	public void playerStatusUpdated(ArrayList<String> players, String name) {
		this.players = players;
		this.name = name;
		
		gridPaneCenter.getChildren().clear();
		anchorPane.setLeft(gridPaneLeft);
		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
		anchorPane.setRight(gridPaneRight);
		gridPaneRight.setAlignment(Pos.TOP_CENTER);
		
//		boolean left = true;
		Label labelname = new Label(name);

		if(players.get(0) == name) {
			gridPaneLeft.add(labelname, 0, 0);
			this.j = 0;
			this.left = true;
		}
		
		else if(players.get(1) == name) {
			gridPaneRight.add(labelname, 0, 0);
			this.j = 0;
			this.left = false;
		}
		
		else if(players.size()>=3 && players.get(2) == name) {
			gridPaneLeft.add(labelname, 1, 0);
			this.j = 1;
			this.left = true;
		}
		
		else if(players.size()>=4 && players.get(3) == name) {
			gridPaneRight.add(labelname, 1, 0);
			this.j = 1;
			this.left = false;
		}
		
		
		
		
	}
	
//	@Override
//	public void cardUpdated(CardStatus newCardStatus) {
//		gridPaneCenter.getChildren().clear();
//		anchorPane.setLeft(gridPaneLeft);
//		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
//		anchorPane.setRight(gridPaneRight);
//		gridPaneRight.setAlignment(Pos.TOP_CENTER);
//		
//		int j = 0;
//		boolean left = true;
//		Label name = new Label(newCardStatus.getPlayer());
//
//		if(players.get(0) == newCardStatus.getPlayer()) {
//			gridPaneLeft.add(name, 0, 0);
//			j = 0;
//			left = true;
//		}
//		
//		else if(players.get(1) == newCardStatus.getPlayer()) {
//			gridPaneRight.add(name, 0, 0);
//			j = 0;
//			left = false;
//		}
//		
//		else if(players.size()>=3 && players.get(2) == newCardStatus.getPlayer()) {
//			gridPaneLeft.add(name, 1, 0);
//			j = 1;
//			left = true;
//		}
//		
//		else if(players.size()>=4 && players.get(3) == newCardStatus.getPlayer()) {
//			gridPaneRight.add(name, 1, 0);
//			j = 1;
//			left = false;
//		}
//		
//		for(int i=0; i<9; i++) {
//			
//			imageView = cardManager.getCard(newCardStatus.getCards()[i]);	
//			imageView.setFitHeight(40);
//			imageView.setFitWidth(40);
//			imageView.setOnMouseClicked(new EventHandler<Event>() {
//				public void handle(Event event) {
////					System.out.println(imageView);
////					System.out.println(cardManager.getCard(1));
////					if (imageView.equals(cardManager.getCard(1))){
////						notifyMenuViewUpdated(1, newCardStatus.getPlayer());
////					}
////					else if (imageView.equals(cardManager.getCard(2))){
////						notifyMenuViewUpdated(2, newCardStatus.getPlayer());
////					}
////					else if (imageView.equals(cardManager.getCard(3))){
////						notifyMenuViewUpdated(3, newCardStatus.getPlayer());
////					}
////					else if (imageView.equals(cardManager.getCard(4))){
////						notifyMenuViewUpdated(4, newCardStatus.getPlayer());
////					}
//					if (cardManager.getNumCard() == 1){
//						notifyMenuViewUpdated(1, newCardStatus.getPlayer());
//					}
//					else if (cardManager.getNumCard() == 2){
//						notifyMenuViewUpdated(2, newCardStatus.getPlayer());
//					}
//					else if (cardManager.getNumCard() == 3){
//						notifyMenuViewUpdated(3, newCardStatus.getPlayer());
//					}
//					else if (cardManager.getNumCard() == 4){
//						notifyMenuViewUpdated(4, newCardStatus.getPlayer());
//					}
//				}
//			});
////			imageView.setOnMouseClicked(handler);
//			
//			if (left) {
//				gridPaneLeft.add(imageView,j,i+1,1,1);
//			} else {
//				gridPaneRight.add(imageView,j,i+1,1,1);
//			}
//		
//		}
//	}

	@Override
	public void cardUpdated(Card card, int i, int numCard, String player) {
		imageView = cardManager.getCard(numCard);	
		imageView.setFitHeight(40);
		imageView.setFitWidth(40);
		imageView.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
//					System.out.println(imageView);
//					System.out.println(cardManager.getCard(1));
//					if (imageView.equals(cardManager.getCard(1))){
//						notifyMenuViewUpdated(1, newCardStatus.getPlayer());
//					}
//					else if (imageView.equals(cardManager.getCard(2))){
//						notifyMenuViewUpdated(2, newCardStatus.getPlayer());
//					}
//					else if (imageView.equals(cardManager.getCard(3))){
//						notifyMenuViewUpdated(3, newCardStatus.getPlayer());
//					}
//					else if (imageView.equals(cardManager.getCard(4))){
//						notifyMenuViewUpdated(4, newCardStatus.getPlayer());
//					}
					notifyMenuViewUpdated(numCard, player);
//					if (cardManager.getNumCard() == 1){
//						notifyMenuViewUpdated(1, player);
//					}
//					else if (cardManager.getNumCard() == 2){
//						notifyMenuViewUpdated(2, player);
//					}
//					else if (cardManager.getNumCard() == 3){
//						notifyMenuViewUpdated(3, player);
//					}
//					else if (cardManager.getNumCard() == 4){
//						notifyMenuViewUpdated(4, newCardStatus.getPlayer());
//					}
				}
			});
//			imageView.setOnMouseClicked(handler);
			
			if (left) {
				gridPaneLeft.add(imageView,j,i+1,1,1);
			} else {
				gridPaneRight.add(imageView,j,i+1,1,1);
			}
	}
	
//	@Override
//	public void cardUpdated(CardStatus newCardStatus) {
//		gridPaneCenter.getChildren().clear();
//		anchorPane.setLeft(gridPaneLeft);
//		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
//		anchorPane.setRight(gridPaneRight);
//		gridPaneRight.setAlignment(Pos.TOP_CENTER);
//		
//		int j = 0;
//		boolean left = true;
//		Label name = new Label(newCardStatus.getPlayer());
//
//		if(players.get(0) == newCardStatus.getPlayer()) {
//			gridPaneLeft.add(name, 0, 0);
//			j = 0;
//			left = true;
//		}
//		
//		else if(players.get(1) == newCardStatus.getPlayer()) {
//			gridPaneRight.add(name, 0, 0);
//			j = 0;
//			left = false;
//		}
//		
//		else if(players.size()>=3 && players.get(2) == newCardStatus.getPlayer()) {
//			gridPaneLeft.add(name, 1, 0);
//			j = 1;
//			left = true;
//		}
//		
//		else if(players.size()>=4 && players.get(3) == newCardStatus.getPlayer()) {
//			gridPaneRight.add(name, 1, 0);
//			j = 1;
//			left = false;
//		}
//		
//		for(int i=0; i<9; i++) {
//			
//			imageView = cardManager.getCard(newCardStatus.getCards()[i]);	
//			imageView.setFitHeight(40);
//			imageView.setFitWidth(40);
//			imageView.setOnMouseClicked(new EventHandler<Event>() {
//				public void handle(Event event) {
////					System.out.println(imageView);
////					System.out.println(cardManager.getCard(1));
////					if (imageView.equals(cardManager.getCard(1))){
////						notifyMenuViewUpdated(1, newCardStatus.getPlayer());
////					}
////					else if (imageView.equals(cardManager.getCard(2))){
////						notifyMenuViewUpdated(2, newCardStatus.getPlayer());
////					}
////					else if (imageView.equals(cardManager.getCard(3))){
////						notifyMenuViewUpdated(3, newCardStatus.getPlayer());
////					}
////					else if (imageView.equals(cardManager.getCard(4))){
////						notifyMenuViewUpdated(4, newCardStatus.getPlayer());
////					}
//					if (cardManager.getNumCard() == 1){
//						notifyMenuViewUpdated(1, newCardStatus.getPlayer());
//					}
//					else if (cardManager.getNumCard() == 2){
//						notifyMenuViewUpdated(2, newCardStatus.getPlayer());
//					}
//					else if (cardManager.getNumCard() == 3){
//						notifyMenuViewUpdated(3, newCardStatus.getPlayer());
//					}
//					else if (cardManager.getNumCard() == 4){
//						notifyMenuViewUpdated(4, newCardStatus.getPlayer());
//					}
//				}
//			});
////			imageView.setOnMouseClicked(handler);
//			
//			if (left) {
//				gridPaneLeft.add(imageView,j,i+1,1,1);
//			} else {
//				gridPaneRight.add(imageView,j,i+1,1,1);
//			}
//		
//		}
//	}
	
	protected void notifyMenuViewUpdated(int num, String player) {
		for(ViewObserver o : registeredMenuViewObservers) {
			o.menuViewUpdated(num, player);
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
	
	public Scene choosePlayerNum() {
		
		anchorPane.setCenter(gridPaneCenter);		
		gridPaneCenter.setAlignment(Pos.CENTER);
		gridPaneCenter.setHgap(10);
		gridPaneCenter.setVgap(10);
		
		Label text = new Label("How many players are playing?");
		gridPaneCenter.add(text,0,0,4,1);
		
		Button button1 = new Button("1");
		gridPaneCenter.add(button1,0,1);
		button1.setOnMouseClicked(handler);
		
		Button button2 = new Button("2");
		gridPaneCenter.add(button2,1,1);
		button2.setOnMouseClicked(handler);
		
		Button button3 = new Button("3");
		gridPaneCenter.add(button3,2,1);
		button3.setOnMouseClicked(handler);
		
		Button button4 = new Button("4");
		gridPaneCenter.add(button4,3,1);
		button4.setOnMouseClicked(handler);
		
		return scene;
	}
	
	public void typePlayerNames(int i) {
		gridPaneCenter.getChildren().clear();
		ArrayList<String> names = new ArrayList<String>();
		
		TextField textField1 = new TextField();
		TextField textField2 = new TextField();
		TextField textField3 = new TextField();
		TextField textField4 = new TextField();
		
		if (i>0 && i<5) {
			if (i>0) {
				Label text1 = new Label("Type the name of player 1 (Green robot):");
				gridPaneCenter.add(text1,0,0);
				gridPaneCenter.add(textField1,0,1);
			}
		
			if (i>1) {
				Label text2 = new Label("Type the name of player 2 (Yellow robot):");
				gridPaneCenter.add(text2,0,2);
				gridPaneCenter.add(textField2,0,3);
			}
			
			if (i>2) {
				Label text3 = new Label("Type the name of player 3 (Red robot):");
				gridPaneCenter.add(text3,0,4);
				gridPaneCenter.add(textField3,0,5);
			}
			
			if (i>3) {
				Label text4 = new Label("Type the name of player 4 (Blue robot):");
				gridPaneCenter.add(text4,0,6);
				gridPaneCenter.add(textField4,0,7);
			}
			
			Button button = new Button("Next");
			gridPaneCenter.add(button,0,i*2);			
			button.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					
					if (i>0) {				
						names.add(textField1.getText());
					}
					if (i>1) {
						names.add(textField2.getText());
					}
					if (i>2) {
						names.add(textField3.getText());
					}
					if (i>3) {
						names.add(textField4.getText());
					}
		
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
			});
					
		}else {
			System.out.println("There cannot be less than 1 player or more than 4 players");
		}		
	}
	
	public void chooseDifficulty() {
		gridPaneCenter.getChildren().clear();
		
		Label text = new Label("Choose difficulty:");
		gridPaneCenter.add(text,0,0,3,1);
		
		Button easyButton = new Button("Easy");
		gridPaneCenter.add(easyButton,0,1);
		easyButton.setOnMouseClicked(handler);
		
		Button mediumButton = new Button("Medium");
		gridPaneCenter.add(mediumButton,1,1);
		mediumButton.setOnMouseClicked(handler);

		Button hardButton = new Button("Hard");
		gridPaneCenter.add(hardButton,2,1);
		hardButton.setOnMouseClicked(handler);
		
	}
	
	public void setRegisteredObservers(ViewObserver observer) {
		this.registeredMenuViewObservers.add(observer);	
	}
	
	public void notifyMenuViewUpdated(ArrayList<String> names) {
		for(ViewObserver o : registeredMenuViewObservers) {
			o.menuViewUpdated(names);
		}
	}
}
