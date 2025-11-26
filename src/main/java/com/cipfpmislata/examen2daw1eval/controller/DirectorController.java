package com.cipfpmislata.examen2daw1eval.controller;

import com.cipfpmislata.examen2daw1eval.controller.mapper.CrewMapper;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.service.DirectorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;
    private final CrewMapper crewMapper = new CrewMapper();

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public List<CrewSummaryResponse> findAll() {
        return directorService.findAll().stream().map(crewMapper::toSummaryResponse).toList();
    }
}
