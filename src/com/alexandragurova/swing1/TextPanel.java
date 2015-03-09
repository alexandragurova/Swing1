package com.alexandragurova.swing1;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gurova on 25.02.2015.
 */
public class TextPanel extends JPanel{
    private JTextArea textArea;

    public TextPanel() {
        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String s){
        textArea.append(s);
    }
}
