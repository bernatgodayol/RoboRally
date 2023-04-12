Feature: The robot is placed on the board

  @tag1
  Scenario: Succesfully placing the robot on the board
    Given a robot
    And a position
    And a board
    When the robot is placed on the board
    Then the robot is in the correct tile on the board
    