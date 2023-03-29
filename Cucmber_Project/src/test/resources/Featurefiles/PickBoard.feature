@tag
Feature: The player picks the board

  @tag1
  Scenario: Succesfully picking the board
    Given a board
    And a player with a robot
    When the player picks the board
    Then the robot of the player is assigned to the board
