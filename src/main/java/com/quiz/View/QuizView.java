package com.quiz.View;

import javax.swing.*;

import com.quiz.Model.Quiz;
import com.quiz.View.Theme.GlassPanel;
import com.quiz.View.Theme.ModernButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuizView extends GlassPanel {
    private JPanel subjectPanel;
    private ArrayList<JButton> quizButtons;

    private JLabel questionLabel, timerLabel, subjectTitleLabel, progressLabel; // Added timer label
    private JButton nextButton, prevButton;
    private JRadioButton optionButton1, optionButton2, optionButton3, optionButton4;
    private ButtonGroup buttonGroup;
    private int ID;
    private JProgressBar progressBar;

    public QuizView(int ID) {

        this.ID = ID;
        setLayout(null);
        setBounds(250, 170, 1300, 680);

        subjectPanel = new JPanel();
        subjectPanel.setLayout(null);
        subjectPanel.setBounds(0, 0, getWidth(), getHeight());
        subjectPanel.setBackground(new Color(116, 202, 192));
        subjectPanel.setVisible(true);

        add(subjectPanel);

        optionButton1 = new JRadioButton("Option 1");
        optionButton1.setBounds(350, 250, 800, 30);
        optionButton1.setBackground(new Color(116, 202, 192));
        optionButton1.setEnabled(false);
        optionButton1.setFocusable(false);
        optionButton1.setRequestFocusEnabled(false);
        optionButton1.setFont(new Font("Arial", Font.BOLD, 18));
        optionButton1.setForeground(Color.WHITE);
        add(optionButton1);

        optionButton2 = new JRadioButton("Option 2");
        optionButton2.setBounds(350, 300, 800, 30);
        optionButton2.setBackground(new Color(116, 202, 192));
        optionButton2.setEnabled(false);
        optionButton2.setFocusable(false);
        optionButton2.setRequestFocusEnabled(false);
        optionButton2.setFont(new Font("Arial", Font.BOLD, 18));
        optionButton2.setForeground(Color.WHITE);
        add(optionButton2);

        optionButton3 = new JRadioButton("Option 3");
        optionButton3.setBounds(350, 350, 800, 30);
        optionButton3.setBackground(new Color(116, 202, 192));
        optionButton3.setEnabled(false);
        optionButton3.setFocusable(false);
        optionButton3.setRequestFocusEnabled(false);
        optionButton3.setFont(new Font("Arial", Font.BOLD, 18));
        optionButton3.setForeground(Color.WHITE);
        add(optionButton3);

        optionButton4 = new JRadioButton("Option 4");
        optionButton4.setBounds(350, 400, 800, 30);
        optionButton4.setBackground(new Color(116, 202, 192));
        optionButton4.setEnabled(false);
        optionButton4.setFocusable(false);
        optionButton4.setRequestFocusEnabled(false);
        optionButton4.setFont(new Font("Arial", Font.BOLD, 18));
        optionButton4.setForeground(Color.WHITE);
        add(optionButton4);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(optionButton1);
        buttonGroup.add(optionButton2);
        buttonGroup.add(optionButton3);
        buttonGroup.add(optionButton4);

        quizButtons = new ArrayList<>();
        quizButtons.add(createQuizButton("Start Quiz", 430, 250));

        // titleLabel = new JLabel("");
        // titleLabel.setBounds(750, 30, 300, 40);
        // add(titleLabel);

        subjectTitleLabel = new JLabel("Take Quiz !");
        subjectTitleLabel.setBounds(550, 70, 300, 40);
        subjectPanel.add(subjectTitleLabel);
        subjectTitleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        subjectTitleLabel.setForeground(Color.WHITE);

        questionLabel = new JLabel("This is a question label");
        questionLabel.setBounds(300, 150, 800, 60);
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(questionLabel);

        timerLabel = new JLabel("Time Remainging: 20 seconds");
        timerLabel.setBounds(450, 60, 300, 20);
        timerLabel.setForeground(Color.white);
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(timerLabel);

        progressLabel = new JLabel("Your Quiz Progress");
        progressLabel.setBounds(1090, 560, 150, 30);
        progressLabel.setForeground(Color.WHITE);
        progressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        add(progressLabel);

        progressBar = new JProgressBar(JProgressBar.VERTICAL);
        progressBar.setBounds(1150, 150, 20, 400);
        progressBar.setStringPainted(true);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setValue(0);
        add(progressBar);

        nextButton = new ModernButton("Next");
        nextButton.setBounds(540, 500, 100, 40);
        add(nextButton);

        prevButton = new ModernButton("Previous");
        prevButton.setBounds(420, 500, 100, 40);
        add(prevButton);

        setVisible(false);
    }

    private JButton createQuizButton(String buttonText, int x, int y) {
        JButton button = new ModernButton(buttonText);
        button.setBounds(x, y, 400, 90);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // JButton clickedButton = (JButton) e.getSource();
                // String buttonText = clickedButton.getText();

                nextButton.setEnabled(true);
                nextButton.setText("Next");
                prevButton.setEnabled(true);
                // titleLabel.setText(buttonText);

                // Retrieve quiz data based on the button text
                Quiz quiz = new Quiz();

                ArrayList<String[]> quizData = quiz.getQuizData();
                // Inside the ActionListener for the quiz button
                //new QuizController(nextButton, prevButton, questionLabel, quizData, buttonGroup, optionButton1,
                        //optionButton2, optionButton3, optionButton4, timerLabel, subjectPanel, ID, progressBar);

                optionButton1.setEnabled(true);
                optionButton1.setFocusable(true);
                optionButton1.setRequestFocusEnabled(true);

                optionButton2.setEnabled(true);
                optionButton2.setFocusable(true);
                optionButton2.setRequestFocusEnabled(true);

                optionButton3.setEnabled(true);
                optionButton3.setFocusable(true);
                optionButton3.setRequestFocusEnabled(true);

                optionButton4.setEnabled(true);
                optionButton4.setFocusable(true);
                optionButton4.setRequestFocusEnabled(true);

                setVisible(true);
                subjectPanel.setVisible(false);
            }
        });
        subjectPanel.add(button);
        return button;
    }

}
