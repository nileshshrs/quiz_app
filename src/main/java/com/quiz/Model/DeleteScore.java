package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteScore {
    private int ScoreID;
    public DeleteScore(int scoreID) {
        this.ScoreID= scoreID;

        deleteScore(ScoreID);
    }

    public void deleteScore(int ScoreID) {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "DELETE FROM user_score WHERE score_id = ? ";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            statement = connection.prepareStatement(sql);
            statement.setInt(1, ScoreID);

            statement.executeUpdate();
            System.out.println("Data Deleted.");
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
