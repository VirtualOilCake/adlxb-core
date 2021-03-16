package com.oilman.adlxb.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IslandGUI {
    private JTextField userInputTextField;
    private JButton sendButton;
    private JScrollPane scrollPane;
    private JPanel jPanel2;
    private JPanel rootJPanel;
    private JLabel inputHintLabel;
    private JTextPane outputTextPane;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//当前系统风格
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("A岛离线版");
        frame.setContentPane(new IslandGUI().rootJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        sendButton = new JButton();
        sendButton.setFont(Font.getFont("SansSerif"));
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
