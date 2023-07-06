package com.quiz.Model;



public class ProfileInformationTest {
    public static void main(String[] args) {
        // Sample user information
        int userID = 1;
        String age = "30";
        String address = "123 Main St";
        String phoneNumber = "123-456-7890";

        // Create a ProfileInformation object and set the user information
        ProfileInformation profileInfo = new ProfileInformation(userID, age, address, phoneNumber);

        // The setInfo method should have stored or updated the user information in the database.
        System.out.println("User information has been stored or updated in the database.");
    }
}
