@tag
Feature: Turn robot

  @tag1
  Scenario: Successfully U turning the robot
    Given a board
    And a robot on the board facing north
    And a UTurn card
    When the UTurn card is executed
    Then the robot is facing south
   
  @tag2
  Scenario: Successfully U turning the robot
    Given a board
    And a robot on the board facing south
    And a UTurn card
    When the UTurn card is executed
    Then the robot is facing south
    
  @tag3
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing north
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing east
  
  @tag4
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing east
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing south
    
  @tag5
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing south
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing west
  
  @tag6
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing west
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing north
    
   @tag3
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing north
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing east
  
  @tag4
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing east
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing south
    
  @tag5
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing south
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing west
  
  @tag6
  Scenario: Successfully right turning the robot
    Given a board
    And a robot on the board facing west
    And a RightTurn card
    When the RightTurn card is executed
    Then the robot is facing north
   