package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Quiz {

    private ArrayList<String[]> quizData;

    public Quiz() {
        this.quizData = new ArrayList<>();
        retrieveData();

    }

    public void setQuizData(ArrayList<String[]> quizData) {
        this.quizData = quizData;
    }

    public ArrayList<String[]> getQuizData() {
        return quizData;
    }

    public void retrieveData() {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT qu.question_id, qu.question_text, qu.option1, qu.option2, qu.option3, qu.option4, qu.correct_answer "
                + "FROM questions qu " + "ORDER BY qu.question_id ASC;";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String question = rs.getString("question_text");
                String answer1 = rs.getString("option1");
                String answer2 = rs.getString("option2");
                String answer3 = rs.getString("option3");
                String answer4 = rs.getString("option4");
                String correctAnswer = rs.getString("correct_answer");

                String[] rowData = { question, answer1, answer2, answer3, answer4, correctAnswer };
                quizData.add(rowData);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Quiz();
    }
}
