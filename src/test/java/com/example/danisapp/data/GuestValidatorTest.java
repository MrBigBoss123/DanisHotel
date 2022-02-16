package com.example.danisapp.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class GuestValidatorTest {


    public static String[] invalidEmails() { return new String[]{ "", " ", " smith@gmail.com", "a@aaa","@gmail.com","a@a.", "dani@@gmail.com", "jeff;smith@gmail.com", "jeff.smith@gmail."};}

    @ParameterizedTest
    @MethodSource(value = "invalidEmails")
    void testInvalidEmail(String invalidEmail) {
        //String invalidEmail = "notAValid email";
        boolean valid = GuestValidator.isEmailValid(invalidEmail);
        assertFalse(valid, invalidEmail);
    }

    public static String[] validEmails() { return new String[]{"John@yahoo.com", "bill@cz.net", "jeff.smith@gmail.com"};}

    @ParameterizedTest
    @MethodSource(value = "validEmails")
    void testValidEmails(String email) {
        boolean valid = GuestValidator.isEmailValid(email);
        assertTrue(valid);
    }
    public static String[] invalidPhoneNumbers() { return new String[]{"123456789", "", " ", "123;1243"};}
    @ParameterizedTest
    @MethodSource(value = "invalidPhoneNumbers")
    void testInvalidPhoneNumbers(String phoneNumbers) {
        boolean valid = GuestValidator.isPhoneNumberValid(phoneNumbers);
        assertFalse(valid, phoneNumbers);
    }
    public static String[] validPhoneNumbers() { return new String[]{"123 123 1234", "123-123-1234", "(123) 123 1234", "(123)-123-1234"};}
    @ParameterizedTest
    @MethodSource(value = "validPhoneNumbers")
    void testValidPhoneNumbers(String phoneNumbers) {
        boolean valid = GuestValidator.isPhoneNumberValid(phoneNumbers);
        assertTrue(valid, phoneNumbers);
    }
}