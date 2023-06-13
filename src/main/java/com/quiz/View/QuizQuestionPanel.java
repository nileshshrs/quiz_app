package com.quiz.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import com.quiz.View.Theme.GlassPanel;

import java.awt.*;

import java.util.ArrayList;

import java.util.Map;

public class QuizQuestionPanel extends GlassPanel {

    private ArrayList<String[]> QuestionData;
    private Map<String, Integer> subjectMap;

    public QuizQuestionPanel() {

        Color color = new Color(245, 245, 245, 200);

        setLayout(null);
        setBounds(250, 170, 1300, 680);


    }
}
