@tag
Feature: Punish player

  @tag1
  Scenario: Succesfully punishing player when robot hit by laser
    Given a board
    And a player
    And a robot on the board that belongs to the player
    And a programming deck of cards that belongs to the player
    And a laser on the tile where the robot is
    When the robot is hit by the laser
    Then a damage card is placed in the programming deck of the player

  @tag2
  Scenario: Succesfully punishing player when robot falls into a pit
  Given a board
  And a player
  And a robot on the board that belongs to the player
  And a programming deck of cards that belongs to the player
  And a pit on the tile where the robot is
  When the robot falls into the pit
  Then a damage card is placed in the programming deck of the player
  And the robot goes to the reboot cell