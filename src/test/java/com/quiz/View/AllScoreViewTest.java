package com.quiz.View;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class AllScoreViewTest {

    @Test
    public void testAllScoreViewInitialization() {
        // Test data
        ArrayList<String[]> scoreData = new ArrayList<>();
        scoreData.add(new String[]{"1", "123", "John", "Doe", "johndoe", "johndoe@example.com", "Java", "90%", "9", "10", "Passed"});

        // Create an instance of AllScoreView
        AllScoreView allScoreView = new AllScoreView(scoreData);

        // Verify the initialization
        assertNotNull(allScoreView);
        assertEquals(1300, allScoreView.getWidth());
        assertEquals(680, allScoreView.getHeight());
        // Add more assertions if necessary
    }

    // Add more test methods for other functionalities if needed
}
