@tag
Feature: Move concrete cards

	@tag1
  Scenario: Succesfully moving 1 concrete card
		Given a player
    And a playing deck of cards with 9 cards
    And an action deck of cards
    When the player moves the 4 th card from the playing deck to the action deck
    Then the card is in the action deck
    And the card is not in the playing deck
  
  @tag2
  Scenario: Succesfully moving 5 concrete cards
		Given a player
    And a playing deck of cards with 9 cards
    And an action deck of cards
    When the player moves the cards 2 5 4 8 7 from the playing deck to the action deck
    Then the card is in the action deck
    And the 5 cards are not in the playing deck
   
   
  @tag3
  Scenario: Succesfully moving 1 concrete card
		Given a player
		And a second player
    And a playing deck of cards with 9 cards
    And a second playing deck of cards with 9 cards
    And an action deck of cards
    And a second action deck of cards
    When the player moves the 4 th card from the playing deck to the action deck
    And the second player moves the 4 th card from the second playing deck to the second action deck
    Then the card is in the action deck
    And the card is not in the playing deck
    And the second card is in the second action deck
    And the second card is not in the second playing deck
  
  @tag4
  Scenario: Succesfully moving 5 concrete cards
		Given a player
		And a second player
    And a playing deck of cards with 9 cards
    And a second playing deck of cards with 9 cards
    And an action deck of cards
    And a second action deck of cards
    When the player moves the cards 2 5 4 8 7 from the playing deck to the action deck
    And the second player moves the cards 2 5 4 8 7 from the second playing deck to the second action deck
    Then the 5 cards are in the action deck
    And the 5 cards are in the second action deck
    And the 5 cards are not in the playing deck
		And the 5 cards are not in the second playing deck

