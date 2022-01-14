package edu.illinoisstate.it296;

public class Security {

    public static boolean validateUsername(String input) {
        return input.length() < 3 || input.length() > 12;
    }

}
