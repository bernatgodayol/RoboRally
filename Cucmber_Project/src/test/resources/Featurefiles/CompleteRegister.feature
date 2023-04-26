@tag
Feature: Complete register

	@tag1
	Scenario: Successfully completing one register
  Given a board
  And two robots on the board
  And a player
  And a second player
  And the first robot belongs to the player
  And the second robots belongs to the second player
  And a non-empty action deck of cards that belongs to the player
  And a second non-empty action deck of cards that belongs to the second player
  When the first card of the action deck of cards that belongs to the player is played
  And the second card of the action deck of cards that belongs to the second player is played
  Then the obstacles in the board activate
  And the register is completed
  
	
  