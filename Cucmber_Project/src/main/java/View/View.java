package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.ActivationPhaseObserver;
import controller.ActivationViewObserver;
import controller.BoardObserver;
import controller.BoardViewObserver;
import controller.CardObserver;
import controller.MenuHandler;
import controller.MenuViewObserver;
import controller.PlayerStatusObserver;
import controller.RobotObserver;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.css.PseudoClass;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Board;
import model.Card;
import model.Player;

public class View implements BoardObserver, CardObserver, PlayerStatusObserver, RobotObserver, ActivationPhaseObserver{
	
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
	private Set<MenuViewObserver> registeredMenuViewObservers = new HashSet<MenuViewObserver>();
	private Set<ActivationViewObserver> registeredActivationViewObservers = new HashSet<ActivationViewObserver>();
	private MenuHandler handler;

	private BorderPane anchorPane = new BorderPane();
	private GridPane gridPaneCenter = new GridPane();
	private GridPane gridPaneLeft = new GridPane();
	private GridPane gridPaneRight = new GridPane();
	Scene scene = new Scene(anchorPane,800,650);
	
	private String name;
	private boolean isBorderVisible = false;
//	private int j;
//	private boolean left;
	
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
	
	
	@Override
	public void playerStatusUpdated(ArrayList<String> players, String name) {
		this.players = players;
		this.name = name;
		
//		gridPaneCenter.getChildren().clear();
//		anchorPane.setLeft(gridPaneLeft);
//		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
//		anchorPane.setRight(gridPaneRight);
//		gridPaneRight.setAlignment(Pos.TOP_CENTER);
//		
//		Label labelname = new Label(name);
//		
//		
//		if(players.get(0) == name) {
//			gridPaneLeft.add(labelname, 0, 0);
//			this.j = 0;
//			this.left = true;
//		}
//			
//		else if(players.get(1) == name) {
//			gridPaneRight.add(labelname, 0, 0);
//			this.j = 0;
//			this.left = false;
//		}
//			
//		else if(players.size()>=3 && players.get(2) == name) {
//			gridPaneLeft.add(labelname, 1, 0);
//			this.j = 1;
//			this.left = true;
//		}
//			
//		else if(players.size()>=4 && players.get(3) == name) {
//			gridPaneRight.add(labelname, 1, 0);
//			this.j = 1;
//			this.left = false;
//		}
	}
	

	@Override
	public void cardUpdated(Card card, int index, int numCard, String player) {
		
//		gridPaneCenter.getChildren().clear();
		anchorPane.setLeft(gridPaneLeft);
		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
		anchorPane.setRight(gridPaneRight);
		gridPaneRight.setAlignment(Pos.TOP_CENTER);
		
		isBorderVisible = false;
		
		Label labelname = new Label(player);
		int j = 0;
		boolean left = false;
		
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

		imageView = cardManager.getCardImage(numCard);	
		imageView.setFitHeight(40);
		imageView.setFitWidth(40);
		
		Rectangle border = new Rectangle();
		border.setFill(Color.TRANSPARENT);
	    border.setStroke(Color.YELLOW);
	    border.setStrokeWidth(2);
	    border.setWidth(imageView.getFitWidth()-14);
	    border.setHeight(imageView.getFitHeight()-3);
	    border.setVisible(isBorderVisible);
	    
		if (player != "AI" && !isBorderVisible) {
			imageView.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
//					border.setVisible(true);
					notifyBoardViewUpdated(index, player);
					isBorderVisible = true;
					border.setVisible(isBorderVisible);
				}
			});	
			
//			isBorderVisible = true;
			
		}
		
		if (left) {
//			gridPaneLeft.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == j && GridPane.getRowIndex(node) == (index+1));   
			gridPaneLeft.add(imageView,j,index+1,1,1);
			gridPaneLeft.add(border, j,index+1,1,1);
//			gridPaneLeft.setHalignment(imageView, HPos.CENTER);
//			gridPaneLeft.setHalignment(border, HPos.CENTER);
//			gridPaneLeft.setHalignment(labelname, HPos.CENTER);
			
		} else {
//			gridPaneRight.getChildren().removeIf( node -> GridPane.getColumnIndex(node) == j && GridPane.getRowIndex(node) == (index+1));
			gridPaneRight.add(imageView,j,index+1,1,1);
			gridPaneRight.add(border, j,index+1,1,1);
		
		}
		
		GridPane.setHalignment(imageView, HPos.CENTER);
		GridPane.setHalignment(border, HPos.CENTER);
		GridPane.setHalignment(labelname, HPos.CENTER);
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
	
	public void setRegisteredMenuViewObservers(MenuViewObserver observer) {
		this.registeredMenuViewObservers.add(observer);	
	}
	
	public void setRegisteredBoardViewObservers(BoardViewObserver observer) {
		this.registeredBoardViewObservers.add(observer);	
	}
	
	public void setRegisteredActivationViewObservers(ActivationViewObserver observer) {
		this.registeredActivationViewObservers.add(observer);	
	}
	
	public void notifyMenuViewUpdated(ArrayList<String> names) {
		for(MenuViewObserver o : registeredMenuViewObservers) {
			o.menuViewUpdated(names);
		}
	}
	
	protected void notifyBoardViewUpdated(int num, String player) {
		for(BoardViewObserver o : registeredBoardViewObservers) {
			o.boardViewUpdated(num, player);
		}
	}
	
	private void notifyActivationViewUpdated(ArrayList<Player> players, Board board) {
		for(ActivationViewObserver o : registeredActivationViewObservers) {
			o.continueActivationPhase(players, board);
		}		
	}

	@Override
	public void winnerFound(String player) {
		gridPaneCenter.getChildren().clear();
		gridPaneLeft.getChildren().clear();
		gridPaneRight.getChildren().clear();
		
		Label text = new Label(player + " has won!");
		
		gridPaneCenter.add(text,0,0);
		
	}

	@Override
	public void activationPhaseUpdated(ArrayList<Player> players, Board board) {
		Button nextButton = new Button("Next");
		gridPaneRight.add(nextButton, 0, 15);
		nextButton.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				notifyActivationViewUpdated(players,board);
			}
		});	
	}
	
//	public Node removeNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
//
//		ObservableList<Node> childrens = gridPane.getChildren();
//		for(Node node : childrens) {
//		    if(node instanceof ImageView && gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
//		        ImageView imageView = ImageView(node); // use what you want to remove
//		        gridPane.getChildren().remove(imageView);
//		        break;
//		    }
//		  } 
//		   }
}
