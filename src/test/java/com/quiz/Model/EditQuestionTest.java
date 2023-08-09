package com.quiz.Model;

public class EditQuestionTest {
    public static void main(String[] args) {
        // Set the question details and subject ID
        String question = "What is the capital of France?";
        String answer1 = "Berlin";
        String answer2 = "London";
        String answer3 = "Paris";
        String answer4 = "Rome";
        String correctAnswer = "Paris";
        int subjectId = 123;  // Replace with the actual subject ID

        // Create an EditQuestion object and pass the parameters
        EditQuestion editQuestion = new EditQuestion(question, answer1, answer2, answer3, answer4, correctAnswer, subjectId);

        System.out.println("Question data updated.");
    }
}
