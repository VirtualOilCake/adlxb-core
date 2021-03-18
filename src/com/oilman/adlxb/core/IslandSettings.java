package com.oilman.adlxb.core;

/**
 * A class that stores settings
 * This class should be able to change and don't have final
 * If you want to have a constance that is not visible for users, you should go to IslandConstants class
 */
public class IslandSettings {
    // do the program needs to log?
    public static boolean toLog = true;
    // these two int are used for how many responses the user will get
    public static int baseNumberForReplies = 5;
    public static int numberForRepliesRange = 5; // add to base number

}
