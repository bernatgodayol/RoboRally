@tag
Feature: Activate Obstacles

  @tag1
  Scenario: Succesfully activating a laser
    Given an inactive laser
    When the laser activates
    Then the laser is active 
  
  @tag2
  Scenario: Succesfully inactivating a laser
    Given an active laser
    When the laser inactivates
    Then the laser is inactive 


