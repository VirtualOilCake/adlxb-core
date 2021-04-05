package com.oilman.adlxb.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static com.oilman.adlxb.core.CoreConstants.chanceOfSage;
import static com.oilman.adlxb.core.CoreConstants.to_sage;
import static com.oilman.adlxb.core.CoreVariables.toLog;


/**
 * @author oilman
 * @since 2.0.0
 */
enum ThreadConditionEnum {
    NORMAL, SAGE, TEST
}

/**
 * This class represent a thread on A Island
 *
 * @author oilman
 * @see IslandPost
 * @since 2.0.0
 */
public class IslandThread {
    private final IslandPost userPost;
    private final IslandPost[] responses;
    private final ThreadConditionEnum threadCondition;
    private final Date createdTime;

    public IslandThread(IslandPost userPost, IslandPost[] responses,
                        ThreadConditionEnum threadCondition, Date createdTime) {
        this.userPost = userPost;
        this.responses = responses;
        this.threadCondition = threadCondition;
        this.createdTime = createdTime;
    }

    public IslandThread(IslandPost userPost, IslandPost[] responses,
                        ThreadConditionEnum threadCondition) {
        this.userPost = userPost;
        this.responses = responses;
        this.threadCondition = threadCondition;
        this.createdTime = new Date();
    }

    public IslandThread(String userInput) {
        this.userPost = new UserPost(userInput);
        ArrayList<IslandPost> responsesList = new ArrayList<>();
        String[] responsesContents = IslandUtils.getResponse(userInput, userPost.getCookie());
        if (toLog) {
            System.out.println("Original responses number = " + responsesContents.length);
        }
        boolean isSage = false;
        for (String responsesContent : responsesContents) {
            // if is the sage key word
            if (responsesContent.equals(to_sage)) {
                if (IslandUtils.random().nextInt(101) <= chanceOfSage) {
                    isSage = true;
                    if (toLog) {
                        System.out.println("SAGE!");
                    }
                    break;
                }
            } else {
                responsesList.add(new BotPost(responsesContent));
            }

        }
        // check the sage condition
        if (isSage) {
            this.threadCondition = ThreadConditionEnum.SAGE;
        } else {
            this.threadCondition = ThreadConditionEnum.NORMAL;
        }
        this.responses = responsesList.toArray(new IslandPost[0]);
        this.createdTime = new Date();
    }

    // Only for test
    public IslandThread() {
        this.userPost = new UserPost("TEST");
        this.responses = new IslandPost[]{
            new BotPost("TEST RESPONSE 1"),
            new BotPost("TEST RESPONSE 2"),
            new BotPost("TEST RESPONSE 3")
        };
        this.threadCondition = ThreadConditionEnum.TEST;
        this.createdTime = new Date();
    }

    /**
     * The more user friendly version of String that describe this object.
     *
     * @return a String that describe this object
     */
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        //output.append("==== Island Thread ====\n");
        output.append("--- User Post --- \n");
        output.append(userPost.getCookie()).append(": ").append(userPost.getContent());
        output.append("\n--- Responses --- ");
        for (int i = 0; i < responses.length; i++) {
            IslandPost post = responses[i];
            output.append("\n").append("<").append(i).append("> cookie: ")
                .append(post.getCookie())
                .append(" | No.").append(post.getPostNumber()).append("\n")
                .append(post.getContent());
        }
        output.append("\nThread Condition: ").append(threadCondition);
        output.append("\nCreated Time: ").append(createdTime);
        //output.append("\n====IslandThread====");
        return output.toString();
    }

    public String valueOf() {
        return "IslandThread{" +
            "userPost=" + userPost +
            ", responses=" + Arrays.toString(responses) +
            ", threadCondition=" + threadCondition +
            ", createdTime=" + createdTime +
            '}';
    }

    public boolean isSage() {
        return this.threadCondition == ThreadConditionEnum.SAGE;
    }
}
