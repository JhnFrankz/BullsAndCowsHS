### New level

Stage 6/7:New level

#### Description

Some players need a challenge, so let's make the secret code in the game harder to guess. Add support for more than 10 symbols by adding letters. Now, the secret code can contain the numbers `0-9` and the lowercase Latin characters `a-z`. The new maximum length for the code is 36. Note that the length of the secret word may not match the number of possible characters in the secret code, so you should request input twice: once for the secret code length and once for the number of possible characters.

Also, since a secret code is not a number anymore, the symbol `0` should be allowed as the first character in a secret code.


#### Objectives

In this step, your program should:

1. Ask for the length of the secret code.
2. Ask for the range of possible characters in the secret code.
3. Generate a secret code using numbers and characters. This time, you should also print the secret code using `*` characters and print which characters were used to generate the secret code.
4. Function as a fully playable game.


#### Example

The greater-than symbol followed by a space `>` represents the user input. Note that it's not part of the input.

```
Input the length of the secret code:
> 4
Input the number of possible symbols in the code:
> 16
The secret is prepared: **** (0-9, a-f).
Okay, let's start a game!
Turn 1:
> 1a34
Grade: 1 bull and 1 cow
Turn 2:
> b354
Grade: 2 bulls and 1 cow
Turn 3:
> 93b4
Grade: 4 bulls
Congratulations! You guessed the secret code.
```

