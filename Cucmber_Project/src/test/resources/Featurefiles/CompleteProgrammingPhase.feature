@tag
Feature: Complete programming phase

  @tag1
  Scenario: Successfully completing the programming phase
  Given a player
  And a second player 
  And a programming deck of cards that belongs to the player
  And a playing deck of cards that belongs to the player
  And a action deck of cards that belongs to the player
  And a discard deck of cards that belongs to the player
  And a second programming deck of cards that belongs to the second player
  And a second playing deck of cards that belongs to the second player
  And a second action deck of that belongs to the second player
  And a second discard deck of that belongs to the second player
  When the 9 cards are moved from the programming deck to the playing deck
  And the 9 cards are moved from the second programming deck to the second playing deck
  And the player moves the cards 2 5 4 8 7 from the playing deck to the action deck
  And the second player moves the cards 6 3 2 9 1 from the second playing deck to the second action deck
  And the remaining cards are moved from the playing deck to the discard deck
  And the remaining cards are moved from the second playing deck to the second discard deck
  Then the cards are not in the programming deck
  And the cards are not in the second programming deck
  And the 5 cards are in the action deck
  And the 5 cards are in the second action deck
	And the remaining cards are in the discard deck
  And the remaining cards are in the second discard deck
  And the playing deck is empty
  And the second playing deck is empty
	
	
  