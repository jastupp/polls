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

}
