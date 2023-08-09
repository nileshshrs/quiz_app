package com.quiz.Model;

public class EditScoreTest {
    public static void main(String[] args) {
        // Set the score ID, user ID, subject ID, and other parameters
        int scoreId = 1;
        int userId = 123;
        int subjectId = 456;
        double score = 85.5;
        int answers = 20;
        int totalQuestions = 25;
        String status = "Pass";

        // Create an EditScore object and pass the parameters
        EditScore editScore = new EditScore(scoreId, userId, subjectId, score, answers, totalQuestions, status);

        System.out.println("Score data updated.");
    }
}
