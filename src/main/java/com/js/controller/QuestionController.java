package com.js.controller;

import com.js.model.Question;
import com.js.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class QuestionController {

    private QuestionService m_question_service;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public ResponseEntity getQuestions() {

        Set<Question> questions = m_question_service.getQuestions();
        return new ResponseEntity(questions, HttpStatus.OK);
    }

}

