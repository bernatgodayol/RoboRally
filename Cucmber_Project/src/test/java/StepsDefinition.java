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
import model.Tile;
import model.UTurn;
import model.Wall;

public class StepsDefinition {
	
	Player player1;
	Player player2;
	Robot robot1;
	Robot robot2;
	Robot robot3;
	Robot robot4;
	Board board;
	Direction direction;
	Card card;
	Card extractedCard1;
	Card extractedCard2;
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
	int numCards9 = 9;
	int numCards5 = 5;
	int numCards4 = 4;
	int initialSizeProgrammingDeck1;
	int initialSizeProgrammingDeck2;
	int initialSizeActionDeck1;
	int initialSizeActionDeck2;
	int initialSizeDiscardDeck1;
	int size1;
	int size2;
	int robot1PositionX;
	int robot1PositionY;
	int oldRobot1i;
	int oldRobot1j;
	int oldRobot2i;
	int oldRobot2j;
	int oldRobot3i;
	int oldRobot3j;
	int oldRobot4i;
	int oldRobot4j;
	int int1 = 8;
	int int2 = 3;
	int int3 = 2;
	int int4 = 5;
	int int5 = 1;
	int int6 = 6;
	int int7 = 3;
	int int8 = 2;
	int int9 = 0;
	int int10 = 1;
	AI AI;
	
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
		assertEquals(player1.getRobot(), new Robot(Color.BLUE)); 
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
		assertEquals(player2.getRobot(), new Robot(Color.RED));
	}
	
    ///////////////////////////
	// U2 : INITIALIZE BOARD //
	///////////////////////////
	
	@Given("a board")
	public void a_board() {
		board = Board.getInstance();
		board.emptyBoard();
	}
	@When("the EASY board is initialised")
	public void the_easy_board_is_initialised() {
		board.initializeEASY();
	}
	@When("the MEDIUM board is initialised")
	public void the_medium_board_is_initialised() {
		board.initializeMEDIUM();
	}
	@When("the HARD board is initialised")
	public void the_hard_board_is_initialised() {
		board.initializeHARD();
	}
	@Then("the obstacles of the EASY board are in the expected tiles")
	public void the_obstacles_of_the_EASY_board_are_in_the_expected_tiles() {
	    for (int i=0; i<13; i++) {
	    	for (int j=0; j<10; j++) {
	    		if (i==3 && j==3) {
	    			assertEquals(board.getTile(i, j).getNorthBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==4 && j==3) {
	    			assertEquals(board.getTile(i, j).getSouthBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==3 && j==5) {
	    			assertEquals(board.getTile(i, j).getWestBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==3 && j==6) {
	    			assertEquals(board.getTile(i, j).getEastBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==6 && j==3) {
	    			assertEquals(board.getTile(i, j).getWestBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==6 && j==4) {
	    			assertEquals(board.getTile(i, j).getEastBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==5 && j==6) {
	    			assertEquals(board.getTile(i, j).getNorthBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==6 && j==6) {
	    			assertEquals(board.getTile(i, j).getSouthBarrier(), new Wall());
	    			assertEquals(board.getTile(i, j).getWalkableElement(), new Laser());
	    		} else if (i==11 && j==2) {
	    			assertEquals(board.getTile(i, j).getWestBarrier(), new Wall());
	    		} else if (i==10 && j==4) {
	    			assertEquals(board.getTile(i, j).getNorthBarrier(), new Wall());
	    		} else if (i==10 && j==5) {
	    			assertEquals(board.getTile(i, j).getNorthBarrier(), new Wall());
	    		} else if (i==11 && j==7) {
	    			assertEquals(board.getTile(i, j).getEastBarrier(), new Wall());
	    		} else {
	    			assertTrue(board.getTile(i, j).isEmpty());
	    		}
	    	}
	    }
	}
	
	@Then("the obstacles of the HARD board are in the expected tiles")
	public void the_obstacles_of_the_HARD_board_are_in_the_expected_tiles() {
		assertEquals(board.getTile(5, 3).getWestBarrier(), new Wall());
		assertEquals(board.getTile(3, 0).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(4, 0).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(3, 9).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(4, 9).getSouthBarrier(), new Wall());
		
		assertEquals(board.getTile(0, 6).getWestBarrier(), new Wall());
		assertEquals(board.getTile(0, 7).getEastBarrier(), new Wall());
		assertEquals(board.getTile(9, 1).getWestBarrier(), new Wall());
		assertEquals(board.getTile(9, 2).getEastBarrier(), new Wall());
		
		assertEquals(board.getTile(3, 4).getWestBarrier(), new Wall());
		assertEquals(board.getTile(3, 5).getEastBarrier(), new Wall());
		assertEquals(board.getTile(6, 4).getWestBarrier(), new Wall());
		assertEquals(board.getTile(6, 5).getEastBarrier(), new Wall());
		
		assertEquals(board.getTile(2, 2).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(3, 2).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(6, 2).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(7, 2).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(2, 7).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(3, 7).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(6, 7).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(7, 7).getSouthBarrier(), new Wall());
		
		assertEquals(board.getTile(11, 2).getWestBarrier(), new Wall());
		assertEquals(board.getTile(10, 4).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(10, 5).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(11, 7).getEastBarrier(), new Wall());
		
		
		assertEquals(board.getTile(2, 3).getWalkableElement(), new Pit());
		assertEquals(board.getTile(3, 3).getWalkableElement(), new Pit());
		assertEquals(board.getTile(6, 3).getWalkableElement(), new Pit());
		assertEquals(board.getTile(7, 3).getWalkableElement(), new Pit());
		assertEquals(board.getTile(2, 6).getWalkableElement(), new Pit());
		assertEquals(board.getTile(3, 6).getWalkableElement(), new Pit());
		assertEquals(board.getTile(6, 6).getWalkableElement(), new Pit());
		assertEquals(board.getTile(7, 6).getWalkableElement(), new Pit());
		
		for (int j=6; j<8; j++) {
			assertEquals(board.getTile(0, j).getWalkableElement(), new Laser());
		}
		for (int j=1; j<3; j++) {
			assertEquals(board.getTile(9, j).getWalkableElement(), new Laser());
		}
		for (int j=4; j<6; j++) {
			assertEquals(board.getTile(3, j).getWalkableElement(), new Laser());
		}
		for (int j=4; j<6; j++) {
			assertEquals(board.getTile(6, j).getWalkableElement(), new Laser());
		}
		for (int i=2; i<8; i++) {
			if (i!=4 && i!=5) {
				assertEquals(board.getTile(i, 2).getWalkableElement(), new Laser());
			}
		}
		for (int i=2; i<8; i++) {
			if (i!=4 && i!=5) {
				assertEquals(board.getTile(i, 7).getWalkableElement(), new Laser());
			}		
		}
		for (int i=0; i<10; i++) {
			if (i!=3 && i!=4) {
				assertTrue(board.getTile(i, 0).isEmpty());
			}
		}
		for (int i=0; i<9; i++) {
			assertTrue(board.getTile(i, 1).isEmpty());	
		}
		for (int i=0; i<10; i++) {
			if (i!=2 && i!=3 && i!=6 && i!=7 && i!=9) {
				assertTrue(board.getTile(i, 2).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=2 && i!=3 && i!=6 && i!=7 && i!=5) {
				assertTrue(board.getTile(i, 3).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=3 && i!=6 ) {
				assertTrue(board.getTile(i, 4).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=3 && i!=6 ) {
				assertTrue(board.getTile(i, 5).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=2 && i!=3 && i!=6 && i!=7 && i!=0) {
				assertTrue(board.getTile(i, 6).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=2 && i!=3 && i!=6 && i!=7 && i!=0) {
				assertTrue(board.getTile(i, 7).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			assertTrue(board.getTile(i, 8).isEmpty());
		}
		for (int i=0; i<10; i++) {
			if (i!=3 && i!=4) {
				assertTrue(board.getTile(i, 9).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=4 && i!=5) {
				assertTrue(board.getTile(10, i).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			if (i!=2 && i!=7) {
				assertTrue(board.getTile(11, i).isEmpty());
			}
		}
		for (int i=0; i<10; i++) {
			assertTrue(board.getTile(12, i).isEmpty());	
		}	
	}
	
	@Then("the obstacles of the MEDIUM board are in the expected tiles")
	public void the_obstacles_of_the_MEDIUM_board_are_in_the_expected_tiles() {
		assertEquals(board.getTile(2, 2).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(3, 2).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(2, 3).getWestBarrier(), new Wall());
		assertEquals(board.getTile(2, 4).getEastBarrier(), new Wall());
		assertEquals(board.getTile(2, 6).getWestBarrier(), new Wall());
		assertEquals(board.getTile(2, 7).getEastBarrier(), new Wall());
		assertEquals(board.getTile(3, 7).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(4, 7).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(5, 2).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(6, 2).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(7, 2).getWestBarrier(), new Wall());
		assertEquals(board.getTile(7, 3).getEastBarrier(), new Wall());
		assertEquals(board.getTile(7, 5).getWestBarrier(), new Wall());
		assertEquals(board.getTile(7, 6).getEastBarrier(), new Wall());
		assertEquals(board.getTile(7, 7).getSouthBarrier(), new Wall());
		assertEquals(board.getTile(6, 7).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(11, 2).getWestBarrier(), new Wall());
		assertEquals(board.getTile(10, 4).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(10, 5).getNorthBarrier(), new Wall());
		assertEquals(board.getTile(11, 7).getEastBarrier(), new Wall());
		assertEquals(board.getTile(1, 4).getWalkableElement(), new Pit());
		assertEquals(board.getTile(4, 8).getWalkableElement(), new Pit());
		assertEquals(board.getTile(5, 1).getWalkableElement(), new Pit());
		assertEquals(board.getTile(8, 5).getWalkableElement(), new Pit());	
		for (int i=2; i<8; i++) {
			if (i!=4) {
				assertEquals(board.getTile(i, 2).getWalkableElement(), new Laser());
			}
		}
		for (int i=2; i<8; i++) {
			if (i!=5) {
				assertEquals(board.getTile(i, 7).getWalkableElement(), new Laser());
			}		
		}
		for (int j=2; j<8; j++) {
			if (j!=5) {
				assertEquals(board.getTile(2, j).getWalkableElement(), new Laser());
			}		
		}
		for (int j=2; j<8; j++) {
			if (j!=4) {
				assertEquals(board.getTile(7, j).getWalkableElement(), new Laser());
			}		
		}
		for (int i=0; i<10; i++) {
	    	for (int j=0; j<2; j++) {
	    		if (i == 5 && j == 1) {
	                continue; 
	            }
	    		assertTrue(board.getTile(i, j).isEmpty());
	    		}
	    	}
		for (int i=0; i<10; i++) {
	    	for (int j=8; j<10; j++) {
	    		if (i == 4 && j == 8) {
	                continue; 
	            }
	    		assertTrue(board.getTile(i, j).isEmpty());
	    		}
	    	}
		for (int i=0; i<2; i++) {
	    	for (int j=2; j<8; j++) {
	    		if (i == 1 && j == 4) {
	                continue; 
	            }
	    		assertTrue(board.getTile(i, j).isEmpty());
	    		}
	    	}
		for (int i=8; i<10; i++) {
	    	for (int j=2; j<8; j++) {
	    		if (i == 8 && j == 5) {
	                continue; 
	            }
	    		assertTrue(board.getTile(i, j).isEmpty());
	    		}
	    	}
		for (int i=3; i<7; i++) {
	    	for (int j=3; j<7; j++) {
	    		assertTrue(board.getTile(i, j).isEmpty());
	    		}
	    	}
		assertTrue(board.getTile(2, 5).isEmpty());
		assertTrue(board.getTile(4, 2).isEmpty());
		assertTrue(board.getTile(5, 7).isEmpty());
		assertTrue(board.getTile(7, 4).isEmpty());
		for (int i=0; i<10; i++) {
			if (i!=4 && i!=5) {
				assertTrue(board.getTile(10, i).isEmpty());
			}
		}	
		for (int i=0; i<10; i++) {
			if (i!=2 && i!=7) {
				assertTrue(board.getTile(11, i).isEmpty());
			}
		}	
		for (int i=0; i<10; i++) {
			assertTrue(board.getTile(12, i).isEmpty());	
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
	    assertEquals(player1.getProgrammingDeck(), programmingDeck1);
	    assertTrue(player1.getProgrammingDeck().getDeckSize() == 22);
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
	    assertEquals(player1.getPlayingDeck(), playingDeck1);
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
	    assertEquals(player1.getActionDeck(), actionDeck1);
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
		assertEquals(player1.getDiscardDeck(), discardDeck1);
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
		assertEquals(player2.getProgrammingDeck(), programmingDeck2);
	    assertTrue(player2.getProgrammingDeck().getDeckSize() == 22);
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
		assertEquals(player2.getPlayingDeck(), playingDeck2);
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
		assertEquals(player2.getActionDeck(), actionDeck2);
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
		assertEquals(player2.getDiscardDeck(), discardDeck2);
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
		assertTrue(robot1.getDirection() == Direction.NORTH);
	}
	@When("the two robots are placed on the board")
	public void the_two_robots_are_placed_on_the_board() {
		board.setRobots(robot1, robot2);
	}
	@When("the three robots are placed on the board")
	public void the_three_robots_are_placed_on_the_board() {
		board.setRobots(robot1, robot2, robot3);
	}
	@When("the four robots are placed on the board")
	public void the_four_robots_are_placed_on_the_board() {
		board.setRobots(robot1, robot2, robot3, robot4);
	}
	@Then("the two robots are in the initial positions of the board")
	public void the_two_robots_are_in_the_initial_positions_of_the_board() {
		assertTrue(robot1.geti() == 12 && robot1.getj() == 3);
		assertTrue(robot2.geti() == 12 && robot2.getj() == 6);
	}
	@Given("a third robot")
	public void a_third_robot() {
	    robot3 = new Robot(Color.GREEN);
	}
	@Given("a fourth robot")
	public void a_fourth_robot() {
	    robot4 = new Robot(Color.YELLOW);
	}
	@Then("the three robots are in the initial positions of the board")
	public void the_three_robots_are_in_the_initial_positions_of_the_board() {
		assertTrue(robot1.geti() == 12 && robot1.getj() == 3);
		assertTrue(robot2.geti() == 12 && robot2.getj() == 6);
		assertTrue(robot3.geti() == 11 && robot3.getj() == 4);
	}
	@Then("the four robots are in the initial positions of the board")
	public void the_four_robots_are_in_the_initial_positions_of_the_board() {
		assertTrue(robot1.geti() == 12 && robot1.getj() == 3);
		assertTrue(robot2.geti() == 12 && robot2.getj() == 6);
		assertTrue(robot3.geti() == 11 && robot3.getj() == 4);
		assertTrue(robot4.geti() == 11 && robot4.getj() == 5);
	}
	@Then("the two robots are facing north")
	public void the_two_robots_are_facing_north() {
		assertTrue(robot1.getDirection() == Direction.NORTH);
		assertTrue(robot2.getDirection() == Direction.NORTH);
	}
	@Then("the three robots are facing north")
	public void the_three_robots_are_facing_north() {
		assertTrue(robot1.getDirection() == Direction.NORTH);
		assertTrue(robot2.getDirection() == Direction.NORTH);
		assertTrue(robot3.getDirection() == Direction.NORTH);
	}
	@Then("the four robots are facing north")
	public void the_four_robots_are_facing_north() {
		assertTrue(robot1.getDirection() == Direction.NORTH);
		assertTrue(robot2.getDirection() == Direction.NORTH);
		assertTrue(robot3.getDirection() == Direction.NORTH);
		assertTrue(robot4.getDirection() == Direction.NORTH);
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
		System.out.println("the player moves the cards {int} {int} {int} {int} {int} from the playing deck to the action deck");
		System.out.println(playingDeck1.getDeckSize());
    	System.out.println(actionDeck1.getDeckSize());
		choosenCard1 = playingDeck1.getCard(int1);
		choosenCard2 = playingDeck1.getCard(int2);
		choosenCard3 = playingDeck1.getCard(int3);
		choosenCard4 = playingDeck1.getCard(int4);
		choosenCard5 = playingDeck1.getCard(int5);
    	playingDeck1.moveCard(int1, int2, int3, int4, int5, actionDeck1);
    	System.out.println(playingDeck1.getDeckSize());
    	System.out.println(actionDeck1.getDeckSize());
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
		choosenCard6 = playingDeck2.getCard(int6);
		choosenCard7 = playingDeck2.getCard(int7);
		choosenCard8 = playingDeck2.getCard(int8);
		choosenCard9 = playingDeck2.getCard(int9);
		choosenCard10 = playingDeck2.getCard(int10);
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
	
	///////////////////////////////////
	// U8 : CHOOSE 5 RANDOM CARDS AI //
	///////////////////////////////////
	
	@Given("an AI")
	public void an_ai() {
		AI = new AI();
	}
	@Given("the playing deck belongs to the AI")
	public void the_playing_deck_belongs_to_the_ai() {
		AI.setPlayingDeck(playingDeck1);
	}
	@Given("the action deck belongs to the AI")
	public void the_action_deck_belongs_to_the_ai() {
		AI.setActionDeck(actionDeck1);
	}
	@When("the AI picks {int} random cards from the playing deck and they are moved to the action deck")
	public void the_ai_picks_random_cards_from_the_playing_deck_and_they_are_moved_to_the_action_deck(Integer int1) {
		AI.pickCards(numCards5);
	}

//////////////////////
// ACTIVATION PHASE //
//////////////////////
	
	/////////////////////
	// U9 : MOVE ROBOT //
	/////////////////////
	
	////// 9.1 MOVE FORWARD
	
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
	
	////// 9.2 HIT WALL
	
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
	@Given("an east wall in the tile where the first robot is")
	public void an_east_wall_in_the_tile_where_the_first_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setEastBarrier(new Wall());
	}
	@Then("the robot does not move forward east")
	public void the_robot_does_not_move_forward_east() {
		assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	    assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	@Given("an east wall in the tile where the robot is")
	public void an_east_wall_in_the_tile_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j).setEastBarrier(new Wall());
	}
	@Given("an east wall in the tile left where the robot is")
	public void an_east_wall_in_the_tile_left_where_the_robot_is() {
		board.getTile(oldRobot1i, oldRobot1j - 1).setEastBarrier(new Wall());
	}
	@Given("a west wall in the tile right where the robot is")
	public void a_west_wall_in_the_tile_right_where_the_robot_is() {
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

	////// 9.3 GO OUT OF THE BOARD
	
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
	
	///////////////////////
	// U10 : TURN ROBOT  //
	///////////////////////
	
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
	
	///////////////////////////
	// U11 : ROBOT COLLISION //
	///////////////////////////
	
	////// COLLISION BETWEEN 2 ROBOTS
	
	@Given("two robots on the board")
	public void two_robots_on_the_board() {
	robot1 = new Robot(Color.BLUE);
	robot2 = new Robot(Color.RED);
	board.setRobots(robot1, robot2);
	}
	@Given("the second robot facing north")
	public void the_second_robot_facing_north() {
	robot2.setDirection(Direction.NORTH);
	}
	@Given("the second robot facing east")
	public void the_second_robot_facing_east() {
	robot2.setDirection(Direction.EAST);
	}
	@Given("the second robot facing south")
	public void the_second_robot_facing_south() {
	robot2.setDirection(Direction.SOUTH);
	}
	@Given("the second robot facing west")
	public void the_second_robot_facing_west() {
	robot2.setDirection(Direction.WEST);
	}
	@Given("the first robot somewhere in the middle of the board")
	public void the_first_robot_somewhere_in_the_middle_of_the_board() {
	robot1.seti(3);
	robot1.setj(4);
	oldRobot1i = robot1.geti();
	oldRobot1j = robot1.getj();
	}
	@Given("the second robot in the tile below where the first robot is")
	public void the_second_robot_in_the_tile_below_where_the_first_robot_is() {
	robot2.seti(robot1.geti() + 1);
	robot2.setj(robot1.getj());
	oldRobot2i = robot2.geti();
	oldRobot2j = robot2.getj();
	}
	@Given("the second robot in the tile above where the first robot is")
	public void the_second_robot_in_the_tile_above_where_the_first_robot_is() {
	robot2.seti(robot1.geti() - 1);
	robot2.setj(robot1.getj());
	oldRobot2i = robot2.geti();
	oldRobot2j = robot2.getj();
	}
	@Given("the second robot in the tile right where the first robot is")
	public void the_second_robot_in_the_tile_right_where_the_first_robot_is() {
	robot2.seti(robot1.geti());
	robot2.setj(robot1.getj() + 1);
	oldRobot2i = robot2.geti();
	oldRobot2j = robot2.getj();
	}
	@Given("the second robot in the tile left where the first robot is")
	public void the_second_robot_in_the_tile_left_where_the_first_robot_is() {
	robot2.seti(robot1.geti());
	robot2.setj(robot1.getj() - 1);
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
	@Then("the second robot moves forward east")
	public void the_second_robot_moves_forward_east() {
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j + 1));
	}
	@Then("the second robot moves forward south")
	public void the_second_robot_moves_forward_south() {
	assertFalse((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
	assertTrue ((robot2.geti() == oldRobot2i + 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the second robot moves forward west")
	public void the_second_robot_moves_forward_west() {
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j - 1));
	}
	@Then("the first robot is moved forward north")
	public void the_first_robot_is_moved_forward_north() {
	assertFalse((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	assertTrue ((robot1.geti() == oldRobot1i - 1) && (robot1.getj() == oldRobot1j));
	}
	@Then("the first robot is moved forward east")
	public void the_first_robot_is_moved_forward_east() {
	assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	@Then("the first robot is moved forward south")
	public void the_first_robot_is_moved_forward_south() {
	assertFalse((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	assertTrue ((robot1.geti() == oldRobot1i + 1) && (robot1.getj() == oldRobot1j));
	}
	@Then("the first robot is moved forward west")
	public void the_first_robot_is_moved_forward_west() {
	assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j - 1));
	}
	@Given("a north wall in the tile where the first robot is")
	public void a_north_wall_in_the_tile_where_the_first_robot_is() {
	board.getTile(oldRobot1i, oldRobot1j).setNorthBarrier(new Wall());
	}
	@Given("a south wall in the tile above where the first robot is")
	public void a_south_wall_in_the_tile_above_where_the_first_robot_is() {
	board.getTile(oldRobot1i - 1, oldRobot1j).setSouthBarrier(new Wall());
	}
	@Given("a south wall in the tile where the first robot is")
	public void a_south_wall_in_the_tile_where_the_first_robot_is() {
	board.getTile(oldRobot1i, oldRobot1j).setSouthBarrier(new Wall());
	}
	@Given("a north wall in the tile below where the first robot is")
	public void a_north_wall_in_the_tile_below_where_the_first_robot_is() {
	board.getTile(oldRobot1i + 1, oldRobot1j).setNorthBarrier(new Wall());
	}
	@Given("an east wall in the tile right where the first robot is")
	public void an_east_wall_in_the_tile_right_where_the_first_robot_is() {
	board.getTile(oldRobot1i, oldRobot1j + 1).setEastBarrier(new Wall());
	}
	@Given("a west wall in the tile right where the first robot is")
	public void a_west_wall_in_the_tile_right_where_the_first_robot_is() {
	board.getTile(oldRobot1i, oldRobot1j + 1).setWestBarrier(new Wall());
	}
	@Given("a west wall in the tile where the first robot is")
	public void a_west_wall_in_the_tile_where_the_first_robot_is() {
	board.getTile(oldRobot1i, oldRobot1j).setWestBarrier(new Wall());
	}
	@Given("an east wall in the tile left where the first robot is")
	public void an_east_wall_in_the_tile_left_where_the_first_robot_is() {
	board.getTile(oldRobot1i, oldRobot1j - 1).setEastBarrier(new Wall());
	}
	@Then("the first robot is not moved forward north")
	public void the_first_robot_is_not_moved_forward_north() {
	assertTrue ((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	assertFalse((robot1.geti() == oldRobot1i - 1) && (robot1.getj() == oldRobot1j));
	}
	@Then("the first robot is not moved forward east")
	public void the_first_robot_is_not_moved_forward_east() {
	assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j + 1));
	}
	@Then("the first robot is not moved forward south")
	public void the_first_robot_is_not_moved_forward_south() {
	assertTrue ((robot1.geti() == oldRobot1i    ) && (robot1.getj() == oldRobot1j));
	assertFalse((robot1.geti() == oldRobot1i + 1) && (robot1.getj() == oldRobot1j));
	}
	@Then("the first robot is not moved forward west")
	public void the_first_robot_is_not_moved_forward_west() {
	assertTrue ((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j    ));
	assertFalse((robot1.geti() == oldRobot1i) && (robot1.getj() == oldRobot1j - 1));
	}
	@Then("the second robot does not move forward north")
	public void the_second_robot_does_not_move_forward_north() {
	assertTrue ((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
	assertFalse((robot2.geti() == oldRobot2i - 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the second robot does not move forward east")
	public void the_second_robot_does_not_move_forward_east() {
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j + 1));
	}
	@Then("the second robot does not move forward south")
	public void the_second_robot_does_not_move_forward_south() {
	assertTrue ((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
	assertFalse((robot2.geti() == oldRobot2i + 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the second robot does not move forward west")
	public void the_second_robot_does_not_move_forward_west() {
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j - 1));
	}
	@Given("the first robot in the edge of the board north")
	public void the_first_robot_in_the_edge_of_the_board_north() {
	robot1.seti(0);
	robot1.setj(3);
	oldRobot1i = robot1.geti();
	oldRobot1j = robot1.getj();
	}
	@Given("the first robot in the edge of the board east")
	public void the_first_robot_in_the_edge_of_the_board_east() {
	robot1.seti(3);
	robot1.setj(9);
	oldRobot1i = robot1.geti();
	oldRobot1j = robot1.getj();
	}
	@Given("the first robot in the edge of the board south")
	public void the_first_robot_in_the_edge_of_the_board_south() {
	robot1.seti(12);
	robot1.setj(3);
	oldRobot1i = robot1.geti();
	oldRobot1j = robot1.getj();
	}
	@Given("the first robot in the edge of the board west")
	public void the_first_robot_in_the_edge_of_the_board_west() {
	robot1.seti(3);
	robot1.setj(0);
	oldRobot1i = robot1.geti();
	oldRobot1j = robot1.getj();
	}
	@Then("the first robot goes to the reboot cell")
	public void the_first_robot_goes_to_the_reboot_cell() {
	assertTrue ((robot1.geti() == board.getRebooti()) && (robot1.getj() == board.getRebootj()));
	assertFalse((robot1.geti() == oldRobot1i        ) && (robot1.getj() == oldRobot1j));
	}
	@Then("the second robot is not moved forward north")
	public void the_second_robot_is_not_moved_forward_north() {
	assertTrue ((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot1j));
	assertFalse((robot2.geti() == oldRobot2i - 1) && (robot2.getj() == oldRobot1j));
	}
	@Then("the second robot is not moved forward east")
	public void the_second_robot_is_not_moved_forward_east() {
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j + 1));
	}
	@Then("the second robot is not moved forward south")
	public void the_second_robot_is_not_moved_forward_south() {
	assertTrue ((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
	assertFalse((robot2.geti() == oldRobot2i + 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the second robot is not moved forward west")
	public void the_second_robot_is_not_moved_forward_west() {
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j - 1));
	}
	////// COLLISION BETWEEN 3 ROBOTS
	
	@Given("three robots on the board")
	public void three_robots_on_the_board() {
	robot1 = new Robot(Color.BLUE);
	robot2 = new Robot(Color.RED);
	robot3 = new Robot(Color.GREEN);
	board.setRobots(robot1, robot2, robot3);
	}
	@Given("the third robot facing north")
	public void the_third_robot_facing_north() {
	robot3.setDirection(Direction.NORTH);
	}
	@Given("the third robot facing east")
	public void the_third_robot_facing_east() {
	robot3.setDirection(Direction.EAST);
	}
	@Given("the third robot facing south")
	public void the_third_robot_facing_south() {
	robot3.setDirection(Direction.SOUTH);
	}
	@Given("the third robot facing west")
	public void the_third_robot_facing_west() {
	robot3.setDirection(Direction.WEST);
	}
	@Given("the third robot in the tile below where the second robot is")
	public void the_third_robot_in_the_tile_below_where_the_second_robot_is() {
	robot3.seti(robot2.geti() + 1);
	robot3.setj(robot2.getj());
	oldRobot3i = robot3.geti();
	oldRobot3j = robot3.getj();
	}
	@Given("the third robot in the tile above where the second robot is")
	public void the_third_robot_in_the_tile_above_where_the_second_robot_is() {
	robot3.seti(robot2.geti() - 1);
	robot3.setj(robot2.getj());
	oldRobot3i = robot3.geti();
	oldRobot3j = robot3.getj();
	}
	@Given("the third robot in the tile right where the second robot is")
	public void the_third_robot_in_the_tile_right_where_the_second_robot_is() {
	robot3.seti(robot2.geti());
	robot3.setj(robot2.getj() + 1);
	oldRobot3i = robot3.geti();
	oldRobot3j = robot3.getj();
	}
	@Given("the third robot in the tile left where the second robot is")
	public void the_third_robot_in_the_tile_left_where_the_second_robot_is() {
	robot3.seti(robot2.geti());
	robot3.setj(robot2.getj() - 1);
	oldRobot3i = robot3.geti();
	oldRobot3j = robot3.getj();
	}
	@When("the third robot moves forward")
	public void the_third_robot_moves_forward() {
	cardMoveForward = new MoveForward();
	cardMoveForward.execute(robot3, board);
	}
	@Then("the third robot moves forward north")
	public void the_third_robot_moves_forward_north() {
	assertFalse((robot3.geti() == oldRobot3i    ) && (robot3.getj() == oldRobot3j));
	assertTrue ((robot3.geti() == oldRobot3i - 1) && (robot3.getj() == oldRobot3j));
	}
	@Then("the third robot moves forward east")
	public void the_third_robot_moves_forward_east() {
	assertFalse((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j    ));
	assertTrue ((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j + 1));
	}
	@Then("the third robot moves forward south")
	public void the_third_robot_moves_forward_south() {
	assertFalse((robot3.geti() == oldRobot3i    ) && (robot3.getj() == oldRobot3j));
	assertTrue ((robot3.geti() == oldRobot3i + 1) && (robot3.getj() == oldRobot3j));
	}
	@Then("the third robot moves forward west")
	public void the_third_robot_moves_forward_west() {
	assertFalse((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j    ));
	assertTrue ((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j - 1));
	}
	@Then("the second robot is moved forward north")
	public void the_second_robot_is_moved_forward_north() {
	assertFalse((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
	assertTrue ((robot2.geti() == oldRobot2i - 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the second robot is moved forward east")
	public void the_second_robot_is_moved_forward_east() {
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j + 1));
	}
	@Then("the second robot is moved forward south")
	public void the_second_robot_is_moved_forward_south() {
	assertFalse((robot2.geti() == oldRobot2i    ) && (robot2.getj() == oldRobot2j));
	assertTrue ((robot2.geti() == oldRobot2i + 1) && (robot2.getj() == oldRobot2j));
	}
	@Then("the second robot is moved forward west")
	public void the_second_robot_is_moved_forward_west() {
	assertFalse((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j    ));
	assertTrue ((robot2.geti() == oldRobot2i) && (robot2.getj() == oldRobot2j - 1));
	}
	@Then("the third robot does not move forward north")
	public void the_third_robot_does_not_move_forward_north() {
	assertTrue ((robot3.geti() == oldRobot3i    ) && (robot3.getj() == oldRobot3j));
	assertFalse((robot3.geti() == oldRobot3i - 1) && (robot3.getj() == oldRobot3j));
	}
	@Then("the third robot does not move forward east")
	public void the_third_robot_does_not_move_forward_east() {
	assertTrue ((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j    ));
	assertFalse((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j + 1));
	}
	@Then("the third robot does not move forward south")
	public void the_third_robot_does_not_move_forward_south() {
	assertTrue ((robot3.geti() == oldRobot3i    ) && (robot3.getj() == oldRobot3j));
	assertFalse((robot3.geti() == oldRobot3i + 1) && (robot3.getj() == oldRobot3j));
	}
	@Then("the third robot does not move forward west")
	public void the_third_robot_does_not_move_forward_west() {
	assertTrue ((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j    ));
	assertFalse((robot3.geti() == oldRobot3i) && (robot3.getj() == oldRobot3j - 1));
	}
	
	////////////////////////////
	// U12 : PENALISED PLAYER //
	////////////////////////////
	
	////// 12.1 WHEN HIT BY LASER
	
	@Given("a robot on the board that belongs to the player")
	public void a_robot_on_the_board_that_belongs_to_the_player() {
	    robot1 = new Robot(Color.BLUE);
	    player1.setRobot(robot1);
	    board.setRobots(robot1);
	    oldRobot1i = robot1.geti();
		oldRobot1j = robot1.getj();
	}
	@Given("a laser on the tile where the robot is")
	public void a_laser_on_the_tile_where_the_robot_is() {
	    board.getTile(robot1.geti(), robot1.getj()).setWalkableElement(new Laser());
	}
	@When("the robot is hit by the laser")
	public void the_robot_is_hit_by_the_laser() {
		board.getTile(robot1.geti(), robot1.getj()).getWalkableElement().action(robot1, board);
	}
	@Then("a damage card is placed in the programming deck of the player")
	public void a_damage_card_is_placed_in_the_programming_deck_of_the_player() {
	    assertTrue(programmingDeck1.getDeckSize() == initialSizeProgrammingDeck1 + 1);
	    assertTrue(programmingDeck1.contains(new Damage()));
	}

	////// 12.2 WHEN FALL INTO A PIT
	

	@Given("a pit on the tile where the robot is")
	public void a_pit_on_the_tile_where_the_robot_is() {
		board.getTile(robot1.geti(), robot1.getj()).setWalkableElement(new Pit());
	}
	@When("the robot falls into the pit")
	public void the_robot_falls_into_the_pit() {
		board.getTile(robot1.geti(), robot1.getj()).getWalkableElement().action(robot1, board);
	}
	
	/////////////////
	// REFILL DECK //
	/////////////////
	
	@Given("a programming deck of cards with less than {int} cards")
	public void a_programming_deck_of_cards_with_less_than_cards(Integer int1) {
	    programmingDeck1 = new Deck();
	    initialSizeProgrammingDeck1 = programmingDeck1.getDeckSize();
	}
	@Given("a non-empty discard deck of cards")
	public void a_non_empty_discard_deck_of_cards() {
	    discardDeck1 = new Deck();
	    for (int i=0; i<20; i++) {
	    	discardDeck1.addCard(new RightTurn());
	    }
	    initialSizeDiscardDeck1 = discardDeck1.getDeckSize();
	}
	@When("the cards from the discard deck are moved to the programming deck")
	public void the_cards_from_the_discard_deck_are_moved_to_the_programming_deck() {
	    programmingDeck1.refillDeck(discardDeck1);
	}
	@Then("the programming deck is refilled")
	public void the_programming_deck_is_refilled() {
	    assertTrue(programmingDeck1.getDeckSize() == initialSizeDiscardDeck1 + initialSizeProgrammingDeck1);
	}
	@Then("the discard deck is empty")
	public void the_discard_deck_is_empty() {
	    assertTrue(discardDeck1.deckIsEmpty());
	}
	
////////////////////////////////////
// ROBO RALLY : THE LIGHT VERSION //
////////////////////////////////////
	
	/////////////////////
	// SET UP THE GAME //
	/////////////////////
	
	////////////////////////////////
	// COMPLETE PROGRAMMING PHASE //
	////////////////////////////////
	
	@Given("an action deck of cards that belongs to the player")
	public void an_action_deck_of_cards_that_belongs_to_the_player() {
		actionDeck1 = new Deck();
		player1.setActionDeck(actionDeck1);
	}
	@Given("a second action deck of cards that belongs to the second player")
	public void a_second_action_deck_of_cards_that_belongs_to_the_second_player() {
		actionDeck2 = new Deck();
		player2.setActionDeck(actionDeck2);
	}
	@Given("a discard deck of cards that belongs to the player")
	public void a_discard_deck_of_cards_that_belongs_to_the_player() {
		discardDeck1 = new Deck();
		player1.setDiscardDeck(discardDeck1);
	}
	
	@Given("a second discard deck of cards that belongs to the second player")
	public void a_second_discard_deck_of_cards_that_belongs_to_the_second_player() {
		discardDeck2 = new Deck();
		player2.setDiscardDeck(discardDeck2);
	}
	@Then("the playing deck is empty")
	public void the_playing_deck_is_empty() {
	    assertTrue(playingDeck1.deckIsEmpty());
	}
	@Then("the second playing deck is empty")
	public void the_second_playing_deck_is_empty() {
		assertTrue(playingDeck2.deckIsEmpty());
	}
	
	///////////////////////////////
	// COMPLETE ACTIVATION PHASE //
	///////////////////////////////
	
	@Given("the first robot belongs to the player")
	public void the_first_robot_belongs_to_the_player() {
	    player1.setRobot(robot1);
	}
	@Given("the second robots belongs to the second player")
	public void the_second_robots_belongs_to_the_second_player() {
		player2.setRobot(robot2);
	}
	@Given("a non-empty action deck of cards that belongs to the player")
	public void a_non_empty_action_deck_of_cards_that_belongs_to_the_player() {
		actionDeck1 = new Deck();
		actionDeck1.addCard(new MoveForward());
		actionDeck1.addCard(new RightTurn());
		actionDeck1.addCard(new MoveForward());
		actionDeck1.addCard(new MoveForward());
		actionDeck1.addCard(new LeftTurn());
		player1.setActionDeck(actionDeck1);
		initialSizeActionDeck1 = actionDeck1.getDeckSize();
	}
	@Given("a second non-empty action deck of cards that belongs to the second player")
	public void a_second_non_empty_action_deck_of_cards_that_belongs_to_the_second_player() {
		actionDeck2 = new Deck();
		actionDeck2.addCard(new UTurn());
		actionDeck2.addCard(new RightTurn());
		actionDeck2.addCard(new MoveForward());
		actionDeck2.addCard(new MoveForward());
		actionDeck2.addCard(new MoveForward());
		player2.setActionDeck(actionDeck2);
		initialSizeActionDeck2 = actionDeck2.getDeckSize();
	}
	@When("the first card of the action deck of cards that belongs to the player is played")
	public void the_first_card_of_the_action_deck_of_cards_that_belongs_to_the_player_is_played() {
	   extractedCard1 = actionDeck1.extractCard(0);
	   extractedCard1.execute(robot1, board);
	}
	@When("the second card of the action deck of cards that belongs to the second player is played")
	public void the_second_card_of_the_action_deck_of_cards_that_belongs_to_the_second_player_is_played() {
		extractedCard2 = actionDeck2.extractCard(0);
		extractedCard2.execute(robot2, board);
	}
	@Then("the obstacles in the board activate")
	public void the_obstacles_in_the_board_activate() {
		if (!(board.getTile(robot1.geti(), robot1.getj()).getWalkableElement() == null)) {
			board.getTile(robot1.geti(), robot1.getj()).getWalkableElement().action(robot1, board);
		}
		if (!(board.getTile(robot2.geti(), robot2.getj()).getWalkableElement() == null)) {
			board.getTile(robot2.geti(), robot2.getj()).getWalkableElement().action(robot2, board);
		}
	}
	@Then("the register is completed")
	public void the_register_is_completed() {
	    assertTrue(actionDeck1.getDeckSize() == initialSizeActionDeck1 - 1);
	    assertTrue(actionDeck2.getDeckSize() == initialSizeActionDeck2 - 1);
	}
	
}

