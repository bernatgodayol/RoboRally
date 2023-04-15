@tag
Feature: Move 1 concrete card

	@tag1
  Scenario: Succesfully moving 1 concrete card
		Given a player
    And a playing deck of cards with 9 cards
    And an action deck of cards
    When the player moves the 4th card from the playing deck to the action deck
    Then the card is in the action deck
    And the card is not in the playing deck


