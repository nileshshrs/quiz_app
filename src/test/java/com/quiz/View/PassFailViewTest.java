package com.quiz.View;

import org.junit.Assert;
import org.junit.Test;

public class PassFailViewTest {

    @Test
    public void testPassFailView() {
        double percentage = 67.67;
        int score = 13;
        int totalQuestions = 20;
        String passFailStatus = "PASS";
        int id = 1;
        int quizId = 1;

        PassFailView passFailView = new PassFailView(percentage, score, totalQuestions, passFailStatus, id, quizId);

        // Check if the PassFailView instance is created
        Assert.assertNotNull(passFailView);

        // Check if the passFailStatus label is updated correctly
        Assert.assertEquals(passFailStatus + ": " + percentage + "%", passFailView.statusLabel.getText());

        // Check if the correctAnswerLabel is updated correctly
        String expectedCorrectAnswerText = "you got " + score + " out of " + totalQuestions + " correct";
        Assert.assertEquals(expectedCorrectAnswerText, passFailView.correctAnswerLabel.getText());
    }
}
