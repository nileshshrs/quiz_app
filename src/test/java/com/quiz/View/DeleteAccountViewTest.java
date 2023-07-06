package com.quiz.View;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeleteAccountViewTest {

    @Test
    public void testDeleteAccount_Success() {
        DeleteAccountView deleteAccountView = new DeleteAccountView(1, "ava");

        assertTrue(deleteAccountView.isVisible());
    }

}
