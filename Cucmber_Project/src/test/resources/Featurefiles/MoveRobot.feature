
@tag
Feature: 
  The robot is moved according to the programming cards

  @tag1
  Scenario: Succedfully making the robot move according to a programming card
    Given a board
    And an action deck of cards that belongs to the player
    When the first programming card is taken from the action deck of cards
    Then the robot is moved according to the programming card
    And the card is moved from the programming deck of cards to the discard deck of cards