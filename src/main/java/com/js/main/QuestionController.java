package com.js.main;

import com.js.model.Poll;
import com.js.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    //*****************
    // Class Members **
    //*****************
    private PollService m_poll_service;

    /**
     * Constructor
     *
     * @param service - the poll service
     */
    public QuestionController(PollService service)
    {
        m_poll_service = service;
    }

    /**
     * Get method for the polls
     *
     * @return - the polls
     */
    @GetMapping
    public ResponseEntity<List<Poll>> getPolls()
    {
        List<Poll> questions = service().getPolls();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    /**
     * Post the new question
     */
    @PostMapping
    public ResponseEntity<Poll> createOrder(@RequestBody Poll poll) throws URISyntaxException
    {
        Poll new_poll = service().create(poll);
        return ResponseEntity.created(new URI("/questions/" + new_poll.getId())).body(new_poll);
    }

    //*******************
    // Private Methods **
    //*******************

    /**
     * Get the poll service
     * @return
     */
    private PollService service()
    {
        return m_poll_service;
    }
}

