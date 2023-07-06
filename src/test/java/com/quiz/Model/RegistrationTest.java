package com.quiz.Model;

import static org.junit.Assert.*;
import org.junit.Test;

public class RegistrationTest {

    @Test
    public void testRegisterUser() {
        String firstName = "John";
        String lastName = "Doe";
        String username = "johndoe";
        String email = "johndoe@example.com";
        String password = "password";
        String confirmPassword = "password";
        String role = "user";

        Registration registration = new Registration(firstName, lastName, username, email, password, confirmPassword, role);

        // Verify user data
        assertEquals(firstName, registration.getFirstName());
        assertEquals(lastName, registration.getLastName());
        assertEquals(username, registration.getUsername());
        assertEquals(email, registration.getEmail());
        assertEquals(password, registration.getPassword());
        assertEquals(confirmPassword, registration.getConfirmPassword());
        assertEquals(role, registration.getRole());
    }
}
