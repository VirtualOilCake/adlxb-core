package com.oilman.adlxb.terminal;

import java.util.Locale;

/**
 * Utils class for Terminal
 *
 * @author Oilman
 * @version 3.0.0
 * @since 3.0.0
 */
public class IslandTerminalUtils {
    /**
     * to know weather the program is running on Windows.
     *
     * @return true if running on Windows.
     */
    public static boolean isRunningOnWindows() {
        return System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows");
    }
}
