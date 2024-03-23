### Improve the code generator

Stage 5/7:Improve the code generator

#### Description

The algorithm suggested for generating the secret code in the previous stage was really a “reinvention of the wheel”. Java already has the tools for generating random numbers! Research some common pseudo-random generation methods, such as `Math.random()` and other methods from the `Random` class. Choose the method you like and use it to rewrite the secret code generation. To learn more about the `Random` class, jump to [Random](https://hyperskill.org/learn/step/4910) topic. If you want to get to know all the intricacies of the `Math` library, don't forget to check out the [Math](https://hyperskill.org/learn/step/3501) library topic as well.

Nothing else is supposed to change at this stage: the program asks for the length, generates a secret code, and then receives and grades the attempts until the code is guessed. Your task here is to rewrite the code generator without breaking the existing code.



#### Objectives

In this stage, rewrite the secret code generator using a suitable Java method.


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

