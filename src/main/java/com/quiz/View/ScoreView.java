package com.quiz.View;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.quiz.View.Theme.GlassPanel;
import com.quiz.View.Theme.ModernButton;

public class ScoreView extends GlassPanel {
    private JButton viewResult, printResult;

    public ScoreView(ArrayList<String[]> scoreData) {

        setLayout(null);
        setBounds(250, 170, 1300, 680);

        JLabel titleLabel = new JLabel("Your Quiz Scores");
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
        String[] columnNames = { "ID", "First Name", "Last Name", "username", "Score in %", "Correct Answers",
                "Total Questions", "Status" };
        tableModel.setColumnIdentifiers(columnNames);

        // Add the question data to the table model
        for (String[] rowData : scoreData) {
            tableModel.addRow(rowData);
        }
        JScrollPane scrollPane = new JScrollPane(table);
        int tableHeight = getHeight() - 150; // Subtract 100 for padding
        int scrollPaneHeight = tableHeight;
        int scrollPaneWidth = 1100;
        int scrollPaneX = 100; // Set the X position to 50 for left alignment
        int scrollPaneY = (getHeight() - scrollPaneHeight) / 2; // Calculate the Y position
        scrollPane.setBounds(scrollPaneX, scrollPaneY, scrollPaneWidth, scrollPaneHeight); // Set the bounds dynamically
        scrollPane.getViewport().setBackground(new Color(75, 159, 150));
        // Create a custom border with white color
        Border whiteBorder = BorderFactory.createLineBorder(new Color(54, 69, 79));
        // Set the viewport border
        scrollPane.setViewportBorder(whiteBorder);

        viewResult = new ModernButton("Check your Result");
        viewResult.setBounds(320, 620, 300, 50);
        viewResult.setFont(new Font("Arial", Font.BOLD, 16));

        printResult = new ModernButton("Print your Result");
        printResult.setBounds(720, 620, 300, 50);
        printResult.setFont(new Font("Arial", Font.BOLD, 16));

        add(viewResult);
        add(printResult);
        add(scrollPane);

    }

}
