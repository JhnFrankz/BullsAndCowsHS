package com.jhnfrankz.bullsandcows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String secretCode;
    private static int length;
    private static int numberOfSymbols;
    private static String inputCode;
    private static int cows = 0;
    private static int bulls = 0;
    private static String digitsRange = "";
    private static String alphabetsRange = "";

    public static void main(String[] args) {
        executeProgram();
    }

    public static void executeProgram() {
        readLength();
        readNumberOfSymbols();
        startGame();
    }

    public static void startGame() {
        generateRandomSecretCode();
        System.out.println("Okay, let's start a game!");

        for (int i = 1; !isSecretCodeGuessed(); i++) {
            System.out.printf("Turn %d:%n", i);

            readInputCode();
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
        System.out.println("Input the length of the secret code:");
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

    // Read length for secret code
    public static void readNumberOfSymbols() {
        System.out.println("Input the number of possible symbols in the code:");
        numberOfSymbols = Integer.parseInt(scanner.nextLine());

        if (numberOfSymbols < 0 || numberOfSymbols > 36) {
            readNumberOfSymbols();
        }
    }

    public static void generateRandomSecretCode() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        String finalSymbols = getFinalSymbols();

        setRangeOfSymbols();

        for (int i = 0; i < length; i++) {
            int c = random.nextInt(numberOfSymbols);
            String symbol = String.valueOf(finalSymbols.charAt(c));

            if (result.toString().contains(symbol)) {
                i--;
                continue;
            }

            result.append(symbol);
        }

        secretCode = result.toString();

        showSecretCodePrepared();
    }

    public static String getFinalSymbols() {
        return "0123456789abcdefghijklmnopqrstuvwxyz".substring(0, numberOfSymbols);
    }

    public static void setRangeOfSymbols() {
        String finalSymbols = getFinalSymbols();

        if (numberOfSymbols > 10) {
            digitsRange = finalSymbols.substring(0, 10);
            alphabetsRange = finalSymbols.substring(10, numberOfSymbols);
        } else {
            digitsRange = finalSymbols.substring(0, numberOfSymbols);
        }
    }

    public static void showSecretCodePrepared() {
        if (numberOfSymbols > 10) {
            System.out.printf("The secret is prepared: %s (0-9, %s).%n"
                    , "*".repeat(length)
                    , numberOfSymbols == 11
                            ? "".concat(String.valueOf(alphabetsRange.charAt(0)))
                            : "a-".concat(String
                            .valueOf(alphabetsRange.charAt(alphabetsRange.length() - 1))));
        } else {
            System.out.printf("The secret is prepared: %s (%s-%s).%n"
                    , "*".repeat(length)
                    , digitsRange.charAt(0)
                    , digitsRange.charAt(digitsRange.length() - 1));
        }
    }

    // Read user input for game
    public static void readInputCode() {
        inputCode = scanner.nextLine();
    }

    public static void countBullsAndCows() {
        if (secretCode.equals(inputCode)) {
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
        return secretCode.contains(String.valueOf(inputCode.charAt(i)));
    }

    public static boolean isBull(int i) {
        return secretCode.charAt(i) == inputCode.charAt(i);
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