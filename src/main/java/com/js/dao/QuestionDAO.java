package com.js.dao;

import com.js.model.Question;

import java.util.Set;

public interface QuestionDAO {

    /**
     * Get the questions
     *
     * @return -
     */
    Set<Question> getQuestions();

}
