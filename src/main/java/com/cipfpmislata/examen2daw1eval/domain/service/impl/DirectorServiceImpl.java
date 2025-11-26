package com.cipfpmislata.examen2daw1eval.domain.service.impl;

import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.DirectorService;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final CrewRepository crewRepository;

    public DirectorServiceImpl(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public Crew findById(Long id) {
        return crewRepository.findDirectorById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found"));
    }
}
