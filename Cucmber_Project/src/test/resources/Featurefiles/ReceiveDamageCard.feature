@tag
Feature: Receive damage card

  @tag1
  Scenario: Succesfully receiving a damage card when robot hit by laser
    Given a board
    And a laser
    And a player
    And a programming deck of cards that belongs to the player
    And a robot that belongs to the player
    When the robot is hit by the laser
    Then a damage card is in the programming deck

  @tag2
  Scenario: Succesfully receiving damage when robot falls in a pit
  Given a board
  And a pit
  And a player
  And a programming deck of cards that belongs to the player
  And a robot on the board that belongs to a player
  When a pit is in the same tile as the robot
  Then a damage card is in the programming deck
 