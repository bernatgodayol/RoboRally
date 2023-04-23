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
  Then the first robot is moved forward north
  
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
 
  @tag4
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing east
  And the second robot in the tile left where the first robot is
  When the second robot moves forward
  Then the second robot moves forward east
  Then the first robot is moved forward east
  
  @tag5
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing east
  And the second robot in the tile left where the first robot is
  And a east wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot does not move forward east
  And the second robot is not moved forward east
 
  @tag6
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing east
  And the first robot in the edge of the board east
  And the second robot in the tile left where the first robot is
  When the second robot moves forward
  Then the second robot moves forward east
  And the first robot goes to the reboot cell
 
  @tag7
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing south
  And the second robot in the tile above where the first robot is
  When the second robot moves forward
  Then the second robot moves forward south
  Then the first robot is moved forward south
  
  @tag8
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing south
  And the second robot in the tile above where the first robot is
  And a south wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot does not move forward south
  And the second robot is not moved forward south
  
  @tag9
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing south
  And the first robot in the edge of the board south
  And the second robot in the tile above where the first robot is
  When the second robot moves forward
  Then the second robot moves forward south
  And the first robot goes to the reboot cell
 
  @tag10
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing west
  And the second robot in the tile right where the first robot is
  When the second robot moves forward
  Then the second robot moves forward west
  Then the first robot is moved forward west
  
  @tag11
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing west
  And the second robot in the tile right where the first robot is
  And a west wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot does not move forward west
  And the second robot is not moved forward west
  
  @tag12
  Scenario: Successfully pushing a robot
  Given a board
  And two robots on the board
  And the second robot facing west
  And the first robot in the edge of the board west
  And the second robot in the tile right where the first robot is
  When the second robot moves forward
  Then the second robot moves forward west
  And the first robot goes to the reboot cell