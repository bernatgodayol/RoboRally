@tag
Feature: Discard remaining cards

  @tag1
  Scenario: Succesfully moving remaining cards from the playing deck to the discard deck
    Given a playing deck with 4 cards
    And a discard deck of cards
    When the remaining cards are moved from the playing deck to the discard deck
    Then the remaining cards are in the discard deck
    And the remaining cards are not in the playing deck
  
  @tag2
  Scenario: Succesfully moving remaining cards from the playing deck to the discard deck
    Given a playing deck with 4 cards
    And a second playing deck with 4 cards
    And a discard deck of cards
    And a second discard deck of cards
    When the remaining cards are moved from the playing deck to the discard deck
    And the remaining cards are moved from the second playing deck to the second discard deck
    Then the remaining cards are in the discard deck
    And the remaining cards are not in the playing deck
    And the remaining cards are in the second discard deck
    And the remaining cards are not in the second playing deck