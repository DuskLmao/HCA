package com.hca.utils;

import java.util.Random;

public class Utils {
    public static String generatePassword(int length) {
        String symbol = "-/.^&*_!@%=+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";


        String finalString = cap_letter + small_letter +
                numbers + symbol;

        Random random = new Random();

        char[] password = new char[length];

        for (int i = 0; i < length; i++)
        {
            password[i] =
                    finalString.charAt(random.nextInt(finalString.length()));

        }
        return String.valueOf(password);
    }
}
