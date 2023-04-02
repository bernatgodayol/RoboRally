Feature: The player is assigned a deck of discard cards

  @tag1
  Scenario: Succesfully assigning a deck of discard cards to the player
    Given a player
    And a discard deck of cards
    When the player is assigned the discard deck of cards
    Then the player has that discard deck of cards