import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
	Laser laser;

//////////////////ASSIGNING ROBOT TO PLAYER
	
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
	
////////////////////INITIALIZING 5B BOARD
	
	@Given("an empty board of size {int} x {int}")
	public void an_empty_board_of_size_x(Integer int1, Integer int2) {
	
	}
	
	@When("the 5B board is initialised")
	public void the_5b_board_is_initialised() {
		board = new Board();
		board.initialize5B();
	}
	
	@Then("the obstacles of the board should be in the expected tiles on the board")
	public void the_obstacles_of_the_board_should_be_in_the_expected_tiles_on_the_board() {
	    // Write code here that turns the phrase above into concrete actions
	    for (int i=0; i<13; i++) {
	    	for (int j=0; j<10; j++) {
	    		if (i==3 && j==3) {
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
	    			assertTrue(board.getTile(i, j).emptyTile());
	    		}
	    	}
	    }
	}

	
///////////////////////ASSIGNING ROBOT DORECTION
	
	
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
	
/////////////////ASSIGNING STARTING DECK TO PLAYER
	
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

////////////////ASSIGNING STARTING DECK OF DISCARD CARDS TO PLAYER
	

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
		assertEquals(player.getDiscardDeck(), discardDeck);

	}	

////////////////PLAYER RECIEVES 9 CARDS FROM PROGRAMMING DECK TO PLAYING DECK
	
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

///////////////////MOVING CARDS FROM PLAYING DECK TO PROGRAMMING DECK
	
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
		assertEquals(playingDeck.getDeck()[0], null);		
	}
	
////////////////ASSIGNING ROBOT STARTING POSITION
	

	int robotPositionX;
    int robotPositionY;
    
	@Given("a position")
	public void a_position() {
		robotPositionX = 11;
		robotPositionY = 1;
	}
	
	@When("the robot is placed on the board")
	public void the_robot_is_placed_on_the_board() {
		board.getTile(robotPositionX, robotPositionY).addElement(robot);
	}
	
	@Then("the robot is in the correct tile on the board")
	public void the_robot_is_in_the_correct_tile_on_the_board() {
		assertTrue(board.getTile(robotPositionX, robotPositionY).containsElement(robot));
//		assertEquals(board.getTile(robotPositionX, robotPositionY), robot);
	}

////////////////MOVE ROBOT ACCORDING TO CARD, COLLISION WITH WALL AND REBOOT CELL

	@Given("a board")
	public void a_board() {
		board = new Board();
		board.initialize5B();
	}
	
	@Given("an action deck of cards that belongs to the player")
	public void an_action_deck_of_cards() {
		actionDeck = new ActionDeck();
	}
	
	@Given("a robot in the cell with xcoordinate {int} and ycoordinate {int}")
	public void a_robot_in_the_cell_with_xcoordinate_and_ycoordinate(Integer int1, Integer int2) {
		board.getTile(int1, int2).addElement(robot);
	}
	
	@When("an action card is played")
	public void an_action_card_is_played() {
		card = actionDeck.extractFirstCard();
		int oldX = 11;
		int oldY = 1;
		board.moveRobot(oldX, oldY, robot, card);
		discardDeck.addCard(card);
	}
	
	@Then("the card is moved from the action deck of cards to the discard deck of cards")
	public void the_card_is_moved_from_the_action_deck_of_cards_to_the_discard_deck_of_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("the robot is moved according to the programming card")
	public void the_robot_is_moved_according_to_the_programming_card() {
		assertFalse(board.getTile(11, 1).containsElement(robot));
	
	}
//	@Then("the card is placed in the discard deck of cards")
//	public void the_card_is_placed_in_the_discard_deck_of_cards() {
//		assertTrue(board.getTile(11, 1).containsElement(robot));
//	}
	

	MoveForwardCard moveForwardCard;
	Wall northWall = new Wall(Direction.NORTH);
	Wall  westWall = new Wall(Direction.WEST);
	Wall  eastWall = new Wall(Direction.EAST);
	Wall southWall = new Wall(Direction.SOUTH);
	
	@Given("a robot direction where it faces north in a tile with a north wall")
	public void a_robot_direction_where_it_faces_north_in_a_tile_with_a_north_wall() {
		
		robot.setDirection(Direction.NORTH);
		board.getTile(3, 2).addElement(northWall);
		board.getTile(3, 2).addElement(robot);
	}
	@When("a move forward card is executed a")
	public void a_move_forward_card_is_executed_a() {
		board.moveRobot(3, 2, robot, moveForwardCard);
	}
	
	@Then("the robot cannot move forward")
	public void the_robot_cannot_move_forward() {
//	    assertTrue((!(board.getTile(3, 2).containsElement(robot))) && 
//	    		   (  board.getTile(2, 2).containsElement(robot)));
	    assertFalse(board.getTile(3, 2).containsElement(robot));
	    assertTrue(board.getTile(2, 2).containsElement(robot));
	    
	}
	
	@Given("a robot facing south in a tile with xcoodinate {int} and ycoordinate {int}")
	public void a_robot_facing_south_in_a_tile_with_xcoodinate_and_ycoordinate(Integer int1, Integer int2) {
		robot.setDirection(Direction.SOUTH);
		board.getTile(int1, int2).addElement(robot);
	}
	
	@When("a move forward card is executed {int}")
	public void a_move_forward_card_is_executed(Integer int1) {
		board.moveRobot(12, 1, robot, moveForwardCard);
	}
	
	@Then("the robot is moved to the reboot cell in the board")
	public void the_robot_is_moved_to_the_reboot_cell_in_the_board() {
//		assertTrue((  board.getTile(board.getRebootPositionX(), board.getRebootPositionY()).containsElement(robot)) && 
//	    		   (!(board.getTile(12, 1).containsElement(robot))));
		assertFalse(board.getTile(12, 1).containsElement(robot));
	    assertTrue(board.getTile(board.getRebootPositionX(),board.getRebootPositionY()).containsElement(robot));
	}

///////////////////////////ACITIVATING LASER
	
	@Given("an inactive laser")
	public void an_inactive_laser() {
	    laser = new Laser();
	}
	
	@When("the laser activates")
	public void the_laser_activates() {
	    laser.active(true);
	}
	
	@Then("the laser is active")
	public void the_laser_is_active() {
	    assertEquals(laser.getActive(),true);
	}
	

/////////////////////PLACING REMAINING CARDS FROM PLAYING DECK IN DISCARD DECK

	@Given("a playing deck with {int} cards")
	public void a_playing_deck_with_cards(Integer int1) {
		player = new Player("Mejse");
		playingDeck = new PlayingDeck();
		for(int i=0; i<int1; i++) {
			playingDeck.getDeck()[i] = new RightTurnCard();
	    }
		player.setPlayingDeck(playingDeck);
	}
	
	@When("the remaining cards in the playing deck is discarded")
	public void the_remaining_cards_in_the_playing_deck_is_discarded() {
		discardDeck = new DiscardDeck();
//		for(int i=0; i<int1; i++) {
//			discardDeck.addCard(player.getPlayingDeck()[i]);
//	    }
		for(int i=0; i<int1; i++) {
			discardDeck.addCard(playingDeck.getDeck()[i]);
	    }
		player.setDiscardDeck(discardDeck);
	}
	
	@Then("the cards are moved to the discard deck")
	public void the_cards_are_moved_to_the_discard_deck() {
	    assertTrue(player.getDiscardDeck().contains(new RightTurnCard()));
	}
}

