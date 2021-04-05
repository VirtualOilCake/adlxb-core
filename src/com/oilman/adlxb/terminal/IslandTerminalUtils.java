package com.oilman.adlxb.terminal;

import java.util.Locale;

public class IslandTerminalUtils {
    public static boolean isRunningOnWindows(){
        return System.getProperty("os.name").toLowerCase(Locale.ROOT).startsWith("windows");
    }
}
