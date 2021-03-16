package com.oilman.adlxb.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static com.oilman.adlxb.core.IslandGuiUtils.*;
import static com.oilman.adlxb.core.IslandSettings.toLog;

public class IslandGUI {
    private JTextField userInputTextField;
    private JButton sendButton;
    private JScrollPane scrollPane;
    private JPanel jPanel2;
    private JPanel rootJPanel;
    private JLabel inputHintLabel;
    private JTextPane outputTextPane;

    static Font normalFont;
    static Font boldFont;
    static int normalFontSize = 12;
    static int boldFontSize = 11;

    public static void main(String[] args) {
        // To make the UI looks better
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格
        } catch (Exception e) {
            System.out.println("Your system dose not support UIManager.getSystemLookAndFeelClassName()");
            e.printStackTrace();
        }
        setAllFontsTo(getFont());


        JFrame frame = new JFrame("A岛离线版");
        frame.setContentPane(new IslandGUI().rootJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        sendButton = new JButton();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userInputTextField.getText().isBlank()){
                    outputTextPane.setText("输入点东西吧");
                }
                else {
                    IslandThread thisThread = new IslandThread(userInputTextField.getText());
                    outputTextPane.setText(thisThread.toString());
                }
            }
        });
    }
}
