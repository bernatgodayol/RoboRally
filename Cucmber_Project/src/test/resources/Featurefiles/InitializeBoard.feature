@tag
Feature: Initialize board

  @tag1
  Scenario: Succesfully initialising the 5B board
    Given a board
    When the 5B board is initialised 
    Then the obstacles of the 5B board should be in the expected tiles
    