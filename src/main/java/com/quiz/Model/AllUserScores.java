package com.quiz.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AllUserScores {
    private ArrayList<String[]> allUserScore;

    public AllUserScores() {
        retrieveAllScores();
    }

    public ArrayList<String[]> getUserScore() {
        return allUserScore;
    }

    public void retrieveAllScores() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "SELECT q.quiz_name, u.firstname, u.lastname, u.username, u.email, us.* " +
                    "FROM user_score us " +
                    "JOIN users u ON u.id = us.user_id " +
                    "JOIN quiz q ON q.quiz_id = us.quiz_id";

            statement = connection.prepareStatement(sql);

            rs = statement.executeQuery();

            allUserScore = new ArrayList<>();

            while (rs.next()) {
                String quizName = rs.getString("quiz_name");
                int userID= rs.getInt("user_id");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String username = rs.getString("username");
                String email = rs.getString("email");
                int scoreId = rs.getInt("score_id");
                double score = rs.getDouble("score");
                int totalCorrectAnswers = rs.getInt("total_correct_answers");
                int totalQuestions = rs.getInt("total_questions");
                String passFailStatus = rs.getString("pass_fail_status");

                String[] rowData = {
                        String.valueOf(scoreId),
                        String.valueOf(userID),
                        firstName,
                        lastName,
                        username,
                        email,
                        quizName,
                        String.valueOf(score),
                        String.valueOf(totalCorrectAnswers),
                        String.valueOf(totalQuestions),
                        passFailStatus
                };

                // System.out.println(Arrays.toString(rowData));
                allUserScore.add(rowData);

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

    public static void main(String[] args) {
        new AllUserScores();
    }
}
