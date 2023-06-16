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

import com.quiz.Model.AddQuizQuestions;

public class AddQuestionController implements ActionListener {
    private JTextField QuestionField;
    private JTextField OptionField1;
    private JTextField OptionField2;
    private JTextField OptionField3;
    private JTextField OptionField4;
    private JTextField CorrectAnswerField;
    private String SelectedSubject;
    private int SelectedSubjectId;
    private JLabel ErrorLabel;
    private DefaultTableModel TableModel;

    public AddQuestionController(JTextField questionField, JTextField optionField1, JTextField optionField2,
            JTextField optionField3, JTextField optionField4, JTextField correctAnswerField, String selectedSubject,
            int selectedSubjectId, JLabel errorLabel, DefaultTableModel tableModel) {
        this.QuestionField = questionField;
        this.OptionField1 = optionField1;
        this.OptionField2 = optionField2;
        this.OptionField3 = optionField3;
        this.OptionField4 = optionField4;
        this.CorrectAnswerField = correctAnswerField;
        this.SelectedSubject = selectedSubject;
        this.SelectedSubjectId = selectedSubjectId;
        this.ErrorLabel = errorLabel;
        this.TableModel = tableModel;
    }

    // recieving data for validation
    public void actionPerformed(ActionEvent event) {

        String Question = QuestionField.getText().toLowerCase();
        String Answer1 = OptionField1.getText().toLowerCase();
        String Answer2 = OptionField2.getText().toLowerCase();
        String Answer3 = OptionField3.getText().toLowerCase();
        String Answer4 = OptionField4.getText().toLowerCase();
        String CorrectAnswer = CorrectAnswerField.getText().toLowerCase();
        int subjectID = SelectedSubjectId;
        String selectedSubject = SelectedSubject;

        String[] Data = { selectedSubject, Question,
                Answer1,
                Answer2,
                Answer3,
                Answer4,
                CorrectAnswer };

        final Timer timer = new Timer();
        // final Component sourceComponent = (Component) event.getSource();

        if (Question.isEmpty() || Answer1.isEmpty() || Answer2.isEmpty() || Answer3.isEmpty() || Answer4.isEmpty()
                || CorrectAnswer.isEmpty()) {
            ErrorLabel.setText("form fields cannot be empty");
            ErrorLabel.setVisible(true);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ErrorLabel.setVisible(false);
                    timer.cancel();
                }
            }, 3000);
        }
        // add database validation for questions
        else {
            try {
                String SQL = "SELECT * FROM questions WHERE question_text = ?";
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz_application", "root",
                        "SiberiaV2.0");
                PreparedStatement stmt = con.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                stmt.setString(1, Question);

                ResultSet rs = stmt.executeQuery();

                // do the sql validation here when the database is created
                if (rs.next()) {
                    ErrorLabel.setText("Question already exists");
                    ErrorLabel.setVisible(true);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ErrorLabel.setText("");
                            ErrorLabel.setVisible(false);
                            timer.cancel();

                        }
                    }, 3000);
                } //
                else if (Question.isEmpty() || Answer1.isEmpty() || Answer1.isEmpty() || Answer2.isEmpty()
                        || Answer3.isEmpty() || Answer4.isEmpty() || CorrectAnswer.isEmpty()) {
                    ErrorLabel.setText("Fields cannot be empty");
                    ErrorLabel.setVisible(true);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ErrorLabel.setText("");
                            ErrorLabel.setVisible(false);
                            timer.cancel();
                        }
                    }, 3000);

                } else {

                    new AddQuizQuestions(Question, Answer1, Answer2, Answer3, Answer4, CorrectAnswer, subjectID);

                    ErrorLabel.setText("Question has been added.");
                    ErrorLabel.setVisible(true);
                    ErrorLabel.setBackground(new Color(230, 255, 237)); // light green color
                    ErrorLabel.setForeground(new Color(0, 100, 0));

                    TableModel.addRow(Data);

                    QuestionField.setText("");
                    OptionField1.setText("");
                    OptionField2.setText("");
                    OptionField3.setText("");
                    OptionField4.setText("");
                    CorrectAnswerField.setText("");

                    // Close the view after a delay
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            ErrorLabel.setText("");
                            ErrorLabel.setVisible(false);
                            timer.cancel();
                        }
                    }, 3000);
                }

                // do this in else block

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}