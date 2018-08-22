package com.js.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.*;

public class Poll implements Serializable {

    //*****************
    // Class members **
    //*****************
    private Integer m_id;
    private String m_question;
    private Date m_created;
    private Set<Choice> m_choices;

    /**
     * Constructor
     */
    public Poll() {}

    /**
     * Constructor
     *
     * @param question - the question for the poll
     */
    public Poll(String question)
    {
        // use the other constructor
        this(question, new Date());
    }

    /**
     * Constructor
     *
     * @param question - the question
     * @param created - the date created
     */
    public Poll(String question, Date created)
    {
        // set the class members
        m_question = question;
        m_created = created;
    }

    /**
     * Get the id
     *
     * @return - the poll id
     */
    @JsonIgnore
    public Integer getId()
    {
        return m_id;
    }

    /**
     * Set the id
     * @param id - the id
     */
    public void setId(Integer id)
    {
        m_id = id;
    }

    /**
     * Get the question
     *
     * @return - the question
     */
    public String getQuestion()
    {
        return m_question;
    }

    /**
     * Set the question
     *
     * @param question - the question
     */
    public void setQuestion(String question)
    {
        m_question = question;
    }

    /**
     * Get the created date
     *
     * @return - the created date
     */
    @JsonProperty("published-at")
    public Date getCreated()
    {
        return m_created == null ? new Date() : m_created;
    }

    /**
     * Set the created date
     *
     * @param created - the created date
     */
    public void setCreated(Date created)
    {
        m_created = created;
    }

    /**
     * Get the choices for the poll
     *
     * @return - the choices
     */
    public Set<Choice> getChoices()
    {
        return m_choices == null ? m_choices = new HashSet<>() : m_choices;
    }

    /**
     * Set the choices
     *
     * @param choices - the choices
     */
    public void setChoices(Set<Choice> choices)
    {
        m_choices = choices;
    }

    /**
     * Check the items are equal
     *
     * @param that -
     * @return -
     */
    @Override
    public boolean equals(Object that)
    {
        // true if equal
        return that instanceof Poll &&
                getQuestion().equals(((Poll)that).getQuestion()) &&
                getCreated().equals(((Poll)that).getCreated());
    }
}
