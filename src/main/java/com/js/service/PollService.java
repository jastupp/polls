package com.js.service;

import com.js.model.Poll;

import java.util.List;

public interface PollService {

    /**
     * Get all the polls
     *
     * @return - all the polls
     */
    List<Poll> getPolls();

    /**
     * Create a new poll
     *
     * @param poll -
     * @return - the created poll
     */
    Poll create(Poll poll);

}
