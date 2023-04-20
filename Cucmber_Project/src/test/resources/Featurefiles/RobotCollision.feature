@tag
Feature: Robot collision

  @tag1
  Scenario: Successfully pushing a robot
  Given a board
  And a robot on the board facing north
  And a second robot in the tile above where the robot is
  When the robot moves forward
  Then the robot moves forward north
  And the second robot is moved forward north