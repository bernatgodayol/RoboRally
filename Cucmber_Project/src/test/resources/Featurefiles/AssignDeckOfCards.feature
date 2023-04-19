Feature: Assign deck of cards
  
  @tag1
  Scenario: Succesfully assigning the programming deck of cards to the player
    Given a player
    And a programming deck of cards
    When the player is assigned the programming deck of cards
    Then the player has a programming deck of cards
   
  @tag2
  Scenario: Succesfully assigning the playing deck of cards to the player
    Given a player
    And a playing deck of cards
    When the player is assigned the playing deck of cards
    Then the player has a playing deck of cards
   
  @tag3
  Scenario: Succesfully assigning the action deck of cards to the player
    Given a player
    And an action deck of cards
    When the player is assigned the action deck of cards
    Then the player has an action deck of cards
   
  @tag4
  Scenario: Succesfully assigning the discard deck of cards to the player
    Given a player
    And a discard deck of cards
    When the player is assigned the discard deck of cards
    Then the player has a discard deck of cards
    
  @tag5
  Scenario: Succesfully assigning the programming deck of cards to two players
    Given a player
    And a second player
    And a programming deck of cards
    And a second programming deck of cards
    When the player is assigned the programming deck of cards
    And the second player is assigned the second programming deck of cards
    Then the player has a programming deck of cards
    Then the second player has a programming deck of cards
   
  @tag6
  Scenario: Succesfully assigning the playing deck of cards to two players
    Given a player
    And a second player
    And a playing deck of cards
    And a second playing deck of cards
    When the player is assigned the playing deck of cards
    And the second player is assigned the second playing deck of cards
    Then the player has a playing deck of cards
    Then the second player has a playing deck of cards
    
  @tag7
  Scenario: Succesfully assigning the action deck of cards to two players
    Given a player
    And a second player
    And an action deck of cards
    And a second action deck of cards
    When the player is assigned the action deck of cards
    And the second player is assigned the second action deck of cards
    Then the player has an action deck of cards
    And the second player has an action deck of cards
   
  @tag8
  Scenario: Succesfully assigning the discard deck of cards to two players
    Given a player
    And a second player
    And a discard deck of cards
    And a second discard deck of cards
    When the player is assigned the discard deck of cards
    And the second player is assigned the second discard deck of cards
    Then the player has a discard deck of cards
    And the second player has a discard deck of cards