# RoboRally User Stories

### GAME SET UP 

- *U1*: As a player, I want to be assigned a robot, so that I own a robot to play the game. 
- *U2*: As a player, I want the game board to be initialised with the specific obstacles in their expected positions, so that I can play the game in a particular level of difficulty. 
- *U3*: As a player, I want to receive a deck of cards, so that I own a deck of cards. 
- *U4*: As a player, I want my robot to be placed at a starting position and a starting direction on the game board, so that my robot is set on the game board. 

### PROGRAMMING PHASE 

- *U5*: As a player, I want to receive 9 random cards from my programming card deck when the programming phase starts, so that I have 9 cards in my playing deck of cards.  
- *U6*: As a player, want to move 5 concrete cards from my playing deck to my action deck, so that my robot will move according to them in the activation phase. 
- *U7*: As a player, I want the 4 remaining cards in my playing deck to be placed in my discard deck, so that I can reuse them later. 
- *U8*: As an AI player, I want to randomly choose 5 cards from my playing deck, so that my robot will move according to them in the activation face. 

### ACTIVATION PHASE (1 REGISTER) 

- *U9.1*: As a player, I want my robot to move forward one tile when a Move Forward card is activated, so that my robot moves forward. 
- *U9.2*: As a player, I want my robot to stop moving forward when it hits a wall, so that the robot does not cross a wall. 
- *U9.3*: As a player, I want my robot to be moved to the reboot cell when my robot goes out of the board, so that my robot can continue the game from the reboot cell. 
- *U10*: As a player, I want my robot to change direction when a Turn Card is activated, so that my robot changes direction. 
- *U11*: As a player, I want my robot to push forward another robot when it is on its way, so that two robots are never in the same position on the game board $^1$.
- *U12.1*: As a player I want to receive a damage card if my robot is hit by a laser, so that I am penalised. 
- *U12.2*: As a player I want my robot to receive a damage card and to be moved to the reboot cell if my robot falls into a pit, so that I am penalised. 
- *U13*: As a player I want my card used in the n register to be discarded to my discard deck, so that I do not play it twice. 
- *U14*: As a player I want my robot to perform the action in my n card, so that I can complete the n register. 

### END OF THE GAME 

- *U19*: As a player, I want to win the game when my robot is located on the endpoint of the board at the end of a register, so that I will be the winner of the game. 
- *U20*: As a player, I want the game to end when a winner is found, so that the game does not go on forever. 

### GAME PLAY  

- *U22*: As a player I want to be able to play with up to 3 more players, so that I can play with more people.  
- *U21*: As a player I want to be able to choose to play against an AI, so that I can play against the computer. 

$^{1}$ Multiple robots can be in the reboot cell at the same time if they die at the end of the same register. 

 

 
 
