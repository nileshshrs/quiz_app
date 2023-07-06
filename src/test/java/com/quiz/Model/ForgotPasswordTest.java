package com.quiz.Model;

public class ForgotPasswordTest {
    public static void main(String[] args) {
        // Set the username, current password, and new password
        String username = "johndoe";
        String currentPassword = "oldpassword";
        String newPassword = "newpassword";

        // Create a ForgotPassword object and pass the username and passwords
        ForgotPassword forgotPassword = new ForgotPassword(username, currentPassword, newPassword);

        // Retrieve the new password from the ForgotPassword object
        String newPasswordSet = forgotPassword.getNewPassword();

        // Check if the new password is not empty
        if (newPasswordSet != null) {
            System.out.println("New password set: " + newPasswordSet);
        } else {
            System.out.println("Failed to set new password.");
        }
    }
}
