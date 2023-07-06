package com.quiz.Controller;

import javax.swing.JComponent;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.quiz.Model.ForgotPassword;
import com.quiz.View.ForgotPasswordView;
import com.quiz.View.LoginView;

import java.awt.Color;
import java.awt.Window;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class ForgotPasswordController {
    private Timer timer;
    private JTextField usernameField, passwordField, newPasswordField;
    private JLabel errorLabel;

    public ForgotPasswordController(JTextField usernameField, JTextField passwordField, JTextField newPasswordField,
            JLabel errorLabel) {
        this.usernameField = usernameField;
        this.passwordField = passwordField;
        this.newPasswordField = newPasswordField;
        this.errorLabel = errorLabel;
        timer = new Timer();
        validateUser();
    }

    public void validateUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String newPassword = newPasswordField.getText();
        Connection connection = null;
        PreparedStatement statement = null;

        if (username.isEmpty() || password.isEmpty() || newPassword.isEmpty()) {
            errorLabel.setText("form fields are empty");
            errorLabel.setVisible(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    errorLabel.setVisible(false);
                    timer.cancel();
                }
            }, 3000);
            return;
        } else {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create a connection to the database
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/quiz_application?user=root&password=SiberiaV2.0");

                statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
                statement.setString(1, username);
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    new ForgotPassword(username, password, newPassword);
                    errorLabel.setText("Password reset succesful");
                    errorLabel.setVisible(true);
                    errorLabel.setBackground(new Color(230, 255, 237)); // light green color
                    errorLabel.setForeground(new Color(0, 100, 0));

                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            errorLabel.setVisible(false);
                            Window window = SwingUtilities.getWindowAncestor(errorLabel);
                            if (window != null) {
                                window.dispose();
                            }
                            timer.cancel();
                        }
                    }, 3000);

                } else {
                    errorLabel.setText("invalid username");
                    errorLabel.setForeground(new Color(255, 0, 0));
                    errorLabel.setBackground(Color.PINK);
                    timer.schedule(new TimerTask() {

                        @Override
                        public void run() {
                            errorLabel.setVisible(false);
                            timer.cancel();
                        }
                    }, 3000);
                    return;
                }

            } catch (

            ClassNotFoundException exception) {
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
}
