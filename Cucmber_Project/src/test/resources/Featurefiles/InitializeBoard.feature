@tag
Feature: Initialise board

  @tag1
  Scenario: Succesfully initialising the EASY board
    Given a board
    When the EASY board is initialised 
    Then the obstacles of the EASY board are in the expected tiles
    
  @tag2
  Scenario: Succesfully initialising the MEDIUM board
    Given a board
    When the MEDIUM board is initialised 
    Then the obstacles of the MEDIUM board are in the expected tiles
    
  @tag3
  Scenario: Succesfully initialising the HARD board
    Given a board
    When the HARD board is initialised 
    Then the obstacles of the HARD board are in the expected tiles