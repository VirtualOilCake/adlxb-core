package com.oilman.adlxb.core;

/**
 * Most of the constants of this program should go here
 *
 * @author Oilman
 * @author Sod-Momas
 * @since 1.0.1
 */
public class IslandConstants {
    private void IslandSettings() {
    }//private constructor

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
    public final static int chanceOfSage = 50;

    // This is the range for the index of the posts (not used for now)
    public final static int postNumberIncreaseSpeed = 500;

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

    // these are used in Island rule
    public static final String user_input_key = "user_input_key_in_enum";
    public static final String user_cookie_key = "user_cookie_key_in_enum";
    public static final String to_repeat = "repeat_key_in_enum";
}
