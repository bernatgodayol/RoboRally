@tag
Feature: Complete activation phase

  @tag1
  Scenario: Successfully completing one register
  Given a player
  And a second player
  And a robot that belongs to the player
  And a second robot that belongs to the second player
  And a action deck of cards that belongs to the player
  And a second action deck of that belongs to the second player
  And a discard deck of cards that belongs to the player
  And a second discard deck of that belongs to the second player
  And a 5B board
  When the first card in the action deck is played
  And the first card in the second action deck is played
	And the obstacles are activated
	Then the register is completed # this needs to be implemented
	
  