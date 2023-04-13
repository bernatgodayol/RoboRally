@tag
Feature: The player is assigned the robot

  @tag1
  Scenario: Succesfully assigning the robot to the player
    Given a robot
    And a player
    When the robot is assigned to the player
    Then the robot belongs to the player


