package com.quiz.Model;

import java.util.ArrayList;

public class ProfileTest {
    public static void main(String[] args) {
        // Provide a username to retrieve the profile information
        String username = "avarittia";

        // Create a Profile object and retrieve the profile information
        Profile profile = new Profile(username);

        // Get the retrieved profile data
        ArrayList<String[]> userData = profile.getUserData();

        if (!userData.isEmpty()) {
            // Display the profile information
            String[] profileData = userData.get(0);
            System.out.println("User ID: " + profileData[0]);
            System.out.println("First Name: " + profileData[1]);
            System.out.println("Last Name: " + profileData[2]);
            System.out.println("Username: " + profileData[3]);
            System.out.println("Email: " + profileData[4]);
            System.out.println("Role: " + profileData[5]);
            System.out.println("Password: " + profileData[6]);
            System.out.println("Age: " + profileData[7]);
            System.out.println("Address: " + profileData[8]);
            System.out.println("Phone Number: " + profileData[9]);
        } else {
            System.out.println("Profile not found for the given username.");
        }
    }
}
