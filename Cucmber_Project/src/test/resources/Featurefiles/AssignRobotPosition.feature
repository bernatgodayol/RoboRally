Feature: The robot is placed on the board

  @tag1
  Scenario: Succesfully placing the robot on the board
    Given a robot
    And a position
    When the robot is placed on the board
    Then the robot is placed on the board
    