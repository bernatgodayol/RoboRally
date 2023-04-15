@tag
Feature: Assign robot to player

  @tag1
  Scenario: Succesfully assigning the robot to the player
    Given a robot
    And a player
    When the robot is assigned to the player
    Then the robot belongs to the player

	@tag2
  Scenario: Succesfully assigning two robots to two players
    Given a robot
    And a player
    And a second robot
    And a second player
    When the robots are assigned to the players
    Then the robots belongs to the players

