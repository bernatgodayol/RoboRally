@tag
Feature: Initialise board

  @tag1
  Scenario: Succesfully initialising the 5B board
    Given a board
    When the 5B board is initialised 
    Then the obstacles of the 5B board are in the expected tiles
    
  @tag2
  Scenario: Succesfully initialising the 2B board
    Given a board
    When the 2B board is initialised 
    Then the obstacles of the 2B board are in the expected tiles
    
  @tag3
  Scenario: Succesfully initialising the 4A board
    Given a board
    When the 4A board is initialised 
    Then the obstacles of the 4A board are in the expected tiles