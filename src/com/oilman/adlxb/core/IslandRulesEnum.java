package com.oilman.adlxb.core;


import static com.oilman.adlxb.core.IslandConstants.*;
import static com.oilman.adlxb.core.IslandUtils.getARandomKaomoji;

/**
 * The response rule of the program, aka 岛规(bushi)
 * <p>
 * The first argument is a String array that stores keywords.
 * NOTE: all English in keywords MUST be low case.
 * The second argument is a String array that stores responses if the input has the given keywords
 * <p>
 * For the content in the rule, please use Chinese notation as much as possible,
 * because English is used in programing and may cause errors.
 * Please use English, Pinyin, or Romaji for variables names.
 * You MUST NOT use Chinese or Japanese for variables names.
 *
 * @author oilman
 * @see IslandUtils
 * @see IslandConstants
 * @since 2.0.0
 */
// TODO create more rules
public enum IslandRulesEnum {
    /**
     * You can use methods in other classes,
     * because this is technically another class.
     * <p>
     * If you want to activate your rule only when more than one keywords applied,
     * you may want to use "and" logic!
     * The syntax goes like: "&&,keyword 1,keyword 2,keyword 3"
     * (NO space in between. MUST have "," after "&&")
     * (in this case, your rule will be applied
     * only if the input has all of keyword 1, keyword 2, and keyword 3)
     * <p>
     * Method or Constants you may want to use:
     * IslandConstants.user_input_key
     * // This is the content of the original user input
     * IslandConstants.user_cookie_key
     * // This is the user's cookie
     * IslandUtils.getARandomKaomoji()
     * // This will give you a random Kaomoji (of cause comes from A Island)
     * IslandConstants.to_repeat
     * // The syntax of this: "你想要复读或者增加权重的话", to_repeat, "233"
     * IslandConstants.to_sage
     * // The thread may be sage, possibility see IslandConstants.chanceOfSage
     * <p>
     * Basic format:
     * name_of_the_rule(new String[]{""}, new String[]{""}),
     */
    default_responses(
        new String[]{""}, // always true
        new String[]{
            "( ﾟ∀。)", "( ´_ゝ`)旦", "(|||ﾟДﾟ)", "(ﾟДﾟ≡ﾟДﾟ)",
            "⊂彡☆))д`)", "(　^ω^)", "致", "摩多摩多", "hso( ´ρ`)",
            "你把大伙叫出来就是为了这点事啊",
            user_input_key, getARandomKaomoji()
        }),

    ////// A //////

    ac_fun(new String[]{"acfun"}, new String[]{""}),

    ask_questions(new String[]{"&&,知道,？", "是什么？", "为什么"},
        new String[]{"不知道", "虫族不要上岛", "祭品呢？", "因为" + user_cookie_key}),

    atm(new String[]{"atm", "延毕", "毕业论文", "岛主", "a主席", "momo"}, new String[]{
        to_sage,
        "你完了，猴子*眼小", "好靓的饼干", "继续说，a哥很喜欢", "已清退", "清❤退❤退"
    }),

    ////// B //////

    bog(new String[]{"bili", "pili", "xili", "批站", "b站", "哔哩", "干杯", "( ゜- ゜)つロ", "ビリ"},
        new String[]{
            to_sage,
            "守❤护❤最❤好❤的❤霹❤雳❤霹❤雳",
            "钓鱼不可取", "哪里来的bog？", "……？",
            "叔叔我啊，最讨厌Bog了！", "BOG不要上岛",
            "Sage来了",
            "呕呕呕呕呕",
            "欢乐恶搞不是法外地",
            "钓鱼？(　^ω^)\n(　-ω-)累了，毁灭吧"
        }),

    broken_record(new String[]{"复读"}, new String[]{user_input_key, to_repeat, "20"}),

    ////// C //////
    ////// D //////
    ////// E //////
    ////// F //////
    funny(new String[]{"( ﾟ∀。)", "草", "艹"}, new String[]{"( ﾟ∀。)", to_repeat, "3", "草( ﾟ∀。)", "草", "( ﾟ∀。)？"}),
    ////// G //////
    girl_friend(new String[]{"女友"}, new String[]{to_sage, "线虫不要上岛", "晒妹SAGE！"}),
    ////// H //////
    ////// I //////
    ////// J //////
    ju_gao_gao(new String[]{"&&,今天,生日", "&&,今天,轮到我"},
        new String[]{"举高高(ノﾟ∀ﾟ)ノ", to_repeat, "10",
            "(ノﾟ∀ﾟ)ノ举高高", to_repeat, "5",
        }),
    ////// K //////
    ////// L //////
    lo_li_con(new String[]{"炼", "铜"}, new String[]{"冶金专业不要上岛！"}),
    ////// M //////
    ////// N //////
    ni_ji_gen(new String[]{
        "二次元", "呐", "米娜桑", "啊诺", "！？", "？！", "动漫", "三次元", "(｡◕∀◕｡)", "☆", "の"
    }, new String[]{
        to_sage,
        "守❤护❤最❤好❤的❤二❤次❤元", "呐呐呐呐呐", "小殇君不要⊂彡☆))д`)",
        "泻药，人在日本，刚下福岛", "纯度，太高了", "请问这里是福岛吗？", "嘻嘻",
        "(●˙꒳˙●)", "四兄弟去打猎：老大打虎，老三杀豹，老四砍狼\n\n\n老二刺猿"}),
    ////// O //////
    out_dated(new String[]{"分享图片", "转自", "听说"}, new String[]{"你把大伙叫出来只是为了这点事啊.jpg"}),
    ////// P //////
    ////// Q //////
    qi_qi_ha_er(new String[]{"σ", "来蛤我", "( ´_ゝ`)", "( ・_ゝ・)",
        "我竟然", "不信邪", "(´ﾟДﾟ`)"}, new String[]{
        "(`ヮ´ )σ`∀´) ﾟ∀ﾟ)σ蛤蛤蛤",
        "･ﾟ( ﾉヮ´ )(`ヮ´ )σ`∀´) ﾟ∀ﾟ)σ",
        "草(`ヮ´ )σ`∀´) ﾟ∀ﾟ)σ",
        "UCCU σ`∀´)",
        "蛤蛤蛤蛤蛤 乐死我了σ`∀´)"}),
    ////// R //////
    roll(new String[]{"roll", "测一测"}, new String[]{
        "r", to_repeat, "20",
        "roll", to_repeat, "10"
    }),
    ////// S //////
    sage(new String[]{"sage"}, new String[]{to_sage, "SAGE!", "如你所愿！SAGE吧", "世嘉！"}),
    sexual_preference(new String[]{"喜欢", "我可以", "xp", "suki", "hso", "性癖", "戳我"},
        new String[]{"(つд⊂)hso", "人不能，至少不该", "兄啊！你的XP好鸡掰的怪啊！",
            "(〃∀〃)\n(つд⊂)\n来", "虽然人的xp是自由的，但是我还是建议你看医生"}),
    ////// T //////
    the_fifth_republic(new String[]{"阁下", "虫豸"}, new String[]{"Shack it！"}),
    ////// U //////
    ////// V //////
    ////// W //////
    who_is(new String[]{"谁"}, new String[]{
        user_cookie_key, to_repeat, "10",
        "张驰", "A T M !"}),
    ////// X //////

    ////// Y //////
    ////// Z //////


    ;


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
