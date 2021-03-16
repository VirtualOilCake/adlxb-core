package com.oilman.adlxb.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.oilman.adlxb.core.IslandGuiUtils.*;

/**
 * The desktop GUI version of this program.
 * Created using IntelliJ IDEA's Swing UI Design Form.
 *
 * @author Oilman
 * @since 2.1.0
 */
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

    /**
     * Main GUI for users
     *
     * @param args IDK
     */
    public static void main(String[] args) {
        System.out.println(hasFont("Noto Sans"));
        // To make the UI looks better
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// Current system style
        } catch (Exception e) {
            System.out.println(
                    "Your system dose not support UIManager.getSystemLookAndFeelClassName()");
            e.printStackTrace();
        }
        setDefaultFontTo(getFont());


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
                if (userInputTextField.getText().isBlank()) {
                    outputTextPane.setText("输入点东西吧");
                } else {
                    IslandThread thisThread = new IslandThread(userInputTextField.getText());
                    outputTextPane.setText(thisThread.toString());
                }
            }
        });
    }
}
