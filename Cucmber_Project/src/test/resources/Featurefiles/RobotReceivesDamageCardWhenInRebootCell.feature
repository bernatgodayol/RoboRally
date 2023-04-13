@tag
Feature: Robot receives damage card when in the reboot cell

  @tag1
  Scenario: Succesfully giving damage card to robot in reboot cell
    Given a board
    And a player
    And a robot that belongs to the player
    And a reboot cell
    And the robot is in the reboot cell
    And a programming deck that belongs to the player
    When the player receives a damage card
    Then that damage card is in the players programming deck