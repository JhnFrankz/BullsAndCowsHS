package com.jhnfrankz.bullsandcows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static String secretCode;
    private static int length;

    public static void main(String[] args) {
        readLength();
        checkLength();
    }

    public static void readLength() {
        length = Integer.parseInt(scanner.nextLine());
    }

    public static void checkLength() {
        if (length > 10) {
            System.out.printf("Error: can't generate a secret number with a length of %d because " +
                    "there aren't enough unique digits.", length);
        } else {
            generateRandomSecretCode();
            System.out.printf("The random secret number is %s.", secretCode);
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
}
