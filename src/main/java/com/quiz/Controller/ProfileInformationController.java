package com.quiz.Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.quiz.Model.ProfileInformation;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class ProfileInformationController implements ActionListener {

    private JTextField ageTextField, addressField, phoneField;
    private JLabel ageText, addressText, phoneText, ErrorLabel;
    private int ID;

    public ProfileInformationController(JTextField ageTextField, JLabel ageText, JTextField addressField,
            JLabel addressText, JTextField phoneField, JLabel phoneText, int ID, JLabel errorLabel) {
        this.ageTextField = ageTextField;
        this.addressField = addressField;
        this.phoneField = phoneField;
        this.ageText = ageText;
        this.addressText = addressText;
        this.phoneText = phoneText;
        this.ID = ID;
        this.ErrorLabel = errorLabel;
    }

    public void actionPerformed(ActionEvent e) {
        // Implement the desired action/event handling logic here
        final Timer timer = new Timer();
        String age = ageTextField.getText();
        String address = addressField.getText();
        String phonenumber = phoneField.getText();

        new ProfileInformation(ID, age, address, phonenumber);

        ErrorLabel.setText("Profile updated Sucessfully.");
        ErrorLabel.setVisible(true);
        ErrorLabel.setBackground(new Color(230, 255, 237)); // light green color
        ErrorLabel.setForeground(new Color(0, 100, 0));

        if (age.isEmpty()) {
            ageText.setText("not set");
        } else {

            ageText.setText(age);
        }

        if (address.isEmpty()) {
            addressText.setText("not set");
        } else {

            addressText.setText(address);

        }

        if (phonenumber.isEmpty()) {
            phoneText.setText("not set");
        } else {

            phoneText.setText(phonenumber);

        }

        ageTextField.setText("");
        addressField.setText("");
        phoneField.setText("");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ErrorLabel.setText("");
                ErrorLabel.setVisible(false);
                timer.cancel();
            }
        }, 3000);
    }

}
