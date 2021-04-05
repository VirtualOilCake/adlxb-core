package com.oilman.adlxb.test;

import com.oilman.adlxb.core.IslandThread;

/**
 * Random tests goes here.
 *
 * @version how ever your want
 * @since 3.0.0
 */
public class IslandTester {
    public static void main(String[] args) {
        IslandThread islandThread = new IslandThread("sadas");
        System.out.println(islandThread.responsesToString());
    }
}
