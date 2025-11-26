package com.cipfpmislata.examen2daw1eval.controller;

import com.cipfpmislata.examen2daw1eval.controller.mapper.CrewMapper;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.service.ActorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    private final ActorService actorService;
    private final CrewMapper crewMapper = new CrewMapper();

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<CrewSummaryResponse> findAll() {
        return actorService.findAll().stream().map(crewMapper::toSummaryResponse).toList();
    }
}
