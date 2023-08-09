package com.quiz.Model;

public class AddQuizQuestionsTest {

    public static void main(String[] args) {
        testAddQuestions();
    }

    public static void testAddQuestions() {
        String question = "What is the capital of France?";
        String answer1 = "London";
        String answer2 = "Berlin";
        String answer3 = "Paris";
        String answer4 = "Madrid";
        String correctAnswer = "Paris";
        int subjectId = 1;

        AddQuizQuestions addQuizQuestions = new AddQuizQuestions(
            question, answer1, answer2, answer3, answer4, correctAnswer, subjectId);

        // Simulate calling the addQuestions method
        addQuizQuestions.addQuestions(
            question, answer1, answer2, answer3, answer4, correctAnswer, subjectId);

        // Print a message to indicate successful test completion
        System.out.println("Test completed.");
    }
}
