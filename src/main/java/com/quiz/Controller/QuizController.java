package com.quiz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.Timer;



public class QuizController {

    JButton nextButton, prevButton;
    JLabel questionLabel, timerLabel;
    int CurrentIndex, ID, remainingTime, score;
    JRadioButton optionButton1, optionButton2, optionButton3, optionButton4;
    ButtonGroup buttonGroup;
    ArrayList<String[]> quizData;
    JPanel subjectPanel;
    Timer timer;
    double percentage;
    JProgressBar progressBar;

    public QuizController(JButton nextButton, JButton prevButton, JLabel questionLabel, ArrayList<String[]> quizData,
            ButtonGroup buttonGroup, JRadioButton optionButton1, JRadioButton optionButton2, JRadioButton optionButton3,
            JRadioButton optionButton4, JLabel timerLabel, JPanel subjectPanel, int ID, JProgressBar progressBar) {

        Collections.shuffle(quizData);
        this.nextButton = nextButton;
        this.prevButton = prevButton;
        this.questionLabel = questionLabel;
        this.quizData = quizData;
        this.buttonGroup = buttonGroup;
        this.optionButton1 = optionButton1;
        this.optionButton2 = optionButton2;
        this.optionButton3 = optionButton3;
        this.optionButton4 = optionButton4;
        this.timerLabel = timerLabel;
        this.subjectPanel = subjectPanel;
        this.ID = ID;
        this.CurrentIndex = 0;
        this.remainingTime = 20;
        this.score = 0;
        this.progressBar = progressBar;

        updateQuizView();
        setButtonActions();
        startTimer();


    }

    private void updateQuizView() {

        if (CurrentIndex >= 0 && CurrentIndex < quizData.size()) {
            String[] currentQuestion = quizData.get(CurrentIndex);
            questionLabel.setText("<html>" + currentQuestion[0] + "</html>");
            optionButton1.setText(currentQuestion[1]);
            optionButton2.setText(currentQuestion[2]);
            optionButton3.setText(currentQuestion[3]);
            optionButton4.setText(currentQuestion[4]);
            clearSelection();
            // System.out.println(ID);
        }
        if (CurrentIndex == quizData.size() - 1) {
            nextButton.setText("Submit");
        } else {
            nextButton.setText("Next");
        }

    }

    private void clearSelection() {
        buttonGroup.clearSelection();
    }

    private void setButtonActions() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                CurrentIndex++;
                if (CurrentIndex >= quizData.size()) {
                    // showScore();
                    remainingTime = 20;

                    subjectPanel.setVisible(true);
                    CurrentIndex = 0;
                    timer.stop();

                }
                updateQuizView();
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentIndex--;
                if (CurrentIndex < 0) {
                    CurrentIndex = 0;
                }
                updateQuizView();
            }
        });
    }


 

    // timer
    private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;
                if (remainingTime >= 0) {
                    timerLabel.setText("Time: " + remainingTime + " seconds");

                } else {
                    

                    subjectPanel.setVisible(true);
                    CurrentIndex = 0;
                    timer.stop();
                    timerLabel.setText("Time's up!");

                    // Call any method or perform any action when the timer ends
                }
            }
        });
        timer.start();
    }
}
