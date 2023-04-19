@tag
Feature: Initialise board

  @tag1
  Scenario: Succesfully initialising the 5B board
    Given a board
    When the 5B board is initialised 
    Then the obstacles of the 5B board are in the expected tiles