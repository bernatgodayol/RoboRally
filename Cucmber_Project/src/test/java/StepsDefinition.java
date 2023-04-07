import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
	Player player;
	Robot robot;
	Board board;
	Direction direction;
	Card card;
	DiscardDeck discardDeck;
	ProgrammingDeck programmingDeck;
	PlayingDeck playingDeck;
	ActionDeck actionDeck;
	int int1 = 9;
	int initialSizeProgrammingDeck;
	int robotPositionX;
    int robotPositionY;

	
	@Given("a robot")
	public void a_robot() {
		robot = new Robot(Color.BLUE);
	}
	
	@Given("a player with no robot")
	public void a_player_with_no_robot() {
		player = new Player("Mejse");
	}
	
	@When("the robot is assigned to the player")
	public void the_robot_is_assigned_to_the_player() {
		player.setRobot(robot);
	}
	
	@Then("the robot belongs to the player")
	public void the_robot_belongs_to_the_player() {
//		assertEquals(player.getRobot().getColor(), Color.BLUE);
		assertTrue(player.getRobot().equals(new Robot(Color.BLUE))); 
	}
	
////////////////////
	
	@Given("an empty board of size {int} x {int}")
	public void an_empty_board_of_size_x(Integer int1, Integer int2) {
	
	}
	
	@When("the 5B board is initialised")
	public void the_5b_board_is_initialised() {
		board = new Board5B();
	}
	
	@Then("the obstacles of the board should be in the expected tiles on the board")
	public void the_obstacles_of_the_board_should_be_in_the_expected_tiles_on_the_board() {
	    // Write code here that turns the phrase above into concrete actions
	    for (int i=0; i<13; i++) {
	    	for (int j=0; j<10; j++) {
	    		if (i==3 && j==4) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.NORTH)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==4 && j==3) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.SOUTH)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==3 && j==5) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.WEST)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==3 && j==6) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.EAST)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==6 && j==3) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.WEST)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==6 && j==4) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.EAST)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==5 && j==6) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.NORTH)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==6 && j==6) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.SOUTH)));
	    			assertTrue(board.getTile(i, j).containsElement(new Laser()));
	    		}
	    		
	    		else if (i==11 && j==2) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.WEST)));
	    		}
	    		
	    		else if (i==10 && j==4) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.NORTH)));
	    		}
	    		
	    		else if (i==10 && j==5) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.NORTH)));
	    		}
	    		
	    		else if (i==11 && j==7) {
	    			assertTrue(board.getTile(i, j).containsElement(new Wall(Direction.EAST)));
	    		}
	    		
	    		else {
	    			assertTrue(board.getTile(i, j) == null);
	    		}
	    	}
	    }
	}

	
///////////////////////
	
	
	@Given("a direction")
	public void a_direction() {
		direction = Direction.NORTH;
	}
	
	@When("the robot is assigned the direction")
	public void the_robot_is_assigned_the_direction() {
		robot.setDirection(direction);
	}
	
	@Then("the robot has that direction")
	public void the_robot_has_that_direction() {
		assertEquals(robot.getDirection(),direction);
	}
	
/////////////////
	
	@Given("a player")
	public void a_player() {
	    player = new Player("Mejse");
	}
	
	@Given("a deck of cards")
	public void a_deck_of_cards() {
		programmingDeck = new ProgrammingDeck();
	}
	
	@When("the player is assigned the deck of cards")
	public void the_player_is_assigned_the_deck_of_cards() {
	    player.setProgrammingDeck(programmingDeck);
	}
	
	@Then("the player has that deck of cards") 
	public void the_player_has_that_deck_of_cards() {
		assertEquals(player.getProgrammingDeck(), programmingDeck);
	}

////////////////
	

	@Given("a discard deck of cards")
	public void a_discard_deck_of_cards() {
		discardDeck = new DiscardDeck();
	}
	@When("the player is assigned the discard deck of cards")
	public void the_player_is_assigned_the_discard_deck_of_cards() {
		player.setDiscardDeck(discardDeck);
	}
	@Then("the player has that discard deck of cards")
	public void the_player_has_that_discard_deck_of_cards() {
		assertEquals(player.getDiscardDeck(),discardDeck);

	}	

