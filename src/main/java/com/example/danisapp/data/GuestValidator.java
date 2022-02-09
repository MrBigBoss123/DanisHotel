package com.example.danisapp.data;

public class GuestValidator {

    public static boolean isEmailValid(String email) {
        char[] validLetters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '3', '4', '4', '5', '6', '7', '8', '9'};
        boolean validLetterFound = false;
        for (int i = 0; i < validLetters.length; i++){
            if ((email.toLowerCase()).charAt(0) == validLetters[i]) {
                validLetterFound = true;
                break;
            }
        }

        boolean validAtFound = ((email.substring(0,email.length()-3)).contains("@"));



        return validLetterFound && validAtFound;
    }
}
