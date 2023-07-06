package com.quiz.Model;



public class QuizTest {

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        System.out.println("Java Questions:");
        for (String[] question : quiz.getJavaQuizData()) {
            printQuestionData(question);
        }

        System.out.println("Python Questions:");
        for (String[] question : quiz.getPythonQuizData()) {
            printQuestionData(question);
        }

        System.out.println("JavaScript Questions:");
        for (String[] question : quiz.getJavaScriptQuizData()) {
            printQuestionData(question);
        }

        System.out.println("HTML & CSS Questions:");
        for (String[] question : quiz.getHtmlCssQuizData()) {
            printQuestionData(question);
        }
    }

    private static void printQuestionData(String[] question) {
        System.out.println("Question: " + question[0]);
        System.out.println("Option 1: " + question[1]);
        System.out.println("Option 2: " + question[2]);
        System.out.println("Option 3: " + question[3]);
        System.out.println("Option 4: " + question[4]);
        System.out.println("Correct Answer: " + question[5]);
        System.out.println();
    }
}

