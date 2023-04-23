import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import model.AI;
import model.Board;
import model.Card;
import model.Color;
import model.Damage;
import model.Deck;
import model.Direction;
import model.Laser;
import model.LeftTurn;
import model.MoveForward;
import model.Pit;
import model.Player;
import model.RightTurn;
import model.Robot;
import model.UTurn;
import model.Wall;

public class StepsDefinition {
	
	Player player1;
	Player player2;
	Robot robot1;
	Robot robot2;
	Board board;
	Direction direction;
	Card card;
	Card extractedCard;
	Card choosenCard1;
	Card choosenCard2;
	Card choosenCard3;
	Card choosenCard4;
	Card choosenCard5;
	Card choosenCard6;
	Card choosenCard7;
	Card choosenCard8;
	Card choosenCard9;
	Card choosenCard10;
	Card cardMoveForward;
	Card cardUTurn;
	Card cardRightTurn;
	Card cardLeftTurn;
	Deck programmingDeck1;
	Deck playingDeck1;
	Deck actionDeck1;
	Deck discardDeck1;
	Deck programmingDeck2;
	Deck playingDeck2;
	Deck actionDeck2;
	Deck discardDeck2;
	Laser laser;
	Pit pit;
	int numCards9 = 9;
	int numCards4 = 4;
	int initialSizeProgrammingDeck1;
	int initialSizeProgrammingDeck2;
	int size1;
	int size2;
	int robot1PositionX;
	int robot1PositionY;
	int oldRobot1i;
	int oldRobot1j;
	int oldRobot2i;
	int oldRobot2j;
	int int1 = 8;
	int int2 = 3;
	int int3 = 2;
	int int4 = 5;
	int int5 = 1;
	int int6 = 6;
	int int7 = 3;
	int int8 = 2;
	int int9 = 9;
	int int10 = 1;
	AI AIPlayer;
	
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
	
	@When("the second robot is assigned to the second player")
	public void the_robots_are_assigned_to_the_player() {
		player2.setRobot(robot2);
	}
	
