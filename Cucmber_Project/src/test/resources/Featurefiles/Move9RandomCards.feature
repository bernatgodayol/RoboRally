
@tag
Feature: Move 9 random cards

  @tag1
  Scenario: Succesfully moving 9 random cards
    Given a player
    And a programming deck of cards
    And a playing deck of cards
    When the 9 cards are moved from the programming deck to the playing deck
    Then the cards are in the playing deck
    And the cards are not in the programming deck