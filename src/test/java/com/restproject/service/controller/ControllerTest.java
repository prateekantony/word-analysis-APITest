package com.restproject.service.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WordController.class)
class ControllerTest {

    @Autowired
    private MockMvc mm;

    @Test
    void getLinkDefault() throws Exception
    {
        RequestBuilder req = MockMvcRequestBuilders.get("/api/link");
        MvcResult mvcr = mm.perform(req).andReturn();
        assertEquals("Error Occurred: Invalid URL", mvcr.getResponse().getContentAsString());
    }

    @Test
    void getLinkValid() throws Exception
    {
        RequestBuilder req = MockMvcRequestBuilders.get("/api/link?url=https://prateekantony.github.io/test-file-dump/files/sample1.txt");
        MvcResult mvcr = mm.perform(req).andReturn();
        assertEquals("Word count = 9\n" +
                "Average word length = 4.556\n" +
                "Number of words of length 1 is 1\n" +
                "Number of words of length 2 is 1\n" +
                "Number of words of length 3 is 1\n" +
                "Number of words of length 4 is 2\n" +
                "Number of words of length 5 is 2\n" +
                "Number of words of length 7 is 1\n" +
                "Number of words of length 10 is 1\n" +
                "The most frequently occurring word length is 2, for word lengths of 4 & 5", mvcr.getResponse().getContentAsString());
    }
}