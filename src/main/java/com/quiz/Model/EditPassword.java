package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditPassword {
    private int id;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public EditPassword(int id, String password) {
        setId(id);
        setPassword(password);

        updatePassword(getId(), getPassword());

    }

    public void updatePassword(int id, String password) {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println(password);
            System.out.println(id);
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "UPDATE users SET password = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, password);
            statement.setInt(2, id);

            statement.executeUpdate();

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
