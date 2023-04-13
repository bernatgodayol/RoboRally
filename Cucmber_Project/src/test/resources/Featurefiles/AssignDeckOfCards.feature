Feature: The player is assigned a deck of cards
  
  @tag1
  Scenario: Succesfully assigning a deck of cards to the player
    Given a player
    And a programming deck of cards
    When the player is assigned the deck of cards
    Then the player has that deck of cards