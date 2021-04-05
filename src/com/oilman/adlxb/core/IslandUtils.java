package com.oilman.adlxb.core;

import java.util.ArrayList;
import java.util.Random;

import static com.oilman.adlxb.core.CoreConstants.*;
import static com.oilman.adlxb.core.CoreVariables.*;


/**
 * The class for utils
 *
 * @author Oilman
 * @author Sod-Momas
 * @version 2.0.0
 * @since 1.0.1
 */
public class IslandUtils {
    /**
     * Since many parts of this program require Random object, this random method should improve the performance.
     *
     * @return a Random object
     * @since 1.0.2
     */
    public static Random random() {
        return new Random();
    }

    /**
     * Get a new cookie
     *
     * @return a new cookie
     * @since 1.0.1
     */
    public static String getANewCookie() {
        final StringBuilder cookieStringBuilder = new StringBuilder(cookieLength);
        for (int i = 0; i < cookieLength; i++) {
            int index = random().nextInt(cookieContents.length);
            cookieStringBuilder.append(cookieContents[index]);
        }
        return cookieStringBuilder.toString();
    }

    public static String formatInputString(String userInput) {
        String lowerCased = userInput.toLowerCase();
//        if (IslandSettings.translateTraditionalChinese){
//            //TODO change TS to CS if exist
//        }
        return lowerCased;
    }

    /**
     * Get how many responses one thread will have.
     *
     * @return base number + a random number between 0 and range
     */
    private static int getResponseNumber() {
        return baseNumberForReplies +
            IslandUtils.random().nextInt(numberForRepliesRange);
    }

    /**
     * Get the responses for a given input.
     *
     * @param userInput the input of the user
     * @return an array of String of responses
     */
    public static String[] getResponse(String userInput, String userCookie) {
        if (toLog) {
            System.out.println("getResponse() is being called");
        }
        String[] responses = new String[getResponseNumber()];
        ArrayList<IslandRulesEnum> rulesSatisfied =
            getAllSatisfiedRules(formatInputString(userInput)); // List for all satisfied rules
        ArrayList<String> possibleResponses = getAllPossibleResponses(rulesSatisfied);
        if (toLog) {
            System.out.println("All Possible responses: " + possibleResponses);
        }
        // Cannot use "for each"
        // Replace the keywords
        for (int i = 0; i < responses.length; i++) {
            responses[i] = possibleResponses.get(random().nextInt(possibleResponses.size()));
            if (responses[i].contains(user_input_key)) {
                responses[i] = responses[i].replace(user_input_key, userInput);
            }
            if (responses[i].contains(user_cookie_key)) {
                responses[i] = responses[i].replace(user_cookie_key, userCookie);
            }
        }
        return responses;
    }

    private static ArrayList<IslandRulesEnum> getAllSatisfiedRules(String formattedUserInput) {
        ArrayList<IslandRulesEnum> rulesSatisfied = new ArrayList<>();
        for (int currentRuleIndex = 0; currentRuleIndex < IslandRulesEnum.values().length; currentRuleIndex++) {
            for (String currentKeyword : IslandRulesEnum.values()[currentRuleIndex].getKeywords()) {
                // for and logic
                if (currentKeyword.startsWith("&&,")) {
                    String[] andLogicKeywords = currentKeyword.split(",");
                    boolean hasAllKeys = true;
                    for (int i = 1, andLogicKeywordsLength = andLogicKeywords.length; i < andLogicKeywordsLength; i++) {
                        String key = andLogicKeywords[i];
                        if (!formattedUserInput.contains(key)) {
                            hasAllKeys = false;
                            break;
                        }
                    }
                    if (hasAllKeys) {
                        rulesSatisfied.add(IslandRulesEnum.values()[currentRuleIndex]);
                        break;
                    }
                }
                // match the normal keywords
                else if (formattedUserInput.contains(currentKeyword)) {
                    rulesSatisfied.add(IslandRulesEnum.values()[currentRuleIndex]);
                    break;
                }
            }
        }
        return rulesSatisfied;
    }

    private static ArrayList<String> getAllPossibleResponses(ArrayList<IslandRulesEnum> satisfiedRules) {
        ArrayList<String> possibleResponses = new ArrayList<>();
        for (IslandRulesEnum currentRule : satisfiedRules) {
            // Add all possible responses to possibleResponses list
            for (int indexInRule = 0; indexInRule < currentRule.getResponses().length; indexInRule++) {
                // Repeat the response
                if (to_repeat.equals(currentRule.getResponses()[indexInRule])) {
                    String responseToRepeat = currentRule.getResponses()[indexInRule - 1];
                    int timesToRepeat = Integer.parseInt(currentRule.getResponses()[indexInRule + 1]);
                    // print state
                    if (toLog)
                        System.out.println("response {" + responseToRepeat +
                            "} will be repeated for " + timesToRepeat + " times.");
                    for (int i = 0; i < timesToRepeat; i++) {
                        possibleResponses.add(responseToRepeat);
                    }
                    indexInRule++;
                }
                // The normal case
                else {
                    if (!currentRule.getResponses()[indexInRule].isBlank()) {
                        possibleResponses.add(currentRule.getResponses()[indexInRule]);
                    } else {
                        if (toLog) {
                            System.err.println("Waring: There is at least one blank response in: " + currentRule);
                        }
                    }
                }
            }
        }
        return possibleResponses;
    }

    /**
     * @return a random Kaomoji in islandKaomoji array
     * @version 2.0.0
     * @since 2.0.0
     */
    public static String getARandomKaomoji() {
        return islandKaomoji[random().nextInt(islandKaomoji.length)];
    }
}
