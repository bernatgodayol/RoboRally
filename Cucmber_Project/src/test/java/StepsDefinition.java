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
	Card extractedCard;
	Deck discardDeck;
	Deck programmingDeck;
	Deck playingDeck;
	Deck actionDeck;
	Laser laser;
	Reboot reboot;
	int numCards = 9;
	int initialSizeProgrammingDeck;

//////////////////ASSIGNING ROBOT TO PLAYER
	
	@Given("a robot")
	public void a_robot() {
		robot = new Robot(Color.BLUE);
	}
	
	@Given("a player")
	public void a_player() {
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
		board = new Board();
	}
	
	@When("the 5B board is initialised")
	public void the_5b_board_is_initialised() {
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

	
///////////////////////ASSIGNING ROBOT DIRECTION
	
	
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
	
	@Given("a programming deck of cards")
	public void a_programming_deck_of_cards() {
		programmingDeck = new Deck();
	}
	
	@When("the player is assigned the deck of cards")
	public void the_player_is_assigned_the_deck_of_cards() {
		programmingDeck.initializeProgrammingDeck();
	    player.setProgrammingDeck(programmingDeck);
	}
	
	@Then("the player has that deck of cards") 
	public void the_player_has_that_deck_of_cards() {
		assertEquals(player.getProgrammingDeck(), programmingDeck);
	}

////////////////PLAYER RECIEVES 9 CARDS FROM PROGRAMMING DECK TO PLAYING DECK
	
	@Given("a programming deck that belongs to the player")
	public void a_programming_deck_that_belongs_to_the_player() {
	// Write code here that turns the phrase above into concrete actions
	programmingDeck = new Deck();
	player.setProgrammingDeck(programmingDeck);
	player.getProgrammingDeck().initializeProgrammingDeck();
	initialSizeProgrammingDeck = player.getProgrammingDeck().getDeckSize();
	System.out.println(initialSizeProgrammingDeck);
	}
	
	@Given("a playing deck that belongs to the player")
	public void a_playing_deck_that_belongs_to_the_player() {
	// Write code here that turns the phrase above into concrete actions
	playingDeck = new Deck();
	player.setPlayingDeck(playingDeck);
	}
	
	@When("the {int} random cards are selected from the programming deck")
	public void the_random_cards_are_selected_from_the_programming_deck(int numCards) {
	// Write code here that turns the phrase above into concrete actions
	player.getProgrammingDeck().moveRandomCards(playingDeck, 9);
	}
	@Then("the cards are moved to the playing deck")
	public void the_cards_are_moved_to_the_playing_deck() {
	// Write code here that turns the phrase above into concrete actions
	 assertTrue(player.getPlayingDeck().getDeckSize() == 9 && player.getProgrammingDeck().getDeckSize() == initialSizeProgrammingDeck - 9);
	}

////////////////ASSIGNING STARTING DECK OF DISCARD CARDS TO PLAYER
	

	@Given("a discard deck of cards")
	public void a_discard_deck_of_cards() {
		discardDeck = new Deck();
	}
	@When("the player is assigned the discard deck of cards")
	public void the_player_is_assigned_the_discard_deck_of_cards() {
		player.setDiscardDeck(discardDeck);
	}
	@Then("the player has that discard deck of cards")
	public void the_player_has_that_discard_deck_of_cards() {
		assertEquals(player.getDiscardDeck(), discardDeck);
	}

/////////////////// MOVING CARDS FROM PLAYING DECK TO ACTION DECK
    
    @Given("an action deck that belongs to the player")
    public void an_action_deck_that_belongs_to_the_player() {
    	actionDeck = new Deck();
		player.setActionDeck(actionDeck);
    }
    
    @When("the player chooses one card")
    public void the_player_chooses_one_card() {
    	int indexChoosenCard = 4;
    	for(int i=0; i<5; i++) {
    		player.getPlayingDeck().addCard(Card.RightTurn);
    	}
    	player.getPlayingDeck().moveCard(indexChoosenCard, player.getActionDeck());
    }
    
    @Then("the card is moved from the playing deck to the action deck")
    public void the_card_is_moved_from_the_playing_deck_to_the_action_deck() {
    	assertTrue(player.getPlayingDeck().contains(Card.RightTurn));
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

/////////////////MOVE ROBOT ACCORDING TO CARD, COLLISION WITH WALL AND REBOOT CELL

	@Given("a board")
	public void a_board() {
		board = new Board();
		board.initialize5B();
	}
	
	@Given("a robot in the cell with xcoordinate 2 and ycoordinate 3 with direction north")
	public void a_robot_in_the_cell_with_xcoordinate__2_and_ycoordinate_3_with_diretion_north() {
		robot = new Robot(Color.BLUE);
		player.setRobot(robot);
		direction = Direction.NORTH;
		robot.setDirection(direction);
		board.getTile(2, 3).addElement(robot);
	}
	
	@When("an action card is played")
	public void an_action_card_is_played() {
//		card = actionDeck.extractFirstCard();
		card = Card.MoveForward;
		player.getActionDeck().addCard(card);
		extractedCard = player.getActionDeck().extractCard(0);
		board.moveRobot(2, 3, robot, extractedCard);
		player.setDiscardDeck(discardDeck);
		player.getDiscardDeck().addCard(extractedCard);
	}
	
	@Then("the card is moved from the action deck of cards to the discard deck of cards")
	public void the_card_is_moved_from_the_action_deck_of_cards_to_the_discard_deck_of_cards() {
		assertTrue(player.getActionDeck().deckIsEmpty());
		assertTrue(player.getDiscardDeck().getCard(0) == Card.MoveForward);
	}
	
	@Then("the robot is moved according to the programming card")
	public void the_robot_is_moved_according_to_the_programming_card() {
		assertFalse(board.getTile(2, 3).containsElement(robot));
		assertTrue(board.getTile(1, 3).containsElement(robot));
	}
    @Then("the card is placed in the discard deck of cards")
    public void the_card_is_placed_in_the_discard_deck_of_cards() {
		assertTrue(discardDeck.contains(card));
	}

	Card moveForwardCard = Card.MoveForward;
	Wall northWall = new Wall(Direction.NORTH);
	Wall  westWall = new Wall(Direction.WEST);
	Wall  eastWall = new Wall(Direction.EAST);
	Wall southWall = new Wall(Direction.SOUTH);
	
	@Given("a robot direction where it faces north in a tile with a north wall")
	public void a_robot_direction_where_it_faces_north_in_a_tile_with_a_north_wall() {
		robot.setDirection(Direction.NORTH);
		board.getTile(2, 3).addElement(northWall);
		board.getTile(2, 3).addElement(robot);
	}
	@When("a move forward card is executed_1")
	public void a_move_forward_card_is_executed() {
		board.moveRobot(2, 3, robot, moveForwardCard);
	}
	
	@Then("the robot cannot move forward")
	public void the_robot_cannot_move_forward() {
//	    assertTrue((!(board.getTile(3, 2).containsElement(robot))) && 
//	    		   (  board.getTile(2, 2).containsElement(robot)));
	    assertTrue(board.getTile(2, 3).containsElement(robot));
	    assertFalse(board.getTile(1, 3).containsElement(robot));
	}
	
	@Given("a robot facing south in a tile with xcoodinate 12 and ycoordinate 4")
	public void a_robot_facing_south_in_a_tile_with_xcoodinate_12_and_ycoordinate_4(Integer int1, Integer int2) {
		robot.setDirection(Direction.SOUTH);
		board.getTile(12, 4).addElement(robot);
	}
	
	@When("a move forward card is executed_2")
	public void a_move_forward_card_is_executed_2() {
		board.moveRobot(12, 4, robot, moveForwardCard);
	}
	
	@Then("the robot is moved to the reboot cell in the board")
	public void the_robot_is_moved_to_the_reboot_cell_in_the_board() {
//		assertTrue((  board.getTile(board.getRebootPositionX(), board.getRebootPositionY()).containsElement(robot)) && 
//	    		   (!(board.getTile(12, 1).containsElement(robot))));
		assertFalse(board.getTile(12, 4).containsElement(robot));
	    assertTrue(board.getTile(board.getRebootPositionX(),board.getRebootPositionY()).containsElement(robot));
	}

///////////////////////////ACTIVATING LASER
	
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
	    playingDeck = new Deck();
	    
	    for(int i=0; i<int1; i++) {
	    	playingDeck.addCard(Card.RightTurn);
	    }
	}
	
	@Given("the decks belongs to the player")
	public void the_decks_belongs_to_the_player() {
	    player.setPlayingDeck(playingDeck);
	    player.setDiscardDeck(discardDeck);
	}
	
	@When("the playing deck contains {int} cards")
	public void the_playing_deck_contains_cards(Integer int1) {
		if(playingDeck.getDeckSize() == int1) {
			for (int i = 0; i < int1; i++) {
//		        player.getPlayingDeck().moveCard(i, player.getDiscardDeck());
				player.getDiscardDeck().addCard(Card.RightTurn);
				player.getPlayingDeck().removeCard(Card.RightTurn);
		    }
		}
	}
	
	@Then("the cards are moved from the playing deck to the discard deck")
	public void the_cards_are_moved_from_the_playing_deck_to_the_discard_deck() {
		assertTrue(player.getPlayingDeck().deckIsEmpty());
		assertTrue(player.getDiscardDeck().contains(Card.RightTurn));
	}
	

////////////////////////DAMAGE CARDS
	
	@Given("a robot that belongs to the player")
	public void a_robot_belonging_to_the_player() {
		robot = new Robot(Color.BLUE);
		player.setRobot(robot);
	}
	
	@Given("an active laser")
	public void an_active_laser() {
	    laser = new Laser();
	    laser.active(true);
	}
	
	@When("the robot is hit by the laser the player recieves a damage card")
	public void the_robot_is_hit_by_the_laser_the_player_recieves_a_damage_card() {
	    laser.hit(robot);
	}
	
	@Then("a damage card is placed in the players programming deck")
	public void a_damage_card_is_placed_in_the_players_programming_deck() {
		assertTrue(player.getProgrammingDeck().contains(Card.Damage));
	}

//////////////////////////Player receives damage card when robot in reboot cell
	
	@Given("a reboot cell")
	public void a_reboot_cell() {
		reboot = new Reboot();
	}
	
	@Given("the robot is in the reboot cell")
	public void the_robot_is_in_the_reboot_cell() {
		board.getTile(board.getRebootPositionX(), board.getRebootPositionY()).addElement(player.getRobot());
	}
	
	@When("the player receives a damage card")
	public void the_player_receives_a_damage_card() {
	    reboot.punishPlayer(robot);
	}
	
	@Then("that damage card is in the players programming deck")
	public void that_damage_card_is_in_the_players_programming_deck() {
	    assertTrue(player.getProgrammingDeck().contains(Card.Damage));
	}
	
	
}

