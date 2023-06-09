package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.BoardObserver;
import controller.BoardViewObserver;
import controller.CardObserver;
import controller.CardStatus;
import controller.PlayerStatusObserver;
import controller.RobotObserver;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Card;

public class BoardView implements BoardObserver, CardObserver, PlayerStatusObserver, RobotObserver{
	
	private CardStatus cardstatus;
	private ImageView imageView;
	private ImageView robot1;
	private ImageView robot2;
	private ImageView robot3;
	private ImageView robot4;
	private TileManager tilemanager = new TileManager();
	private CardManager cardManager = new CardManager();
	private RobotManager robotManager = new RobotManager();
	private ArrayList<String> players = new ArrayList<String>();
	private Set<BoardViewObserver> registeredBoardViewObservers = new HashSet<BoardViewObserver>();
	
	private BorderPane anchorPane;
	private GridPane gridPaneCenter;
	private GridPane gridPaneLeft = new GridPane();
	private GridPane gridPaneRight = new GridPane();
	private Scene scene;

	private boolean isBorderVisible = false;
	private int j = 0;
	
	public BoardView(BorderPane anchorPane, GridPane gridPaneCenter, Scene scene) {
		this.anchorPane = anchorPane;
		this.gridPaneCenter = gridPaneCenter;
		this.scene = scene;
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public GridPane getGridPaneCenter() {
		return gridPaneCenter;
	}
	
	public GridPane getGridPaneLeft() {
		return gridPaneLeft;
	}
	
	public GridPane getGridPaneRight() {
		return gridPaneRight;
	}
	
	public void setCardStatus(CardStatus cardstatus) {
		this.cardstatus = cardstatus;
	}
	
	@Override
	public void boardUpdated(BoardStatus newBoardStatus) {
		//Prints the board on the scene when board is initialized
		
		//The scene is cleared
		gridPaneCenter.getChildren().clear();
		gridPaneCenter.setHgap(0);
		gridPaneCenter.setVgap(0);
		
		/*The matrix in the BoardStatus class is run through. An image that corresponds
		to the tile integer is found using the class TileManager*/
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
	public void playerStatusUpdated(String name) {
		//When the player status is updated, an array with player names is created
		this.players.add(name);
	}
	
	@Override
	public void cardUpdated(Card card, int index, int numCard, String player) {
		/*Prints the playing cards on the scene when the random cards are moved from
		 *the programming deck to the playing deck*/
		
		anchorPane.setLeft(gridPaneLeft);
		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
		anchorPane.setRight(gridPaneRight);
		gridPaneRight.setAlignment(Pos.TOP_CENTER);
		
		isBorderVisible = false;
		
		//creating a label for the player name
		Label labelname = new Label(player);
		boolean left = false;
		
		/*According to the numbers of players, the label and cards gets a different 
		 *position on the scene*/
		if(players.get(0) == player) {
			gridPaneLeft.add(labelname, 0, 0);
			j = 0;
			left = true;
		}
			
		else if(players.get(1) == player) {
			gridPaneRight.add(labelname, 0, 0);
			j = 0;
			left = false;
		}
			
		else if(players.size()>=3 && players.get(2) == player) {
			gridPaneLeft.add(labelname, 1, 0);
			j = 1;
			left = true;
		}
			
		else if(players.size()>=4 && players.get(3) == player) {
			gridPaneRight.add(labelname, 1, 0);
			j = 1;
			left = false;
		}
		
		//The correct image for each card is found using the class CardManager
		imageView = cardManager.getCardImage(numCard);	
		imageView.setFitHeight(40);
		imageView.setFitWidth(40);
		
		//A border is created. This will be printed on top of the cards
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
	    border.setStroke(Color.GREEN);
	    border.setStrokeWidth(2);
	    border.setWidth(imageView.getFitWidth()-14);
	    border.setHeight(imageView.getFitHeight()-3);
	    border.setVisible(isBorderVisible);
	    
	    /*Sets the border visible and notifies BoardViewObserver that the board has updated
	     * if the player is not an AI, is clicking on an already chosen card and has space 
	     * in their action deck.*/
		if (player != "AI" && !isBorderVisible) {
			imageView.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					boolean notify = false;
					
					if(players.size()>1) {
						if(players.get(0) == player){
							if(cardstatus.getCardGrids().get(0).size()<5) {
								notify = true;
							}
						}
						else if(players.get(1) == player) {
							if(cardstatus.getCardGrids().get(1).size()<5) {
								notify = true;
							}
						}
					}
					if(players.size()>2){
						if(players.get(2) == player){
							if(cardstatus.getCardGrids().get(2).size()<5) {
								notify = true;
							}
						}
					}
					if(players.size()>3){
						if(players.get(3) == player){
							if(cardstatus.getCardGrids().get(3).size()<5) {
								notify = true;
							}
						}
					}
					
					if(notify) {
						notifyBoardViewUpdated(index, player);
						isBorderVisible = true;
						border.setVisible(isBorderVisible);
					}
				}
			});	
		}
		
		//prints the cards and names on the scene and removes previously printed cards
		if (left) {
			gridPaneLeft.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == j && 
					GridPane.getRowIndex(node) == index+1);
			gridPaneLeft.add(imageView,j,index+1,1,1);
			gridPaneLeft.add(border, j,index+1,1,1);
			
		} else {
			gridPaneRight.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == j && 
					GridPane.getRowIndex(node) == index+1);
			gridPaneRight.add(imageView,j,index+1,1,1);
			gridPaneRight.add(border, j,index+1,1,1);
		
		}
		
		GridPane.setHalignment(imageView, HPos.CENTER);
		GridPane.setHalignment(border, HPos.CENTER);
		GridPane.setHalignment(labelname, HPos.CENTER);
	}

	@Override
	public void robotUpdated(int i, int j, int oldI, int oldJ, int color, int direction) {
		/*When the robot position is updated, the robots are moved from their previous 
		 * position and printed on their new position on the board. The correct picture
		 * of the robots are found using the class RobotManager.*/
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
	
	public void setRegisteredBoardViewObservers(BoardViewObserver observer) {
		this.registeredBoardViewObservers.add(observer);	
	}
	
	private void notifyBoardViewUpdated(int num, String player) {
		//BoardViewObservers are notified that the board is changed
		for(BoardViewObserver o : registeredBoardViewObservers) {
			o.boardViewUpdated(num, player);
		}
	}
}
