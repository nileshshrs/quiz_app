package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAccount {
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public DeleteAccount(int ID) {
        setID(19);

        deleteAccount(getID());
    }

    public void deleteAccount(int id) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "DELETE from users WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Account deleted");
            } else {
                System.out.println("Failed to delete account");
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
