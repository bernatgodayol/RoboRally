import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
	Player player;
	Robot robot1;
	Robot robot2;
	Board board;
	
	@Given("a set of robots")
	public void a_set_of_robots() {
		robot1 = new Robot(RobotColor.BLUE);
	    robot2 = new Robot(RobotColor.RED);
	}
	
	@Given("a player with no robot")
	public void a_player_with_no_robot() {
	    player = new Player("Mejse");
	}
	
	@When("the player picks the robot")
	public void the_player_picks_the_robot() {
		player.setRobot(robot1);
	}
	
	@Then("the robot is assigned to the player")
	public void the_robot_is_assigned_to_the_player() {
	    assertEquals(player.getRobot().getColor(),RobotColor.BLUE);
	}
	
////////////////////

	@Given("a board")
	public void a_board() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("a player with a robot")
	public void a_player_with_a_robot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("the player picks the board")
	public void the_player_picks_the_board() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the robot of the player is assigned to the board")
	public void the_robot_of_the_player_is_assigned_to_the_board() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
///////////////////////
	
	@Given("a board with a starting position")
	public void a_board_with_a_starting_position() {
	    board = new Board();
	}
	
	@Given("a robot")
	public void a_robot() {
		robot1 = new Robot(RobotColor.BLUE);
	}
	
	@When("the game initializes")
	public void the_game_initializes() {
	    board.setStarterCell(robot1);
	    board.setBoard();
	}
	
	@Then("the robot is placed in the starting position")
	public void the_robot_is_placed_in_the_starting_position() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
/////////////////
	
	

	
}
