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
    public static void main(String[] args) {
        run();
    }

    /**
     * The main terminal program
     *
     * @since 0.0.1
     */
    public static void run() {
        IslandValueHolder.setToLog(false);

        Scanner userInputStringScanner = new Scanner(System.in);
        System.out.print("要PO些啥呢：");
        if (userInputStringScanner.hasNextLine()) {
            String userInput = userInputStringScanner.nextLine();
            try {
                printALotOfNewLines();
                System.out.print("\u001b[1m" + "\u001b[36m");//Bold+Cyan
                System.out.println("============= 串内容 ==============");
                System.out.print("\u001b[0m");//Reset
                printThread(userInput);
                System.out.print("\u001b[1m" + "\u001b[36m");//Bold+Cyan
                System.out.println("==================================");
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

    private static void printThread(String userInput) {

        IslandThread threadToPrint = new IslandThread(userInput);
        System.out.println(threadToPrint);
        if (threadToPrint.isSage()) {
            System.out.print("\u001b[31m");//Print red
            System.out.println(" \n Sage掉了！");
            System.out.print("\u001b[0m");//Reset
        }

    }

    private static void printALotOfNewLines() {
        for (int i = 0; i < 20; i++) {
            System.out.println("\n");
        }
    }
}
