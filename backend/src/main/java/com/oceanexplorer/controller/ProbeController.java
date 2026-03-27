package com.oceanexplorer.controller;

import com.oceanexplorer.dto.ProbeRequest;
import com.oceanexplorer.dto.ProbeResponse;
import com.oceanexplorer.service.ProbeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/probe")
public class ProbeController {

    private final ProbeService probeService;

    public ProbeController(ProbeService probeService) {
        this.probeService = probeService;
    }

    @PostMapping("/execute")
    public ProbeResponse execute(@RequestBody ProbeRequest request) {
        return probeService.execute(request);
    }
}