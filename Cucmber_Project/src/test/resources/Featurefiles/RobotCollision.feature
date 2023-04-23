@tag
Feature: Robot collision

  @tag1
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing north
  And the second robot in the tile below where the first robot is
  When the second robot moves forward
  Then the second robot moves forward north
  And the first robot is moved forward north
  
  @tag2
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing north
  And the second robot in the tile below where the first robot is
  And a north wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot does not move forward north
  And the second robot is not moved forward north
  
  @tag3
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing north
  And the first robot in the edge of the board north
  And the second robot in the tile below where the first robot is
  When the second robot moves forward
  Then the second robot moves forward north
  And the first robot goes to the reboot cell