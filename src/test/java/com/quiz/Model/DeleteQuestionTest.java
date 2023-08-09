package com.quiz.Model;

public class DeleteQuestionTest {
    public static void main(String[] args) {
        // Set the question and its options to be deleted
        String question = "What is the capital of France?";
        String option1 = "London";
        String option2 = "Berlin";
        String option3 = "Paris"; // Correct option
        String option4 = "Madrid";
        String correctOption = "Paris";

        // Create a DeleteQuestion object and pass the question and options
        DeleteQuestion deleteQuestion = new DeleteQuestion(question, option1, option2, option3, option4, correctOption);

        System.out.println("Question deleted.");
    }
}
