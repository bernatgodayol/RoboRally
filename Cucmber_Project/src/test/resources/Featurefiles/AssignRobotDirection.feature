Feature: The robot is assigned a direction

  @tag1
  Scenario: Succesfully assigning a direction to the robot
    Given a robot
    And a direction
    When the robot is assigned the direction
    Then the robot has that direction
