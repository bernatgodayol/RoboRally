@tag
Feature: Receive damage card

  @tag1
  Scenario: Succesfully receiving a damage card when robot hit by laser
    Given a player
    And a robot that belongs to the player
    And a programming deck of cards that belongs to the player
    And an active laser
    When the robot is hit by the laser
    Then a damage card is in the programming deck

  @tag2
  Scenario: Succesfully receiving damage when robot in reboot cell
    Given a player
    And a robot that belongs to the player
    And a programming deck of cards that belongs to the player
    And a reboot cell
    When the robot is punished by the reboot cell
    Then a damage card is in the programming deck
