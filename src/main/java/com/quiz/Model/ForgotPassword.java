package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ForgotPassword {
    private String username, password, newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ForgotPassword(String username, String password, String newPassword) {
        setUsername(username);
        setNewPassword(newPassword);
        setPassword(password);

        resetPassword(getUsername(), getPassword(), getNewPassword());
    }

    public void resetPassword(String username, String password, String newPassword) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "UPDATE users SET password = ? WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setString(2, username);


            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Password reset successful");
            } else {
                System.out.println("Failed to reset password");
            }

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
