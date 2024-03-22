### Grader

Stage 2/7:Grader

#### Description
Let's add some interactivity to our program. The program should create a 4-digit secret code, and the player should try to guess it on the first try. The program should give a grade to evaluate how accurate the player was.

As you remember, a correctly guessed digit is a cow, and if its position is also correct, then it is a bull. After the player tries to guess the secret code, the program should grade the attempt and finish the execution.

For example, if the secret code is `9305`, then:

1. The number `9305` contains 4 bulls and 0 cows since all 4 digits are correct and their positions are correct as well. It's the only number that can contain 4 bulls, so it's also the secret code itself.
2. The numbers `3059`, `3590`, `5930`, `5039` contain 0 bulls and 4 cows since all 4 digits are correct but their positions don't match the positions in the secret code.
3. The numbers `9306`, `9385`, `9505`, `1305` contain 3 bulls.
4. The numbers `9350`, `9035`, `5309`, `3905` contain 2 bulls and 2 cows.
5. The numbers `1293`, `5012`, `3512`, `5129` contain 0 bulls and 2 cows.
6. The numbers `1246`, `7184`, `4862`, `2718` contain 0 bulls and 0 cows.

Note that guesses can contain repetitive digits, so:

1. The number `1111` contains 0 bulls and 0 cows.
2. The number `9999` contains 1 bull and 3 cows.
3. The number `9955` contains 2 bulls and 2 cows.

#### Objectives
In this stage, your goal is to write the core part of the game: the grader.

1. Your program should take a 4-digit number as an input.
2. Use a predefined 4-digit code and grade the answer that was input. You can do it digit by digit.

The grade is considered correct if it contains number-and-word pairs (like `X bulls and Y cows`) that give the correct information. If the answer doesn't contain any bulls and cows, you should output `None`.


#### Examples
The greater-than symbol followed by a space `>` represents the user input. Note that it's not part of the input.

##### Example 1:

```
> 1234
Grade: 1 cow(s). The secret code is 9305.
```

##### Example 2:

```
> 9087
Grade: 1 bull(s) and 1 cow(s). The secret code is 9305.
```

##### Example 3:

```
> 1267
Grade: None. The secret code is 9305.
```