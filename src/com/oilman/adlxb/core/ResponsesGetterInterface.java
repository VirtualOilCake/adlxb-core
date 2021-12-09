package com.oilman.adlxb.core;

import java.util.ArrayList;

public interface ResponsesGetterInterface {
    /**
     * Get one response based on the input.
     *
     * @param userInput a String of user input.
     * @return a String of response.
     */
    public String getOneResponse(String userInput);

    /**
     * Return all possible responses
     *
     * @param userInput a String of user input.
     * @return a List of responses.
     */
    public ArrayList<String> getResponses(String userInput);

    /**
     * Return some responses from possible responses.
     *
     * @param userInput a String of user input.
     * @return a List of responses.
     */
    public ArrayList<String> getResponses(String userInput, int size);

    /**
     * Return all possible responses
     *
     * @param userInput a String of user input.
     * @return a List of responses.
     */
    public ArrayList<String> getRawResponses(String userInput);

    /**
     * Return some responses from possible responses.
     *
     * @param userInput a String of user input.
     * @return a List of responses.
     */
    public ArrayList<String> getRawResponses(String userInput, int size);

}
