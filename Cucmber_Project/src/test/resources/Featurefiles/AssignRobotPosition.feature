Feature: Therobots are placed on the board

  @tag1
  Scenario: Succesfully placing two robots on the board
    Given two robots
    And a board
    When the robots are placed on the board
    Then the robot are in the initial positions of the board
    
  @tag2
  Scenario: Succesfully placing one robots on the board
    Given a robot
    And a board
    When the robot is placed on the board
    Then the robot is in the initial position of the board
    