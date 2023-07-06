package com.quiz.View;

import org.junit.Assert;


public class EditPasswordViewTest {

    @org.junit.Test
    public void testEditPasswordView() {
        int id = 2;
        EditPasswordView editPasswordView = new EditPasswordView(id);

        // Check if the EditPasswordView instance is created
        Assert.assertNotNull(editPasswordView);

        // Check if the panel is not null
        Assert.assertNotNull(editPasswordView.panel);

        // Check if the title of the EditPasswordView is set correctly
        Assert.assertEquals("Edit Password", editPasswordView.getTitle());

        // ... perform additional assertions to validate other aspects of the EditPasswordView
    }
}
