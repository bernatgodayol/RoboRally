@tag
Feature: The 5B board is initialised 

  @tag1
  Scenario: Succesfully initialising the 5B board
    Given an empty board of size 13 x 10
    When the 5B board is initialised 
    Then the obstacles of the board should be in the expected tiles on the board

    