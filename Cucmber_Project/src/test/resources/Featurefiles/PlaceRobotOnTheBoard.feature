Feature: Place robot on the board
    
  @tag1
  Scenario: Succesfully placing one robot on the board
    Given a robot
    And a board
    When the robot is placed on the board
    Then the robot is in the initial position of the board
    And the robot is facing north
    
  @tag2
  Scenario: Succesfully placing two robots on the board
    Given a robot
    And a second robot
    And a board
    When the two robots are placed on the board
    Then the two robots are in the initial positions of the board
    And the two robots are facing north
    
  @tag3
  Scenario: Succesfully placing two robots on the board
    Given a robot
    And a second robot
    And a third robot
    And a board
    When the three robots are placed on the board
    Then the three robots are in the initial positions of the board
    And the three robots are facing north
   
  @tag4
  Scenario: Succesfully placing two robots on the board
    Given a robot
    And a second robot
    And a third robot
    And a fourth robot
    And a board
    When the four robots are placed on the board
    Then the four robots are in the initial positions of the board
    And the four robots are facing north