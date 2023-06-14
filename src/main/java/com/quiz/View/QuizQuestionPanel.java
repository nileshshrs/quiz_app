package com.quiz.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import com.quiz.View.Theme.GlassPanel;

import java.awt.*;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.quiz.View.Theme.GlassPanel;


import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuizQuestionPanel extends GlassPanel {

    private ArrayList<String[]> QuestionData;
    private Map<String, Integer> subjectMap;



    public QuizQuestionPanel(ArrayList<String[]> questionData) {

        Color color = new Color(245, 245, 245, 200);
        this.QuestionData = questionData;
        setLayout(null);
        setBounds(250, 170, 1300, 680);

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
        String[] columnNames = { "Quiz Name", "Question", "Option 1", "Option 2", "Option 3", "Option 4",
                "Correct Answer" };
        tableModel.setColumnIdentifiers(columnNames);

        // Add the question data to the table model
        for (String[] rowData : QuestionData) {
            tableModel.addRow(rowData);
        }

        // Create a scroll pane to contain the table
        JScrollPane scrollPane = new JScrollPane(table);
        int tableHeight = getHeight() - 150; // Subtract 100 for padding
        int scrollPaneHeight = tableHeight;
        int scrollPaneWidth = 800;
        int scrollPaneX = 20; // Set the X position to 50 for left alignment
        int scrollPaneY = (getHeight() - scrollPaneHeight) / 2; // Calculate the Y position
        scrollPane.setBounds(scrollPaneX, scrollPaneY, scrollPaneWidth, scrollPaneHeight); // Set the bounds dynamically
        scrollPane.getViewport().setBackground(new Color(75, 159, 150));
        // Create a custom border with white color
        Border whiteBorder = BorderFactory.createLineBorder(new Color(54, 69, 79));
        // Set the viewport border
        scrollPane.setViewportBorder(whiteBorder);
        add(scrollPane);

        // table view ending here

    }
}
