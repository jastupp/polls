package com.js.main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.js.dao.PollDAO;
import com.js.model.Choice;
import com.js.model.Poll;
import com.js.service.PollService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc m_mock;

    @MockBean
    private PollService m_poll_service;

    @MockBean
    private PollDAO m_poll_dao;


    /**
     * Test the application will return json
     */
    @Test
    public void testJSONReturn() throws Exception
    {
        List<Poll> list = Collections.singletonList(createTestPoll());

        when(this.m_poll_service.getPolls()).thenReturn(list);

        mock().perform(get("/questions")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(asJsonString(list)));
    }

    /**
     * Test the get list
     */
    @Test
    public void testGetList() throws Exception
    {
        mock().perform(get("/questions")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

    /**
     * Test the post
     *
     * @throws Exception -
     */
    @Test
    public void testAddPoll() throws Exception
    {
        Poll poll = createTestPoll();

        when(this.m_poll_service.create(poll)).thenReturn(poll);

        mock().perform(post("/questions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(poll))
                .characterEncoding("UTF8")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(asJsonString(poll)));

    }



    //*******************
    // Private Methods **
    //*******************

    private MockMvc mock() { return m_mock; }

    /**
     * Convert to JSON string
     *
     * @param object -
     * @return -
     * @throws Exception -
     */
    private String asJsonString(Object object) throws Exception
    {
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZZZZ");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        mapper.setDateFormat(format);
        return mapper.writeValueAsString(object);
    }

    /**
     * Create the test poll
     *
     * @return -
     */
    private Poll createTestPoll()
    {
        Integer id = 101;

        Poll poll = new Poll("Test question");
        poll.setId(id);
        poll.getChoices().add(new Choice("Test Choice 1"));
        poll.getChoices().add(new Choice("Test Choice 2"));
        poll.getChoices().add(new Choice("Test Choice 3"));
        poll.getChoices().add(new Choice("Test Choice 4"));

        return poll;
    }
}
