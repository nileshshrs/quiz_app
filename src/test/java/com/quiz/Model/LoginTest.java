
package com.quiz.Model;

import java.util.ArrayList;

import com.quiz.View.StudentQuizPage;
import com.quiz.View.TeacherQuizPage;


public class LoginTest {
    private ArrayList<String[]> userData;
    
    public LoginTest(ArrayList<String[]> userData) {
        this.userData = userData;
        loginWithRole();
    }

    // Getter for userData
    public ArrayList<String[]> getUserData() {
        return userData;
    }

    // Setter for userData
    public void setUserData(ArrayList<String[]> userData) {
        this.userData = userData;
    }

    private void loginWithRole() {
        for (String[] data : userData) {
            String username = data[3]; int ID = Integer.valueOf(data[0]);
            String role = data[6];
            if (role.equals("student")) {
                // System.out.println(username);
                new StudentQuizPage(username, ID);
                // new TeacherQuizPage(username);
            } else if (role.equals("teacher")) {
                // System.out.println(username);
                // new StudentQuizPage();
                new TeacherQuizPage(username,ID);
            }
        }
    }
}
