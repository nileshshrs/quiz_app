package com.quiz.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditEmail {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public EditEmail(String email, int ID) {
        setEmail(email);
        setID(ID);

        updateEmail(getEmail(), getID());
    }

    public void updateEmail(String email, int ID){
            Connection connection = null;
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");
            String sql = "UPDATE users SET email = ? WHERE ID = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setInt(2, ID);


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
