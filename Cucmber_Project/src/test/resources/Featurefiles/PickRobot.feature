@tag
Feature: The player picks the robot

  @tag1
  Scenario: Succesfully picking the robot
    Given a set of robots
    And a player with no robot
    When the player picks the robot
    Then the robot is assigned to the player


