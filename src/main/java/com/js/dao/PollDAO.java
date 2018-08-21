package com.js.dao;

import com.js.model.Poll;

import java.util.List;

public interface PollDAO {

    /**
     * Get the polls
     *
     * @return - the polls
     */
    List<Poll> getPolls();

    /**
     * Create a new poll
     *
     * @param poll - the poll to create
     * @return - the created poll
     */
    Poll create(Poll poll);

}
