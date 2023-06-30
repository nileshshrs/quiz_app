package com.quiz.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class DeleteScoreController implements ActionListener {
    private JTable Table;
    private DefaultTableModel TableModel;
    private JLabel ErrorLabel;

    public DeleteScoreController(JTable table, DefaultTableModel tableModel, JLabel errorLabel) {
        this.Table = table;
        this.TableModel = tableModel;
        this.ErrorLabel = errorLabel;
    }

    public void actionPerformed(ActionEvent event) {

        int selectedRow = Table.getSelectedRow();

        final Timer timer = new Timer();
        // System.out.println(selectedRow);

        if (selectedRow != -1) {
            int scoreID = Integer.parseInt(Table.getValueAt(selectedRow, 0).toString());
  

            //new DeleteScore(scoreID);

            ErrorLabel.setText("Deleted Sucessfully.");
            ErrorLabel.setVisible(true);
            ErrorLabel.setBackground(new Color(230, 255, 237)); // light green color
            ErrorLabel.setForeground(new Color(0, 100, 0));
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ErrorLabel.setText("");
                    ErrorLabel.setVisible(false);
                    timer.cancel();
                }
            }, 3000);
            TableModel.removeRow(selectedRow);
        }

    }
}
