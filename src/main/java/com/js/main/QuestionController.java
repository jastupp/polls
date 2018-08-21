package com.js.main;

import com.js.model.Poll;
import com.js.service.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
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
    @GetMapping(value = "/question")
    public ResponseEntity<List<Poll>> getPolls()
    {
        List<Poll> questions = m_poll_service.getPolls();
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}

