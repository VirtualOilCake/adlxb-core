package com.oilman.adlxb.desktop;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;
import java.util.Locale;

import static com.oilman.adlxb.desktop.GuiVariables.toLog;


/**
 * This is the invisible part for the GUI
 *
 * @author Oilman
 * @since 2.1.0
 */
public class IslandGuiUtils {
    /**
     * To cheak if a given font exist
     *
     * @param fontName the font you want to find
     * @return true if the given font exist, false otherwise.
     * @since 2.1.0
     */
    public static boolean hasFont(String fontName) {
        GraphicsEnvironment systemGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = systemGraphicsEnvironment.getAvailableFontFamilyNames();
        for (String font : fonts) {
            //System.out.println(font);
            if (font.equals(fontName)) {
                if (toLog) {
                    System.out.println(fontName + " is found!");
                }
                return true;
            }
        }
        return false;
    }


    /**
     * Set the default font to all parts
     * <p>
     * Source:https://blog.csdn.net/chenxuejiakaren/article/details/7637731
     *
     * @param font given font
     */
    public static void setDefaultFontTo(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }


    /**
     * Set the default font to all parts
     * <p>
     * Source: http://www.jguru.com/faq/view.jsp?EID=340519
     *
     * @param font given font
     * @since 2.1.0
     */
    public static void setDefaultFontToOld(Font font) {
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

    /**
     * Get a sans serif font
     * This method is here thanks to the lack of Chinese support in Microsoft Windows!
     *
     * @param fontSize the font size
     * @return a sans serif font
     * @since 2.1.0
     */
    public static Font getFont(int fontSize) {
        Font outputFont;
        if (System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows")) {

            if (toLog) System.out.println("You are running Windows. Trying to use Microsoft YaHei.");

            if (hasFont("Microsoft YaHei")) {
                outputFont = new Font("Microsoft YaHei", Font.PLAIN, fontSize);
            } else {
                outputFont = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);

                if (toLog) System.out.println("You do not have Microsoft YaHei installed on your system!");

            }
        } else {

            outputFont = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);

            if (toLog) System.out.println("You are not running Windows. Using the SANS_SERIF font.");
        }
        if (toLog) System.out.println("Final font is: "+outputFont.getFamily());
        return outputFont;
    }

    /**
     * call getFont(int fontSize) with 12
     *
     * @return a sans serif font with size 12
     * @since 2.1.0
     */
    public static Font getFont() {
        // Default font size is 12
        return getFont(12);
    }

}