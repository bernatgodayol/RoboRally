
@tag
Feature: Activating laser 

  @tag1
  Scenario: Succesfully activating a laser
    Given an inactive laser
    When the laser activates
    Then the laser is active 


