package com.cipfpmislata.examen2daw1eval.domain.service.impl;

import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.ActorService;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    private final CrewRepository crewRepository;

    public ActorServiceImpl(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public Crew findById(Long id) {
        return crewRepository.findActorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not found"));
    }
}
