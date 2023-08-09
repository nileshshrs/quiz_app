package com.quiz.View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.quiz.Model.DeleteAccount;
import com.quiz.View.Theme.ModernButton;
import com.quiz.View.Theme.ModernTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DeleteAccountView extends JFrame {
    private String username;
    private int ID;
    private JTextField usernameField;

    public DeleteAccountView(int id, String USERNAME) {
        this.ID = id;
        this.username = USERNAME;
        setTitle("Delete Account");
        setBounds(100, 100, 410, 240);
        setLocationRelativeTo(null);


        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(35, 178, 161));
        setContentPane(contentPane);

        final JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setBackground(Color.PINK);
        errorLabel.setOpaque(true);
        errorLabel.setVisible(false);
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setBounds(60, 20, 280, 25);
        contentPane.add(errorLabel);

        JLabel confirmLabel = new JLabel("<HTML><center>To confirm, type " + "'" + username + "'"
                + " in the box below:</center></HTML>");
        confirmLabel.setBounds(60, 55, 280, 30);
        confirmLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmLabel.setForeground(Color.WHITE);
        confirmLabel.setFont(new Font("Arial", Font.BOLD, 15));
        contentPane.add(confirmLabel);

        usernameField = new ModernTextField("enter your username here...", Color.WHITE, Color.WHITE, Color.WHITE,
                Color.WHITE);
        usernameField.setBounds(60, 110, 280, 20);
        contentPane.add(usernameField);

        JButton deleteButton = new ModernButton("Delete");
        deleteButton.setBounds(60, 150, 280, 35);
        contentPane.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                if (enteredUsername.equals(username)) {
                    new DeleteAccount(ID);
                    closeIndependentFrames();
                    dispose();
                    new LoginView();
                } else {
                    errorLabel.setText("Username is incorrect");
                    errorLabel.setVisible(true);
                }
            }
        });

        setVisible(true);
    }

    private void closeIndependentFrames() {
        Window[] windows = Frame.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame && window != this && !(window instanceof DeleteAccountView)) {
                new DeleteAccount(ID);
                window.dispose();
            }
        }
    }

    public static void main(String[] args) {
        new DeleteAccountView(12, "ava");

    }
}
