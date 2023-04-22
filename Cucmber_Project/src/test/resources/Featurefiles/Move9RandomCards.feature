
@tag
Feature: Move 9 random cards

  @tag1
  Scenario: Succesfully moving 9 random cards
  	Given a player
    And a programming deck of cards that belongs to the player
    And a playing deck of cards that belongs to the player
    When the 9 cards are moved from the programming deck to the playing deck
    Then the cards are in the playing deck
    And the cards are not in the programming deck
  
  @tag2
  Scenario: Succesfully moving 9 random cards
  	Given a player
  	And a second player
    Given a programming deck of cards that belongs to the player
    And a second programming deck of cards that belongs to the second player
    And a playing deck of cards that belongs to the player
    And a second playing deck of cards that belongs to the second player
    When the 9 cards are moved from the programming deck to the playing deck
    And the 9 cards are moved from the second programming deck to the second playing deck
    Then the cards are in the playing deck
    Then the cards are in the second playing deck
    And the cards are not in the programming deck
    And the cards are not in the second programming deck