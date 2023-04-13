
@tag
Feature: The remaining 4 cards in the playing deck that is not moved to the programming deck is placed in discard deck

  @tag1
  Scenario: Succesfully placing cards in discard deck
    Given a playing deck with 4 cards
    And a discard deck of cards
    And a player
    And the decks belongs to the player
    When the playing deck contains 4 cards
    Then the cards are moved from the playing deck to the discard deck
 