
@tag
Feature: 
  The robot is moved according to the programming cards

  @tag1
  Scenario: Successfully making the robot move according to a programming card
    Given a board
    And an action deck of cards that belongs to the player
    When the first programming card is taken from the action deck of cards
    Then the robot is moved according to the programming card
    And the card is moved from the action deck of cards to the discard deck of cards
    
  @tag2
  Scenario: Successfully making the robot stop when it hits a wall
  	Given a board
  	And a robot facing {NORTH} in a tile with a {NORTH} wall
    When a move forward card is executed 1
    Then the robot cannot move forward
    
  @tag3
  Scenario: Successfully moving the robot to the reboot cell when it goes out of the board
  	Given a board
  	And a robot facing {SOUTH} in a tile in {12} x {int}
  	When a move forward card is executed 2
  	Then the robot is moved to the reboot cell in the board