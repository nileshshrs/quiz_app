package com.quiz.View;

import com.quiz.View.ProfileView;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProfileViewTest {

    private ProfileView profileView;

    @Before
    public void setUp() {
        ArrayList<String[]> userData = new ArrayList<>();
        // Add sample user data to the ArrayList for testing
        String[] userDataEntry = {"1", "John", "Doe", "johndoe", "johndoe@example.com",
                "role", "other", "25", "address", "1234567890"};
        userData.add(userDataEntry);

        profileView = new ProfileView(userData);
        profileView.setVisible(false); // Prevent the GUI components from being displayed during testing
    }

    @Test
    public void testProfileViewInitialization() {
        assertNotNull(profileView);

        // Test the bounds of the ProfileView
        Rectangle bounds = profileView.getBounds();
        assertEquals(250, bounds.x);
        assertEquals(170, bounds.y);
        assertEquals(1300, bounds.width);
        assertEquals(680, bounds.height);


    }


}
