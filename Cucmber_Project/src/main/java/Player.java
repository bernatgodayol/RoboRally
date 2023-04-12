import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String name;
	private Robot robot;
	private ProgrammingDeck programmingDeck;
	private DiscardDeck discardDeck;
	private PlayingDeck playingDeck;
	private ActionDeck actionDeck;

	public Player(String name) {
		this.name = name;
	}
	
	public void setRobot(Robot robot) {
		this.robot = robot;
		robot.setPlayer(this);
	}
	
	public Robot getRobot() {
		return robot;
	}
	
	public String getName() {
		return name;
	}

	public void setProgrammingDeck(ProgrammingDeck programmingDeck) {
		this.programmingDeck = programmingDeck;
	}
	
	public ProgrammingDeck getProgrammingDeck() {
		return programmingDeck;
	}

	public void setDiscardDeck(DiscardDeck discardDeck) {
		this.discardDeck = discardDeck;
	}
	
	public DiscardDeck getDiscardDeck() {
		return discardDeck;
	}
		
	public void setPlayingDeck(PlayingDeck playingDeck) {
		this.playingDeck = playingDeck;
	}
	
	public PlayingDeck getPlayingDeck() {
		return playingDeck;
	}
	
	public void setActionDeck(ActionDeck actionDeck) {
		this.actionDeck = actionDeck;
	}
	
	public ActionDeck getActionDeck() {
		return actionDeck;
	}
	
	public void pickCard(int int1) {
		Scanner s = new Scanner(System.in);
	    for (int i=0; i<int1; i++) {
	    	//System.out.println("Hello");
	    	//int index = s.nextInt();
	    	int index = 0;
	    	playingDeck.moveCard(index,actionDeck);
	    }
		s.close();
	}

	
	
	
	
}
