package com.quiz.View;

import javax.swing.*;

import com.quiz.Model.EditPassword;
import com.quiz.View.Theme.ModernButton;

import com.quiz.View.Theme.ModernTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.TimerTask;

public class EditPasswordView extends JFrame {
    private JTextField usernameField;
    private JTextField passwordField;
    private JTextField newPasswordField;
    private JButton resetButton;
    private JPanel passwordPanel;
    JPanel panel;
    private JLabel emailLabel, errorLabel;
    private int id;
    private Timer timer;

    public EditPasswordView(int ID) {
        this.id = ID;

        setTitle("Edit Password");
        setSize(410, 280);
        setResizable(false);

        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(new Color(35, 178, 161));
        panel.setLayout(null);

        JLabel titleLabel = new JLabel(
                "Edit Password");
        titleLabel.setBounds(50, 10, 300, 50);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        errorLabel = new JLabel("");
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setBackground(Color.PINK);
        errorLabel.setOpaque(true);
        errorLabel.setVisible(false);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setBounds(50, 60, 300, 25);
        panel.add(errorLabel);

        passwordField = new ModernTextField("password", Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
        passwordField.setBounds(50, 100, 300, 20);

        newPasswordField = new ModernTextField("confirm-password", Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE);
        newPasswordField.setBounds(50, 150, 300, 20);

        resetButton = new ModernButton("edit password");
        resetButton.setBounds(50, 200, 300, 30);

        panel.add(passwordField);
        panel.add(newPasswordField);
        panel.add(resetButton);

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String password = passwordField.getText();
                String confirm_password = newPasswordField.getText();

                if (password.equals(confirm_password)) {
                    new EditPassword(id, password);

                    errorLabel.setText("Password edit succesful");
                    errorLabel.setVisible(true);
                    errorLabel.setBackground(new Color(230, 255, 237)); // light green color
                    errorLabel.setForeground(new Color(0, 100, 0));

                    timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            errorLabel.setVisible(false);

                            dispose();
                        }
                    });

                    timer.start();

                } else {
                    errorLabel.setText("password does not match");
                    errorLabel.setVisible(true);
                    errorLabel.setForeground(new Color(255, 0, 0));
                    errorLabel.setBackground(Color.PINK);
                    timer = new Timer(3000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            errorLabel.setVisible(false);

                        }
                    });

                    timer.start();
                }

            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {

        new EditPasswordView(2);

    }
}
