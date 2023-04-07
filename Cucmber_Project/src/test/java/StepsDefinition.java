import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
	Player player;
	Robot robot;
	Board board;
	Direction direction;
	Deck discardDeck;
	Deck programmingDeck;
	Deck playingDeck;
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
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.NORTH)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==4 && j==3) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.SOUTH)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==3 && j==5) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.WEST)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==3 && j==6) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.EAST)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==6 && j==3) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.WEST)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==6 && j==4) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.EAST)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==5 && j==6) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.NORTH)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==6 && j==6) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.SOUTH)));
	    			assertTrue(board.getTile(i, j).containsObstacle(new Laser()));
	    		}
	    		
	    		else if (i==11 && j==2) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.WEST)));
	    		}
	    		
	    		else if (i==10 && j==4) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.NORTH)));
	    		}
	    		
	    		else if (i==10 && j==5) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.NORTH)));
	    		}
	    		
	    		else if (i==11 && j==7) {
	    			assertTrue(board.getTile(i, j).containsObstacle(new Wall(Direction.EAST)));
	    		}
	    		
	    		else {
	    			assertTrue(board.getTile(i, j) == null);
	    		}
	    	}
	    }
	}

	
///////////////////////
	
	@Given("a board with a starting position")
	public void a_board_with_a_starting_position() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the game initializes")
	public void the_game_initializes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot is placed in the starting position")
	public void the_robot_is_placed_in_the_starting_position() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
/////////////////
	
	
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
		programmingDeck = new Deck(true);
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
		boolean programmingDeck = false;
		discardDeck = new Deck(programmingDeck);
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
		playingDeck = new Deck(false);
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
	    assertTrue(playingDeck.getDeck().size() == 9 && programmingDeck.getDeck().size() == initialSizeProgrammingDeck - 9);
	}
	
////////////////
	
	@Given("a position")
	public void a_position() {
	    robotPositionX = 1;
	    robotPositionY = 11;
	}
	
	@When("the robot is placed on the board")
	public void the_robot_is_placed_on_the_board() {
		board.getTile(robotPositionX,robotPositionY).setObstacle(robot);
	}
	
	@Then("the robot is in the correct tile on the board")
	public void the_robot_is_in_the_correct_tile_on_the_board() {
	    assertEquals(board.getTile(robotPositionX, robotPositionY),robot);
	}
	
}
