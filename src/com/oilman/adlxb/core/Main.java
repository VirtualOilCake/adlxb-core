package com.oilman.adlxb.core;

public class Main {
    public static void main(String[] args) {
        String userInput = "你们这里谁是岛主？";
        System.out.println("User Input is: " + userInput);
        System.out.print(new IslandThread(userInput));
    }
}
