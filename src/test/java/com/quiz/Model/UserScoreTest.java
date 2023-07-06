package com.quiz.Model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class UserScoreTest {

    @Test
    public void testRetrieveUserScore() {
        UserScore userScore = new UserScore(1);

        ArrayList<String[]> scores = userScore.getUserScore();

        assertNotNull(scores);
        assertEquals(2, scores.size());

        String[] score1 = scores.get(0);
        assertEquals("1", score1[0]);
        assertEquals("John", score1[1]);
        assertEquals("Doe", score1[2]);
        assertEquals("johndoe", score1[3]);
        assertEquals("80.0", score1[4]);
        assertEquals("8", score1[5]);
        assertEquals("10", score1[6]);
        assertEquals("Pass", score1[7]);

        String[] score2 = scores.get(1);
        assertEquals("2", score2[0]);
        assertEquals("Jane", score2[1]);
        assertEquals("Smith", score2[2]);
        assertEquals("janesmith", score2[3]);
        assertEquals("75.0", score2[4]);
        assertEquals("6", score2[5]);
        assertEquals("8", score2[6]);
        assertEquals("Pass", score2[7]);
    }
}
