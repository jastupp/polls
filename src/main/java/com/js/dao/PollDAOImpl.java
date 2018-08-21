package com.js.dao;

import com.js.model.Poll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class PollDAOImpl implements PollDAO {

    //*****************
    // Class Members **
    //*****************
    private SessionFactory m_factory;

    /**
     * Get the polls
     *
     * @return - return the list of polls
     */
    @Override
    public List<Poll> getPolls()
    {
        Session session = sessionFactory().openSession();
        return Collections.checkedList(session.createQuery("from Poll").list(), Poll.class);
    }


    //*******************
    // Private Methods **
    //*******************

    /**
     * Get the session factory
     *
     * @return - the factory
     */
    private SessionFactory sessionFactory()
    {
        return m_factory == null ? m_factory = createSessionFactory() : m_factory;
    }

    /**
     * Create the session factory
     *
     * @return - the session factory
     */
    private SessionFactory createSessionFactory() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        return new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

}
