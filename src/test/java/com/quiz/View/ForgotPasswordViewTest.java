package com.quiz.View;

import org.junit.Assert;
import org.junit.Test;


public class ForgotPasswordViewTest {

    @Test
    public void testForgotPasswordView() {
        ForgotPasswordView forgotPasswordView = new ForgotPasswordView();

        // Check if the ForgotPasswordView instance is created
        Assert.assertNotNull(forgotPasswordView);

        // Check if the panel is not null
        Assert.assertNotNull(forgotPasswordView.panel);

        // Check if the title of the ForgotPasswordView is set correctly
        Assert.assertEquals("Forgot Password", forgotPasswordView.getTitle());

        // ... perform additional assertions to validate other aspects of the ForgotPasswordView
    }
}
