package com.quiz.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class AllUserScoresTest {
    public static void main(String[] args) {
        AllUserScores allUserScores = new AllUserScores();
        ArrayList<String[]> userScores = allUserScores.getUserScore();

        if (userScores != null && !userScores.isEmpty()) {
            System.out.println("User Scores:");

            for (String[] userData : userScores) {
                System.out.println(Arrays.toString(userData));
            }
        } else {
            System.out.println("No user scores available.");
        }
    }
}
