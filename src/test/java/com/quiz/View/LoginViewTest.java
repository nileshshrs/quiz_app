package com.quiz.View;

import java.awt.Color;

import org.junit.Assert;


public class LoginViewTest {

    @org.junit.Test
    public void testLoginView() {
        LoginView loginView = new LoginView();

        // Check if the LoginView instance is created
        Assert.assertNotNull(loginView);

        // Check if the panel is not null
        Assert.assertNotNull(loginView.panel);

        // Check if the title of the LoginView is set correctly
        Assert.assertEquals("Login", loginView.getTitle());

        // Check if the panel background color is set correctly
        Assert.assertEquals(new Color(35, 178, 161), loginView.panel.getBackground());

        // ... perform additional assertions to validate other aspects of the LoginView
    }
}
