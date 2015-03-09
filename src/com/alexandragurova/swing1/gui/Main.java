package com.alexandragurova.swing1.gui;

import javax.swing.*;

/**
 * Created by Gurova on 25.02.2015.
 */
public class Main {
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
