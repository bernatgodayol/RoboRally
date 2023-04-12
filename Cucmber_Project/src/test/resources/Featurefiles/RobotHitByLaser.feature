@tag
Feature: Robot hit by laser

  @tag1
  Scenario: Player receiving a damage card when robot is hit by a laser
    Given a player
    And a robot belonging to the player
    And a programming deck belonging to the player
    And an active laser
    When the robot is hit by the laser the player recieves a damage card 
    Then a damage card is placed in the players programming deck

  
