package com.oilman.adlxb.core;


/**
 * The response rule of the program, aka 岛规(bushi)
 * <p>
 * The first argument is a String array that stores keywords.
 * NOTE: all English in keyword MUST be low case.
 * The second argument is a String array that stores responses if the input has the given keywords
 * <p>
 * Basic format:
 * name_for_the_rule(new String[]{""}, new String[]{""})
 * For the content in the rule, please use Chinese notation as much as possible,
 * because English is used in programing and may cause errors.
 * Please use English, Pinyin, or Romaji for variables names.
 * You MUST NOT use Chinese or Japanese.
 * <p>
 * tips:
 * You can use methods in other classes,
 * because this is technically another class.
 * If your response has "sage" (not case sensitive) in it,
 * there is a chance that this thread will get sage.
 *
 * @author oilman
 * @see IslandUtils
 * @see IslandConstants
 * @since 2.0.0
 */
// TODO create more rules
public enum IslandRulesEnum {
    /**
     * Method or Constants you may want to use:
     * IslandConstants.userInputKeyword
     * // This is the content of the original user input
     * IslandUtils.getARandomKaomoji()
     * // This will give you a random Kaomoji (of cause comes from A Island)
     * IslandConstants.responseRepeatKeyword
     * // The syntax of this: "你想要复读或者增加权重的话", IslandConstants.responseRepeatKeyword, "233"
     * <p>
     * Basic format:
     * name_of_the_rule(new String[]{""}, new String[]{""})
     */
    default_responses(new String[]{""}, new String[]{
            "( ﾟ∀。)",
            "( ´_ゝ`)旦",
            "(|||ﾟДﾟ)",
            "(ﾟДﾟ≡ﾟДﾟ)",
            "⊂彡☆))д`)",
            "(　^ω^)",
            "致",
            "摩多摩多",
            "hso( ´ρ`)",
            IslandConstants.userInputKeyword,
            IslandUtils.getARandomKaomoji()
    }),
    atm(new String[]{"atm", "延毕", "毕业论文", "岛主"}, new String[]{"你完了，猴子*眼小"}),
    bog(new String[]{"bili", "pili", "xili", "批站", "b站", "哔哩", "干杯"},
            new String[]{"守❤护❤最❤好❤的❤霹❤雳❤霹❤雳", "钓鱼不可取", "哪里来的bog？", "……？", "叔叔我啊，最讨厌Bog了", "BOG不要上岛！", "Sage来了！"}),
    who_is(new String[]{"谁是"}, new String[]{IslandConstants.userCookieKeyword, IslandConstants.responseRepeatKeyword, "5"}),

    the_fifth_republic(new String[]{"阁下", "虫豸"}, new String[]{"毕业论文"}),
    sage(new String[]{"sage"}, new String[]{"SAGE!", "如你所愿！SAGE吧", "世嘉！"});


    // Two variables
    private final String[] keywords;
    private final String[] responses;

    /**
     * The constructor
     *
     * @param keywords  An Array of keywords
     * @param responses An Array of responses to the given keywords
     */
    IslandRulesEnum(String[] keywords, String[] responses) {
        this.keywords = keywords;
        this.responses = responses;
    }

    /**
     * Keyword getter
     *
     * @return keywords of a given rule.
     */
    public String[] getKeywords() {
        return keywords;
    }

    /**
     * Responses getter
     *
     * @return responses of a given rule.
     */
    public String[] getResponses() {
        return responses;
    }


}
