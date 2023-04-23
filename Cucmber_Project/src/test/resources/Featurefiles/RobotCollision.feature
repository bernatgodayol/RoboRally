@tag
Feature: Robot collision

  @tag1
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing north in the tile below where the first robot is
  When the second robot moves forward
  Then the second robot moves forward north
  Then the first robot is moved forward north
  
  @tag2
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And a north wall in the tile where the first robot is
  And the second robot facing north in the tile below where the first robot is
  When the second robot moves forward
  Then the second robot does not move forward north
  And the first robot does not move forward north

  
  # @tag2
  # Scenario: Successfully pushing a robot
  # Given a board
  # And a robot on the board facing north
  # And a second robot in the tile above where the robot is
  # And a third robot in the tile above where the second robot is
  # When the robot moves forward
  # Then the robot moves forward north
  # And the second robot is moved forward north
  # And the third robot is moved forward north
  
  # @tag3
  # Scenario: Successfully pushing a robot
  # Given a board
  # And a robot on the board facing north
  # And a second robot in the tile above where the robot is
  # And a third robot in the tile above where the second robot is
  # And a fourth robot in the tile above where the third robot is
  # When the robot moves forward
  # Then the robot moves forward north
  # And the second robot is moved forward north
  # And the third robot is moved forward north
  # And the fourth robot is moved forward north