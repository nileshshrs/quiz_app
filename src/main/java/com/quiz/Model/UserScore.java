package com.quiz.Model;

import java.util.ArrayList;
import java.sql.*;

public class UserScore {
    private ArrayList<String[]> userScore;

    public UserScore(int id) {
        retrieveUserScore(id);
    }

    public ArrayList<String[]> getUserScore() {
        return userScore;
    }

    private void retrieveUserScore(int ID) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "SELECT q.quiz_name, u.firstname, u.lastname, u.username, us.* " +
                    "FROM user_score us " +
                    "JOIN users u ON u.id = us.user_id " +
                    "JOIN quiz q ON q.quiz_id = us.quiz_id " +
                    "WHERE u.id = ?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);

            rs = statement.executeQuery();

            userScore = new ArrayList<>();

            while (rs.next()) {
                String quizName = rs.getString("quiz_name");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String username = rs.getString("username");

                int scoreId = rs.getInt("score_id");
                double score = rs.getDouble("score");
                int totalCorrectAnswers = rs.getInt("total_correct_answers");
                int totalQuestions = rs.getInt("total_questions");
                String passFailStatus = rs.getString("pass_fail_status");

                String[] rowData = {
                        String.valueOf(scoreId),
                        firstName,
                        lastName,
                        username,
                        String.valueOf(score),
                        String.valueOf(totalCorrectAnswers),
                        String.valueOf(totalQuestions),
                        passFailStatus
                };

                userScore.add(rowData);

                // System.out.println("Quiz Name: " + quizName);
                // System.out.println("User Name: " + firstName + " " + lastName);
                // System.out.println("Username: " + username);
                // System.out.println("Score ID: " + scoreId);
                // System.out.println("Score: " + score);
                // System.out.println("Total Correct Answers: " + totalCorrectAnswers);
                // System.out.println("Total Questions: " + totalQuestions);
                // System.out.println("Pass/Fail Status: " + passFailStatus);
                // System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection");
                e.printStackTrace();
            }
        }
    }
}