	@Then("the second robot belongs to the second player")
	public void the_second_robot_belongs_to_the_second_player() {
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
	
	@Then("the obstacles of the 5B board are in the expected tiles")
	public void the_obstacles_of_the_5B_board_are_in_the_expected_tiles() {
	    // Write code here that turns the phrase above into concrete actions
	    for (int i=0; i<13; i++) {
	    	for (int j=0; j<10; j++) {
	    		if (i==3 && j==3) {
	    			assertTrue(board.getTile(i, j).getNorthBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==4 && j==3) {
	    			assertTrue(board.getTile(i, j).getSouthBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==3 && j==5) {
	    			assertTrue(board.getTile(i, j).getWestBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==3 && j==6) {
	    			assertTrue(board.getTile(i, j).getEastBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==6 && j==3) {
	    			assertTrue(board.getTile(i, j).getWestBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==6 && j==4) {
	    			assertTrue(board.getTile(i, j).getEastBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==5 && j==6) {
	    			assertTrue(board.getTile(i, j).getNorthBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==6 && j==6) {
	    			assertTrue(board.getTile(i, j).getSouthBarrier() instanceof Wall);
	    			assertTrue(board.getTile(i, j).getWalkableElement() instanceof Laser);
	    		} else if (i==11 && j==2) {
	    			assertTrue(board.getTile(i, j).getWestBarrier() instanceof Wall);
	    		} else if (i==10 && j==4) {
	    			assertTrue(board.getTile(i, j).getNorthBarrier() instanceof Wall);
	    		} else if (i==10 && j==5) {
	    			assertTrue(board.getTile(i, j).getNorthBarrier() instanceof Wall);
	    		} else if (i==11 && j==7) {
	    			assertTrue(board.getTile(i, j).getEastBarrier() instanceof Wall);
	    		} else {
	    			assertTrue((board.getTile(i, j).isEmpty()));
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
	
	@Given("a second programming deck of cards")
	public void a_second_programming_deck_of_cards() {
		programmingDeck2 = new Deck();
		programmingDeck2.initializeProgrammingDeck();
	}
	
	@When("the second player is assigned the second programming deck of cards")
	public void the_second_player_is_assigned_the_second_programming_deck_of_cards() {
		player2.setProgrammingDeck(programmingDeck2);
	}
	
	@Then("the second player has a programming deck of cards")
	public void the_second_player_has_a_programming_deck_of_cards() {
		assertTrue(player2.getProgrammingDeck().equals(programmingDeck2));
	    assertTrue(player2.getProgrammingDeck().getDeckSize() == 17);
	}
	
	@Given("a second playing deck of cards")
	public void a_second_playing_deck_of_cards() {
		playingDeck2 = new Deck();
	}
	@When("the second player is assigned the second playing deck of cards")
	public void the_second_player_is_assigned_the_second_playing_deck_of_cards() {
		player2.setPlayingDeck(playingDeck2);
	}
	@Then("the second player has a playing deck of cards")
	public void the_second_player_has_a_playing_deck_of_cards() {
		assertTrue(player2.getPlayingDeck().equals(playingDeck2));
	}
	
	@Given("a second action deck of cards")
	public void a_second_action_deck_of_cards() {
		actionDeck2 = new Deck();
	}
	@When("the second player is assigned the second action deck of cards")
	public void the_second_player_is_assigned_the_second_action_deck_of_cards() {
		player2.setActionDeck(actionDeck2);
	}
	@Then("the second player has an action deck of cards")
	public void the_second_player_has_an_action_deck_of_cards() {
		assertTrue(player2.getActionDeck().equals(actionDeck2));
	}
	
	@Given("a second discard deck of cards")
	public void a_second_discard_deck_of_cards() {
		discardDeck2 = new Deck();
	}
	
	@When("the second player is assigned the second discard deck of cards")
	public void the_second_player_is_assigned_the_second_discard_deck_of_cards() {
		player2.setDiscardDeck(discardDeck2);
	}
	
	@Then("the second player has a discard deck of cards")
	public void the_second_player_has_a_discard_deck_of_cards() {
		assertTrue(player2.getDiscardDeck().equals(discardDeck2));
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
		assertTrue(robot1.geti() == 12 && robot1.getj() == 3);
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
		assertTrue(robot1.geti() == 12 && robot1.getj() == 3);
		assertTrue(robot2.geti() == 12 && robot2.getj() == 6);
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
	
	@Given("a programming deck of cards that belongs to the player")
	public void a_programming_deck_of_cards_that_belongs_to_the_player() {
		programmingDeck1 = new Deck();
		programmingDeck1.initializeProgrammingDeck();
		player1.setProgrammingDeck(programmingDeck1);
		initialSizeProgrammingDeck1 = programmingDeck1.getDeckSize();
	}
	
	@Given("a playing deck of cards that belongs to the player")
	public void a_playing_deck_of_cards_that_belongs_to_the_player() {
		playingDeck1 = new Deck();
		player1.setPlayingDeck(playingDeck1);
	}
	
	@When("the {int} cards are moved from the programming deck to the playing deck")
	public void the_cards_are_moved_from_the_programming_deck_to_the_playing_deck(int numCards9){
		programmingDeck1.moveRandomCards(playingDeck1, numCards9);
	}
	
	@Then("the cards are in the playing deck")
	public void the_cards_are_in_the_playing_deck() {
		assertTrue(playingDeck1.getDeckSize() == 9);
	}
	@Then("the cards are not in the programming deck")
	public void the_cards_are_not_in_the_programming_deck() {
		assertTrue(programmingDeck1.getDeckSize() == initialSizeProgrammingDeck1 - 9);
	}
	
	@Given("a second programming deck of cards that belongs to the second player")
	public void a_second_programming_deck_of_cards_that_belongs_to_the_second_player() {
		programmingDeck2 = new Deck();
		programmingDeck2.initializeProgrammingDeck();
		player1.setProgrammingDeck(programmingDeck2);
		initialSizeProgrammingDeck2 = programmingDeck2.getDeckSize();
	}
	
	@Given("a second playing deck of cards that belongs to the second player")
	public void a_second_playing_deck_of_cards_that_belongs_to_the_second_player() {
		playingDeck2 = new Deck();
		player2.setPlayingDeck(playingDeck2);
	}
	
	@When("the {int} cards are moved from the second programming deck to the second playing deck")
	public void the_cards_are_moved_from_the_second_programming_deck_to_the_second_playing_deck(Integer numCards9) {
		initialSizeProgrammingDeck2 = programmingDeck2.getDeckSize();
		programmingDeck2.moveRandomCards(playingDeck2, numCards9);
	}
	@Then("the cards are in the second playing deck")
	public void the_cards_are_in_the_second_playing_deck() {
		assertTrue(playingDeck2.getDeckSize() == 9);
	}
	@Then("the cards are not in the second programming deck")
	public void the_cards_are_not_in_the_second_programming_deck() {
		assertTrue(programmingDeck2.getDeckSize() == initialSizeProgrammingDeck2 - 9);
	}
	
	//////////////////////////////
	// U6 : MOVE CONCRETE CARDS //
	//////////////////////////////
    
	@Given("a playing deck of cards with {int} cards")
	public void a_playing_deck_of_cards_with_cards(int numCards9) {
		playingDeck1 = new Deck();
		for (int i=0; i<numCards9; i++) {
	    	playingDeck1.addCard(new RightTurn());
	    }
	    size1 = playingDeck1.getDeckSize();
	}
	
	@When("the player moves the {int} th card from the playing deck to the action deck")
	public void the_player_moves_the_th_card_from_the_playing_deck_to_the_action_deck(Integer int1) {
		choosenCard1 = playingDeck1.getCard(int1);
    	playingDeck1.moveCard(int1, actionDeck1);
	}
	
	@Then("the card is in the action deck")
	public void the_card_is_in_the_action_deck() {
		assertTrue(playingDeck1.contains(choosenCard1));
	}
	@Then("the card is not in the playing deck")
	public void the_card_is_not_in_the_playing_deck() {
	    assertTrue(playingDeck1.getDeckSize() == size1 - 1);
	}
	
	@When("the player moves the cards {int} {int} {int} {int} {int} from the playing deck to the action deck")
	public void the_player_moves_the_cards_from_the_playing_deck_to_the_action_deck(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5) {
		choosenCard1 = playingDeck1.getCard(int1-1);
		choosenCard2 = playingDeck1.getCard(int2-1);
		choosenCard3 = playingDeck1.getCard(int3-1);
		choosenCard4 = playingDeck1.getCard(int4-1);
		choosenCard5 = playingDeck1.getCard(int5-1);
    	playingDeck1.moveCard(int1, int2, int3, int4, int5, actionDeck1);
	}
	
	@Given("a second playing deck of cards with {int} cards")
	public void a_second_playing_deck_of_cards_with_cards(Integer numCards9) {
		playingDeck2 = new Deck();
		for (int i=0; i<numCards9; i++) {
	    	playingDeck2.addCard(new RightTurn());
	    }
	    size2 = playingDeck2.getDeckSize();
	}
	
	@When("the second player moves the {int} th card from the second playing deck to the second action deck")
	public void the_second_player_moves_the_card_from_the_second_playing_deck_to_the_second_action_deck(Integer int6) {
		choosenCard2 = playingDeck2.getCard(int6);
    	playingDeck2.moveCard(int6, actionDeck2);
	}
	@Then("the second card is in the second action deck")
	public void the_second_card_is_in_the_second_action_deck() {
		assertTrue(playingDeck2.contains(choosenCard2));
	}
	@Then("the second card is not in the second playing deck")
	public void the_second_card_is_not_in_the_second_playing_deck() {
		assertTrue(playingDeck2.getDeckSize() == size2 - 1);
	}
	
	@When("the second player moves the cards {int} {int} {int} {int} {int} from the second playing deck to the second action deck")
	public void the_second_player_moves_the_cards_from_the_second_playing_deck_to_the_second_action_deck(Integer int6, Integer int7, Integer int8, Integer int9, Integer int10) {
		choosenCard6 = playingDeck2.getCard(int6-1);
		choosenCard7 = playingDeck2.getCard(int7-1);
		choosenCard8 = playingDeck2.getCard(int8-1);
		choosenCard9 = playingDeck2.getCard(int9-1);
		choosenCard10 = playingDeck2.getCard(int10-1);
    	playingDeck2.moveCard(int6, int7, int8, int9, int10, actionDeck2);
	}
	@Then("the {int} cards are in the action deck")
	public void the_cards_are_in_the_action_deck(Integer numCards5) {
		assertTrue(actionDeck1.getDeckSize() == numCards5);
		
	}
	@Then("the {int} cards are in the second action deck")
	public void the_cards_are_in_the_second_action_deck(Integer numCards5) {
		assertTrue(actionDeck2.getDeckSize() == numCards5);
	}
	@Then("the {int} cards are not in the playing deck")
	public void the_cards_are_not_in_the_playing_deck(Integer numCards5) {
		 assertTrue(playingDeck1.getDeckSize() == size1 - numCards5);
	}
	@Then("the {int} cards are not in the second playing deck")
	public void the_cards_are_not_in_the_second_playing_deck(Integer numCards5) {
		 assertTrue(playingDeck2.getDeckSize() == size1 - numCards5);
	}
	
	//////////////////////////////////
	// U7 : DISCARD REMAINING CARDS //
	//////////////////////////////////
	
	@Given("a playing deck with {int} cards")
	public void a_playing_deck_with_cards(Integer numCards4) {
		playingDeck1 = new Deck();
		for (int i=0; i<4; i++) {
			playingDeck1.addCard(new RightTurn());
			}
	}
	
	@When("the remaining cards are moved from the playing deck to the discard deck")
	public void the_remaining_cards_are_moved_from_the_playing_deck_to_the_discard_deck() {
		for (int i=0; i<4; i++) {
		playingDeck1.moveCard(0, discardDeck1);
		}
	}
	
	@Then("the remaining cards are in the discard deck")
	public void the_remaining_cards_are_in_the_discard_deck() {
		assertTrue(discardDeck1.getDeckSize() == numCards4);
	}
	
	@Then("the remaining cards are not in the playing deck")
	public void the_remaining_cards_are_not_in_the_playing_deck() {
		assertTrue(playingDeck1.deckIsEmpty());
	}
	
	@Given("a second playing deck with {int} cards")
	public void a_second_playing_deck_with_cards(Integer numCards4) {
		playingDeck2 = new Deck();
		for (int i=0; i<4; i++) {
		playingDeck2.addCard(new RightTurn());
		}
	}
	@When("the remaining cards are moved from the second playing deck to the second discard deck")
	public void the_remaining_cards_are_moved_from_the_second_playing_deck_to_the_second_discard_deck() {
		for (int i=0; i<4; i++) {
			playingDeck2.moveCard(0, discardDeck2);
		}
	}
	@Then("the remaining cards are in the second discard deck")
	public void the_remaining_cards_are_in_the_second_discard_deck() {
		assertTrue(discardDeck2.getDeckSize() == numCards4);
	}
	@Then("the remaining cards are not in the second playing deck")
	public void the_remaining_cards_are_not_in_the_second_playing_deck() {
		assertTrue(playingDeck2.deckIsEmpty());
	}

//////////////////////
// ACTIVATION PHASE //
//////////////////////
	
	/////////////////////
	// U8 : MOVE ROBOT //
	/////////////////////
	
	////// MOVE FORWARD
	
	@Given("a robot on the board facing north")
	public void a_robot_on_the_board_facing_north() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.NORTH);
		robot1.seti(3);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		}
	@Given("a move forward card")
	public void a_move_forward_card() {
	    cardMoveForward = new MoveForward();
	}
	@When("the move forward card is executed")
	public void the_move_forward_card_is_executed() {
	    cardMoveForward.execute(robot1, board);
	}
	@Then("the robot moves forward north")
	public void the_robot_moves_forward_north() {
	    assertFalse((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	    assertTrue ((robot1.geti() == oldRobot1i - 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("a robot on the board facing south")
	public void a_robot_on_the_board_facing_south() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.SOUTH);
		robot1.seti(3);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		}
	@Then("the robot moves forward south")
	public void the_robot_moves_forward_south() {
		assertFalse((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	    assertTrue ((robot1.geti() == oldRobot1i + 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("a robot on the board facing east")
	public void a_robot_on_the_board_facing_east() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.EAST);
		robot1.seti(3);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		}
	@Then("the robot moves forward east")
	public void the_robot_moves_forward_east() {
		assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	    assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	
	@Given("a robot on the board facing west")
	public void a_robot_on_the_board_facing_west() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.WEST);
		robot1.seti(3);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		}
	@Then("the robot moves forward west")
	public void the_robot_moves_forward_west() {
		assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	    assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j - 1));
	}
	
	////// HIT WALL
	
	@Given("a north wall in the tile where the robot is")
	public void a_north_wall_in_the_tile_where_the_robot_is() {
	    board.getTile(oldRobot1i, oldRobot1j).setNorthBarrier(new Wall());
	}
	@Then("the robot does not move forward north")
	public void the_robot_does_not_move_forward_north() {
		assertTrue ((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	    assertFalse((robot1.geti() == oldRobot1i - 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("a north wall in the tile below where the robot is")
	public void a_north_wall_in_the_tile_below_where_the_robot_is() {
		board.getTile(oldRobot1i + 1, oldRobot1j).setNorthBarrier(new Wall());
	}
	@Then("the robot does not move forward south")
	public void the_robot_does_not_move_forward_south() {
		assertTrue ((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	    assertFalse((robot1.geti() == oldRobot1i + 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("a south wall in the tile where the robot is")
	public void a_south_wall_in_the_tile_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setSouthBarrier(new Wall());
	}
	
	@Given("a south wall in the tile above where the robot is")
	public void a_south_wall_in_the_tile_above_where_the_robot_is() {
		board.getTile(oldRobot1i - 1, oldRobot1j).setSouthBarrier(new Wall());
	}
	
	@Given("a east wall in the tile where the robot is")
	public void a_east_wall_in_the_tile_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setEastBarrier(new Wall());
	}
	@Then("the robot does not move forward east")
	public void the_robot_does_not_move_forward_east() {
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	    assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	
	@Given("a east wall in the tile next left where the robot is")
	public void a_east_wall_in_the_tile_next_left_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j - 1).setEastBarrier(new Wall());
	}
	@Given("a west wall in the tile next right where the robot is")
	public void a_west_wall_in_the_tile_next_right_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j + 1).setWestBarrier(new Wall());
	}

	@Then("the robot does not move forward west")
	public void the_robot_does_not_move_forward_west() {
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	    assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j - 1));
	}
	
	@Given("a west wall in the tile where the robot is")
	public void a_west_wall_in_the_tile_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setWestBarrier(new Wall());
	}
	
	@Given("a west wall in the tile next left where the robot is")
	public void a_west_wall_in_the_tile_next_left_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j - 1).setWestBarrier(new Wall());
	}
	
	////// GO OUT OF THE BOARD
	
	@Given("a robot on the edge of board facing north")
	public void a_robot_on_the_edge_of_board_facing_north() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.NORTH);
		robot1.seti(0);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
	}
	@Then("the robot goes to the reboot cell")
	public void the_robot_goes_to_the_reboot_cell() {
		assertTrue ((robot1.geti() == board.getRebooti()) && (robot1.getj() == board.getRebootj()));
	    assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("a robot on the edge of board facing south")
	public void a_robot_on_the_edge_of_board_facing_south() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.SOUTH);
		robot1.seti(12);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
	}
	
	@Given("a robot on the edge of board facing east")
	public void a_robot_on_the_edge_of_board_facing_east() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.EAST);
		robot1.seti(3);
		robot1.setj(9);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
	}
	
	@Given("a robot on the edge of board facing west")
	public void a_robot_on_the_edge_of_board_facing_west() {
		robot1 = new Robot(Color.BLUE);
		board.setRobots(robot1);
		robot1.setDirection(Direction.WEST);
		robot1.seti(3);
		robot1.setj(0);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
	}
	
	//////////////////////////
	// U9 : Falls in a pit ///
	//////////////////////////
	
	@Given("a pit")
	public void a_pit() {
		pit = new Pit();
	}
	
	@When("a pit is in the same tile as the robot")
	public void a_pit_is_in_the_same_tile_as_the_robot() {
		board.getTile(oldRobot1i, oldRobot1j).setWalkableElement(new Pit());
		pit.action(robot1, board);
		}
	
	
	
	@Given("a robot on the board that belongs to a player")
	public void a_robot_on_the_board_that_belongs_to_a_player() {
		robot1 = new Robot(Color.BLUE);
		player1.setRobot(robot1);
		board.setRobots(robot1);
		robot1.setDirection(Direction.NORTH);
		robot1.seti(3);
		robot1.setj(4);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		}
	
	
	//////////////////////
	// U9 : TURN ROBOT  //
	//////////////////////
	
	@Given("a UTurn card")
	public void a_u_turn_card() {
		cardUTurn = new UTurn();
	}
	@When("the UTurn card is executed")
	public void the_u_turn_card_is_executed() {
	    cardUTurn.execute(robot1, board);
	}
	
	@Then("the robot is facing south")
	public void the_robot_is_facing_south() {
	    assertTrue(robot1.getDirection() == Direction.SOUTH);
	}

	@Given("a RightTurn card")
	public void a_right_turn_card() {
	    cardRightTurn = new RightTurn();
	}
	
	@When("the RightTurn card is executed")
	public void the_right_turn_card_is_executed() {
		cardRightTurn.execute(robot1, board);
	}
	
	@Then("the robot is facing east")
	public void the_robot_is_facing_east() {
		assertTrue(robot1.getDirection() == Direction.EAST);
	}
	
	
	@Then("the robot is facing west")
	public void the_robot_is_facing_west() {
		assertTrue(robot1.getDirection() == Direction.WEST);
	}
	
	@Given("a LeftTurn card")
	public void a_left_turn_card() {
		cardLeftTurn = new LeftTurn();
	}
	@When("the LeftTurn card is executed")
	public void the_left_turn_card_is_executed() {
		cardLeftTurn.execute(robot1, board);
	}
	
	//////////////////////////
	// U10 : ACTIVATE LASER //
	//////////////////////////
	
	@Given("a laser")
	public void an_inactive_laser() {
	    laser = new Laser();
	}
	

	///////////////////////////////
	// U11 : RECEIVE DAMAGE CARD //
	///////////////////////////////
	
	////// WHEN HIT BY LASER
	
	@Given("a robot that belongs to the player")
	public void a_robot_that_belongs_to_the_player() {
		robot1 = new Robot(Color.BLUE);
		player1.setRobot(robot1);
	}
	
	@When("the robot is hit by the laser")
	public void the_robot_is_hit_by_the_laser() {
		board.getTile(oldRobot1i, oldRobot1j).setWalkableElement(laser);
		laser.action(robot1, board);
	}
	@Then("a damage card is in the programming deck")
	public void a_damage_card_is_placed_in_the_programming_deck() {
		assertTrue(programmingDeck1.contains(new Damage()));
	}
	
	//////WHEN GOING TO THE REBOOT CELL
	
	
	    
	
	//////////////////////////
	// U? : ROBOT COLLISION //
	//////////////////////////
	
	@Given("two robots on the board")
	public void two_robots_on_the_board() {
		robot1 = new Robot(Color.BLUE);
		robot2 = new Robot(Color.RED);
		board.setRobots(robot1, robot2);
		robot1.seti(3);
		robot1.setj(4);
	}
	@Given("the second robot facing north")
	public void the_second_robot_facing_north() {
		robot2.setDirection(Direction.NORTH);
	}
	@Given("the second robot in the tile below where the first robot is")
	public void the_second_robot_in_the_tile_below_where_the_first_robot_is() {
		robot2.seti(robot1.geti() + 1);
		robot2.setj(robot1.getj());
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		oldRobot2i = robot2.geti();
		oldRobot2j = robot2.getj();
	}
	@Given("the second robot in the tile above where the first robot is")
	public void the_second_robot_in_the_tile_above_where_the_first_robot_is() {
		robot2.seti(robot1.geti() - 1);
		robot2.setj(robot1.getj());
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		oldRobot2i = robot2.geti();
		oldRobot2j = robot2.getj();
	}
	@Given("the second robot in the tile right where the first robot is")
	public void the_second_robot_in_the_tile_right_where_the_first_robot_is() {
		robot2.seti(robot1.geti());
		robot2.setj(robot1.getj() + 1);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		oldRobot2i = robot2.geti();
		oldRobot2j = robot2.getj();
	}
	@Given("the second robot in the tile left where the first robot is")
	public void the_second_robot_in_the_tile_left_where_the_first_robot_is() {
		robot2.seti(robot1.geti());
		robot2.setj(robot1.getj() - 1);
		oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
		oldRobot2i = robot2.geti();
		oldRobot2j = robot2.getj();
	}
	@When("the second robot moves forward")
	public void the_second_robot_moves_forward() {
		cardMoveForward = new MoveForward();
		cardMoveForward.execute(robot2, board);
	}
	@Then("the second robot moves forward north")
	public void the_second_robot_moves_forward_north() {
		assertFalse((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
		assertTrue ((robot2.geti() == oldRobot2i - 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the first robot is moved forward north")
	public void the_first_robot_is_moved_forward_north() {
		assertFalse((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
		assertTrue ((robot1.geti() == oldRobot1i - 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("a north wall in the tile where the first robot is")
	public void a_north_wall_in_the_tile_where_the_first_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setNorthBarrier(new Wall());
	}
	
	@Given("a east wall in the tile where the first robot is")
	public void a_east_wall_in_the_tile_where_the_first_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setEastBarrier(new Wall());
	}
	
	@Given("a south wall in the tile where the first robot is")
	public void a_south_wall_in_the_tile_where_the_first_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setSouthBarrier(new Wall());
	}
	
	@Given("a west wall in the tile where the first robot is")
	public void a_west_wall_in_the_tile_where_the_first_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setWestBarrier(new Wall());
	}
	
	@Then("the first robot does not move forward north")
	public void the_first_robot_does_not_move_forward_north() {
		assertTrue ((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
		assertFalse((robot1.geti() == oldRobot1i - 1) && (robot1.getj() == oldRobot1j));
	}
	@Then("the second robot is not moved forward north")
	public void the_second_robot_is_not_moved_forward_north() {
		assertTrue ((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
		assertFalse((robot2.geti() == oldRobot2i - 1) && (robot2.getj() == oldRobot2j));
	}
	
	@Given("the first robot in the edge of the board north")
	public void the_first_robot_in_the_edge_of_the_board_north() {
		robot1.seti(0);
		robot1.setj(3);
	}
	@Then("the first robot goes to the reboot cell")
	public void the_first_robot_goes_to_the_reboot_cell() {
		assertTrue ((robot1.geti() == board.getRebooti()) && (robot1.getj() == board.getRebootj()));
		assertFalse((robot1.geti() == oldRobot1i        ) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("the second robot facing west")
	public void the_second_robot_facing_west() {
		robot2.setDirection(Direction.WEST);
	}
	@Then("the first robot does not move forward west")
	public void the_first_robot_does_not_move_forward_west() {
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
		assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j - 1));
	}
	@Then("the second robot is not moved forward west")
	public void the_second_robot_is_not_moved_forward_west() {
		assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
		assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j - 1));
	}
	
	@Given("the second robot facing south")
	public void the_second_robot_facing_south() {
	    robot2.setDirection(Direction.SOUTH);
	}
	
	@Then("the first robot does not move forward east")
	public void the_first_robot_does_not_move_forward_east() {
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
		assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	@Then("the second robot is not moved forward east")
	public void the_second_robot_is_not_moved_forward_east() {
		assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
		assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j + 1));
	}
	@Then("the first robot is moved forward east")
	public void the_first_robot_is_moved_forward_east() {
		assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	@Given("the second robot facing east")
	public void the_second_robot_facing_east() {
		robot2.setDirection(Direction.EAST);
	}
	@Given("the first robot in the edge of the board east")
	public void the_first_robot_in_the_edge_of_the_board_east() {
		robot1.seti(5);
		robot1.setj(9);
	}
	@Then("the second robot moves forward east")
	public void the_second_robot_moves_forward_east() {
		assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
		assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j + 1));
	}
	
	@Then("the first robot is moved forward south")
	public void the_first_robot_is_moved_forward_south() {
		assertFalse((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
		assertTrue ((robot1.geti() == oldRobot1i + 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Then("the first robot does not move forward south")
	public void the_first_robot_does_not_move_forward_south() {
		assertTrue ((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
		assertFalse((robot1.geti() == oldRobot1i + 1) && (robot1.getj() == oldRobot1j));
	}
	
	@Given("the first robot in the edge of the board south")
	public void the_first_robot_in_the_edge_of_the_board_south() {
		robot1.seti(12);
		robot1.setj(6);
	}
	@Then("the second robot moves forward south")
	public void the_second_robot_moves_forward_south() {
		assertFalse((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
		assertTrue ((robot2.geti() == oldRobot2i + 1) && (robot2.getj() == oldRobot2j));
	}

	@Then("the first robot is moved forward west")
	public void the_first_robot_is_moved_forward_west() {
		assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j - 1));
	}

	@Given("the first robot in the edge of the board west")
	public void the_first_robot_in_the_edge_of_the_board_west() {
		robot1.seti(3);
		robot1.setj(0);
	}
	@Then("the second robot moves forward west")
	public void the_second_robot_moves_forward_west() {
		assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
		assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j - 1));
	}
	
	@Then("the second robot is not moved forward south")
	public void the_second_robot_is_not_moved_forward_south() {
		assertTrue ((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
		assertFalse((robot2.geti() == oldRobot2i + 1) && (robot2.getj() == oldRobot2j));
	}
	
////////////////////////////////////
// ROBO RALLY : THE LIGHT VERSION //
////////////////////////////////////
	
	//////////////////////////
	// U? : SET UP THE GAME //
	//////////////////////////
	
	/////////////////////////////////////
	// U? : COMPLETE PROGRAMMING PHASE //
	/////////////////////////////////////
	
	@Then("the playing deck is empty")
	public void the_playing_deck_is_empty() {
	    assertTrue(playingDeck1.deckIsEmpty());
	}
	@Then("the second playing deck is empty")
	public void the_second_playing_deck_is_empty() {
		assertTrue(playingDeck2.deckIsEmpty());
	}
	
	////////////////////////////////////
	// U? : COMPLETE ACTIVATION PHASE //
	////////////////////////////////////
	
	@Given("a second robot that belongs to the second player")
	public void a_second_robot_that_belongs_to_the_second_player() {
		robot2 = new Robot(Color.RED);
		player2.setRobot(robot2);
	}
	@Given("a action deck of cards that belongs to the player")
	public void a_action_deck_of_cards_that_belongs_to_the_player() {
		actionDeck1 = new Deck();
		player1.setActionDeck(actionDeck1);
		actionDeck1.addCard(cardMoveForward);
		actionDeck1.addCard(cardRightTurn);
		actionDeck1.addCard(cardMoveForward);
		actionDeck1.addCard(cardMoveForward);
		actionDeck1.addCard(cardLeftTurn);
	}
	@Given("a second action deck of that belongs to the second player")
	public void a_second_action_deck_of_that_belongs_to_the_second_player() {
		actionDeck2 = new Deck();
		player2.setActionDeck(actionDeck2);
		actionDeck2.addCard(cardMoveForward);
		actionDeck2.addCard(cardMoveForward);
		actionDeck2.addCard(cardLeftTurn);
		actionDeck2.addCard(cardMoveForward);
		actionDeck2.addCard(cardRightTurn);
	}
	@Given("a discard deck of cards that belongs to the player")
	public void a_discard_deck_of_cards_that_belongs_to_the_player() {
		discardDeck1 = new Deck();
		player1.setDiscardDeck(discardDeck1);
	}
	@Given("a second discard deck of that belongs to the second player")
	public void a_second_discard_deck_of_that_belongs_to_the_second_player() {
		discardDeck2 = new Deck();
		player2.setDiscardDeck(discardDeck2);
	}
	@Given("a 5B board")
	public void a_5b_board() {
		board = new Board();
		board.initialize5B();
	}
	@When("the first card in the action deck is played")
	public void the_first_card_in_the_action_deck_is_played() {

	}
	@When("the first card in the second action deck is played")
	public void the_first_card_in_the_second_action_deck_is_played() {

	}
	@When("the obstacles are activated")
	public void the_obstacles_are_activated() {
	}
	@Then("the register is completed")
	public void the_register_is_completed() {
	    assertTrue(true);
	}
	
///////////////////////////
//          AI           //
///////////////////////////
	
	/////////////////////////////////
	// U? : CHOOSE 5 RANDOM CARDS  //
	/////////////////////////////////
	
	@Given("an AI")
	public void an_ai() {
	    AIPlayer = new AI();
	}
	
	@Given("the playing deck belongs to the AI")
	public void the_playing_deck_belongs_to_the_ai() {
	    AIPlayer.setPlayingDeck(playingDeck1);
	}
	
	@Given("the action deck belongs to the AI")
	public void the_action_deck_belongs_to_the_ai() {
	    AIPlayer.setActionDeck(actionDeck1);
	}
	
	@When("the AI picks {int} random cards from the playing deck and they are moved to the action deck")
	public void the_ai_picks_random_cards_from_the_playing_deck_and_they_are_moved_to_the_action_deck(Integer int1) {
	    AIPlayer.pickCards();
	}
	
	
}

