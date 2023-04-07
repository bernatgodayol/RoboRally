@tag
Feature: Choosing a card from the playing deck recieved in the programming phase

	@tag1
  Scenario: Succesfully choosing 1 cards from the playing deck
    Given a player
    And 9 random cards in the players playing deck
    When the player chooses 1 cards
    Then the 1 cards are saved 
    And the 1 cards have been removed from the playing deck
    
  #@tag2
  #Scenario: Unsuccesfully trying to choose more than 5 cards from the playing deck 
    #Given a player
    #And 9 random cards in the players playing deck
    #When the player chooses 6 cards
    #Then 6


