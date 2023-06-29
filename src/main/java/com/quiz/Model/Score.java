package com.quiz.Model;

import java.sql.*;

public class Score {
    // nilesh
    public void recordScore(int user_id, int quiz_id, double score, int totalCorrectAnswers, int totalQuestions,
            String passFailStatus) {
        // System.out.println("User ID: " + user_id);
        // System.out.println("Quiz ID: "+quiz_id);
        // System.out.println("Score: "+ score + "%");
        // System.out.println("Correct Answers: "+ totalCorrectAnswers);
        // System.out.println("Number of Questions: "+ totalQuestions);
        // System.out.println("Status: "+ passFailStatus);

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "CREATE TABLE IF NOT EXISTS user_score ("
                    + "score_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "user_id INT,"
                    + "quiz_id INT,"
                    + "score INT,"
                    + "total_correct_answers INT,"
                    + "total_questions INT,"
                    + "pass_fail_status VARCHAR(10),"
                    + "FOREIGN KEY (user_id) REFERENCES users (id),"
                    + "FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)"
                    + ")";

             statement = connection.prepareStatement(sql);
             statement.executeUpdate();
             System.out.println("database created");
            // Create table if it doesn't exist

            System.out.println("Inserted data into the database!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Failed to close the connection");
                e.printStackTrace();
            }
        }
    }
    // nilesh

}
