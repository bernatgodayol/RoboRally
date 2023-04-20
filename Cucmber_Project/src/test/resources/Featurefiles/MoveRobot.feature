@tag
Feature: Move robot

  @tag1
  Scenario: Successfully moving the robot forward
    Given a board
    And a robot on the board facing north
    And a move forward card
    When the move forward card is executed
    Then the robot moves forward north
   
  @tag2
  Scenario: Successfully moving the robot forward
    Given a board
    And a robot on the board facing south
    And a move forward card
    When the move forward card is executed
    Then the robot moves forward south
    
  @tag3
  Scenario: Successfully moving the robot forward
    Given a board
    And a robot on the board facing east
    And a move forward card
    When the move forward card is executed
    Then the robot moves forward east
    
  @tag4
  Scenario: Successfully moving the robot forward
    Given a board
    And a robot on the board facing west
    And a move forward card
    When the move forward card is executed
    Then the robot moves forward west
  
  @tag5
  Scenario: Successfully making the robot stop when it hits a north wall
    Given a board
    And a robot on the board facing north
    And a north wall in the tile where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward north
  
  @tag6
  Scenario: Successfully making the robot stop when it hits a north wall
    Given a board
    And a robot on the board facing south
    And a north wall in the tile below where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward south
   
  @tag7
  Scenario: Successfully making the robot stop when it hits a south wall
    Given a board
    And a robot on the board facing south
    And a south wall in the tile where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward south
    
  @tag8
  Scenario: Successfully making the robot stop when it hits a south wall
    Given a board
    And a robot on the board facing north
    And a south wall in the tile above where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward north
    
  @tag9
  Scenario: Successfully making the robot stop when it hits a east wall
    Given a board
    And a robot on the board facing east
    And a east wall in the tile where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward east
    
  @tag10
  Scenario: Successfully making the robot stop when it hits a east wall
    Given a board
    And a robot on the board facing west
    And a east wall in the tile next right where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward west
    
  @tag11
  Scenario: Successfully making the robot stop when it hits a west wall
    Given a board
    And a robot on the board facing west
    And a west wall in the tile where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward west
    
  @tag12
  Scenario: Successfully making the robot stop when it hits a west wall
    Given a board
    And a robot on the board facing east
    And a west wall in the tile next left where the robot is
    And a move forward card
    When the move forward card is executed
    Then the robot does not move forward east
    
  @tag13
  Scenario: Successfully making the robot move to the reboot cell when it goes out of the board
    Given a board
    And a robot on the edge of board facing north
    And a move forward card
    When the move forward card is executed
    Then the robot goes to the reboot cell
    
  @tag14
  Scenario: Successfully making the robot move to the reboot cell when it goes out of the board
    Given a board
    And a robot on the edge of board facing south
    And a move forward card
    When the move forward card is executed
    Then the robot goes to the reboot cell
   
  @tag15
  Scenario: Successfully making the robot move to the reboot cell when it goes out of the board
    Given a board
    And a robot on the edge of board facing east
    And a move forward card
    When the move forward card is executed
    Then the robot goes to the reboot cell
   
  @tag16
  Scenario: Successfully making the robot move to the reboot cell when it goes out of the board
    Given a board
    And a robot on the edge of board facing west
    And a move forward card
    When the move forward card is executed
    Then the robot goes to the reboot cell
    
  @tag17
  Scenario: Successfully making the robot move to the reboot cell when it falls into a pit
    Given a board
    And a robot facing west whcih is next to a pit 
    And a move forward card
    When the move forward card is executed
    Then the robot goes to the reboot cell
    
  
  