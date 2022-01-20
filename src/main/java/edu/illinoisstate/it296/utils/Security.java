package edu.illinoisstate.it296.utils;

public class Security {

    public static boolean isValidUsername(String input) {
        return input.length() > 3 && input.length() < 16;
    }

    public static double validateGPA(String input) {
        double value = -1;
        try {
            value = Double.parseDouble(input);
        } catch (NumberFormatException e) {
           System.out.println("Invalid number.");
        }
        return value;
    }

}
