package com.quiz.View;

import javax.swing.*;

import com.quiz.View.Theme.ModernButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.*;
import java.util.ArrayList;

public class ReportCardView extends JFrame {

    private JPanel contentPanel;

    public ReportCardView(String[] scoreData) {
        setTitle("Report Card");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(35, 178, 161));

        contentPanel = new JPanel();
        contentPanel.setBounds(45, 50, 500, 500);
        contentPanel.setBackground(new Color(245, 245, 245));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel);

        JLabel titleLabel = new JLabel("Quiz Report");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        String[] columnNames = { "Information", "Grade" };
        Object[][] data = {
                { "Quiz ID", scoreData[0] },
                { "First Name", scoreData[1] },
                { "Last Name", scoreData[2] },
                { "Username", scoreData[3] },
                { "Score", scoreData[4] + "%" },
                { "Correct Answers", scoreData[5] },
                { "Total Questions", scoreData[6] },
                { "Status", scoreData[7] }
        };
        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(51);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(400, table.getRowHeight() * table.getRowCount())); // Set preferred
                                                                                                     // size based on
                                                                                                     // row height and
                                                                                                     // row count
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Add a print button
        JButton printButton = new ModernButton("close");
        printButton.setBounds(250, 560, 100, 30);
        add(printButton);

        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        setVisible(true);
    }
}
