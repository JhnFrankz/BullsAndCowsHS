### Secret code

Stage 3/7:Secret code

#### Description
Using a predefined secret code doesn't make a fun game. Let's implement the ability to generate a pseudo-random secret number of a given length. If the length is greater than 10, print a warning message and do not generate a number.

We suggest you use the following algorithm to generate the numbers:

`long pseudoRandomNumber = System.nanoTime();`

This code saves the nanoseconds elapsed since a certain time to the `pseudoRandomNumber` variable. We can assume that this is a random number. You can generate a secret code by iterating over the `pseudoRandomNumber` in the reverse order and adding unique digits. If the `pseudoRandomNumber` lacks the required number of unique digits, call `System.nanoTime()` again and try to generate the secret code again until you get a satisfactory result.

You can use the `Character.getNumericValue(char a)` method to get an integer representation of a number!




#### Objectives

In this stage, your program should generate a pseudo-random number of a given length with unique digits and print it. If the length is greater than 10, the program should print a message containing the word `Error`. The secret code may contain any digits from 0 to 9 but only once. The secret code shouldn't start with a digit 0: for the first digit of the secret code, use digits from 1 to 9.

Don't delete your previous work, just move your code to a separate method. You will need it in the future stages.


#### Examples
The greater-than symbol followed by a space `>` represents the user input. Note that it's not part of the input.

##### Example 1:

```
> 5
The random secret number is 48379.
```

##### Example 2:

```
> 4
The random secret number is 5213.
```

##### Example 3:

```
> 11
Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.
```