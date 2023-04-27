@tag
Feature: Fill deck

  @tag1
  Scenario: Succesfully filling the deck
  	Given a programming deck of cards with less than 10 cards
  	And a non-empty discard deck of cards
    When the cards from the discard deck are moved to the programming deck
    Then the programming deck is refilled
    And the discard deck is empty