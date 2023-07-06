package com.quiz.Model;


public class RecordScoreTest {

    public static void main(String[] args) {
        // Create an instance of RecordScore
        RecordScore recordScore = new RecordScore();

        // Sample data for testing
        int userId = 1;
        int quizId = 1;
        double score = 85.5;
        int totalCorrectAnswers = 20;
        int totalQuestions = 25;
        String passFailStatus = "Pass";

        // Call the recordScore method to insert the data into the database
        recordScore.recordScore(userId, quizId, score, totalCorrectAnswers, totalQuestions, passFailStatus);

        // Print a success message
        System.out.println("Recorded score successfully!");
    }
}
