package org.git.springsetup.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
class HelloControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloReturnsGreeting() throws Exception {
        mockMvc.perform(get("/api/hello").param("name", "Spring"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello, Spring!"));
    }
}
