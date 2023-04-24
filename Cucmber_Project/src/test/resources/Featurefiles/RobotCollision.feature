@tag
Feature: Robot collision
	
	# 2 robots north push
	
  @tag1
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing north
  And the first robot somewhere in the middle of the board
  And the second robot in the tile below where the first robot is
  When the second robot moves forward
  Then the second robot moves forward north
  Then the first robot is moved forward north
  
  @tag2
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing north
  And the first robot somewhere in the middle of the board
  And the second robot in the tile below where the first robot is
  And a north wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward north
  And the second robot does not move forward north
  
  @tag3
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing north
  And the first robot somewhere in the middle of the board
  And the second robot in the tile below where the first robot is
  And a south wall in the tile above where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward north
  And the second robot does not move forward north
  
  @tag4
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing north
  And the first robot in the edge of the board north
  And the second robot in the tile below where the first robot is
  When the second robot moves forward
  Then the second robot moves forward north
  And the first robot goes to the reboot cell
 
 	# 2 robots east push
 	
  @tag5
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing east
  And the first robot somewhere in the middle of the board
  And the second robot in the tile left where the first robot is
  When the second robot moves forward
  Then the second robot moves forward east
  And the first robot is moved forward east
  
  @tag6
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing east
  And the first robot somewhere in the middle of the board
  And the second robot in the tile left where the first robot is
  And an east wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward east
  And the second robot does not move forward east
  
  @tag7
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing east
  And the first robot somewhere in the middle of the board
  And the second robot in the tile left where the first robot is
  And a west wall in the tile right where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward east
  And the second robot does not move forward east
 
  @tag8
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing east
  And the first robot in the edge of the board east
  And the second robot in the tile left where the first robot is
  When the second robot moves forward
  Then the second robot moves forward east
  And the first robot goes to the reboot cell
 	
 	# two robots south push
 	
  @tag9
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing south
  And the first robot somewhere in the middle of the board
  And the second robot in the tile above where the first robot is
  When the second robot moves forward
  Then the second robot moves forward south
  Then the first robot is moved forward south
  
  @tag10
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing south
  And the first robot somewhere in the middle of the board
  And the second robot in the tile above where the first robot is
  And a south wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward south
  And the second robot does not move forward south
  
  @tag11
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing south
  And the first robot somewhere in the middle of the board
  And the second robot in the tile above where the first robot is
  And a north wall in the tile below where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward south
  And the second robot does not move forward south
  
  @tag12
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing south
  And the first robot in the edge of the board south
  And the second robot in the tile above where the first robot is
  When the second robot moves forward
  Then the second robot moves forward south
  And the first robot goes to the reboot cell
 	
 	# two robots west push
 	
  @tag13
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing west
  And the first robot somewhere in the middle of the board
  And the second robot in the tile right where the first robot is
  When the second robot moves forward
  Then the second robot moves forward west
  Then the first robot is moved forward west
  
  @tag14
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing west
  And the first robot somewhere in the middle of the board
  And the second robot in the tile right where the first robot is
  And a west wall in the tile where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward west
  And the second robot does not move forward west
  
  @tag15
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the first robot somewhere in the middle of the board
  And the second robot facing west
  And the second robot in the tile right where the first robot is
  And an east wall in the tile left where the first robot is
  When the second robot moves forward
  Then the first robot is not moved forward west
  And the second robot does not move forward west
  
  @tag16
  Scenario: Successfully pushing a robot (collision between 2 robots)
  Given a board
  And two robots on the board
  And the second robot facing west
  And the first robot in the edge of the board west
  And the second robot in the tile right where the first robot is
  When the second robot moves forward
  Then the second robot moves forward west
  And the first robot goes to the reboot cell 
  
  # three robots north push
	
  @tag1
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing north
  And the first robot somewhere in the middle of the board
  And the second robot in the tile below where the first robot is
  And the third robot in the tile below where the second robot is
  When the third robot moves forward
  Then the third robot moves forward north
  And the second robot is moved forward north
  And the first robot is moved forward north
  
  @tag2
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing north
  And the first robot somewhere in the middle of the board
  And the second robot in the tile below where the first robot is
  And the third robot in the tile below where the second robot is
  And a north wall in the tile where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward north
  And the second robot is not moved forward north
  And the first robot is not moved forward north
  
  @tag3
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing north
  And the first robot somewhere in the middle of the board
  And the second robot in the tile below where the first robot is
  And the third robot in the tile below where the second robot is
  And a south wall in the tile above where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward north
  And the second robot is not moved forward north
  And the first robot is not moved forward north
  
  @tag4
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing north
  And the first robot in the edge of the board north
  And the second robot in the tile below where the first robot is
  And the third robot in the tile below where the second robot is
  When the third robot moves forward
  Then the third robot moves forward north
  And the second robot is moved forward north
  And the first robot goes to the reboot cell
 
 	# three robots east push
 	
  @tag5
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing east
  And the first robot somewhere in the middle of the board
  And the second robot in the tile left where the first robot is
  And the third robot in the tile left where the second robot is
  When the third robot moves forward
  Then the third robot moves forward east
  And the second robot is moved forward east
  And the first robot is moved forward east
  
  @tag6
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing east
  And the first robot somewhere in the middle of the board
  And the second robot in the tile left where the first robot is
  And the third robot in the tile left where the second robot is
  And an east wall in the tile where the first robot is
  When the third robot moves forward
  Then the first robot is not moved forward east
  And the second robot is not moved forward east
  And the third robot does not move forward east
  
  @tag7
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing east
  And the first robot somewhere in the middle of the board
  And the second robot in the tile left where the first robot is
  And the third robot in the tile left where the second robot is
  And a west wall in the tile right where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward east
  And the second robot is not moved forward east
  And the first robot is not moved forward east
 
  @tag8
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing east
  And the first robot in the edge of the board east
  And the second robot in the tile left where the first robot is
  And the third robot in the tile left where the second robot is
  When the third robot moves forward
  Then the third robot moves forward east
  And the second robot moves forward east
  And the first robot goes to the reboot cell
 	
 	# 2 robots south push
 	
  @tag9
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing south
  And the first robot somewhere in the middle of the board
  And the second robot in the tile above where the first robot is
  And the third robot in the tile above where the second robot is
  When the third robot moves forward
  Then the third robot moves forward south
  And the second robot is moved forward south
  And the first robot is moved forward south
  
  @tag10
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing south
  And the first robot somewhere in the middle of the board
  And the second robot in the tile above where the first robot is
  And the third robot in the tile above where the second robot is
  And a south wall in the tile where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward south
  And the second robot is not moved forward south
  And the first robot is not moved forward south
  
  @tag11
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing south
  And the first robot somewhere in the middle of the board
  And the second robot in the tile above where the first robot is
  And the third robot in the tile above where the second robot is
  And a north wall in the tile below where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward south
  And the second robot is not moved forward south
  And the first robot is not moved forward south
  
  @tag12
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing south
  And the first robot in the edge of the board south
  And the second robot in the tile above where the first robot is
  And the third robot in the tile above where the second robot is
   When the third robot moves forward
  Then the third robot moves forward south
  And the second robot moves forward south
  And the first robot goes to the reboot cell
 	
 	# 2 robots west push
 	
  @tag13
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing west
  And the first robot somewhere in the middle of the board
  And the second robot in the tile right where the first robot is
  And the third robot in the tile right where the second robot is
  When the third robot moves forward
  Then the third robot moves forward west
  And the second robot is moved forward west
  And the first robot is moved forward west
  
  @tag14
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing west
  And the first robot somewhere in the middle of the board
  And the second robot in the tile right where the first robot is
  And the third robot in the tile right where the second robot is
  And a west wall in the tile where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward west
  And the second robot is not moved forward west
  And the first robot is not moved forward west
  
  @tag15
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the first robot somewhere in the middle of the board
  And the third robot facing west
  And the second robot in the tile right where the first robot is
  And the third robot in the tile right where the second robot is
  And an east wall in the tile right where the first robot is
  When the third robot moves forward
  Then the third robot does not move forward west
  And the second robot is not moved forward west
  And the first robot is not moved forward west
  
  @tag16
  Scenario: Successfully pushing a robot (collision between 3 robots)
  Given a board
  And three robots on the board
  And the third robot facing west
  And the first robot in the edge of the board west
  And the second robot in the tile right where the first robot is
  And the third robot in the tile right where the second robot is
  When the third robot moves forward
  Then the third robot moves forward west
  And the second robot moves forward west
  And the first robot goes to the reboot cell
  