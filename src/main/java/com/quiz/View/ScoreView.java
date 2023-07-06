package com.quiz.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.quiz.View.Theme.GlassPanel;
import com.quiz.View.Theme.ModernButton;

public class ScoreView extends GlassPanel {
    JButton viewResult;
    JButton printResult;
    private String[] Result;

    public ScoreView(ArrayList<String[]> scoreData) {

        setLayout(null);
        setBounds(250, 170, 1300, 680);

        JLabel titleLabel = new JLabel("Your Quiz Scores");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(550, 20, 200, 30);
        add(titleLabel);

        JLabel noteLabel = new JLabel("Please select a row to view/print the result.");
        noteLabel.setFont(new Font("Arial", Font.BOLD, 14));
        noteLabel.setForeground(Color.WHITE);
        noteLabel.setBounds(100, 50, 400, 30);
        add(noteLabel);
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

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Check if the selection is not adjusting (to avoid duplicate events)
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        // Retrieve the values from the selected row

                        String quiz_id = table.getValueAt(selectedRow, 1).toString();
                        String firstname = table.getValueAt(selectedRow, 2).toString();
                        String lastname = table.getValueAt(selectedRow, 3).toString();
                        String username = table.getValueAt(selectedRow, 4).toString();
                        String score = table.getValueAt(selectedRow, 5).toString();
                        String correctAnswer = table.getValueAt(selectedRow, 6).toString();
                        String totalquestions = table.getValueAt(selectedRow, 6).toString();
                        String status = table.getValueAt(selectedRow, 6).toString();

                        Result = new String[] { quiz_id, firstname, lastname, username, score, correctAnswer,
                                totalquestions, status };
                        // Do something with the retrieved values

                    }
                }
            }
        });

        viewResult = new ModernButton("Check your Result");
        viewResult.setBounds(320, 620, 300, 50);
        viewResult.setFont(new Font("Arial", Font.BOLD, 16));
        viewResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                new ReportCardView(Result);

            }

        });

        printResult = new ModernButton("Print your Result");
        printResult.setBounds(720, 620, 300, 50);
        printResult.setFont(new Font("Arial", Font.BOLD, 16));
        printResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                new PrintReportCard(Result);

            }

        });

        add(viewResult);
        add(printResult);
        add(scrollPane);

    }

}
