package com.oilman.adlxb.core;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import static com.oilman.adlxb.core.IslandGuiUtils.*;
import static com.oilman.adlxb.core.IslandSettings.toLog;

/**
 * The desktop GUI version of this program.
 * Created using IntelliJ IDEA's Swing UI Design Form.
 *
 * @author Oilman
 * @since 2.1.0
 */
public class IslandGUI {
    private JButton sendButton;
    private JPanel jPanel2;
    private JPanel rootJPanel;
    private JTextPane outputTextPane;
    private JComboBox comboBox1;
    private JTextPane userInputTextPane;
    private JTextPane 要PO些啥呢TextPane;

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
        comboBox1 = new JComboBox();
        comboBox1.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                //Do nothing
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                if (toLog){
                    System.out.println("Selected: "+Objects.requireNonNull(comboBox1.getSelectedItem()).toString());
                }
                userInputTextPane.setText(userInputTextPane.getText()+
                        Objects.requireNonNull(comboBox1.getSelectedItem()).toString());
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                //Do nothing
            }
        });

        comboBox1.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userInputTextPane.getText().isBlank()) {
                    outputTextPane.setText("输入点东西吧");
                } else {
                    IslandThread thisThread = new IslandThread(userInputTextPane.getText());
                    outputTextPane.setText(thisThread.toString());
                    userInputTextPane.setText("");
                }
            }
        });
    }
}
