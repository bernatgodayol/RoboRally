@tag
Feature: AI chooses random cards from playing deck

	@tag1
  Scenario: Succesfully moving 5 random cards
		Given an AI
    And a playing deck of cards with 9 cards
    And the playing deck belongs to the AI
    And an action deck of cards
    And the action deck belongs to the AI
    When the AI picks 5 random cards from the playing deck and they are moved to the action deck
    Then the 5 cards are in the action deck
    And the 5 cards are not in the playing deck
  
