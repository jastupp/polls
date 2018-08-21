package com.js.dao;

import com.js.model.Poll;

import java.util.Set;

public interface QuestionDAO {

    /**
     * Get the questions
     *
     * @return -
     */
    Set<Poll> getQuestions();

}
