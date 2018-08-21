package com.js.main;

import com.js.dao.PollDAO;
import com.js.dao.PollDAOImpl;
import com.js.service.PollService;
import com.js.service.PollServiceImpl;
import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    ServletRegistrationBean<WebServlet> h2servletRegistration(){
        ServletRegistrationBean<WebServlet> registrationBean = new ServletRegistrationBean<>(new WebServlet());
        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }

    @Bean
    PollDAO getPollDAO()
    {
        return new PollDAOImpl();
    }

    @Bean
    PollService getPollService()
    {
        return new PollServiceImpl(getPollDAO());
    }
}
