package com.quiz.View;

import org.apache.commons.text.WordUtils;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.quiz.Controller.ProfileInformationController;
import com.quiz.View.Theme.GlassPanel;
import com.quiz.View.Theme.ModernButton;
import com.quiz.View.Theme.ModernTextField;

public class ProfileView extends GlassPanel {

    private ArrayList<String[]> userData;
    private JPanel userCard;
    private int ID;

    public ProfileView(ArrayList<String[]> userdata) {
        this.userData = userdata;
        Color color = new Color(245, 245, 245, 200);
        setLayout(null);
        setBounds(250, 170, 1300, 680);

        // Create the card panel
        userCard = new JPanel();
        userCard.setBackground(new Color(75, 159, 150)); // Specify the custom background color
        userCard.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 150)));
        userCard.setBounds(50, 120, 700, 420); // Adjust the size and position as needed
        userCard.setLayout(null); // Use null layout for manual component positioning

        // Create the heading label
        JLabel headingLabel = new JLabel("PROFILE");
        headingLabel.setBounds(0, 5, 700, 40); // Adjust the position and size as needed
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        userCard.add(headingLabel);

        // Create labels for the fields
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 50, 100, 30);
        idLabel.setForeground(Color.WHITE);
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(idLabel);

        JLabel idText = new JLabel();
        idText.setBounds(140, 50, 150, 30);
        idText.setForeground(Color.WHITE);
        idText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(idText);

        // Create labels for the fields
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(30, 90, 100, 30);
        firstNameLabel.setForeground(Color.WHITE);
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(firstNameLabel);

        JLabel firstNameText = new JLabel();
        firstNameText.setBounds(140, 90, 150, 30);
        firstNameText.setForeground(Color.WHITE);
        firstNameText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(firstNameText);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(350, 90, 100, 30);
        lastNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(lastNameLabel);

        JLabel lastNameText = new JLabel();
        lastNameText.setBounds(460, 90, 150, 30);
        lastNameText.setForeground(Color.WHITE);
        lastNameText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(lastNameText);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(30, 130, 100, 30);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(usernameLabel);

        JLabel usernameText = new JLabel();
        usernameText.setBounds(140, 130, 150, 30);
        usernameText.setForeground(Color.WHITE);
        usernameText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(usernameText);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 170, 100, 30);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(emailLabel);

        JLabel emailText = new JLabel();
        emailText.setBounds(140, 170, 200, 30);
        emailText.setForeground(Color.WHITE);
        emailText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(emailText);

        final JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(30, 210, 100, 30);
        ageLabel.setForeground(Color.WHITE);
        ageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(ageLabel);

        final JLabel ageText = new JLabel();
        ageText.setBounds(140, 210, 150, 30);
        ageText.setForeground(Color.WHITE);
        ageText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(ageText);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(30, 250, 100, 30);
        roleLabel.setForeground(Color.WHITE);
        roleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(roleLabel);

        JLabel roleText = new JLabel();
        roleText.setBounds(140, 250, 150, 30);
        roleText.setForeground(Color.WHITE);
        roleText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(roleText);

        final JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 290, 100, 30);
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(addressLabel);

        final JLabel addressText = new JLabel();
        addressText.setBounds(140, 290, 300, 30);
        addressText.setForeground(Color.WHITE);
        addressText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(addressText);

        final JLabel phoneLabel = new JLabel("Phone No. :");
        phoneLabel.setBounds(30, 330, 100, 30);
        phoneLabel.setForeground(Color.WHITE);
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userCard.add(phoneLabel);

        final JLabel phoneText = new JLabel();
        phoneText.setBounds(140, 330, 150, 30);
        phoneText.setForeground(Color.WHITE);
        phoneText.setFont(new Font("Arial", Font.PLAIN, 14));
        userCard.add(phoneText);

        for (String data[] : userData) {
            this.ID = Integer.parseInt(data[0]);
            idText.setText(data[0]);
            firstNameText.setText(WordUtils.capitalize(data[1]));
            lastNameText.setText(WordUtils.capitalize(data[2]));
            usernameText.setText(WordUtils.capitalize(data[3]));
            emailText.setText(WordUtils.capitalize(data[4]));

            roleText.setText(WordUtils.capitalize(data[5]));
            if (data[7] == null || data[7].isEmpty()) {
                ageText.setText("not set");
            } else {
                ageText.setText(data[7]);
            }

            // Update the condition for addressText
            if (data[8] == null || data[8].isEmpty()) {
                addressText.setText("not set");
            } else {
                addressText.setText(data[8]);
            }

            // Update the condition for phoneText
            if (data[9] == null || data[9].isEmpty()) {
                phoneText.setText("not set");
            } else {
                phoneText.setText(data[9]);
            }

        }

        // Add the card panel to the ProfileView

        add(userCard);

        final JLabel TitleLabel = new JLabel("Add Information");
        TitleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        TitleLabel.setForeground(Color.WHITE);
        TitleLabel.setBackground(new Color(116, 202, 192));
        TitleLabel.setOpaque(true);
        TitleLabel.setVisible(true);
        TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TitleLabel.setBounds(850, 125, 400, 40);
        add(TitleLabel);

        final JLabel errorLabel = new JLabel("");
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setBackground(Color.PINK);
        errorLabel.setOpaque(true);
        errorLabel.setVisible(false);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setBounds(850, 175, 400, 25);
        add(errorLabel);

        final JTextField ageField = new ModernTextField("Age",
                color, color,
                color, color);
        ageField.setBounds(850, 225, 400, 40);
        add(ageField);

        final JTextField addressField = new ModernTextField("Address",
                color, color,
                color, color);
        addressField.setBounds(850, 285, 400, 40);
        add(addressField);

        final JTextField phoneField = new ModernTextField("Phone Number",
                color, color,
                color, color);
        phoneField.setBounds(850, 345, 400, 40);
        add(phoneField);

        ModernButton addButton = new ModernButton("Save");
        addButton.setBounds(850, 415, 400, 40);
        add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProfileInformationController controller = new ProfileInformationController(ageField, ageText,
                        addressField, addressText, phoneField, phoneText, ID, errorLabel);
                controller.actionPerformed(e);
            }
        });

        ModernButton changePasswordButton = new ModernButton("Edit Password");
        changePasswordButton.setBounds(850, 485, 400, 40);
        add(changePasswordButton);

        ModernButton deleteAccountButton = new ModernButton("Delete Account ?");
        deleteAccountButton.setBounds(425, 575, 250, 40);
        add(deleteAccountButton);

        ModernButton changeEmailButton = new ModernButton("Edit Email");
        changeEmailButton.setBounds(125, 575, 250, 40);
        add(changeEmailButton);

    }
}
