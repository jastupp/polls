package com.js.service;

import com.js.dao.PollDAO;
import com.js.model.Poll;
import java.util.List;

public class PollServiceImpl implements PollService {

    //*****************
    // Class Members **
    //*****************
    private PollDAO m_dao;

    /**
     * Constructor
     *
     * @param dao - the dao
     */
    public PollServiceImpl(PollDAO dao)
    {
        m_dao = dao;
    }

    /**
     * Get the polls
     *
     * @return - the polls
     */
    public List<Poll> getPolls()
    {
        return dao().getPolls();
    }

    /**
     * Create a new poll
     *
     * @return - the new poll
     */
    public Poll create(Poll poll)
    {
        return dao().create(poll);
    }

    //*******************
    // Private Methods **
    //*******************

    /**
     * Get the dao
     *
     * @return - the dao
     */
    private PollDAO dao()
    {
        return m_dao;
    }
}
