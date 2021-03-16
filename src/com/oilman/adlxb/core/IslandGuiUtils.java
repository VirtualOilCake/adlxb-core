package com.oilman.adlxb.core;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

import static com.oilman.adlxb.core.IslandSettings.toLog;

public class IslandGuiUtils {
    public static boolean hasFont(String fontName) {
        GraphicsEnvironment systemGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = systemGraphicsEnvironment.getAvailableFontFamilyNames();
        for (String font : fonts) {
            System.out.println(font);
            if (font.equals(fontName)) {
                System.out.println(fontName + " is found!");
                return true;
            }
        }
        return false;
    }

    /**
     * Set the default font to all parts
     * <p>
     * Source: http://www.jguru.com/faq/view.jsp?EID=340519
     *
     * @param font given font
     */
    public static void setAllFontsTo(Font font) {
        UIManager.put("Button.font", font);
        UIManager.put("ToggleButton.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("CheckBox.font", font);
        UIManager.put("ColorChooser.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("List.font", font);
        UIManager.put("MenuBar.font", font);
        UIManager.put("MenuItem.font", font);
        UIManager.put("RadioButtonMenuItem.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("PopupMenu.font", font);
        UIManager.put("OptionPane.font", font);
        UIManager.put("Panel.font", font);
        UIManager.put("ProgressBar.font", font);
        UIManager.put("ScrollPane.font", font);
        UIManager.put("Viewport.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TextPane.font", font);
        UIManager.put("EditorPane.font", font);
        UIManager.put("TitledBorder.font", font);
        UIManager.put("ToolBar.font", font);
        UIManager.put("ToolTip.font", font);
        UIManager.put("Tree.font", font);
    }

    public static Font getFont() {
        int normalFontSize = 12;
        if (System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows")) {
            if (toLog) {
                System.out.println("You are running Windows. Trying to use Microsoft YaHei");
            }
            return new Font("Microsoft YaHei", Font.PLAIN, normalFontSize);
        } else {
            if (toLog) {
                System.out.println("You are not running Windows. Using the SANS_SERIF font");
            }
            return new Font(Font.SANS_SERIF, Font.BOLD, normalFontSize);
        }
    }
}