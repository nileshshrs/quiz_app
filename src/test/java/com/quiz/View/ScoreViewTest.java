package com.quiz.View;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JLabel;

import org.junit.Test;

public class ScoreViewTest {

    @Test
    public void testConstructor() {
        ArrayList<String[]> scoreData = new ArrayList<>();
        scoreData.add(new String[] { "1", "John", "Doe", "johndoe", "80%", "8", "10", "Pass" });
        scoreData.add(new String[] { "2", "Jane", "Smith", "janesmith", "75%", "6", "8", "Pass" });

        ScoreView scoreView = new ScoreView(scoreData);

        // Check if the title label is set correctly
        JLabel titleLabel = (JLabel) scoreView.getComponent(0);
        assertEquals("Your Quiz Scores", titleLabel.getText());

        // Check if the note label is set correctly
        JLabel noteLabel = (JLabel) scoreView.getComponent(1);
        assertEquals("Please select a row to view/print the result.", noteLabel.getText());


    }
}
