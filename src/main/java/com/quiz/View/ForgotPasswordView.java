package com.quiz.View;

import javax.swing.*;

import com.quiz.Controller.ForgotPasswordController;
import com.quiz.View.Theme.ModernButton;
import com.quiz.View.Theme.ModernPasswordField;
import com.quiz.View.Theme.ModernTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField newPasswordField;
    private JButton resetButton;
    private JPanel passwordPanel;
    JPanel panel;
    private JLabel emailLabel, errorLabel;

    public ForgotPasswordView() {
        setTitle("Forgot Password");
        setSize(500, 390);

        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(new Color(35, 178, 161));
        panel.setLayout(null);

        JLabel titleLabel = new JLabel(
                "<HTML><center>Lost your password? Please enter your username address. You will be redirected to create a new password.</center></HTML>");
        titleLabel.setBounds(20, 20, 460, 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titleLabel);

        errorLabel = new JLabel("");
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setBackground(Color.PINK);
        errorLabel.setOpaque(true);
        errorLabel.setVisible(false);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setBounds(90, 80, 320, 25);
        panel.add(errorLabel);

        usernameField = new ModernTextField("username", Color.WHITE, Color.WHITE, Color.WHITE,
                Color.WHITE);
        usernameField.setBounds(90, 130, 320, 20);

        passwordField = new ModernPasswordField("password");
        passwordField.setBounds(90, 190, 320, 20);

        newPasswordField = new ModernPasswordField("new password");
        newPasswordField.setBounds(90, 250, 320, 20);

        resetButton = new ModernButton("reset password");
        resetButton.setBounds(90, 290, 320, 30);

        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(newPasswordField);
        panel.add(resetButton);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ForgotPasswordController(usernameField, passwordField, newPasswordField, errorLabel);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {

                new ForgotPasswordView();
            

    }
}
