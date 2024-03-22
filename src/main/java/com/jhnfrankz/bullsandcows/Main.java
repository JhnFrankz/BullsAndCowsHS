package com.jhnfrankz.bullsandcows;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String secretCode = "9305";
    private static String inputNumber;
    private static int cows = 0;
    private static int bulls = 0;

    public static void main(String[] args) {
        readNumber();
        countBullsAndCows();
        showGrade();
    }

    public static void readNumber() {
        inputNumber = scanner.nextLine();
    }

    public static void countBullsAndCows() {
        if (secretCode.equals(inputNumber)) {
            bulls = 4;
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

    public static void showGrade() {
        if (cows > 0 && bulls > 0) {
            System.out.printf("Grade: %d bull(s) and %d cows(s). The secret code is %s.",bulls, cows, secretCode);
        } else if (bulls > 0) {
            System.out.printf("Grade: %d bull(s). The secret code is %s.",bulls, secretCode);
        } else if (cows > 0) {
            System.out.printf("Grade: %d cows(s). The secret code is %s.",cows, secretCode);
        } else {
            System.out.printf("Grade: None. The secret code is %s.", secretCode);
        }
    }
}
