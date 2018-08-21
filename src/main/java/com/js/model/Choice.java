package com.js.model;

public class Choice {

    //*****************
    // Class Members **
    //*****************
    private String m_name;
    private int m_votes;


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
     * @param name - the name of the choice
     * @param votes - the number votes
     */
    public Choice(String name, int votes)
    {
        // set the class members
        m_name = name;
        m_votes = votes;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public int getVotes()
    {
        return m_votes;
    }

    public void setVotes(int votes)
    {
        m_votes = votes;
    }
}
