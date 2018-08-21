package com.js.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

public class Choice implements Serializable {

    //*****************
    // Class Members **
    //*****************
    private Integer m_id;
    private Integer m_poll_id;
    private String m_choice;
    private int m_votes;

    /**
     * Constructor
     */
    public Choice() {}

    /**
     * Constructor
     *
     * @param name - the name of the choice
     */
    public Choice(String name)
    {
        // use the other constructor
        this(name, 0);
    }

    /**
     * Constructor
     *
     * @param choice - the name of the choice
     * @param votes - the number votes
     */
    public Choice(String choice, Integer votes)
    {
        // set the class members
        m_choice = choice;
        m_votes = votes;
    }

    /**
     * Get the id
     *
     * @return - the id
     */
    @JsonIgnore
    public Integer getId()
    {
        return m_id;
    }

    /**
     * Set the id
     *
     * @param id - the id
     */
    public void setId(Integer id)
    {
        m_id = id;
    }

    @JsonIgnore
    public void setPollId(Integer poll_id)
    {
        m_poll_id = poll_id;
    }

    public Integer getPollId()
    {
        return m_poll_id;
    }

    /**
     * Get the name for the choice
     *
     * @return - the choice
     */
    public String getChoice()
    {
        return m_choice;
    }

    /**
     * Set the choice
     *
     * @param choice - the name for the choice
     */
    public void setChoice(String choice)
    {
        m_choice = choice;
    }

    /**
     * Get the number votes
     *
     * @return - the number of votes
     */
    public Integer getVotes()
    {
        return m_votes;
    }

    /**
     * Set the number of votes
     *
     * @param votes - the number votes
     */
    public void setVotes(Integer votes)
    {
        m_votes = votes;
    }
}
