
@tag
Feature: The remaining 4 cards in the playing deck that is not moved to the programming deck is placed in discard deck

  @tag1
  Scenario: Succesfully placing cards in discard deck
    Given a playing deck with 4 cards
    And a discard deck of cards
    When the remaining cards in the playing deck is discarded
    Then the cards are moved to the discard deck