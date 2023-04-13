
@tag
Feature: The robot is moved according to the programming cards

  @tag1
  Scenario: Successfully making the robot move according to a programming card
    Given a board
    And a player
    And a robot
    And an action deck of cards that belongs to the player
    And a discard deck of cards
    And a robot in the cell with xcoordinate 2 and ycoordinate 3 with direction north
    When an action card is played
    Then the card is moved from the action deck of cards to the discard deck of cards
    And the robot is moved according to the programming card
    
  @tag2
  Scenario: Successfully making the robot stop when it hits a wall
  	Given a board
  	And a robot
  	And a robot direction where it faces north in a tile with a north wall
    When a move forward card is executed
    Then the robot cannot move forward
    
  @tag3
  Scenario: Successfully moving the robot to the reboot cell when it goes out of the board
  	Given a board
  	And a robot
  	And a robot facing south in a tile with xcoodinate 12 and ycoordinate 4
  	When a move forward card is executed
  	Then the robot is moved to the reboot cell in the board