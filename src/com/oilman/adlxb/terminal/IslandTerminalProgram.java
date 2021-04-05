package com.oilman.adlxb.terminal;

import com.oilman.adlxb.core.IslandThread;

import java.util.Scanner;

/**
 * The terminal version of this program
 *
 * @author oilman
 * @since 1.0.0
 */
public class IslandTerminalProgram {
    public static void run() {
        Scanner userInputStringScanner = new Scanner(System.in);
        System.out.print("要PO些啥呢：");
        if (userInputStringScanner.hasNextLine()) {
            String userInput = userInputStringScanner.nextLine();
            try {
                printThread(userInput);
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        System.out.println("输入1重新开始 输入其他退出");
        if (userInputStringScanner.hasNextLine()) {
            if (userInputStringScanner.nextLine().equals("1")) {
                run();
            }
        }
    }

    public static void printThread(String userInput) {
        IslandThread threadToPrint = new IslandThread(userInput);
        if (threadToPrint.isSage()) {
            System.err.println("Sage掉了！");
        }
        System.out.println(threadToPrint);
    }
}
