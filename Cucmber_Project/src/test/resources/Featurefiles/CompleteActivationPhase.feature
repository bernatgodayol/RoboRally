@tag
Feature: Complete activation phase

  @tag1
  Scenario: Successfully completing one register
  Given a board
  And a robot on the board facing north
  And a second robot in the tile above where the robot is
  When the robot moves forward
  And pushes the second robot
  Then the robot moves forward north
  And the second robot is moved forward north
 
  
  
	
  