////////////////
	
	@Given("a programming deck of cards that belongs to the player")
	public void a_programming_deck_of_cards_that_belongs_to_the_player() {
	    // Write code here that turns the phrase above into concrete actions
		initialSizeProgrammingDeck = programmingDeck.getDeck().size();
	}
	@Given("a playing deck of cards that belongs to the player")
	public void a_playing_deck_of_cards_that_belongs_to_the_player() {
	    // Write code here that turns the phrase above into concrete actions
		playingDeck = new PlayingDeck();
		player.setPlayingDeck(playingDeck);
	}
	@When("the {int} random cards are selected from the programming deck")
	public void the_random_cards_are_selected_from_the_programming_deck(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    programmingDeck.moveRandomCards(playingDeck, int1);
	}
	@Then("the cards are moved to the playing deck")
	public void the_cards_are_moved_to_the_playing_deck() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(playingDeck.getDeck().length == 9 && programmingDeck.getDeck().size() == initialSizeProgrammingDeck - 9);
	}
	
////////////////
	
	@Given("a position")
	public void a_position() {
	    robotPositionX = 1;
	    robotPositionY = 11;
	}
	
	@When("the robot is placed on the board")
	public void the_robot_is_placed_on_the_board() {
		board.getTile(robotPositionX,robotPositionY).addElement(robot);
	}
	
	@Then("the robot is in the correct tile on the board")
	public void the_robot_is_in_the_correct_tile_on_the_board() {
	    assertEquals(board.getTile(robotPositionX, robotPositionY), robot);
	}
	

////////////////

	@Given("a board")
	public void a_board() {
	    // Write code here that turns the phrase above into concrete actions
		board = new Board5B();
	}
	
	@Given("an action deck of cards that belongs to the player")
	public void an_action_deck_of_cards() {
	    // Write code here that turns the phrase above into concrete actions
		actionDeck = new ActionDeck();
	}
	@When("the first programming card is taken from the action deck of cards")
	public void the_first_programming_card_is_taken_from_the_action_deck_of_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    card = actionDeck.extractFirstCard();
	}
	@Then("the robot is moved according to the programming card")
	public void the_robot_is_moved_according_to_the_programming_card() {
	    // Write code here that turns the phrase above into concrete actions
		int oldX = 1;
		int oldY = 11;
		board.moveRobot(oldX, oldY, robot, card);
	    
	}
	@Then("the card is moved from the programming deck of cards to the discard deck of cards")
	public void the_card_is_moved_from_the_programming_deck_of_cards_to_the_discard_deck_of_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

///////////////////
	
	@Given("{int} random cards in the players playing deck")
	public void random_cards_in_the_players_playing_deck(Integer int1) {
		programmingDeck = new ProgrammingDeck();
		playingDeck = new PlayingDeck();
		player.setPlayingDeck(playingDeck);
		player.setProgrammingDeck(programmingDeck);
		programmingDeck.moveRandomCards(playingDeck, int1);
		
//		playingDeck = new PlayingDeck();
//		playingDeck.getDeck()[0] = new RightTurnCard();
//		playingDeck.getDeck()[1] = new LeftTurnCard();
//		playingDeck.getDeck()[2] = new LeftTurnCard();
//		playingDeck.getDeck()[3] = new LeftTurnCard();
//		playingDeck.getDeck()[4] = new LeftTurnCard();
//		playingDeck.getDeck()[5] = new LeftTurnCard();
//		playingDeck.getDeck()[6] = new LeftTurnCard();
//		playingDeck.getDeck()[7] = new LeftTurnCard();
//		playingDeck.getDeck()[8] = new LeftTurnCard();
//		player.setPlayingDeck(playingDeck);
	}
	
	@When("the player chooses {int} cards")
	public void the_player_chooses_cards(Integer int1) {
		actionDeck = new ActionDeck();
		player.setActionDeck(actionDeck);
		player.pickCard(int1);
	}
	
	@Then("the {int} cards are saved")
	public void the_cards_are_saved(Integer int1) {
		assertTrue(actionDeck.getDeck()[0]!=null);
	}
	
	@Then("the {int} cards have been removed from the playing deck")
	public void the_cards_have_been_removed_from_the_playing_deck(Integer int1) {
		assertEquals(playingDeck.getDeck()[0],null);		
	}
	
}
