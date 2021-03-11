package com.oilman.adlxb.core;

/**
 * Most of the constants of this program should go here
 *
 * @author Oilman, Sod-Momas
 */
public class IslandConstants {
    private void IslandSettings() { }//private constructor

    // possible content in the cookie
    public final static char[] cookieContents =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',};
    // the length of the cookie
    public final static int cookieLength = 7;
    public final static int chanceOfSage = 50; // This should be 0-100. If the responses contains sage how many likely this thread will be saged.
    public final static int responseIndexRange = 100;
    // the kaomojis get from A Island, the copyright of this part of code belongs to ©A岛匿名版
    final static String[] islandKaomojis =
            {"|∀ﾟ", "(´ﾟДﾟ`)", "(;´Д`)", "(`･ω･)", "(=ﾟωﾟ)=", "| ω・´)", "|-` )", "|д` )", "|ー` )", "|∀` )", "(つд⊂)", "(ﾟДﾟ≡ﾟДﾟ)", "(^o^)ﾉ", "(|||ﾟДﾟ)", "( ﾟ∀ﾟ)", "( ´∀`)", "(*´∀`)", "(*ﾟ∇ﾟ)", "(*ﾟーﾟ)", "( ﾟ 3ﾟ)", "( ´ー`)", "( ﾟ 3ﾟ)", "( ・_ゝ・)", "(*´д`)", "(・ー・)", "(・∀・)", "(ゝ∀･)", "(\"∀\")", "(*ﾟ∀ﾟ*)", "( ﾟ∀。)", "( `д´)", "(`ε´ )", "(`ヮ´ )", "σ`∀´)", "ﾟ∀ﾟ)σ", "ﾟ ∀ﾟ)ノ", "(ﾟдﾟ)", "(|||ﾟдﾟ)", "( ﾟдﾟ)", "Σ( ﾟдﾟ)", "( ;ﾟдﾟ)", "( д ) ﾟ ﾟ", "( д)", "((( ﾟдﾟ)))", "( ` ・´)", "( ´д`)", "( -д-)", "･ﾟ( ﾉд`ﾟ)", "( TдT)", "ヾ(´ωﾟ`)", "(*´ω`*)", "(・ω・)", "( ´・ω)", "(´・ω・`)", "(`・ω・´)", "( `_っ´)", "( ´ρ`)", "( ﾟωﾟ)", "(oﾟωﾟo)", "( ^ω^)", "ヾ(´ε`ヾ)", "(ノﾟ∀ﾟ)ノ", "(σﾟдﾟ)σ", "(σﾟ∀ﾟ)σ", "|дﾟ )", "ﾟ(つд`ﾟ)", "⊂彡))д`)", "⊂彡))д´)", "⊂彡))∀`)", "(´∀((ミつ"};
    // Unused but it is used to determine the format of userInput
    public static boolean translateTraditionalChinese = false;

    // these are used in Island rule
    public static final String userInputKeyword = "user_input";
    public static final String userCookieKeyword = "user_cookie";
    public static final String responseRepeatKeyword = "humans_are_broken_records";
}
