
@tag
Feature: The player wants the robot to start at starting position

  @tag1
  Scenario: Succesfully placing the robot in the starting position
    Given a board with a starting position
    And a robot
    When the game initializes
    Then the robot is placed in the starting position