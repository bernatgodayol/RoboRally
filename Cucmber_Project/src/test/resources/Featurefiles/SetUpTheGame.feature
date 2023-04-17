@tag
Feature: Set up the game

  @tag1
  Scenario: Successfully setting up the game
  Given a player
  And a second player
  And a robot
  And a second robot
  And a board
  And a programming deck of cards
  And a playing deck of cards
  And an action deck of cards
  And a discard deck of cards
  And a second programming deck of cards
  And a second playing deck of cards
  And a second action deck of cards
  And a second discard deck of cards
  When the robot is assigned to the player
  And the second robot is assigned to the second player
  And the 5B board is initialised
  And the robots are placed on the board
  And the player is assigned the programming deck of cards
  And the second player is assigned the second programming deck of cards
  And the player is assigned the playing deck of cards
  And the second player is assigned the second playing deck of cards
  And the player is assigned the action deck of cards
  And the second player is assigned the second action deck of cards
  And the player is assigned the discard deck of cards
  And the second player is assigned the second discard deck of cards
  Then the robot belongs to the player
  And the second robot belongs to the second player
  And the obstacles of the 5B board are in the expected tiles
  And the robots are in the initial positions of the board
  And the robots are facing north
  And the player has a programming deck of cards
  And the player has a playing deck of cards
  And the player has an action deck of cards
  And the player has a discard deck of cards
  And the second player has a programming deck of cards
  And the second player has a playing deck of cards
  And the second player has an action deck of cards
  And the second player has a discard deck of cards
  
  

