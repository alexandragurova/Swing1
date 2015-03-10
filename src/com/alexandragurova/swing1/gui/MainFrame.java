package com.alexandragurova.swing1.gui;

import com.alexandragurova.swing1.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by Gurova on 25.02.2015.
 * <p/>
 * Controller of GUI
 */
public class MainFrame extends JFrame {
    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;
    private TablePanel tablePanel;

    private JFileChooser fileChooser;

    private Controller controller;

    public MainFrame() {
        super("Hello Swing");

        setLayout(new BorderLayout());

        controller = new Controller();

        toolbar = new Toolbar();
        formPanel = new FormPanel();
        textPanel = new TextPanel();
        tablePanel = new TablePanel();

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new PersonFileFilter());

        //set up JMenuBar
        setJMenuBar(createMenuBar());

        toolbar.setTextListener(new TextListener() {
            @Override
            public void textEmitted(String s) {
                textPanel.appendText(s);
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {

                controller.addPerson(e);
                tablePanel.refresh();
//                String name = e.getName();
//                String occupation = e.getOccupation();
//                int ageCategory = e.getAgeCategory();
//                String employCategory = e.getEmployCategory();
//
//
//                textPanel.appendText(name + ": " + occupation + ": " +
//                        ageCategory + ": " + employCategory + "\n");
            }
        });
//        toolbar.setTextPanel(textPanel);

        tablePanel.setData(controller.getPeople());

        add(toolbar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);
//        add(textPanel, BorderLayout.CENTER);
        add(tablePanel, BorderLayout.CENTER);

        setMinimumSize(new Dimension(500, 400));
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
        showFormItem.setSelected(true);

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        showFormItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();

                formPanel.setVisible(menuItem.isSelected());
            }
        });


        //add Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        //add Accelerators
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        //set up File Chooser
        importDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        //don't forget to refresh tablePanel
                        tablePanel.refresh();
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(
                                MainFrame.this,
                                "Could not load data from file.",
                                "Loading error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(
                                MainFrame.this,
                                "Could not save data to file.",
                                "Saving error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String dialogInput = JOptionPane.showInputDialog(
//                        MainFrame.this,
//                        "Enter your user name:",
//                        "Enter User Name",
//                        JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);
//                System.out.println(dialogInput + " attempted to exit the program.");

                int actionId = JOptionPane.showConfirmDialog(
                        MainFrame.this,
                        "Are you sure you want to exit the application?",
                        "Confirm exit",
                        JOptionPane.OK_CANCEL_OPTION);
                if (actionId == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }

            }
        });

        return menuBar;

    }


}
