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
	Card cardMoveForward;
	Deck discardDeck1;
	Deck programmingDeck1;
	Deck playingDeck1;
	Deck actionDeck1;
	Laser laser;
	int numCards9 = 9;
	int numCards4 = 4;
	int indexCard = 2;
	int initialSizeProgrammingDeck;
	int size1;
	int size2;
	int robot1PositionX;
	int robot1PositionY;
	Reboot reboot;

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
	
	@Given("a board")
	public void a_board() {
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
	
	//////////////////////////////////
	// U7 : DISCARD REMAINING CARDS //
	//////////////////////////////////
	
	@Given("a playing deck with {int} cards")
	public void a_playing_deck_with_cards(Integer numCards4) {
	playingDeck1 = new Deck();
	for (int i=0; i<4; i++) {
	playingDeck1.addCard(Card.RightTurn);
	}
	}
	
	@When("the cards are moved from the playing deck to the discard deck")
	public void the_cards_are_moved_from_the_playing_deck_to_the_discard_deck() {
	for (int i=0; i<4; i++) {
	playingDeck1.moveCard(0, discardDeck1);
	}
	}
	
	@Then("the cards are in the discard deck")
	public void the_cards_are_in_the_discard_deck() {
	assertTrue(discardDeck1.getDeckSize() == numCards4);
	}
	
	@Then("the cards are not in the playing deck")
	public void the_cards_are_not_in_the_playing_deck() {
	assertTrue(playingDeck1.deckIsEmpty());
	}

//////////////////
// ACTION PHASE //
//////////////////
	
	/////////////////////
	// U8 : MOVE ROBOT //
	/////////////////////
	
	////// MOVE FORWARD
	
	@Given("a robot on the board facing north")
	public void a_robot_on_the_board_facing_north() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.NORTH);
		board.setRobotPositionX(3, robot1);
		board.setRobotPositionY(4, robot1);
		board.getTile(3, 4).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
		}
	@Given("a move forward card")
	public void a_move_forward_card() {
	    cardMoveForward = Card.MoveForward;
	}
	@When("the move forward card is executed")
	public void the_move_forward_card_is_executed() {
	    board.moveRobot(robot1, cardMoveForward);
	}
	@Then("the robot moves forward north")
	public void the_robot_moves_forward_north() {
	    assertFalse(board.containsElement(robot1, robot1PositionX  , robot1PositionY));
	    assertTrue (board.containsElement(robot1, robot1PositionX-1, robot1PositionY));
	}
	
	@Given("a robot on the board facing south")
	public void a_robot_on_the_board_facing_south() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.SOUTH);
		board.setRobotPositionX(3, robot1);
		board.setRobotPositionY(4, robot1);
		board.getTile(3, 4).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
		}
	@Then("the robot moves forward south")
	public void the_robot_moves_forward_south() {
	    assertFalse(board.containsElement(robot1, robot1PositionX  , robot1PositionY));
	    assertTrue (board.containsElement(robot1, robot1PositionX+1, robot1PositionY));
	}
	
	@Given("a robot on the board facing east")
	public void a_robot_on_the_board_facing_east() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.EAST);
		board.setRobotPositionX(3, robot1);
		board.setRobotPositionY(4, robot1);
		board.getTile(3, 4).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
		}
	@Then("the robot moves forward east")
	public void the_robot_moves_forward_east() {
	    assertFalse(board.containsElement(robot1, robot1PositionX, robot1PositionY));
	    assertTrue (board.containsElement(robot1, robot1PositionX, robot1PositionY-1));
	}
	
	@Given("a robot on the board facing west")
	public void a_robot_on_the_board_facing_west() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.WEST);
		board.setRobotPositionX(3, robot1);
		board.setRobotPositionY(4, robot1);
		board.getTile(3, 4).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
		}
	@Then("the robot moves forward west")
	public void the_robot_moves_forward_west() {
	    assertFalse(board.containsElement(robot1, robot1PositionX, robot1PositionY));
	    assertTrue (board.containsElement(robot1, robot1PositionX, robot1PositionY+1));
	}
	
	////// HIT WALL
	
	@Given("a north wall in the tile where the robot is")
	public void a_north_wall_in_the_tile_where_the_robot_is() {
	    board.setObstacle(new Wall(Direction.NORTH), robot1PositionX, robot1PositionY);
	}
	@Then("the robot does not move forward north")
	public void the_robot_does_not_move_forward_north() {
		assertTrue (board.containsElement(robot1, robot1PositionX  , robot1PositionY));
	    assertFalse(board.containsElement(robot1, robot1PositionX-1, robot1PositionY));
	}
	
	@Given("a north wall in the tile below where the robot is")
	public void a_north_wall_in_the_tile_below_where_the_robot_is() {
	    board.setObstacle(new Wall(Direction.NORTH), robot1PositionX+1, robot1PositionY);
	}
	@Then("the robot does not move forward south")
	public void the_robot_does_not_move_forward_south() {
		assertTrue (board.containsElement(robot1, robot1PositionX  , robot1PositionY));
	    assertFalse(board.containsElement(robot1, robot1PositionX+1, robot1PositionY));
	}
	
	@Given("a south wall in the tile where the robot is")
	public void a_south_wall_in_the_tile_where_the_robot_is() {
		board.setObstacle(new Wall(Direction.SOUTH), robot1PositionX, robot1PositionY);
	}
	
	@Given("a south wall in the tile above where the robot is")
	public void a_south_wall_in_the_tile_above_where_the_robot_is() {
		board.setObstacle(new Wall(Direction.SOUTH), robot1PositionX-1, robot1PositionY);
	}
	
	@Given("a east wall in the tile where the robot is")
	public void a_east_wall_in_the_tile_where_the_robot_is() {
		board.setObstacle(new Wall(Direction.EAST), robot1PositionX, robot1PositionY);
	}
	@Then("the robot does not move forward east")
	public void the_robot_does_not_move_forward_east() {
		assertTrue (board.containsElement(robot1, robot1PositionX, robot1PositionY));
	    assertFalse(board.containsElement(robot1, robot1PositionX, robot1PositionY+1));
	}
	
	@Given("a east wall in the tile next right where the robot is")
	public void a_east_wall_in_the_tile_next_right_where_the_robot_is() {
		board.setObstacle(new Wall(Direction.EAST), robot1PositionX, robot1PositionY+1);
	}
	@Then("the robot does not move forward west")
	public void the_robot_does_not_move_forward_west() {
		assertTrue (board.containsElement(robot1, robot1PositionX, robot1PositionY));
	    assertFalse(board.containsElement(robot1, robot1PositionX, robot1PositionY-1));
	}
	
	@Given("a west wall in the tile where the robot is")
	public void a_west_wall_in_the_tile_where_the_robot_is() {
		board.setObstacle(new Wall(Direction.WEST), robot1PositionX, robot1PositionY);
	}
	
	@Given("a west wall in the tile next left where the robot is")
	public void a_west_wall_in_the_tile_next_left_where_the_robot_is() {
		board.setObstacle(new Wall(Direction.WEST), robot1PositionX, robot1PositionY-1);
	}
	
	////// GO OUT OF THE BOARD
	
	@Given("a robot on the edge of board facing north")
	public void a_robot_on_the_edge_of_board_facing_north() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.NORTH);
		board.setRobotPositionX(0, robot1);
		board.setRobotPositionY(4, robot1);
		board.getTile(0, 4).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
	}
	@Then("the robot goes to the reboot cell")
	public void the_robot_goes_to_the_reboot_cell() {
		assertTrue (board.containsElement(robot1, board.getRebootPositionX(), board.getRebootPositionY()));
	    assertFalse(board.containsElement(robot1, robot1PositionX, robot1PositionY));
	}
	
	@Given("a robot on the edge of board facing south")
	public void a_robot_on_the_edge_of_board_facing_south() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.SOUTH);
		board.setRobotPositionX(12, robot1);
		board.setRobotPositionY(4, robot1);
		board.getTile(12, 4).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
	}
	
	@Given("a robot on the edge of board facing east")
	public void a_robot_on_the_edge_of_board_facing_east() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.EAST);
		board.setRobotPositionX(3, robot1);
		board.setRobotPositionY(9, robot1);
		board.getTile(3, 9).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
	}
	
	@Given("a robot on the edge of board facing west")
	public void a_robot_on_the_edge_of_board_facing_west() {
	    robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.WEST);
		board.setRobotPositionX(3, robot1);
		board.setRobotPositionY(0, robot1);
		board.getTile(3, 0).addElement(robot1);
		robot1PositionX = board.getRobotPositionX(robot1);
		robot1PositionY = board.getRobotPositionY(robot1);
	}
	
	//////////////////////
	// U9 : TURN ROBOT //
	//////////////////////
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////
	// U? : ACTIVATE LASER //
	/////////////////////////
	
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

	////////////////////////DAMAGE CARDS
	
	@Given("a robot that belongs to the player")
	public void a_robot_belonging_to_the_player() {
		robot1 = new Robot(Color.BLUE);
		player1.setRobot(robot1);
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
		assertTrue(player1.getProgrammingDeck().contains(Card.Damage));
	}

	//////////////////////////Player receives damage card when robot in reboot cell
	
	@Given("a reboot cell")
	public void a_reboot_cell() {
		reboot = new Reboot();
	}
	
	@Given("the robot is in the reboot cell")
	public void the_robot_is_in_the_reboot_cell() {
		board.getTile(board.getRebootPositionX(), board.getRebootPositionY()).addElement(player1.getRobot());
	}
	
	@When("the player receives a damage card")
	public void the_player_receives_a_damage_card() {
	    reboot.punishPlayer(robot1);
	}
	
	@Then("that damage card is in the players programming deck")
	public void that_damage_card_is_in_the_players_programming_deck() {
	    assertTrue(player1.getProgrammingDeck().contains(Card.Damage));
	}
	
	
}

