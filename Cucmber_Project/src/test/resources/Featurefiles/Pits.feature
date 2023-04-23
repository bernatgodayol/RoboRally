@tag
Feature: Falling into a pit

  @tag1
  Scenario: Succesfully moving the robot to the reboot cell when the robot falls into a pit
  Given a board
  And a pit
  And a player
  And a programming deck of cards that belongs to the player
  And a robot on the board that belongs to a player
  When a pit is in the same tile as the robot
  Then the robot goes to the reboot cell
