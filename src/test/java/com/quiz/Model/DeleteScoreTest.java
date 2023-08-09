package com.quiz.Model;

public class DeleteScoreTest {
    public static void main(String[] args) {
        // Set the score ID to be deleted
        int scoreId = 123;  // Replace with the actual score ID

        // Create a DeleteScore object and pass the score ID
        DeleteScore deleteScore = new DeleteScore(scoreId);

        System.out.println("Score deleted.");
    }
}
