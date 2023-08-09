package com.quiz.Model;

public class DeleteAccountTest {
    public static void main(String[] args) {
        // Set the ID of the account to be deleted
        int idToDelete = 123; // Replace with the actual ID to delete

        // Create a DeleteAccount object and pass the ID
        DeleteAccount deleteAccount = new DeleteAccount(idToDelete);

        System.out.println("Account deletion initiated.");
    }
}
