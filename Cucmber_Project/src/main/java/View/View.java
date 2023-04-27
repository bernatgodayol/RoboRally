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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Board;
import model.Card;
import model.Player;

public class View implements BoardObserver, CardObserver, PlayerStatusObserver, RobotObserver, ActivationPhaseObserver{
	
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
	private Set<MenuViewObserver> registeredMenuViewObservers = new HashSet<MenuViewObserver>();
	private Set<ActivationViewObserver> registeredActivationViewObservers = new HashSet<ActivationViewObserver>();
	private MenuHandler handler;

	private BorderPane anchorPane = new BorderPane();
	private GridPane gridPaneCenter = new GridPane();
	private GridPane gridPaneLeft = new GridPane();
	private GridPane gridPaneRight = new GridPane();
	private Scene scene = new Scene(anchorPane,800,650);
	
	private String name;
	private boolean isBorderVisible = false;
	private int j = 0;
	
	public Scene getScene() {
		return scene;
	}
	
	public void setCardStatus(CardStatus cardstatus) {
		this.cardstatus = cardstatus;
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
	}
	

	@Override
	public void cardUpdated(Card card, int index, int numCard, String player) {
		
		anchorPane.setLeft(gridPaneLeft);
		gridPaneLeft.setAlignment(Pos.TOP_CENTER);
		anchorPane.setRight(gridPaneRight);
		gridPaneRight.setAlignment(Pos.TOP_CENTER);
		
		isBorderVisible = false;
		
		Label labelname = new Label(player);
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
	    border.setStroke(Color.GREEN);
	    border.setStrokeWidth(2);
	    border.setWidth(imageView.getFitWidth()-14);
	    border.setHeight(imageView.getFitHeight()-3);
	    border.setVisible(isBorderVisible);
	    
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
		}
		
		
		Button button = new Button("Next");
		gridPaneCenter.add(button,0,i*2);			
		button.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event event) {
				if (i == 1 && !textField1.getText().isEmpty() && !textField1.getText().equals("AI")) {
					names.add(textField1.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else if (i == 2 && !textField1.getText().isEmpty() && !textField2.getText().isEmpty() && 
						!textField1.getText().equals("AI") && !textField2.getText().equals("AI") &&
						!textField1.getText().equals(textField2.getText())) {
					names.add(textField1.getText());
					names.add(textField2.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else if (i == 3 && !textField1.getText().isEmpty() && !textField2.getText().isEmpty() && 
						!textField3.getText().isEmpty() && !textField1.getText().equals("AI") && 
						!textField2.getText().equals("AI") && !textField3.getText().equals("AI") &&
						!textField1.getText().equals(textField2.getText()) && 
						!textField1.getText().equals(textField3.getText()) && 
						!textField3.getText().equals(textField2.getText())){
					names.add(textField1.getText());
					names.add(textField2.getText());
					names.add(textField3.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else if (i == 4 && !textField1.getText().isEmpty() && !textField2.getText().isEmpty() && 
						!textField3.getText().isEmpty() && !textField4.getText().isEmpty() &&
						!textField1.getText().equals("AI") && !textField2.getText().equals("AI") && 
						!textField3.getText().equals("AI") && !textField4.getText().equals("AI") &&
						!textField1.getText().equals(textField2.getText()) && 
						!textField1.getText().equals(textField3.getText()) && 
						!textField3.getText().equals(textField2.getText()) &&
						!textField1.getText().equals(textField4.getText()) &&
						!textField2.getText().equals(textField4.getText()) &&
						!textField3.getText().equals(textField4.getText())){
					names.add(textField1.getText());
					names.add(textField2.getText());
					names.add(textField3.getText());
					names.add(textField4.getText());
					notifyMenuViewUpdated(names);
					chooseDifficulty();
				}
				else {
					Label text1 = new Label("Please choose a unique name for each player.\n"
							+ "Player cannot be named called 'AI'");
					text1.setStyle("-fx-text-fill: red;");
					gridPaneCenter.add(text1,0,(i*2+1));
				}
			
			}
		});
	}
		
//	int rowCount = 0;
//    TextField[] textField = new TextField[i];
//    Label[] text = new Label[i];
//    String[] robotNames = {"Green", "Yellow", "Red", "Blue"};
//	
//	for (int j = 0; j < i; j++) {
//        text[j] = new Label("Type the name of player " + (j + 1) + " (" + robotNames[j] + " robot):");
//        gridPaneCenter.add(text[j], 0, rowCount++);
//        textField[j] = new TextField();
//        gridPaneCenter.add(textField[j], 0, rowCount++);
//    }
//		Button button = new Button("Next");
//		gridPaneCenter.add(button,0,i*2);			
//		button.setOnMouseClicked(new EventHandler<Event>() {
//			public void handle(Event event) {
	//		     boolean valid = true;
	//	            for (int j = 0; j < i; j++) {
	//	                if (textField[j].getText().isEmpty() || textField[j].getText().equals("AI")) {
	//	                    valid = false;
	//	                    break;
	//	                }
	//	                for (int k = j + 1; k < i; k++) {
	//	                    if (textField[j].getText().equals(textField[k].getText())) {
	//	                        valid = false;
	//	                        break;
	//	                    }
	//	                }
	//	                if (!valid) {
	//	                    break;
	//	                }
	//	                names.add(textField[j].getText());
	//	            }
	//	            if (valid) {
	//	                notifyMenuViewUpdated(names);
	//	                chooseDifficulty();
	//	            }
            	
	
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
		text.setStyle("-fx-text-fill: red;-fx-font-size: 16px;");
		gridPaneCenter.add(text,0,0);
		
		Sound sound = new Sound();
		sound.playSound("fanfare");
	}
	
	@Override
	public void activationPhaseUpdated(ArrayList<Player> players, Board board, boolean endActivationPhase) {
		if (!endActivationPhase) {
			Button nextButton = new Button("Next");
			gridPaneRight.add(nextButton, 0, 15);
			nextButton.setOnMouseClicked(new EventHandler<Event>() {
				public void handle(Event event) {
					notifyActivationViewUpdated(players,board);
				}
			});
		}else {
			gridPaneRight.getChildren().removeIf(node -> GridPane.getColumnIndex(node)==0 && 
					GridPane.getRowIndex(node)==15);
		}	
	}
}
