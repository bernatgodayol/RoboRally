@tag
Feature: Choosing a card from the playing deck recieved in the programming phase

	@tag1
  Scenario: Succesfully choosing a cards from the playing deck
		Given a player
		And a programming deck that belongs to the player
    And a playing deck that belongs to the player
    And an action deck that belongs to the player
    When the player chooses one card
    Then the card is moved from the playing deck to the action deck
    
  #@tag2
  #Scenario: Unsuccesfully trying to choose more than 5 cards from the playing deck 
    #Given a player
    #And 9 random cards in the players playing deck
    #When the player chooses 6 cards
    #Then 6


