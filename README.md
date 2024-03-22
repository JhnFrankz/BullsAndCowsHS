### Game time!

Stage 4/7:Game time!

#### Description
In this stage, you should combine all the previous parts into a simple playable version of the "Bulls and Cows" game. First, prompt the player to input the length of the secret code. The length will determine the difficulty level for the current game session. The program should generate a secret code of the given length. Remember that it should consist of unique numbers.

Then, the game starts and the program prompts the player to guess the code. When the player inputs a number, the program should grade it in bulls and cows. The game goes on until the code is guessed, that is, until the number of bulls is equal to the number of digits in the code. When the game ends, the program should finish its execution.



#### Objectives

In this stage, your program should:

1. Ask for the length of the secret code and then generate the code.
2. Wait for the user input.
3. Grade the guessing attempt in bulls and cows.
4. If the secret code has been guessed, the program stops; otherwise, return to the second step.



#### Example

The greater-than symbol followed by a space `>` represents the user input. Note that it's not part of the input.

```
Please, enter the secret code's length:
> 4
Okay, let's start a game!
Turn 1:
> 1234
Grade: 1 bull and 1 cow
Turn 2:
> 7354
Grade: 2 bulls and 1 cow
Turn 3:
> 9374
Grade: 4 bulls
Congratulations! You guessed the secret code.
```

