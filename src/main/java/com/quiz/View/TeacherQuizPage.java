package com.quiz.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.quiz.View.Theme.Sidebar;

public class TeacherQuizPage extends JFrame {

    private JPanel currentPanel;

    // uncomment
    // private QuizQuestionPanel quizQuestionPanel; // Moved outside the constructor
    // uncomment
    public TeacherQuizPage(String username) {
        // System.out.println(username);
        setTitle("Quiz Application");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(35, 178, 161));

        JLabel applicationLabel = new JLabel("Quizzeria");
        applicationLabel.setBounds(750, 0, 500, 200);
        applicationLabel.setFont(new Font("Arial", Font.BOLD, 37));
        applicationLabel.setForeground(Color.white);
        contentPanel.add(applicationLabel);

        ImageIcon icon = null;
        try {
            URL imageUrl = getClass().getResource("/com/Assets/graduation hat.png");
            BufferedImage image = ImageIO.read(imageUrl);
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setBounds(650, 45, imageLabel.getPreferredSize().width, imageLabel.getPreferredSize().height);
            contentPanel.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // uncomment
        // quizQuestionPanel = new QuizQuestionPanel();
        // Initialize the quizQuestionPanel
        // uncomment
        Sidebar sidebar = new Sidebar();
        sidebar.addButton("My Profile");
        sidebar.addButton("Quiz Questions");
        sidebar.addButton("Take Quiz");
        sidebar.addButton("Your Scores");
        sidebar.addButton("All Scores");
        sidebar.addButton("logout");

        sidebar.setTitle("Quizzeria");

        sidebar.setButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = ((JButton) e.getSource()).getText();
                System.out.println("Clicked: " + buttonText);

                // Remove current panel from its parent container
                if (currentPanel != null && currentPanel.getParent() != null) {
                    currentPanel.getParent().remove(currentPanel);
                }

                // Show new panel
                if (buttonText.equals("Quiz Questions")) {
                    // uncomment
                    // contentPanel.add(quizQuestionPanel); // Add the panel back to the parent
                    // container
                    // quizQuestionPanel.setVisible(true);
                    // currentPanel = quizQuestionPanel;
                    // uncomment
                } else if (buttonText.equals("My Profile")) {
                    // uncomment
                    // Add code for My Profile panel
                    // uncomment
                } else {
                    currentPanel = null;
                    // Add code for other panels
                }

                // Repaint the parent container to reflect the changes
                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        sidebar.setBounds(40, 40, 200, getHeight() - 200);
        contentPanel.add(sidebar);
        // uncomment
        // contentPanel.add(quizQuestionPanel);
        // uncomment
        getContentPane().add(contentPanel);
        // uncomment
        // Set quiz panel as the default panel
        // currentPanel = quizQuestionPanel;
        // uncomment
        currentPanel.setVisible(true);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TeacherQuizPage("nilesh");
    }
}
