package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditScore {

    private int score_ID, user_ID, Answers, TotalQuestions, SubjectID;
    private double Score;
    private String Status;

    public EditScore(int score_id, int user_id, int subjectID, double score, int answers, int totalQuestions,
            String status) {
        this.score_ID = score_id;
        this.user_ID = user_id;
        this.Score = score;
        this.Answers = answers;
        this.TotalQuestions = totalQuestions;
        this.Status = status;
        this.SubjectID = subjectID;

        updateScoreTable(score_ID, user_ID, SubjectID, Score, Answers, TotalQuestions, Status);
    }

    public void updateScoreTable(int score_id, int user_id, int subjectID, double score, int answers,
            int totalQuestions,
            String status) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "UPDATE user_score SET user_id = ?, quiz_id = ?, score = ?, total_correct_answers   = ?, total_questions = ?, pass_fail_status = ?  WHERE score_id = ?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            statement.setInt(2, subjectID);
            statement.setDouble(3, score);
            statement.setInt(4, answers);
            statement.setInt(5, totalQuestions);
            statement.setString(6, status);
            statement.setInt(7, score_id);

            statement.executeUpdate();

            System.out.println("edited data");

        } catch (ClassNotFoundException exception) {
            System.out.println("MySQL JDBC driver not found");
            exception.printStackTrace();
        } catch (SQLException exception) {
            System.out.println("Failed to connect to the database");
            exception.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                System.out.println("Failed to close the connection");
                exception.printStackTrace();
            }
        }
    }
}
