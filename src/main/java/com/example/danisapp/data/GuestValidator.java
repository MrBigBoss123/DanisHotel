package com.example.danisapp.data;

public class GuestValidator {
    static char[] validLetters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '3', '4', '4', '5', '6', '7', '8', '9', '0'};

    static char[] validEmailCharacters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '3', '4', '4', '5', '6', '7', '8',
            '9', '0', '@', '.','!', '#', '$', '%', '&', '*', '+', '-', '/', '=', '?', '^', '_', '`', '{', '|', '}', '~'};

    static char[] validNumbers = new char[]{'1', '2', '3', '3', '4', '4', '5', '6', '7', '8', '9', '0'};


    public static boolean isEmailValid(String email) {
        if (email.length() <5){
            return false;
        }
        boolean validLetterFound = false;
        for (int i = 0; i < validLetters.length; i++){
            if ((email.toLowerCase()).charAt(0) == validLetters[i]) {
                validLetterFound = true;
                break;
            }
        }

        boolean allCharactersValid = true;
        for (int i = 0; i<email.length(); i++){
            boolean validCharacter =false;
            for (int z = 0; z < validEmailCharacters.length; z++) {
                if ((email.toLowerCase()).charAt(i) == validEmailCharacters[z]) {
                    validCharacter = true;
                    break;
                }
            }
            if (validCharacter == false){
                allCharactersValid = false;
                break;
            }
        }
        boolean validAtFound = ((email.substring(0,email.length()-3)).contains("@"));

        String emailSubStringAfterAt = email.substring(email.indexOf("@")+1);
        boolean invalidMultipleAtsFound = !emailSubStringAfterAt.contains("@");

        boolean validDotFound = email.substring(email.indexOf("@")+1,email.length()-1).contains(".");


        return validLetterFound && validAtFound && invalidMultipleAtsFound && validDotFound && allCharactersValid;
    }
    public static boolean isPhoneNumberValid(String phoneNumber) {
        String clensedPhoneNumber = phoneNumber.trim()
                .replace("(", "")
                .replace(")", "")
                .replace("-", "")
                .replace("/", "")
                .replace(" ", "");
        if(clensedPhoneNumber.length()!= 10){
            return false;
        }


        for (int i = 0; i<clensedPhoneNumber.length(); i++){
            boolean validCharacter =false;
            for (int z = 0; z < validNumbers.length; z++) {
                if ((clensedPhoneNumber).charAt(i) == validNumbers[z]) {
                    validCharacter = true;
                    break;
                }
            }
            if (validCharacter == false){
               return false;
            }
        }
        return true;
    }
}
