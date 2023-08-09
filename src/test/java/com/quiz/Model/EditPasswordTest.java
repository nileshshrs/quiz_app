package com.quiz.Model;

public class EditPasswordTest {
    public static void main(String[] args) {
        // Set the user ID and new password
        int userId = 123;  // Replace with the actual user ID
        String newPassword = "newPassword123";  // Replace with the new password

        // Create an EditPassword object and pass the parameters
        EditPassword editPassword = new EditPassword(userId, newPassword);

        System.out.println("Password updated.");
    }
}
