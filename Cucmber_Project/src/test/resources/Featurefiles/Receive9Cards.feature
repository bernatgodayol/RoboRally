
@tag
Feature: The player receives 9 random programming cards

  @tag1
  Scenario: Succesfully receiving 9 random programming cards
    Given a player
    And a programming deck of cards that belongs to the player
    And a playing deck of cards that belongs to the player
    When the 9 random cards are selected from the programming deck
    Then the cards are moved to the playing deck