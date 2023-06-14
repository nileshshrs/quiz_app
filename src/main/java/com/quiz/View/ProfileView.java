package com.quiz.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.quiz.View.Theme.GlassPanel;


public class ProfileView extends GlassPanel {

    private ArrayList <String []> userData;
    private JPanel userCard;

    public ProfileView(ArrayList <String[]> userdata) {
        this.userData=userdata;

        for (String data []: userData){
            System.out.println(data[5]);
        }

  
        setLayout(null);
        setBounds(250, 170, 1300, 680);

  
    }
}
