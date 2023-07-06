package com.quiz.View;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class QuizQuestionPanelTest {

    @Test
    public void testQuizQuestionPanelInitialization() {
        // Arrange
        ArrayList<String[]> questionData = new ArrayList<>();

        // Act
        QuizQuestionPanel quizQuestionPanel = new QuizQuestionPanel(questionData);

        // Assert
        assertNotNull(quizQuestionPanel);
    }

    @Test
    public void testQuizQuestionPanelBounds() {
        // Arrange
        ArrayList<String[]> questionData = new ArrayList<>();

        // Act
        QuizQuestionPanel quizQuestionPanel = new QuizQuestionPanel(questionData);
        int expectedX = 250;
        int expectedY = 170;
        int expectedWidth = 1300;
        int expectedHeight = 680;

        // Assert
        assertEquals(expectedX, quizQuestionPanel.getX());
        assertEquals(expectedY, quizQuestionPanel.getY());
        assertEquals(expectedWidth, quizQuestionPanel.getWidth());
        assertEquals(expectedHeight, quizQuestionPanel.getHeight());
    }

    // Add more test methods as needed to cover other functionality

}
