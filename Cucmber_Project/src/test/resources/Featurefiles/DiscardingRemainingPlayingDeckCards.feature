
@tag
Feature: Discard remaining cards

  @tag1
  Scenario: Succesfully moving remaining cards from the playing deck to the discard deck
    Given a playing deck with 4 cards
    And a discard deck of cards
    When the cards are moved from the playing deck to the discard deck
    Then the cards are in the discard deck
    And the cards are not in the playing deck