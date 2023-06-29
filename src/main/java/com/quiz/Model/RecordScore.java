
package com.quiz.Model;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class RecordScore {

    public void recordScore(int user_id, int quiz_id, double score, int totalCorrectAnswers, int totalQuestions,
            String passFailStatus) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            // Create table if it doesn't exist
            String sql = "CREATE TABLE IF NOT EXISTS user_score ("
                    + "score_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "user_id INT,"
                    + "quiz_id INT,"
                    + "score DOUBLE,"
                    + "total_correct_answers INT,"
                    + "total_questions INT,"
                    + "pass_fail_status VARCHAR(10),"
                    + "FOREIGN KEY (user_id) REFERENCES users (id),"
                    + "FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)"
                    + ")";

            statement = connection.prepareStatement(sql);
            statement.executeUpdate();
            System.out.println("database created");

            String SQL = "INSERT INTO user_score (user_id, quiz_id, score, total_correct_answers, total_questions, pass_fail_status) "
                    +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, user_id);
            statement.setInt(2, quiz_id);
            statement.setDouble(3, score);
            statement.setInt(4, totalCorrectAnswers);
            statement.setInt(5, totalQuestions);
            statement.setString(6, passFailStatus);
            statement.executeUpdate();

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

    // public ArrayList<String[]> getUserScore() {
    //     return userScore;
    // }

    // public void setUserScore(ArrayList<String[]> userScore) {
    //     this.userScore = userScore;
    // }

    // public void retrieveUserScore(int ID) {
    //     Connection connection = null;
    //     PreparedStatement statement = null;

    //     try {
    //         Class.forName("com.mysql.cj.jdbc.Driver");
    //         connection = DriverManager.getConnection(
    //                 "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
    //         String sql = "SELECT q.quiz_name, u.firstname, u.lastname, u.username, us.* " +
    //                 "FROM user_score us " +
    //                 "JOIN users u ON u.id = us.user_id " +
    //                 "JOIN quiz q ON q.quiz_id = us.quiz_id " +
    //                 "WHERE u.id = ?";

    //         statement = connection.prepareStatement(sql);
    //         statement.setInt(1, ID);

    //         ResultSet rs = statement.executeQuery();

    //         while (rs.next()) {
    //             String quizName = rs.getString("quiz_name");
    //             String firstName = rs.getString("firstname");
    //             String lastName = rs.getString("lastname");

    //             String username = rs.getString("username");

    //             // Access other columns from the user_score table using the appropriate data
    //             // types
    //             int scoreId = rs.getInt("score_id");
    //             int score = rs.getInt("score");
    //             int totalCorrectAnswers = rs.getInt("total_correct_answers");
    //             int totalQuestions = rs.getInt("total_questions");
    //             String passFailStatus = rs.getString("pass_fail_status");

    //             String rowData[] = {
    //                     String.valueOf(scoreId),
    //                     firstName,
    //                     lastName,
    //                     username,
    //                     String.valueOf(score),
    //                     String.valueOf(totalCorrectAnswers),
    //                     String.valueOf(totalQuestions),
    //                     passFailStatus
    //             };
    //             // System.out.println(Arrays.toString(rowData));
    //             userScore.add(rowData);

    //             // Process the fetched data as desired
    //             System.out.println("Quiz Name: " + quizName);
    //             System.out.println("User Name: " + firstName + " " + lastName);
    //             System.out.println("Username: " + username);
    //             System.out.println("Score ID: " + scoreId);
    //             System.out.println("Score: " + score);
    //             System.out.println("Total Correct Answers: " + totalCorrectAnswers);
    //             System.out.println("Total Questions: " + totalQuestions);
    //             System.out.println("Pass/Fail Status: " + passFailStatus);
    //             System.out.println();
    //         }
    //     } catch (ClassNotFoundException e) {
    //         System.out.println("MySQL JDBC driver not found");
    //         e.printStackTrace();
    //     } catch (SQLException e) {
    //         System.out.println("Failed to connect to the database");
    //         e.printStackTrace();
    //     } finally {
    //         try {
    //             if (connection != null) {
    //                 connection.close();
    //             }
    //         } catch (SQLException e) {
    //             System.out.println("Failed to close the connection");
    //             e.printStackTrace();
    //         }
    //     }
    // }

}
