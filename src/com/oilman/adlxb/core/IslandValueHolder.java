package com.oilman.adlxb.core;

public class IslandValueHolder {
    public static void setToLog(boolean b){
        CoreVariables.toLog=b;
    }
}
/**
 * Most of the constants of this program should go here
 *
 * @author Oilman
 * @author Sod-Momas
 * @since 1.0.1
 */
class CoreConstants {
    // possible content in the cookie
    public final static char[] cookieContents = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
    };
    // the length of the cookie
    public final static int cookieLength = 7;
    // This should be 0-100. If the responses contains sage how many likely this thread will be saged.
    public final static int chanceOfSage = 80;
    // This is the range for the index of the posts (not used for now)
    public final static int postNumberIncreaseSpeed = 500;
    // these are used in Island rule
    public static final String user_input_key = "user_input_key_in_enum";
    public static final String user_cookie_key = "user_cookie_key_in_enum";
    public static final String to_repeat = "repeat_key_in_enum";
    public static final String to_sage = "this_thread_may_sage";
    // These kaomojis were got from A Island. The copyright of this part of code belongs to ©A岛匿名版
    final static String[] islandKaomoji = {
        "|∀ﾟ", "(´ﾟДﾟ`)", "(;´Д`)", "(`･ω･)", "(=ﾟωﾟ)=", "| ω・´)", "|-` )",
        "|д` )", "|ー` )", "|∀` )", "(つд⊂)", "(ﾟДﾟ≡ﾟДﾟ)", "(^o^)ﾉ", "(|||ﾟДﾟ)",
        "( ﾟ∀ﾟ)", "( ´∀`)", "(*´∀`)", "(*ﾟ∇ﾟ)", "(*ﾟーﾟ)", "( ﾟ 3ﾟ)", "( ´ー`)",
        "( ﾟ 3ﾟ)", "( ・_ゝ・)", "(*´д`)", "(・ー・)", "(・∀・)", "(ゝ∀･)", "(\"∀\")",
        "(*ﾟ∀ﾟ*)", "( ﾟ∀。)", "( `д´)", "(`ε´ )", "(`ヮ´ )", "σ`∀´)", "ﾟ∀ﾟ)σ",
        "ﾟ ∀ﾟ)ノ", "(ﾟдﾟ)", "(|||ﾟдﾟ)", "( ﾟдﾟ)", "Σ( ﾟдﾟ)", "( ;ﾟдﾟ)", "( д ) ﾟ ﾟ",
        "( д)", "((( ﾟдﾟ)))", "( ` ・´)", "( ´д`)", "( -д-)", "･ﾟ( ﾉд`ﾟ)", "( TдT)",
        "ヾ(´ωﾟ`)", "(*´ω`*)", "(・ω・)", "( ´・ω)", "(´・ω・`)", "(`・ω・´)",
        "( `_っ´)", "( ´ρ`)", "( ﾟωﾟ)", "(oﾟωﾟo)", "( ^ω^)", "ヾ(´ε`ヾ)",
        "(ノﾟ∀ﾟ)ノ", "(σﾟдﾟ)σ", "(σﾟ∀ﾟ)σ", "|дﾟ )", "ﾟ(つд`ﾟ)", "⊂彡))д`)",
        "⊂彡))д´)", "⊂彡))∀`)", "(´∀((ミつ"
    };
    // Unused but it is used to determine the format of userInput
    public static boolean translateTraditionalChinese = false;

    private void IslandSettings() {
    }//private constructor
}
/**
 * A class that stores values that will change while using the program
 * This class should be able to change and don't have final
 * If you want to have a constance that is not visible for users, you should go to IslandValueHolder class
 */
class CoreVariables {
    // do the program needs to log?
    public static boolean toLog = true;
    // these two int are used for how many responses the user will get
    public static int baseNumberForReplies = 5;
    public static int numberForRepliesRange = 5; // add to base number

}