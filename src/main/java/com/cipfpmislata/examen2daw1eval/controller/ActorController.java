package com.cipfpmislata.examen2daw1eval.controller;

import com.cipfpmislata.examen2daw1eval.controller.mapper.CrewMapper;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewDetailResponse;
import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrewDetailResponse> findById(@PathVariable Long id) {
        Crew actor = actorService.findById(id);
        return ResponseEntity.ok(CrewMapper.toDetailResponse(actor));
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }
}
