package com.quiz.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.quiz.Model.EditQuestion;
import com.quiz.Model.EditScore;

public class EditScoreController implements ActionListener {

    private JTextField useridField;
    private JTextField subjectidField;
    private JTextField scoreField;
    private JTextField answerField;
    private JTextField totalQuestionsField;
    private JTextField statusField;
    private JLabel errorLabel;
    private DefaultTableModel tableModel;
    private int scoreID;

    public EditScoreController(int scoreID, JTextField useridField, JTextField subjectidField, JTextField scoreField,
            JTextField answerField, JTextField totalQuestionsField, JTextField statusField, JLabel errorLabel,
            DefaultTableModel tableModel) {
        this.useridField = useridField;
        this.subjectidField = subjectidField;
        this.scoreField = scoreField;
        this.answerField = answerField;
        this.totalQuestionsField = totalQuestionsField;
        this.statusField = statusField;
        this.errorLabel = errorLabel;
        this.tableModel = tableModel;
        this.scoreID = scoreID;
    }

    // Other methods and code for EditScoreController

    public void actionPerformed(ActionEvent event) {

        int userID = Integer.parseInt(useridField.getText());
        int subjectid = Integer.parseInt(subjectidField.getText());
        double score = Double.parseDouble(scoreField.getText());
        int Answers = Integer.parseInt(answerField.getText());
        int totalQuestions = Integer.parseInt(totalQuestionsField.getText());
        String status = statusField.getText().toUpperCase();

        System.out.println(scoreID);

        // // System.out.println("Question: " + Question);
        // // System.out.println("Option 1: " + Answer1);
        // // System.out.println("Option 2: " + Answer2);
        // // System.out.println("Option 3: " + Answer3);
        // // System.out.println("Option 4: " + Answer4);
        // // System.out.println("Correct Answer: " + CorrectAnswer);
        // // System.out.println("Selected Subject: " + SelectedSubject);
        // // System.out.println("Selected Subject ID: " + subjectID);

        final Timer timer = new Timer();
        try {
            String SQL = "SELECT * FROM user_score WHERE score_id = ?";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application",
                    "root",
                    "SiberiaV2.0");
            PreparedStatement stmt = con.prepareStatement(SQL,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            stmt.setInt(1, scoreID);

            ResultSet rs = stmt.executeQuery();

            // do the sql validation here when the database is created
            if (!rs.next()) {
                errorLabel.setForeground(new Color(255, 0, 0));
                errorLabel.setBackground(Color.PINK);
                errorLabel.setText("Question does not exists");
                errorLabel.setVisible(true);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        errorLabel.setForeground(new Color(255, 0, 0));
                        errorLabel.setBackground(Color.PINK);
                        errorLabel.setText("");
                        errorLabel.setVisible(false);
                        timer.cancel();

                    }
                }, 3000);
            } else {
                new EditScore(scoreID, userID, subjectid, score, Answers, totalQuestions, status);
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    String Value = (String) tableModel.getValueAt(i, 0); // Assuming the
                    if (Value.equals(String.valueOf(scoreID))) {
                        // Retrieve the existing values from the table
                        // Update the values of the matching row
                        tableModel.setValueAt(userID, i, 1); // Assuming subject is in the
                        // first column (index
                        // // 0)
                        tableModel.setValueAt(userID, i, 1);
                        tableModel.setValueAt(score, i, 7);
                        tableModel.setValueAt(Answers, i, 8);
                        tableModel.setValueAt(totalQuestions, i, 9);
                        tableModel.setValueAt(status, i, 10);
                        System.out.println("Row edited: " + i);
                        break; // Exit the loop after editing the row
                    }
                }
                errorLabel.setText("Question sucessfully edited.");
                errorLabel.setVisible(true);
                errorLabel.setBackground(new Color(230, 255, 237)); // light green color
                errorLabel.setForeground(new Color(0, 100, 0));

                useridField.setText("");
                subjectidField.setText("");
                scoreField.setText("");
                answerField.setText("");
                totalQuestionsField.setText("");

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        errorLabel.setText("");
                        errorLabel.setVisible(false);
                        timer.cancel();
                    }
                }, 3000);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
