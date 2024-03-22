package com.jhnfrankz.bullsandcows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String secretCode;
    private static int length;
    private static String inputNumber;
    private static int cows = 0;
    private static int bulls = 0;

    public static void main(String[] args) {
        executeProgram();
    }

    public static void executeProgram() {
        readLength();
        startGame();
    }

    public static void startGame() {
        System.out.println("Okay, let's start a game!");
        generateRandomSecretCode();

        for (int i = 1; !isSecretCodeGuessed(); i++) {
            System.out.printf("Turn %d:%n", i);

            readInputNumber();
            countBullsAndCows();
            showGrade();

            if (isSecretCodeGuessed()) {
                continue;
            }

            clearBullsAndCows();
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    // Read length for secret code
    public static void readLength() {
        System.out.println("Please, enter the secret code's length:");
        length = Integer.parseInt(scanner.nextLine());
        checkLength();
    }

    public static void checkLength() {
        if (length > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because " +
                    "there aren't enough unique digits.%n", length);
            readLength();
        }
    }

    public static void generateRandomSecretCode() {
        List<Integer> randomList =
                new ArrayList<>(List.of(0,1,2,3,4,5,6,7,8,9));

        while (randomList.get(0) == 0) {
            Collections.shuffle(randomList);
        }

        StringBuilder result = new StringBuilder();

        for (var i : randomList.subList(0, length)) {
            result.append(i);
        }

        secretCode = result.toString();
    }

    // Read user input for game
    public static void readInputNumber() {
        inputNumber = scanner.nextLine();
    }

    public static void countBullsAndCows() {
        if (secretCode.equals(inputNumber)) {
            bulls = secretCode.length();
        } else {
            for (int i = 0; i < secretCode.length(); i++) {
                if (isBull(i)) {
                    bulls++;
                } else if (isCow(i)) {
                    cows++;
                }
            }
        }
    }

    public static boolean isCow(int i) {
        return secretCode.contains(String.valueOf(inputNumber.charAt(i)));
    }

    public static boolean isBull(int i) {
        return secretCode.charAt(i) == inputNumber.charAt(i);
    }

    public static void clearBullsAndCows() {
        bulls = 0;
        cows = 0;
    }

    public static void showGrade() {
        if (cows > 0 && bulls > 0) {
            System.out.printf("Grade: %d %s and %d %s%n", bulls, textBulls(), cows, textCows());
        } else if (bulls > 0) {
            System.out.printf("Grade: %d %s%n", bulls, textBulls());
        } else if (cows > 0) {
            System.out.printf("Grade: %d %s%n", cows, textCows());
        } else {
            System.out.printf("Grade: None%n");
        }
    }

    public static String textBulls() {
        return bulls == 1 ? "bull" : "bulls";
    }

    public static String textCows() {
        return cows == 1 ? "cow" : "cows";
    }

    public static boolean isSecretCodeGuessed() {
        return bulls == secretCode.length();
    }
}