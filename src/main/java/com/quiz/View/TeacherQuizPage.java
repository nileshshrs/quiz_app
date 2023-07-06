package com.quiz.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.quiz.Model.AllUserScores;
import com.quiz.Model.Profile;
import com.quiz.Model.QuizQuestionModel;
import com.quiz.Model.UserScore;
import com.quiz.View.Theme.Sidebar;

public class TeacherQuizPage extends JFrame {

    private JPanel currentPanel, contentPanel;
    private QuizQuestionPanel quizQuestionPanel;
    private String USERNAME;
    private int id;
    private Profile profileData;
    private UserScore userscore;
    private AllUserScores alluserscores;
    private JLabel timeLabel; // Declare the time label as a class member
    private Timer timer; // Timer for updating the time label
    private JLabel dateLabel;

    public TeacherQuizPage(String username, int ID) {
        this.id = ID;
        this.USERNAME = username;
        this.profileData = new Profile(USERNAME);
        this.userscore = new UserScore(ID);
        setTitle("Quiz Application");
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBackground(new Color(35, 178, 161));

        JLabel applicationLabel = new JLabel("Quizzeria");
        applicationLabel.setBounds(800, 0, 500, 200);
        applicationLabel.setFont(new Font("Arial", Font.BOLD, 37));
        applicationLabel.setForeground(Color.WHITE);
        contentPanel.add(applicationLabel);

        JLabel welcomeLabel = new JLabel("Welcome, " + USERNAME + "!");
        welcomeLabel.setBounds(50, 0, 500, 50);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.WHITE);
        contentPanel.add(welcomeLabel);

        timeLabel = new JLabel();
        timeLabel.setBounds(1350, 0, 200, 50);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        timeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        timeLabel.setForeground(Color.WHITE);
        contentPanel.add(timeLabel);

        dateLabel = new JLabel();
        dateLabel.setBounds(1350, 30, 200, 50);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        dateLabel.setForeground(Color.WHITE);
        contentPanel.add(dateLabel);

        // Start the timer to update the time label
        startTimer();

        ImageIcon icon = null;
        try {
            URL imageUrl = getClass().getResource("/com/assets/graduation hat.png");
            BufferedImage image = ImageIO.read(imageUrl);
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            icon = new ImageIcon(resizedImage);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setBounds(700, 45, imageLabel.getPreferredSize().width, imageLabel.getPreferredSize().height);
            contentPanel.add(imageLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // getting quiz data

        QuizQuestionModel quizQuestionModel = new QuizQuestionModel();
        final ArrayList<String[]> quizData = quizQuestionModel.getQuizData();

        // getting profile data

        quizQuestionPanel = new QuizQuestionPanel(quizData);

        // quiz panel

        final QuizView quiz = new QuizView(id);

        Sidebar sidebar = new Sidebar();
        sidebar.addButton("My Profile");
        sidebar.addButton("Quiz Questions");
        sidebar.addButton("Take Quiz");
        sidebar.addButton("Your Scores");
        sidebar.addButton("All Scores");
        sidebar.addButton("Log Out");

        sidebar.setTitle("Quizzeria");

        sidebar.setButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = ((JButton) e.getSource()).getText();
                System.out.println("Clicked: " + buttonText);

                if (currentPanel != null && currentPanel.getParent() != null) {
                    currentPanel.getParent().remove(currentPanel);
                }

                if (buttonText.equals("Quiz Questions")) {
                    contentPanel.add(quizQuestionPanel);
                    quizQuestionPanel.setVisible(true);
                    currentPanel = quizQuestionPanel;
                } else if (buttonText.equals("My Profile")) {
                    ArrayList<String[]> userData = profileData.getUserData(); // Retrieve updated profile data
                    ProfileView profile = new ProfileView(userData);
                    currentPanel = profile;
                    contentPanel.add(currentPanel);
                } else if (buttonText.equals("Your Scores")) {
                    setScorePanel(id);
                } else if (buttonText.equals("Take Quiz")) {
                    currentPanel = quiz;
                    contentPanel.add(currentPanel);
                } else if (buttonText.equals("All Scores")) {
                    setAllScorePanel();

                }

                else if (buttonText.equals("Log Out")) {
                    disposeWindow();
                    return;
                } else {
                    currentPanel = null;
                }

                contentPanel.revalidate();
                contentPanel.repaint();
            }
        });

        sidebar.setBounds(20, 170, 200,

                getHeight() - 320);
        contentPanel.add(sidebar);
        contentPanel.add(quiz);

        getContentPane().add(contentPanel);

        currentPanel = quiz;
        currentPanel.setVisible(true);

        setVisible(true);
    }

    private void setScorePanel(int id) {
        this.userscore = new UserScore(id);
        ArrayList<String[]> scoreData = userscore.getUserScore();

        currentPanel = new ScoreView(scoreData);
        contentPanel.add(currentPanel);
    }

    private void setAllScorePanel() {
        this.alluserscores = new AllUserScores();
        ArrayList<String[]> scoreData = alluserscores.getUserScore();

        currentPanel = new AllScoreView(scoreData);
        contentPanel.add(currentPanel);

    }

    // logout
    private void disposeWindow() {
        new LoginView();
        this.dispose();
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Get the current time and date
                Date currentTime = new Date();
                Date currentDate = new Date();
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
                String timeString = timeFormat.format(currentTime);
                String dateString = dateFormat.format(currentDate);

                timeLabel.setText(timeString);
                dateLabel.setText(dateString);
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    public static void main(String[] args) {
        new TeacherQuizPage("nilesh", 2);
    }
}
