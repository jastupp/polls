package com.js.model;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class Poll {

    //*****************
    // Class members **
    //*****************
    private String m_question;
    private LocalDateTime m_created;
    private Set<Choice> m_choices;

    /**
     * Constructor
     *
     * @param question - the question for the poll
     */
    public Poll(String question)
    {
        // use the other constructor
        this(question, LocalDateTime.now());
    }

    /**
     * Constructor
     *
     * @param question - the question
     * @param created - the date created
     */
    public Poll(String question, LocalDateTime created)
    {
        // set the class members
        m_question = question;
        m_created = created;
    }

    public String getQuestion()
    {
        return m_question;
    }

    public void setQuestion(String question)
    {
        m_question = question;
    }

    public LocalDateTime getCreated()
    {
        return m_created;
    }

    public void setCreated(LocalDateTime created)
    {
        m_created = created;
    }

    public Set<Choice> getChoices()
    {
        return m_choices == null ? m_choices = new TreeSet<>() : m_choices;
    }

    public void setChoices(Set<Choice> choices)
    {
        m_choices = choices;
    }

}
