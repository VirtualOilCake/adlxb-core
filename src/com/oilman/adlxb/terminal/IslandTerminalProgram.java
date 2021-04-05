package com.oilman.adlxb.terminal;

import com.oilman.adlxb.core.IslandThread;
import com.oilman.adlxb.core.IslandValueHolder;

import java.util.Scanner;


/**
 * The terminal version of this program
 *
 * @author oilman
 * @since 1.0.0
 */
public class IslandTerminalProgram {
    /**
     * Main method to start the program
     *
     * @param args idk
     */
    public static void main(String[] args) {
        run();
    }

    /**
     * The main terminal program
     *
     * @version 3.0.0
     * @since 0.0.1
     */
    public static void run() {
        IslandValueHolder.setToLog(false);

        Scanner userInputStringScanner = new Scanner(System.in);
        System.out.print("要PO些啥呢：");
        if (userInputStringScanner.hasNextLine()) {
            String userInput = userInputStringScanner.nextLine();
            try {
                IslandThread thisTread = new IslandThread(userInput);
                printALotOfNewLines();
                System.out.print("\u001b[1m" + "\u001b[36m");//Bold+Cyan
                System.out.println("================ 串 =================");
                System.out.print("\u001b[0m");//Reset;
                System.out.println("创建时间：" + thisTread.getCreatedTime());
                System.out.print("当前状态：");
                if (thisTread.isSaged()) {
                    System.out.print("\u001b[31m");//Print red
                    System.out.println("被SAGE啦！");
                    System.out.print("\u001b[0m");//Reset
                } else {
                    System.out.println("正常");
                }
                System.out.print("\u001b[1m" + "\u001b[36m");//Bold+Cyan
                System.out.println("------------- 用户输入 ---------------");
                System.out.print("\u001b[0m");//Reset
                System.out.println(thisTread.selfPostToString());
                System.out.print("\u001b[1m" + "\u001b[36m");//Bold+Cyan
                System.out.println("--------------- 回复 ----------------");
                System.out.print("\u001b[0m");//Reset
                System.out.println(thisTread.responsesToString());
                System.out.print("\u001b[1m" + "\u001b[36m");//Bold+Cyan
                System.out.println("====================================");
                System.out.print("\u001b[0m");//Reset

            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
        System.out.print("输入1重新开始，输入其他退出：");
        if (userInputStringScanner.hasNextLine()) {
            if (userInputStringScanner.nextLine().equals("1")) {
                printALotOfNewLines();
                run();
            }
        }
    }

    /**
     * This was used for printing the thread.
     * It is obsolete now.
     *
     * @param userInput a String that user inputted.
     * @version 1.1.0
     * @since 1.1.0
     */
    private static void printThread(String userInput) {

        IslandThread threadToPrint = new IslandThread(userInput);
        System.out.println(threadToPrint);
        if (threadToPrint.isSaged()) {
            System.out.print("\u001b[31m");//Print red
            System.out.println(" \n Sage掉了！");
            System.out.print("\u001b[0m");//Reset
        }

    }

    /**
     * Print a lot of lines
     *
     * @version 3.0.0
     * @since 3.0.0
     */
    private static void printALotOfNewLines() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
