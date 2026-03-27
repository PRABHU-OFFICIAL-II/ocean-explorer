package com.oceanexplorer.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oceanexplorer.controller.ProbeController;
import com.oceanexplorer.dto.ProbeRequest;
import com.oceanexplorer.service.ProbeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProbeControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        ProbeService probeService = new ProbeService(); // REAL SERVICE
        ProbeController controller = new ProbeController(probeService);

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldExecuteProbeCommands() throws Exception {

        ProbeRequest request = new ProbeRequest();
        request.setStartX(0);
        request.setStartY(0);
        request.setDirection("NORTH");
        request.setCommands("FFRFF");
        request.setGridWidth(5);
        request.setGridHeight(5);

        mockMvc.perform(post("/api/probe/execute")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.finalX").value(2))
                .andExpect(jsonPath("$.finalY").value(2));
    }
}