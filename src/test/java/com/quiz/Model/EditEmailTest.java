package com.quiz.Model;

public class EditEmailTest {
    public static void main(String[] args) {
        // Set the user ID and new email
        int userId = 123;  // Replace with the actual user ID
        String newEmail = "newemail@example.com";  // Replace with the new email

        // Create an EditEmail object and pass the parameters
        EditEmail editEmail = new EditEmail(newEmail, userId);

        System.out.println("Email updated.");
    }
}
