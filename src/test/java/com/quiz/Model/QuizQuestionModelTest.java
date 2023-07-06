package com.quiz.Model;



import java.util.ArrayList;

public class QuizQuestionModelTest {

    public static void main(String[] args) {
        QuizQuestionModel model = new QuizQuestionModel();

        // Retrieve quiz data
        ArrayList<String[]> quizData = model.getQuizData();

        // Print the quiz data
        for (String[] data : quizData) {
            System.out.println("Quiz Name: " + data[0]);
            System.out.println("Question: " + data[1]);
            System.out.println("Option 1: " + data[2]);
            System.out.println("Option 2: " + data[3]);
            System.out.println("Option 3: " + data[4]);
            System.out.println("Option 4: " + data[5]);
            System.out.println("Correct Answer: " + data[6]);
            System.out.println();
        }
    }
}
