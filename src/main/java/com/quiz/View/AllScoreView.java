
package com.quiz.View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.quiz.Controller.DeleteQuestionController;
import com.quiz.Controller.DeleteScoreController;
import com.quiz.Controller.EditQuestionController;

import com.quiz.View.Theme.GlassPanel;
import com.quiz.View.Theme.ModernButton;
import com.quiz.View.Theme.ModernTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllScoreView extends GlassPanel {
    private int scoreID;

    public AllScoreView(ArrayList<String[]> scoreData) {
        Color color = new Color(245, 245, 245, 200);
        setLayout(null);
        setBounds(250, 170, 1300, 680);

        JLabel titleLabel = new JLabel("Quiz Scores");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(550, 20, 200, 30);
        add(titleLabel);

        // Create a DefaultTableModel to hold the data for the JTable
        final DefaultTableModel tableModel = new DefaultTableModel();
        final JTable table = new JTable(tableModel);
        table.setBackground(new Color(75, 159, 150));
        table.setGridColor(new Color(54, 69, 79));
        table.setForeground(new Color(248, 248, 255));
        // Set the header background color
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setBackground(new Color(57, 121, 114));
        tableHeader.setForeground(new Color(248, 248, 255));
        tableHeader.setFont(new Font("Arial", Font.BOLD, 13));

        // Define the column names
        String[] columnNames = { "Quiz ID", "User ID", "First Name", "Last Name", "username", "email", "subject",
                "Score in %",
                "Correct Answers",
                "Total Questions", "Status" };
        tableModel.setColumnIdentifiers(columnNames);

        // Add the question data to the table model
        for (String[] rowData : scoreData) {
            tableModel.addRow(rowData);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        int tableHeight = getHeight() - 150; // Subtract 100 for padding
        int scrollPaneHeight = tableHeight;
        int scrollPaneWidth = 900;
        int scrollPaneX = 5; // Set the X position to 50 for left alignment
        int scrollPaneY = (getHeight() - scrollPaneHeight) / 2; // Calculate the Y position
        scrollPane.setBounds(scrollPaneX, scrollPaneY, scrollPaneWidth, scrollPaneHeight); // Set the bounds dynamically
        scrollPane.getViewport().setBackground(new Color(75, 159, 150));
        // Create a custom border with white color
        Border whiteBorder = BorderFactory.createLineBorder(new Color(54, 69, 79));
        // Set the viewport border
        scrollPane.setViewportBorder(whiteBorder);

        final JLabel errorLabel = new JLabel("");
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setBackground(Color.PINK);
        errorLabel.setOpaque(true);
        errorLabel.setVisible(false);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setBounds(950, 105, 300, 25);
        add(errorLabel);

        final JTextField useridField = new ModernTextField("Quiz ID",
                color, color,
                color, color);
        useridField.setBounds(950, 150, 300, 40);
        add(useridField);

        final JTextField subjectidField = new ModernTextField("Subject ID",
                color, color,
                color, color);
        subjectidField.setBounds(950, 205, 300, 40);
        add(subjectidField);

        final JTextField scoreField = new ModernTextField("Scores",
                color, color,
                color, color);
        scoreField.setBounds(950, 260, 300, 40);
        add(scoreField);

        final JTextField answerField = new ModernTextField("Correct Answers",
                color, color,
                color, color);
        answerField.setBounds(950, 315, 300, 40);
        add(answerField);

        final JTextField totalQuestionsField = new ModernTextField(
                "Total Questions",
                color, color, color, color);
        totalQuestionsField.setBounds(950, 370, 300, 40);
        add(totalQuestionsField);

        final JTextField statusField = new ModernTextField(
                "Status",
                color, color, color, color);
        statusField.setBounds(950, 425, 300, 40);
        add(statusField);

        ModernButton editButton = new ModernButton("Edit");
        editButton.setBounds(950, 500, 310, 35);
        add(editButton);
        

        ModernButton deleteButton = new ModernButton("Delete");
        deleteButton.setBounds(950, 555, 310, 35);
        add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteScoreController deleteScore = new DeleteScoreController(table, tableModel, errorLabel);
                deleteScore.actionPerformed(e);

                // int selectedRow = table.getSelectedRow();
                // if (selectedRow != -1) {
                // // Remove the selected row from the table model
                // tableModel.removeRow(selectedRow);
                // System.out.println("Row deleted: " + selectedRow);

                useridField.setText("");
                subjectidField.setText("");
                scoreField.setText("");
                answerField.setText("");
                totalQuestionsField.setText("");
                statusField.setText("");
                // }
            }
        });
     
    

        add(scrollPane);

    }

}
