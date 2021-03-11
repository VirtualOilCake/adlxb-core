package com.oilman.adlxb.core;

import java.util.ArrayList;
import java.util.Random;

import static com.oilman.adlxb.core.IslandConstants.*;
import static com.oilman.adlxb.core.IslandSettings.toLog;

/**
 * The class for utils
 *
 * @author Oilman
 * @author Sod-Momas
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
        return IslandSettings.baseNumberForReplies +
                IslandUtils.random().nextInt(IslandSettings.numberForRepliesRange);
    }

    /**
     * Get the responses for a given input.
     *
     * @param userInput the input of the user
     * @return an array of String of responses
     */
    public static String[] getResponse(String userInput, String userCookie) {
        String formattedInputString = formatInputString(userInput);
        String[] responses = new String[getResponseNumber()];
        ArrayList<IslandRulesEnum> rulesSatisfied = new ArrayList<IslandRulesEnum>();
        for (int currentRuleIndex = 0; currentRuleIndex < IslandRulesEnum.values().length; currentRuleIndex++) {
            for (String currentKeyword : IslandRulesEnum.values()[currentRuleIndex].getKeywords()) {
                if (formattedInputString.contains(currentKeyword)) {
                    rulesSatisfied.add(IslandRulesEnum.values()[currentRuleIndex]);
                    break;
                }
            }
        }

        ArrayList<String> possibleResponses = new ArrayList<>(); // the list for possible responses of the user input
        for (IslandRulesEnum currentRule : rulesSatisfied) {
            // Add all possible responses to possibleResponses list
            for (int indexInRule = 0; indexInRule < currentRule.getResponses().length; indexInRule++) {
                // Repeat the response
                if (responseRepeatKeyword.equals(currentRule.getResponses()[indexInRule])) {
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
                    possibleResponses.add(currentRule.getResponses()[indexInRule]);
                }
            }
        }
        if (toLog) {
            System.out.println("All Possible responses: " + possibleResponses);
        }
        // Cannot use "for each"
        // Replace the keywords
        for (int i = 0; i < responses.length; i++) {
            responses[i] = possibleResponses.get(random().nextInt(possibleResponses.size()));
            if (responses[i].contains(userInputKeyword)) {
                responses[i] = responses[i].replace(userInputKeyword, userInput);
            }
            if (responses[i].contains(userCookieKeyword)) {
                responses[i] = responses[i].replace(userCookieKeyword, userCookie);
            }
        }
        return responses;
    }


    /**
     * @return a random Kaomoji in islandKaomoji array
     * @since 2.0.0
     */
    public static String getARandomKaomoji() {
        return islandKaomojis[random().nextInt(islandKaomojis.length)];
    }
}
