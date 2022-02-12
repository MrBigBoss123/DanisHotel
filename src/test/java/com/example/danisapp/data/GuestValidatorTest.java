package com.example.danisapp.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class GuestValidatorTest {

    @Test
    void testInvalidEmail() {
        String invalidEmail = "notAValid email";
        boolean valid = GuestValidator.isEmailValid(invalidEmail);
        assertFalse(valid);
    }

    public static String[] validEmails() {
        return new String[]{"john@yahoo.com", "bill@cz.net"};
    }

    @ParameterizedTest
    @MethodSource(value = "validEmails")
    void testValidEmails(String email) {
        boolean valid = GuestValidator.isEmailValid(email);
        assertTrue(valid);
    }
}