package com.netcracker.edu.review.Rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.edu.review.SpringBootTest;
import com.netcracker.edu.review.Util.AppUtility;
import com.netcracker.edu.review.Util.TestValidationUtility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReviewRestTest extends SpringBootTest{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void getReviewByAuthorIdTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/author/1"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String expectedResponse = AppUtility.getContentFromResourceFile("json/TestReviewByAuthorId_response.json");
        String response = result.getResponse().getContentAsString();

        TestValidationUtility.validateResponse(result.getResponse(), expectedResponse);
    }

    @Test
    public void getReviewByPlaceIdTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/place/10"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String expectedResponse = AppUtility.getContentFromResourceFile("json/TestReviewByPlaceId_response.json");
        String response = result.getResponse().getContentAsString();

        TestValidationUtility.validateResponse(result.getResponse(), expectedResponse);
    }
}
