package com.alexandragurova.swing1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gurova on 26.02.2015.
 */
public class Toolbar extends JPanel implements ActionListener{
    private JButton helloButton;
    private JButton byeButton;

    //Toolbar is able to listen for a text
    // (has a private TextListener field )
    //and perform activities based on listener (
    // in setTextListener() method)
    private TextListener textListener;

    public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());
        helloButton = new JButton("Hello");
        byeButton = new JButton("Bye");

        helloButton.addActionListener(this);
        byeButton.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloButton);
        add(byeButton);
    }


    public void setTextListener(TextListener textListener) {
        this.textListener = textListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == helloButton) {
            if (textListener != null) {
                textListener.textEmitted("Hola!");
            }
        } else if (clicked == byeButton) {
            if (textListener != null) {
                textListener.textEmitted("Bye:(");
            }
        }
    }


//    public void setTextPanel(TextPanel textPanel) {
//        this.textPanel = textPanel;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        JButton clicked = (JButton) e.getSource();
//
//        if (clicked == helloButton) {
//            textPanel.appendText("Hola!");
//        } else if (clicked == byeButton){
//            textPanel.appendText("Bye");
//        }
//    }
}
