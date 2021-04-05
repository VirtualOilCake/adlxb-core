package com.oilman.adlxb.desktop;

import com.oilman.adlxb.core.IslandThread;
import com.oilman.adlxb.core.IslandValueHolder;
import sun.awt.SunToolkit;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;

import static com.oilman.adlxb.desktop.GuiVariables.toLog;
import static com.oilman.adlxb.desktop.IslandGuiUtils.*;

/**
 * The desktop GUI version of this program.
 * Created using IntelliJ IDEA's Swing UI Design Form.
 *
 * @author Oilman
 * @since 2.1.0
 */
public class IslandGUI {
    private JButton sendButton;
    private JPanel userInputJPanel;
    private JPanel rootJPanel;
    private JTextPane outputTextPane;
    private JComboBox<String> kaomojiComboBox;
    private JTextPane userInputTextPane;
    private JTextPane HintTextPane;
    private JScrollPane outputScrollPane;
    private JScrollPane userInputScrollPane;
    private JSplitPane mainSplitPane;

    static ResourceBundle bundle;

    /**
     * Main GUI for users
     *
     * @param args IDK
     */
    public static void main(String[] args) {
        // To make the UI looks better
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());// Current system style
        } catch (Exception e) {
            System.out.println(
                "Your system dose not support UIManager.getSystemLookAndFeelClassName()");
            e.printStackTrace();
        }
        setDefaultFontTo(getFont());

        Locale locale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("com.oilman.adlxb.desktop.guiString",locale);

        JFrame frame = new JFrame();
        frame.setContentPane(new IslandGUI().rootJPanel);
        frame.setTitle(bundle.getString("title"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {

        sendButton = new JButton();
        kaomojiComboBox = new JComboBox<String>();
        userInputTextPane = new JTextPane();
        outputTextPane = new JTextPane();


        userInputTextPane.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        outputTextPane.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));

        for (String kaomoji : IslandValueHolder.getKaomoji()) {
            kaomojiComboBox.addItem(kaomoji);
        }

        kaomojiComboBox.addPopupMenuListener(new PopupMenuListener() {
            boolean isCanceled = false;

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                isCanceled = false;
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                if (!isCanceled) {
                    if (toLog) {
                        System.out.println("Selected: " + Objects.requireNonNull(kaomojiComboBox.getSelectedItem()).toString());
                    }
                    userInputTextPane.setText(userInputTextPane.getText() +
                        Objects.requireNonNull(kaomojiComboBox.getSelectedItem()).toString());
                } else {
                    isCanceled = false;
                }
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
                isCanceled = true;
            }
        });

        kaomojiComboBox.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userInputTextPane.getText().isBlank()) {
                    outputTextPane.setText(bundle.getString("input_something"));
                } else {
                    IslandThread thisThread = new IslandThread(userInputTextPane.getText());
                    outputTextPane.setText(thisThread.toString());

                    outputTextPane.setEnabled(true);
                    userInputTextPane.setText("");
                }
            }
        });
    }
}
