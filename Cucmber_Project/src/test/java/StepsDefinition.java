import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
	Player player1;
	Player player2;
	Robot robot1;
	Robot robot2;
	Board board;
	Direction direction;
	Card card;
	Card extractedCard;
	Card choosenCard;
	Deck discardDeck1;
	Deck programmingDeck1;
	Deck playingDeck1;
	Deck actionDeck1;
	Laser laser;
	int numCards9 = 9;
	int indexCard = 2;
	int initialSizeProgrammingDeck;
	int size1;

/////////////////
// GAME SET UP //
/////////////////
	
	/////////////////////////////////
	// U1 : ASSIGN ROBOT TO PLAYER //
	/////////////////////////////////
	
	@Given("a robot")
	public void a_robot() {
		robot1 = new Robot(Color.BLUE);
	}
	
	@Given("a player")
	public void a_player() {
		player1 = new Player("Mejse");
	}
	
	@When("the robot is assigned to the player")
	public void the_robot_is_assigned_to_the_player() {
		player1.setRobot(robot1);
	}
	
	@Then("the robot belongs to the player")
	public void the_robot_belongs_to_the_player() {
		assertTrue(player1.getRobot().equals(new Robot(Color.BLUE))); 
	}
	
	@Given("a second robot")
	public void a_second_robot() {
	    robot2 = new Robot(Color.RED);
	}
	
	@Given("a second player")
	public void a_second_player() {
		player2 = new Player("Bernat");
	}
	@When("the robots are assigned to the players")
	public void the_robots_are_assigned_to_the_players() {
		player1.setRobot(robot1);
		player2.setRobot(robot2);
	}
	
	@Then("the robots belongs to the players")
	public void the_robots_belongs_to_the_players() {
		assertTrue(player1.getRobot().equals(new Robot(Color.BLUE)));
		assertTrue(player2.getRobot().equals(new Robot(Color.RED)));
	}
	
    ///////////////////////////
	// U2 : INITIALIZE BOARD //
	///////////////////////////
	
	@Given("an empty board")
	public void an_empty_board() {
		board = new Board();
	}
	
	@When("the 5B board is initialised")
	public void the_5b_board_is_initialised() {
		board.initialize5B();
	}
	
	@Then("the obstacles of the 5B board should be in the expected tiles")
	public void the_obstacles_of_the_5B_board_should_be_in_the_expected_tiles() {
	    // Write code here that turns the phrase above into concrete actions
	    for (int i=0; i<13; i++) {
	    	for (int j=0; j<10; j++) {
	    		if (i==3 && j==3) {
	    			assertTrue(board.containsElement(new Wall(Direction.NORTH), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==4 && j==3) {
	    			assertTrue(board.containsElement(new Wall(Direction.SOUTH), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==3 && j==5) {
	    			assertTrue(board.containsElement(new Wall(Direction.WEST), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==3 && j==6) {
	    			assertTrue(board.containsElement(new Wall(Direction.EAST), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==6 && j==3) {
	    			assertTrue(board.containsElement(new Wall(Direction.WEST), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==6 && j==4) {
	    			assertTrue(board.containsElement(new Wall(Direction.EAST), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==5 && j==6) {
	    			assertTrue(board.containsElement(new Wall(Direction.NORTH), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==6 && j==6) {
	    			assertTrue(board.containsElement(new Wall(Direction.SOUTH), i, j));
	    			assertTrue(board.containsElement(new Laser(), i, j));
	    		}
	    		
	    		else if (i==11 && j==2) {
	    			assertTrue(board.containsElement(new Wall(Direction.WEST), i, j));
	    		}
	    		
	    		else if (i==10 && j==4) {
	    			assertTrue(board.containsElement(new Wall(Direction.NORTH), i, j));
	    		}
	    		
	    		else if (i==10 && j==5) {
	    			assertTrue(board.containsElement(new Wall(Direction.NORTH), i, j));
	    		}
	    		
	    		else if (i==11 && j==7) {
	    			assertTrue(board.containsElement(new Wall(Direction.EAST), i, j));
	    		}
	    		
	    		else {
	    			assertTrue(board.isEmpty(i, j));
	    		}
	    	}
	    }
	}
	
	///////////////////////////////
	// U3 : ASSIGN DECK OF CARDS //
	///////////////////////////////
	
	@Given("a programming deck of cards")
	public void a_programming_deck_of_cards() {
		programmingDeck1 = new Deck();
		programmingDeck1.initializeProgrammingDeck();
	}
	
	@When("the player is assigned the programming deck of cards")
	public void the_player_is_assigned_the_programming_deck_of_cards() {
	    player1.setProgrammingDeck(programmingDeck1);
	}
	@Then("the player has a programming deck of cards")
	public void the_player_has_a_programming_deck_of_cards() {
	    assertTrue(player1.getProgrammingDeck().equals(programmingDeck1));
	    assertTrue(player1.getProgrammingDeck().getDeckSize() == 17);
	}

	@Given("a playing deck of cards")
	public void a_playing_deck_of_cards() {
		playingDeck1 = new Deck();
	}
	@When("the player is assigned the playing deck of cards")
	public void the_player_is_assigned_the_playing_deck_of_cards() {
	    // Write code here that turns the phrase above into concrete actions
	    player1.setPlayingDeck(playingDeck1);
	}
	@Then("the player has a playing deck of cards")
	public void the_player_has_a_playing_deck_of_cards() {
	    assertTrue(player1.getPlayingDeck().equals(playingDeck1));
	}
	
	@Given("an action deck of cards")
	public void an_action_deck_of_cards() {
	    actionDeck1 = new Deck();
	}
	@When("the player is assigned the action deck of cards")
	public void the_player_is_assigned_the_action_deck_of_cards() {
	    player1.setActionDeck(actionDeck1);
	}
	@Then("the player has an action deck of cards")
	public void the_player_has_an_action_deck_of_cards() {
	    assertTrue(player1.getActionDeck().equals(actionDeck1));
	}

	@Given("a discard deck of cards")
	public void a_discard_deck_of_cards() {
	    discardDeck1 = new Deck();
	}
	
	@When("the player is assigned the discard deck of cards")
	public void the_is_assigned_the_discard_deck_of_cards() {
	    player1.setDiscardDeck(discardDeck1);
	}
	
	@Then("the player has a discard deck of cards")
	public void the_player_has_a_discard_deck_of_cards() {
		assertTrue(player1.getDiscardDeck().equals(discardDeck1));
	}
	
	///////////////////////////////////
	// U4 : PLACE ROBOT ON THE BOARD //
	///////////////////////////////////
	
	@When("the robot is placed on the board")
	public void the_robot_is_placed_on_the_board() {
	board.setRobots(robot1);
	}
	
	@Then("the robot is in the initial position of the board")
	public void the_robot_is_in_the_initial_position_of_the_board() {
	assertTrue(board.containsElement(robot1, 12, 3));
	}
	
	@Then("the robot is facing north")
	public void the_robot_is_facing_north() {
	assertTrue(robot1.getDirection().equals(Direction.NORTH));
	}
	
	@When("the robots are placed on the board")
	public void the_robots_are_placed_on_the_board() {
	board.setRobots(robot1, robot2);
	}
	
	@Then("the robots are in the initial positions of the board")
	public void the_robots_are_in_the_initial_positions_of_the_board() {
	assertTrue(board.containsElement(robot1, 12, 3));
	assertTrue(board.containsElement(robot2, 12, 6));
	}
	
	@Then("the robots are facing north")
	public void the_robots_are_facing_north() {
	assertTrue(robot1.getDirection().equals(Direction.NORTH));
	assertTrue(robot2.getDirection().equals(Direction.NORTH));
	}
	
///////////////////////
// PROGRAMMING PHASE //
///////////////////////
	
	//////////////////////////////
	// U5 : MOVE 9 RANDOM CARDS //
	//////////////////////////////
	
	@When("the {int} cards are moved from the programming deck to the playing deck")
	public void the_cards_are_moved_from_the_programming_deck_to_the_playing_deck(int numCards9){
		initialSizeProgrammingDeck = programmingDeck1.getDeckSize();
		programmingDeck1.moveRandomCards(playingDeck1, numCards9);
	}
	
	@Then("the cards are in the playing deck")
	public void the_cards_are_in_the_playing_deck() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(playingDeck1.getDeckSize() == 9);
	}
	@Then("the cards are not in the programming deck")
	public void the_cards_are_not_in_the_programming_deck() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(programmingDeck1.getDeckSize() == initialSizeProgrammingDeck - 9);
	}
	
	///////////////////////////////
	// U6 : MOVE 1 CONCRETE CARD //
	///////////////////////////////
    
	@Given("a playing deck of cards with {int} cards")
	public void a_playing_deck_of_cards_with_cards(int numCards9) {
		playingDeck1 = new Deck();
		for (int i=0; i<numCards9; i++) {
	    	playingDeck1.addCard(Card.RightTurn);
	    }
	    size1 = playingDeck1.getDeckSize();
	}
	
	@When("the player moves the {int}th card from the playing deck to the action deck")
	public void the_player_moves_the_card_from_the_playing_deck_to_the_action_deck(Integer indexCard) {
		choosenCard = playingDeck1.getCard(indexCard);
    	playingDeck1.moveCard(indexCard, actionDeck1);
	}
	
	@Then("the card is in the action deck")
	public void the_card_is_in_the_action_deck() {
		assertTrue(playingDeck1.contains(choosenCard));
	}
	@Then("the card is not in the playing deck")
	public void the_card_is_not_in_the_playing_deck() {
	    assertTrue(playingDeck1.getDeckSize() == size1 - 1);
	}

/////////////////MOVE ROBOT ACCORDING TO CARD, COLLISION WITH WALL AND REBOOT CELL

	@Given("a board")
	public void a_board() {
		board = new Board();
		board.initialize5B();
	}
	
	@Given("an action deck of cards that belongs to the player")
	public void an_action_deck_of_cards() {
	// Write code here that turns the phrase above into concrete actions
		player = new Player("Mejse");
		actionDeck = new Deck();
		player.setActionDeck(actionDeck);
		player.setRobot(robot1);
		robot1.setDirection(Direction.NORTH);
	}
	
	@When("an action card is played")
	public void an_action_card_is_played() {
//		card = actionDeck.extractFirstCard();
		card = Card.MoveForward;
		player.getActionDeck().addCard(card);
		extractedCard = player.getActionDeck().extractCard(0);
		board.moveRobot(robot1, extractedCard);
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
		assertFalse(board.containsElement(robot1, 12, 3));
		assertTrue(board.containsElement(robot1, 11, 3));
	}
    @Then("the card is placed in the discard deck of cards")
    public void the_card_is_placed_in_the_discard_deck_of_cards() {
		assertTrue(discardDeck.contains(card));
	}
//
//	Card moveForwardCard = Card.MoveForward;
//	Wall northWall = new Wall(Direction.NORTH);
//	Wall  westWall = new Wall(Direction.WEST);
//	Wall  eastWall = new Wall(Direction.EAST);
//	Wall southWall = new Wall(Direction.SOUTH);
//	
//	@Given("a robot direction where it faces north in a tile with a north wall")
//	public void a_robot_direction_where_it_faces_north_in_a_tile_with_a_north_wall() {
//		
//		robot1.setDirection(Direction.NORTH);
//		board.setObstacle(northWall, 11, 3);
//	}
//	@When("a move forward card is executed")
//	public void a_move_forward_card_is_executed() {
//		board.moveRobot(robot1, moveForwardCard);
//	}
//	
//	@Then("the robot cannot move forward")
//	public void the_robot_cannot_move_forward() {
////	    assertTrue((!(board.getTile(3, 2).containsElement(robot))) && 
////	    		   (  board.getTile(2, 2).containsElement(robot)));
//	    assertTrue(board.containsElement(robot1, 11, 3));
//	    assertFalse(board.containsElement(robot1, 10, 3));
//	}
//	
//	@Given("a robot facing south in a tile with xcoordinate 12 and ycoordinate 6")
//	public void a_robot_facing_south_in_a_tile_with_xcoordinate_12_and_ycoordinate_6(Integer int1, Integer int2) {
//		robot2.setDirection(Direction.SOUTH);
//	}
//	
//	@Then("the robot is moved to the reboot cell in the board")
//	public void the_robot_is_moved_to_the_reboot_cell_in_the_board() {
////		assertTrue((  board.getTile(board.getRebootPositionX(), board.getRebootPositionY()).containsElement(robot)) && 
////	    		   (!(board.getTile(12, 1).containsElement(robot))));
//		// board.moveRobot(robot, moveForwardCard);
//		assertFalse(board.containsElement(robot1, 12, 6));
//	    assertTrue(board.containsElement(robot1, board.getRebootPositionX(), board.getRebootPositionY()));
//	}

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
	
	@Given("a robot belonging to the player")
	public void a_robot_belonging_to_the_player() {
		robot1 = new Robot(Color.BLUE);
		player.setRobot(robot1);
	}
	
	@Given("a programming deck belonging to the player")
	public void a_programming_deck_belonging_to_the_player() {
	    programmingDeck = new Deck();
	    programmingDeck.initializeProgrammingDeck();
	    player.setProgrammingDeck(programmingDeck);
	}
	
	@Given("an active laser")
	public void an_active_laser() {
	    laser = new Laser();
	    laser.active(true);
	}
	
	@When("the robot is hit by the laser the player recieves a damage card")
	public void the_robot_is_hit_by_the_laser_the_player_recieves_a_damage_card() {
	    laser.hit(robot1);
	}
	
	@Then("a damage card is placed in the players programming deck")
	public void a_damage_card_is_placed_in_the_players_programming_deck() {
		assertTrue(player.getProgrammingDeck().contains(Card.Damage));
	}

}

