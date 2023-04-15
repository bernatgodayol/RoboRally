Feature: Place robot on the board
    
  @tag2
  Scenario: Succesfully placing one robot on the board
    Given a robot
    And a board
    When the robot is placed on the board
    Then the robot is in the initial position of the board
    And the robot is facing north
    
  @tag1
  Scenario: Succesfully placing two robots on the board
    Given a robot
    And a second robot
    And a board
    When the robots are placed on the board
    Then the robots are in the initial positions of the board
    And the robots are facing north